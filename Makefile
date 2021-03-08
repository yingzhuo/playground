version := 1.0.0-$(shell /bin/date '+%Y%m%d%H%M%S')
image := 192.168.99.115/yingzhuo/playground-core

no-default:
	@echo "no default target"

build-jar:
	@mvn -f $(CURDIR)/pom.xml clean package -P"NonLayeredJar,Assembly" -D"placed.version=$(version)"

build-image:
	@mvn -f $(CURDIR)/pom.xml clean package -P"LayeredJar,DockerContext" -D"placed.version=$(version)"
	@docker image build --tag ${image}:${version} $(CURDIR)/playground-core/target/docker-context/
	@docker image tag ${image}:${version} ${image}:latest

clean:
	@mvn -f $(CURDIR)/pom.xml clean &> /dev/null || true
	@rm -rf $(CURDIR)/dist &> /dev/null || true
	@docker system prune -a -f &> /dev/null || true

version:
	@mvn -f $(CURDIR)/pom.xml versions:set
	@mvn -f $(CURDIR)/pom.xml -N versions:update-child-modules
	@mvn -f $(CURDIR)/pom.xml versions:commit

github:
	@git add .
	@git commit -m "$(shell /bin/date "+%F %T")"
	@git push

.PHONY: no-default build-jar build-image clean github version