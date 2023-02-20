package br.com.curso.controller

import br.com.curso.model.Cliente
import br.com.curso.repository.ClienteRepository
import io.micronaut.http.annotation.Body
import io.micronaut.http.annotation.Controller
import io.micronaut.http.annotation.Get
import io.micronaut.http.annotation.Post

@Controller("/clientes")
class ClienteController(
        private val clienteRepository: ClienteRepository
) {

    @Post
    fun create(@Body cliente: Cliente) {
        clienteRepository.save(cliente)
    }

    @Get
    fun findAll():List<Cliente>{
        return clienteRepository.findAll()
    }
}