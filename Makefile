version := 1.0.0-$(shell /bin/date '+%Y%m%d%H%M%S')
image := 192.168.99.115/yingzhuo/playground-core

no-default:
	@echo "no default target"

build-jar:
	@mvn -f $(CURDIR)/pom.xml clean package -P NonLayeredJar -P Assembly

build-image:
	@mvn -f $(CURDIR)/pom.xml clean package -P LayeredJar -P DockerContext -D project.version=$(version)
	@docker image build --tag ${image}:latest $(CURDIR)/playground-core/target/docker-context/

clean:
	@mvn -f $(CURDIR)/pom.xml clean -q
	@docker image rm ${image}:latest &> /dev/null || true

github:
	@git add .
	@git commit -m "$(shell /bin/date "+%F %T")"
	@git push

.PHONY: no-default build-jar build-image clean github