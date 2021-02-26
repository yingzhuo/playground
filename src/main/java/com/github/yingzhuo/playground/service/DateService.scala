package com.github.yingzhuo.playground.service

import com.github.yingzhuo.playground.datetime.DateTimePattern
import org.springframework.stereotype.Service

sealed trait DateService {
  def now(pattern: DateTimePattern): String
}

@Service
private[service] class DateServiceImpl extends AnyRef with DateService {
  override def now(pattern: DateTimePattern): String = pattern.format(System.currentTimeMillis())
}
