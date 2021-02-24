package com.github.yingzhuo.playground

import com.github.yingzhuo.springboot.env.propertysource.HoconPropertySourceFactory
import org.springframework.context.annotation.{Configuration, Profile, PropertySource}

private[playground] class ApplicationBootProperties {
}

private[playgroud] object ApplicationBootProperties {

  @Configuration
  @PropertySource(value = Array("classpath*:/config/property.conf"), factory = classOf[HoconPropertySourceFactory])
  @Profile(Array("dev"))
  class Dev

}
