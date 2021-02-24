package com.github.yingzhuo.playground

import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication

@SpringBootApplication
private class ApplicationBoot extends AnyRef

object ApplicationBoot extends App {
  SpringApplication.run(classOf[ApplicationBoot], args: _*)
}
