package com.github.yingzhuo.playground.service

import com.github.yingzhuo.playground.datetime.DateTimeHandler
import com.github.yingzhuo.playground.datetime.DateTimeHandler.DateTimeHandler

trait DateService {

  def now(pattern: DateTimeHandler = DateTimeHandler.DateTime): String

}
