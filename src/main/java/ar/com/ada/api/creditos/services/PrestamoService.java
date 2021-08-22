package ar.com.ada.api.creditos.services;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ar.com.ada.api.creditos.entities.Prestamo;
import ar.com.ada.api.creditos.repos.PrestamoRepository;

@Service
public class PrestamoService {

    @Autowired
    PrestamoRepository repository;

    public List<Prestamo> traerTodosLosPrestamos() {
        return repository.findAll();
    }

    public void crearPrestamo(Prestamo prestamo) {
        repository.save(prestamo);
    }

    public Prestamo buscarPorId(Integer id) {
        return repository.findByPrestamoId(id);
    }

    public void actualizar(Prestamo prestamo) {
        repository.save(prestamo);
    }

}
