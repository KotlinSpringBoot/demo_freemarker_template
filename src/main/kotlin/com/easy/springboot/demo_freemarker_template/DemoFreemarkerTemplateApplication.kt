package com.easy.springboot.demo_freemarker_template

import org.springframework.boot.ApplicationRunner
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.builder.SpringApplicationBuilder
import org.springframework.boot.runApplication
import org.springframework.context.support.BeanDefinitionDsl
import org.springframework.context.support.beans
import java.io.File

@SpringBootApplication
class DemoFreemarkerTemplateApplication

fun main(args: Array<String>) {
    SpringApplicationBuilder().initializers(
            beans {
                bean {
                    ApplicationRunner {
                        initCategory()
                    }
                }
            }
    ).sources(DemoFreemarkerTemplateApplication::class.java).run(*args)

}

private fun BeanDefinitionDsl.BeanDefinitionContext.initCategory() {
    /** 初始化学科分类数据 */
    val CategoryDao = ref<CategoryDao>()
    println(File(".").absolutePath) // /Users/jack/easykotlin/reakt/.
    val f1 = File("src/main/resources/学科分类.data")
    f1.readLines().forEach {
        try {
            val items = it.split("=")
            println("${items[0]}=${items[1]}")
            val category = Category()
            category.code = items[0]
            category.name = items[1]
            category.detail = items[2]
            category.type = 1
            CategoryDao.save(category)
        } catch (e: Exception) {
            e.printStackTrace()
        }
    }

    /** 初始化图书分类数据 */

    println(File(".").absolutePath) // /Users/jack/easykotlin/reakt/.
    val f2 = File("src/main/resources/图书分类.data")
    f2.readLines().forEach {
        try {
            val items = it.split("=")
            println("${items[0]}=${items[1]}")
            val category = Category()
            category.code = items[0]
            category.name = items[1]
            category.type = 2
            CategoryDao.save(category)
        } catch (e: Exception) {
            e.printStackTrace()
        }
    }


    /** 初始化全球行业分类数据 */

    println(File(".").absolutePath) // /Users/jack/easykotlin/reakt/.
    val f3 = File("src/main/resources/全球行业分类.data")
    f3.readLines().forEach {
        try {
            val items = it.split("=")
            println("${items[0]}=${items[1]}")
            val category = Category()
            category.code = items[0]
            category.name = items[1]
            category.type = 3
            CategoryDao.save(category)
        } catch (e: Exception) {
            e.printStackTrace()
        }
    }
}

