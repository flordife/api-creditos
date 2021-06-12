 package ar.com.ada.api.creditos.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ar.com.ada.api.creditos.entities.Cliente;
import ar.com.ada.api.creditos.repos.ClienteRepository;

///Vamos a crear un service con la funcionalidad de traer todos los clientes y de grabar un cliente.

@Service
public class ClienteService {


    @Autowired
    ClienteRepository repository;
    
    public List<Cliente> traerTodos(){
        return repository.findAll();
    }

    public void crearCliente(Cliente cliente){
        repository.save(cliente);

    }
}
