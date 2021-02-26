package com.github.yingzhuo.playground

import com.github.yingzhuo.springboot.env.propertysource.HoconPropertySourceFactory
import org.springframework.context.annotation.{Configuration, Profile, PropertySource}

private[playground] object ApplicationBootProperty {

  @Configuration
  @PropertySource(
    factory = classOf[HoconPropertySourceFactory],
    value = Array("classpath:/config/property-dev.conf")
  )
  @Profile(Array("dev"))
  class Dev

  @Configuration
  @PropertySource(
    factory = classOf[HoconPropertySourceFactory],
    value = Array("classpath:/config/property-k8s.conf")
  )
  @Profile(Array("k8s"))
  class K8s

}
