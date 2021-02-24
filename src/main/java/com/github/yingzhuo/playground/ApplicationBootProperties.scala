package com.github.yingzhuo.playground

import com.github.yingzhuo.springboot.env.propertysource.HoconPropertySourceFactory
import org.springframework.context.annotation.{Configuration, Profile, PropertySource}

private[playgroud] object ApplicationBootProperties {

  @Configuration
  @PropertySource(value = Array("classpath*:/config/property-dev.conf"), factory = classOf[HoconPropertySourceFactory])
  @Profile(Array("dev"))
  class Dev

  @Configuration
  @PropertySource(value = Array("classpath*:/config/property-k8s.conf"), factory = classOf[HoconPropertySourceFactory])
  @Profile(Array("k8s"))
  class K8s

}
