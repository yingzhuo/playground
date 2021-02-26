package com.github.yingzhuo.playground.controller

import com.github.yingzhuo.playground.datetime.DateTimePattern
import com.github.yingzhuo.playground.service.DateService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation._

@RestController
private[controller] class DateController @Autowired private(dateService: DateService) {

  @GetMapping(path = Array("/now"))
  def now(): Map[String, AnyRef] = Map(
    "result" -> dateService.now(DateTimePattern.Default)
  )

}
