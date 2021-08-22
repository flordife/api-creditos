package ar.com.ada.api.creditos.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ar.com.ada.api.creditos.entities.Cancelacion;
import ar.com.ada.api.creditos.repos.CancelacionRepository;

@Service
public class CancelacionService {

    @Autowired
    CancelacionRepository repo;

    public void crear(Cancelacion cancelacion) {
        repo.save(cancelacion);
    }

    public List<Cancelacion> traerTodasLasCancelaciones() {
        return repo.findAll();
    }

}
