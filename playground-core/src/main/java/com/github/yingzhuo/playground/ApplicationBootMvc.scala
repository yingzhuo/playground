package com.github.yingzhuo.playground

import org.springframework.boot.web.servlet.ServletComponentScan
import org.springframework.stereotype.Component
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer

@Component
@ServletComponentScan
private class ApplicationBootMvc extends WebMvcConfigurer {
}
