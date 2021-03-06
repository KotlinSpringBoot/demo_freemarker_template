package com.easy.springboot.demo_freemarker_template

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.data.domain.Page
import org.springframework.data.domain.PageRequest
import org.springframework.web.bind.annotation.*
import javax.servlet.http.HttpServletRequest

/**
 * Created by Kor on 2017-12-24 14:04:20.
 */
@RestController
@RequestMapping("/api/category")
class CategoryController {

    @Autowired lateinit var CategoryDao: CategoryDao

    @GetMapping(value = ["/"])
    fun category(request: HttpServletRequest): List<Category> {
        return CategoryDao.findAll()
    }

    @GetMapping(value = ["/{id}"])
    fun getOne(@PathVariable("id") id: Long): Category {
        return CategoryDao.getOne(id)
    }


    @GetMapping(value = ["/search"])
    fun page(
            @RequestParam(value = "pageNo", defaultValue = "0") pageNo: Int,// Spring Data JPA 的分页默认第一页是： pageNo = 0
            @RequestParam(value = "pageSize", defaultValue = "10") pageSize: Int,
            @RequestParam(value = "searchText", defaultValue = "") searchText: String,
            @RequestParam(value = "type", defaultValue = "1") type: Int
    ): Page<Category> {
        return CategoryDao.page(
                searchText,
                type,
                PageRequest.of(pageNo, pageSize))
    }

}
