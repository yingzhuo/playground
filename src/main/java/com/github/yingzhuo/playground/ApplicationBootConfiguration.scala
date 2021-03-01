package com.github.yingzhuo.playground

import org.springframework.boot.context.properties.{ConfigurationPropertiesScan, EnableConfigurationProperties}
import org.springframework.context.annotation.{Configuration, ImportResource}

@Configuration
@ConfigurationPropertiesScan(basePackageClasses = Array(
  classOf[ApplicationBoot]
))
@ImportResource(locations = Array("classpath*:spring/*.xml"))
@EnableConfigurationProperties
private[playground] class ApplicationBootConfiguration