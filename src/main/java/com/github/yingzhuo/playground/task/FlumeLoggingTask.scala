package com.github.yingzhuo.playground.task

import java.util.UUID

import org.slf4j.LoggerFactory
import org.springframework.scheduling.annotation.Scheduled
import org.springframework.stereotype.Component

import scala.collection.mutable.ArrayBuffer

@Component
protected class FlumeLoggingTask {

  private val log = LoggerFactory.getLogger("flume")

  @Scheduled(fixedRate = 50L)
  def loggingTask(): Unit = {
    log.debug("{}", longString())
  }

  private def longString(): String = {
    val buffer = ArrayBuffer[String]()
    for (i <- 1 to 101) {
      buffer.addOne(UUID.randomUUID().toString)
    }
    buffer.mkString("-")
  }

}
