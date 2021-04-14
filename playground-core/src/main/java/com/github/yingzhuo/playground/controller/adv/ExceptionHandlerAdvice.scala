package com.github.yingzhuo.playground.controller.adv

import com.github.yingzhuo.playground.json.Json
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.{ExceptionHandler, ResponseStatus}
import org.springframework.web.servlet.NoHandlerFoundException

class ExceptionHandlerAdvice {

  /**
   * 404
   */
  @ExceptionHandler
  @ResponseStatus(HttpStatus.NOT_FOUND)
  def handle(ex: NoHandlerFoundException): Json[String] = {
    Json("404", Array[String](), null.asInstanceOf[String])
  }

}
