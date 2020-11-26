package com.github.yingzhuo.playground.controller

import com.github.yingzhuo.playground
import com.github.yingzhuo.playground.service.DateService
import org.springframework.web.bind.annotation._

@RestController
protected class DateController private(dateService: DateService) {

  @GetMapping(path = Array("/now"))
  def now(@RequestParam(name = "pattern", required = false, defaultValue = playground.DefaultDatePattern) pattern: String): Map[String, AnyRef] = {
    Map("result" -> dateService.now(pattern))
  }

}
