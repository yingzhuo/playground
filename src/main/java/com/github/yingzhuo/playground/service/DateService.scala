package com.github.yingzhuo.playground.service

import com.github.yingzhuo.playground.datetime.DateTimeHandler
import com.github.yingzhuo.playground.datetime.DateTimeHandler.DateTimeHandler
import org.springframework.stereotype.Service

import java.util.Date

sealed trait DateService {
  def now(pattern: DateTimeHandler = DateTimeHandler.DateTime): String
}

@Service
private[service] class DateServiceImpl extends DateService {
  override def now(pattern: DateTimeHandler): String = pattern.format(new Date())
}
