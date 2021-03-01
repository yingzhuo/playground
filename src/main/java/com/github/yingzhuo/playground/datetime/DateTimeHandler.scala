package com.github.yingzhuo.playground.datetime

import com.github.yingzhuo
import com.github.yingzhuo.playground
import com.github.yingzhuo.playground.datetime

import java.text.SimpleDateFormat
import java.util.Date

object DateTimeHandler extends Enumeration {

  type DateTimeHandler = DateTimeHandlerVal
  val DateOnly: datetime.DateTimeHandler.DateTimeHandler = DateTimeHandlerVal("yyyy-MM-dd")
  val TimeOnly: playground.datetime.DateTimeHandler.DateTimeHandler = DateTimeHandlerVal("HH:mm:ss")
  val DateTime: yingzhuo.playground.datetime.DateTimeHandler.DateTimeHandler = DateTimeHandlerVal("yyyy-MM-dd HH:mm:ss.SSS")

  protected case class DateTimeHandlerVal(pattern: String) {

    def format(date: Long): String = format(new Date(date))

    def format(date: Date): String = new SimpleDateFormat(pattern).format(date)

    def parse(source: String): Date = new SimpleDateFormat(pattern).parse(source)
  }

}
