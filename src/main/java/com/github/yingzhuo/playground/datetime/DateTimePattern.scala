package com.github.yingzhuo.playground.datetime

import org.apache.commons.lang3.time.{DateFormatUtils => Format}

import java.util.{Calendar, Date}

sealed trait DateTimePattern extends Serializable {

  abstract def asString: String

  def format(date: Date): String = Format.format(date, asString)

  def format(date: Long): String = Format.format(date, asString)

  def format(date: Calendar): String = Format.format(date, asString)

}

object DateTimePattern {

  val Long: DateTimePattern = new DateTimePattern {
    override def asString: String = "yyyy-MM-dd HH:mm:ss"
  }

  val Short: DateTimePattern = new DateTimePattern {
    override def asString: String = "yyyy-MM-dd"
  }

  val Default: DateTimePattern = Long

}