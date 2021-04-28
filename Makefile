version := 1.0.0-$(shell /bin/date '+%Y%m%d%H%M%S')
image := yingzhuo/playground-core

usage:
	@echo "================================================"
	@echo "usage           => 显示菜单"
	@echo "release-jar     => 发布"
	@echo "release-docker  => 构建Docker镜像"
	@echo "clean           => 清理构建产物"
	@echo "version         => 变更项目版本号"
	@echo "github          => 推送源代码到github"
	@echo "================================================"

release-jar:
	@rm -rf $(CURDIR)/dist &> /dev/null || true
	@mvn -f $(CURDIR)/pom.xml clean package -P"dist" -D"building.version=$(version)"

release-docker:
	@mvn -f $(CURDIR)/pom.xml clean package -P"docker" -D"building.version=$(version)"
	@docker image build --tag ${image}:${version} $(CURDIR)/playground-core/target/docker-context/
	@docker image tag ${image}:${version} ${image}:latest

clean:
	@mvn -f $(CURDIR)/pom.xml clean &> /dev/null || true
	@rm -rf $(CURDIR)/release &> /dev/null || true

version:
	@mvn -f $(CURDIR)/pom.xml versions:set
	@mvn -f $(CURDIR)/pom.xml versions:update-child-modules -N
	@mvn -f $(CURDIR)/pom.xml versions:commit

github: clean
	@git add .
	@git commit -m "$(shell /bin/date "+%F %T")"
	@git push

.PHONY: usage release-jar release-docker clean version github