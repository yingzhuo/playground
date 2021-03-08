package com.github.yingzhuo.playground.controller

import com.github.yingzhuo.playground.domain.Author
import org.springframework.web.bind.annotation.{RequestMapping, RestController}

@RestController
private class AuthorController {

  @RequestMapping(Array("/author"))
  def author(): Author = Author.Ying

}
