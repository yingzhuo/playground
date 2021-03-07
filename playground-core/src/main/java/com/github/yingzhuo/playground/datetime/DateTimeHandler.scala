package com.github.yingzhuo.playground.datetime

import java.text.SimpleDateFormat
import java.util.Date

object DateTimeHandler extends Enumeration {

  type DateTimeHandler = DateTimeHandlerVal

  val DateOnly: DateTimeHandler = DateTimeHandlerVal("yyyy-MM-dd")
  val TimeOnly: DateTimeHandler = DateTimeHandlerVal("HH:mm:ss")
  val DateTime: DateTimeHandler = DateTimeHandlerVal("yyyy-MM-dd HH:mm:ss.SSS")

  protected case class DateTimeHandlerVal(pattern: String) extends super.Val {
    private final val dateFormat = new SimpleDateFormat(pattern)

    def format(date: Long): String = format(new Date(date))

    def format(date: Date): String = dateFormat.format(date)

    def parse(source: String): Date = dateFormat.parse(source)
  }

}
