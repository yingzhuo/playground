package com.github.yingzhuo.playground.aop

import org.aspectj.lang.ProceedingJoinPoint
import org.aspectj.lang.annotation.{Around, Aspect, Pointcut}
import org.springframework.stereotype.Component

@Aspect
@Component
class ControllerAdvice {

  @Pointcut("within(com.github.yingzhuo.playground.controller..*)")
  private def controller(): Unit = {}

  @Pointcut("execution(public * *(..))")
  private def publicOperation(): Unit = {}

  @Around("controller() && publicOperation()")
  def around(proceedingJoinPoint: ProceedingJoinPoint): AnyRef = {
    // NOP
    proceedingJoinPoint.proceed()
  }

}
