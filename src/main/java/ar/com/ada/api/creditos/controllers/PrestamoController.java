package ar.com.ada.api.creditos.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import ar.com.ada.api.creditos.entities.Prestamo;
import ar.com.ada.api.creditos.models.GenericResponse;
import ar.com.ada.api.creditos.services.PrestamoService;

@RestController
public class PrestamoController {
    
    @Autowired
    PrestamoService service;
    
    @GetMapping("/prestamos")
    public ResponseEntity<List<Prestamo>> traerTodosLosPrestamos(){
        return ResponseEntity.ok(service.traerTodosLosPrestamos());
    }

    @PostMapping("/prestamos")
    public ResponseEntity<?> crearPrestamo(@RequestBody Prestamo prestamo){
        service.crearPrestamo(prestamo);
        GenericResponse respuesta = new GenericResponse();
        respuesta.isOk = true;
        respuesta.id = prestamo.getPrestamoId();
        respuesta.message = "El prestamo fue creado con exito";
        return ResponseEntity.ok(respuesta);
    }
    

}
