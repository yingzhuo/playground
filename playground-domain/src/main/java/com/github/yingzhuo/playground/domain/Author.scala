package com.github.yingzhuo.playground.domain

case class Author(name: String, email: Array[String]) extends Serializable

object Author {

  final val Ying = Author("应卓", Array("yingzhor@gmail.com"))

}
