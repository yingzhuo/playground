package com.github.yingzhuo.playground

import org.springframework.boot.context.properties.ConfigurationPropertiesScan
import org.springframework.context.annotation.{Configuration, ImportResource}

@Configuration
@ConfigurationPropertiesScan(basePackages = Array(BasePackage))
@ImportResource(locations = Array("classpath*:spring/*.xml"))
protected class ApplicationBootBean