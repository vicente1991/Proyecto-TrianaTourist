package com.salesianos.com.TrianaTouristVicenteRufo.repositorio;

import com.salesianos.com.TrianaTouristVicenteRufo.modelo.POI;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface POIRepository extends JpaRepository<POI,Long> {

    boolean existsBylocation (String name);


}
