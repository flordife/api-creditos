package ar.com.ada.api.creditos.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import ar.com.ada.api.creditos.entities.Cliente;
import ar.com.ada.api.creditos.services.ClienteService;

@RestController
public class ClienteController {
    @Autowired
    ClienteService service;

    public List<Cliente> traerTodos(){
        return service.traerTodos();

    }

    public void crearCliente(Cliente cliente){
        service.crearCliente(cliente);

    }


    
}
