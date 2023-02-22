package br.com.curso.controller

import br.com.curso.model.Cliente
import br.com.curso.repository.ClienteRepository
import br.com.curso.service.ClienteService
import io.micronaut.http.annotation.Body
import io.micronaut.http.annotation.Controller
import io.micronaut.http.annotation.Delete
import io.micronaut.http.annotation.Get
import io.micronaut.http.annotation.PathVariable
import io.micronaut.http.annotation.Post
import io.micronaut.http.annotation.Put
import java.net.http.HttpResponse
import javax.transaction.Transactional

@Controller("/clientes")
class ClienteController(
        private val clienteService: ClienteService
) {

    @Post
    fun create(@Body cliente: Cliente): io.micronaut.http.HttpResponse<Cliente> {
        val clienteDB = clienteService.create(cliente)
        return io.micronaut.http.HttpResponse.created(clienteDB)
    }

    @Get
    fun findAll():List<Cliente>{
        return clienteService.findAll()
    }

    @Get("/{id}")
    fun findById(@PathVariable id:Long): Cliente{
        return clienteService.findById(id)
    }

    @Delete("/{id}")
    fun delete(@PathVariable id:Long): io.micronaut.http.HttpResponse<Unit>{
        clienteService.delete(id)
        return io.micronaut.http.HttpResponse.noContent()
    }

    @Put("/{id}")
    fun update(@PathVariable id: Long, @Body cliente: Cliente){
        clienteService.update(id, cliente)
    }
}