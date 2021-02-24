package com.github.yingzhuo.playground.controller

import com.github.yingzhuo.playground.service.DateService
import org.springframework.web.bind.annotation._

@RestController
private[controller] class DateController private(dateService: DateService) {

  @GetMapping(path = Array("/now"))
  def now(@RequestParam(name = "pattern", required = false) pattern: String): Map[String, AnyRef] = {
    val p = Option(pattern) match {
      case Some(x) => x
      case _ => "yyyy-MM-dd HH:mm:ss"
    }
    Map("result" -> dateService.now(p))
  }

}
