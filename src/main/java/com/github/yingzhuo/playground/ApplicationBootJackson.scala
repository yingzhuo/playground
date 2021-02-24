package com.github.yingzhuo.playground

import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.module.scala.DefaultScalaModule
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.context.annotation.Configuration

@Configuration
private[playground] class ApplicationBootJackson extends AnyRef {

  @Autowired(required = false)
  def config(om: ObjectMapper): Unit = Option(om).foreach(_.registerModule(DefaultScalaModule))

}
