package com.github.yingzhuo.playground.service

import org.springframework.stereotype.Service

@Service
private[service] class DateServiceImpl extends AnyRef with DateService {

  override def now(pattern: String): String = {
    import org.apache.commons.lang3.time.{DateFormatUtils => DateFormat}
    DateFormat.format(System.currentTimeMillis(), pattern)
  }

}
