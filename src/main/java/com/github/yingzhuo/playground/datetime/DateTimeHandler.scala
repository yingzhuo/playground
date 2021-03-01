package com.github.yingzhuo.playground.datetime

import java.text.SimpleDateFormat
import java.util.Date

object DateTimeHandler extends Enumeration {

  type DateTimeHandler = DateTimeHandlerVal

  protected case class DateTimeHandlerVal(pattern: String) {

    def format(date: Date): String = new SimpleDateFormat(pattern).format(date)

    def format(date: Long): String = format(new Date(date))

    def parse(source: String): Date = new SimpleDateFormat(pattern).parse(source)
  }

  val DateOnly = DateTimeHandlerVal("yyyy-MM-dd")
  val TimeOnly = DateTimeHandlerVal("HH:mm:ss")
  val DateTime = DateTimeHandlerVal("yyyy-MM-dd HH:mm:ss.SSS")

}
