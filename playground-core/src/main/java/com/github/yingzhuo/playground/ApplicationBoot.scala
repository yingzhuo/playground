package com.github.yingzhuo.playground

import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication

object ApplicationBoot extends App {

  @SpringBootApplication
  private class ApplicationBoot

  SpringApplication.run(classOf[ApplicationBoot], args: _*)
}
