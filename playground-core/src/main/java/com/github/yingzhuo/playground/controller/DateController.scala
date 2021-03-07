package com.github.yingzhuo.playground.controller

import com.github.yingzhuo.playground.json.Json
import com.github.yingzhuo.playground.service.DateService
import org.springframework.web.bind.annotation._

@RestController
private class DateController private(dateService: DateService) {

  @GetMapping(path = Array("/now"))
  def now(): Json[Option[String]] = {
    Json(
      payload = Option(dateService.now())
    )
  }

}
