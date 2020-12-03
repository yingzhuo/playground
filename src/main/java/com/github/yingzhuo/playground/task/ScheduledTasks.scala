package com.github.yingzhuo.playground.task

import java.util.UUID

import org.slf4j.LoggerFactory
import org.springframework.scheduling.annotation.Scheduled
import org.springframework.stereotype.Component

@Component
protected class ScheduledTasks {

  private val log = LoggerFactory.getLogger(getClass)

  @Scheduled(fixedRate = 3000)
  def doExecute(): Unit = {
    log.debug(UUID.randomUUID().toString)
  }

}
