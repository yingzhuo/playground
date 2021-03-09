version := 1.0.0-$(shell /bin/date '+%Y%m%d%H%M%S')
image := yingzhuo/playground-core

usage:
	@echo "================================================"
	@echo "usage    :=> 显示菜单"
	@echo "dist     :=> 打包"
	@echo "docker   :=> 构建Docker镜像"
	@echo "clean    :=> 清理构建产物"
	@echo "version  :=> 变更项目版本号"
	@echo "github   :=> 推送源代码到github"
	@echo "================================================"

dist:
	@rm -rf $(CURDIR)/dist &> /dev/null || true
	@mvn -f $(CURDIR)/pom.xml clean package -P"dist" -D"placed.version=$(version)"

docker:
	@mvn -f $(CURDIR)/pom.xml clean package -P"docker" -D"placed.version=$(version)"
	@docker image build --tag ${image}:${version} $(CURDIR)/playground-core/target/docker-context/
	@docker image tag ${image}:${version} ${image}:latest

clean:
	@mvn -f $(CURDIR)/pom.xml clean &> /dev/null || true
	@rm -rf $(CURDIR)/dist &> /dev/null || true
	@docker system prune -a -f &> /dev/null || true

version:
	@mvn -f $(CURDIR)/pom.xml versions:set
	@mvn -f $(CURDIR)/pom.xml versions:update-child-modules -N
	@mvn -f $(CURDIR)/pom.xml versions:commit

github: clean
	@git add .
	@git commit -m "$(shell /bin/date "+%F %T")"
	@git push

.PHONY: usage dist docker clean version github