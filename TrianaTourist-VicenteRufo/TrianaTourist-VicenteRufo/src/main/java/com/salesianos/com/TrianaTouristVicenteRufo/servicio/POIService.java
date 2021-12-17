package com.salesianos.com.TrianaTouristVicenteRufo.servicio;

import com.salesianos.com.TrianaTouristVicenteRufo.modelo.POI;
import com.salesianos.com.TrianaTouristVicenteRufo.repositorio.POIRepository;
import com.salesianos.com.TrianaTouristVicenteRufo.servicio.base.BaseService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class POIService extends BaseService<POI,Long, POIRepository> {



}
