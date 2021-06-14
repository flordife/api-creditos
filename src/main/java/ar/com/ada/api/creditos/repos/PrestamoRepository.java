package ar.com.ada.api.creditos.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import ar.com.ada.api.creditos.entities.*;

public interface PrestamoRepository extends JpaRepository<Prestamo, Integer> {
    
}
