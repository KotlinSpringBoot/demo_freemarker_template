package com.easy.springboot.demo_freemarker_template

import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.ui.set
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable

/**
 * Created by Kor on 2017-12-24 14:04:20.
 */
@Controller
class RouterController {

    @GetMapping(value = ["/category/list/{type}"])
    fun category(@PathVariable(value = "type") type: Int, model: Model): String {
        model["type"] = type
        return "category/list"
    }

    @GetMapping(value = ["/", ""])
    fun index(model: Model): String {
        model["type"] = 1
        return "category/list"
    }

}
