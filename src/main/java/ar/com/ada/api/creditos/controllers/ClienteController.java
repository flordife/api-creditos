package ar.com.ada.api.creditos.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import ar.com.ada.api.creditos.entities.Cliente;
import ar.com.ada.api.creditos.models.request.InfoClienteActualizada;
import ar.com.ada.api.creditos.models.response.GenericResponse;
import ar.com.ada.api.creditos.services.ClienteService;

@RestController
public class ClienteController {
    
    @Autowired
    ClienteService service;

    @GetMapping("/clientes")
    public ResponseEntity<List<Cliente>> traerTodos() {
        return ResponseEntity.ok(service.traerTodos());

    }

    @PostMapping("/clientes")
    public ResponseEntity<?> crearCliente(@RequestBody Cliente cliente) {
        service.crearCliente(cliente);
        GenericResponse respuesta = new GenericResponse();
        respuesta.isOk = true;
        respuesta.id = cliente.getClienteId();
        respuesta.message = "El cliente fue creado con exito";
        return ResponseEntity.ok(respuesta);
    }

    @PutMapping("/clientes/{id}")
    public ResponseEntity<GenericResponse> actualizarCliente(@PathVariable Integer id,
            @RequestBody InfoClienteActualizada infoCliente) {

        Cliente cliente = service.buscarPorId(id);
        cliente.setNombre(infoCliente.nombre);
        cliente.setDireccion(infoCliente.direccion);
        cliente.setDireccionAlternativa(infoCliente.direccionAlternativa);
        cliente.setFechaNacimiento(infoCliente.fechaNacimiento);
        service.actualizar(cliente);

        GenericResponse respuesta = new GenericResponse();

        respuesta.isOk = true;
        respuesta.id = cliente.getClienteId();
        respuesta.message = "Los datos del cliente han sido actualizados.";

        return ResponseEntity.ok(respuesta);
    }

}
