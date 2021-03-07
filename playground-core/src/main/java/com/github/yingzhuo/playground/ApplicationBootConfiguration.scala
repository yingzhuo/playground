package com.github.yingzhuo.playground

import org.springframework.boot.context.properties.{ConfigurationPropertiesScan, EnableConfigurationProperties}
import org.springframework.context.annotation.Configuration

@Configuration
@ConfigurationPropertiesScan(basePackageClasses = Array(
  classOf[ApplicationBoot]
))
@EnableConfigurationProperties
private class ApplicationBootConfiguration
