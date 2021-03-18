package com.github.yingzhuo.playground

import org.springframework.boot.context.properties.{ConfigurationPropertiesScan, EnableConfigurationProperties}
import org.springframework.context.annotation.Configuration

@Configuration
@ConfigurationPropertiesScan(basePackages = Array(
  BasePackage
))
@EnableConfigurationProperties
private class ApplicationBootConfig
