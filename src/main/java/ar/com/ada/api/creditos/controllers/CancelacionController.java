package ar.com.ada.api.creditos.controllers;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import ar.com.ada.api.creditos.entities.Cancelacion;
import ar.com.ada.api.creditos.entities.Prestamo;
import ar.com.ada.api.creditos.models.request.InfoCancelacionNueva;
import ar.com.ada.api.creditos.models.response.GenericResponse;
import ar.com.ada.api.creditos.services.CancelacionService;
import ar.com.ada.api.creditos.services.PrestamoService;

@RestController
public class CancelacionController {

    @Autowired
    CancelacionService service;

    @Autowired
    PrestamoService prestamoService;

    @PostMapping("/cancelaciones")
    public ResponseEntity<?> crear(@RequestBody InfoCancelacionNueva infoCancelacionNueva) {

        GenericResponse respuesta = new GenericResponse();
        Cancelacion cancelacion = new Cancelacion(infoCancelacionNueva.importeCuota, infoCancelacionNueva.numeroCuota,
                infoCancelacionNueva.fechaCancelacion);
        Prestamo prestamo = prestamoService.buscarPorId(infoCancelacionNueva.prestamoId);
        cancelacion.setPrestamo(prestamo);

        service.crear(cancelacion);
        respuesta.isOk = true;
        respuesta.id = cancelacion.getCancelacionId();
        respuesta.message = "La cancelación ha sido creada con éxito";

        return ResponseEntity.ok(respuesta);
    }

}
