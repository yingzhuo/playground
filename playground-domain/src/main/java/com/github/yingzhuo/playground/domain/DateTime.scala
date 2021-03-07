package com.github.yingzhuo.playground.domain

import java.text.SimpleDateFormat
import java.util.Date

class DateTime private(delegate: Date) extends Serializable {

  override def toString: String = new SimpleDateFormat("yyyy-MM-dd").format(delegate)

}

object DateTime {

  def apply(date: Date): DateTime = new DateTime(date)

  def apply(date: Long): DateTime = DateTime(new Date(date))
}
