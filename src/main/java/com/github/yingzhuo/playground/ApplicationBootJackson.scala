package com.github.yingzhuo.playground

import java.util.Optional

import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.module.scala.DefaultScalaModule
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.context.annotation.Configuration

import scala.jdk.OptionConverters._

@Configuration
protected class ApplicationBootJackson {

  @Autowired(required = false)
  def config(om: Optional[ObjectMapper]): Unit = om.toScala match {
    case Some(x) => x.registerModule(DefaultScalaModule)
    case None => // nop
  }

}
