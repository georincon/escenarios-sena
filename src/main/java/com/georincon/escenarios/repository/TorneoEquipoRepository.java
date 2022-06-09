package com.georincon.escenarios.repository;

import com.georincon.escenarios.model.TorneoEquipo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TorneoEquipoRepository extends JpaRepository<TorneoEquipo, Integer> {
}
