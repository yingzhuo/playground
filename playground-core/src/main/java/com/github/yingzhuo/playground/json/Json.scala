package com.github.yingzhuo.playground.json

case class Json[T](
                    code: String = "000000",
                    errorMessages: Iterable[String] = Array[String](),
                    payload: T)