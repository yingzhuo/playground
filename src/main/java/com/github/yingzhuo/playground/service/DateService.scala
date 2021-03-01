package com.github.yingzhuo.playground.service

import com.github.yingzhuo.playground.datetime.DateTimeHandler.DateTimeHandler
import org.springframework.stereotype.Service

sealed trait DateService {
  def now(pattern: DateTimeHandler): String
}

@Service
private[service] class DateServiceImpl extends DateService {
  override def now(pattern: DateTimeHandler): String = pattern.format(System.currentTimeMillis())
}
