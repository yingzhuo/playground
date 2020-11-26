version := 1.0.0-$(shell /bin/date '+%Y%m%d%H%M%S')
image := 192.168.99.115/yingzhuo/playground

no-default:
	@echo "no default target"

build-jar:
	@mvn -f $(CURDIR)/pom.xml clean package -P NonLayeredJar -D version=$(version)

build-image:
	@mvn -f $(CURDIR)/pom.xml clean package -P LayeredJar -D version=$(version)
	@docker image build --tag ${image}:latest $(CURDIR)/target/docker-context/

push-image: build-image
	@docker login --username=${HARBOR_USERNAME} --password=${HARBOR_PASSWORD} 192.168.99.115 &> /dev/null
	@docker image push ${image}:latest
	@docker logout 192.168.99.115 &> /dev/null

clean:
	@mvn -f $(CURDIR)/pom.xml clean -q
	@docker image rm ${image}:latest &> /dev/null || true

github:
	@git add .
	@git commit -m "$(shell /bin/date "+%F %T")"
	@git push

.PHONY: no-default build-jar build-image push-image clean github
