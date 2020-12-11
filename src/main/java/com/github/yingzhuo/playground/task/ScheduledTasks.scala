package com.github.yingzhuo.playground.task

import com.github.yingzhuo.playground.logback.BusinessLogs
import org.apache.commons.lang3.time.{DateFormatUtils => DateFormat}
import org.springframework.scheduling.annotation.Scheduled
import org.springframework.stereotype.Component

import scala.util.Random

@Component
protected class ScheduledTasks {

  @Scheduled(fixedRate = 800)
  def doExecute(): Unit = {

    val date = DateFormat.format(System.currentTimeMillis(), "yyyy-MM-mm HH:mm:ss.SSS")
    val user = s"user-${Random.between(0, 16)}"
    val upstream = Random.between(0L, 8192L);
    val downstream = Random.between(0L, 8192L);

    BusinessLogs.BUSINESS_1.debug(s"$date,$user,$upstream,$downstream")
  }

}
