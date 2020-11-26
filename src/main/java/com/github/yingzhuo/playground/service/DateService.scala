package com.github.yingzhuo.playground.service

import org.apache.commons.lang3.time.{DateFormatUtils => DateFormat}
import org.springframework.stereotype.Service

sealed trait DateService {

  def now(pattern: String): String

}

@Service
protected class DateServiceImpl private() extends AnyRef
  with DateService {

  override def now(pattern: String): String = DateFormat.format(System.currentTimeMillis(), pattern)

}
