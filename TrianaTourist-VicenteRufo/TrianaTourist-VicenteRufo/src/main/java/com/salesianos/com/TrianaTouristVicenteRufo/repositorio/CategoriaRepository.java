package com.salesianos.com.TrianaTouristVicenteRufo.repositorio;

import com.salesianos.com.TrianaTouristVicenteRufo.modelo.Categoria;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoriaRepository extends JpaRepository<Categoria,Long> {

    boolean existsByName(String name);

}
