package br.com.curso.controller

import io.micronaut.http.annotation.Controller
import io.micronaut.http.annotation.Get
import io.micronaut.http.annotation.Produces
import java.awt.PageAttributes.MediaType

@Controller("/hello")
class HelloController {

    @Get
    @Produces(io.micronaut.http.MediaType.TEXT_PLAIN)
    fun olaMundo(): String {
        return "Ola Mundo"
    }
}