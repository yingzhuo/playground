package com.github.yingzhuo.playground

import com.github.yingzhuo.playground.domain.DateTime
import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication

@SpringBootApplication
private class ApplicationBoot

object ApplicationBoot extends App {
  println(DateTime(0L))
  SpringApplication.run(classOf[ApplicationBoot], args: _*)
}
