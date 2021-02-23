package com.github.yingzhuo.playground

import com.github.yingzhuo.springboot.env.propertysource.HoconPropertySourceFactory
import org.springframework.boot.context.properties.ConfigurationPropertiesScan
import org.springframework.context.annotation.{Configuration, ImportResource, PropertySource}

@Configuration
@ConfigurationPropertiesScan(basePackages = Array(BasePackage))
@ImportResource(locations = Array("classpath*:spring/*.xml"))
@PropertySource(value = Array("classpath:/config/property.conf"), factory = classOf[HoconPropertySourceFactory])
protected class ApplicationBootBean