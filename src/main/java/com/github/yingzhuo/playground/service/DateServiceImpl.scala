package com.github.yingzhuo.playground.service

import org.apache.commons.lang3.time.{DateFormatUtils => DateFormat}
import org.springframework.stereotype.Service

@Service
private class DateServiceImpl extends AnyRef with DateService {

  override def now(pattern: String): String = {
    DateFormat.format(System.currentTimeMillis(), pattern)
  }

}
