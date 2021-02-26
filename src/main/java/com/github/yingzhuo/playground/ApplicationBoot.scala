package com.github.yingzhuo.playground

import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.context.properties.ConfigurationPropertiesScan
import org.springframework.context.annotation.ImportResource

@SpringBootApplication
@ConfigurationPropertiesScan(basePackageClasses = Array(
  classOf[ApplicationBoot]
))
@ImportResource(locations = Array("classpath*:spring/*.xml"))
private class ApplicationBoot

object ApplicationBoot extends App {
  SpringApplication.run(classOf[ApplicationBoot], args: _*)
}
