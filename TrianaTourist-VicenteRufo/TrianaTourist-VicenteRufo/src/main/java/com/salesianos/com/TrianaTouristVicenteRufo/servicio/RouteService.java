package com.salesianos.com.TrianaTouristVicenteRufo.servicio;

import com.salesianos.com.TrianaTouristVicenteRufo.modelo.Route;
import com.salesianos.com.TrianaTouristVicenteRufo.repositorio.RouteRepository;
import com.salesianos.com.TrianaTouristVicenteRufo.servicio.base.BaseService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class RouteService extends BaseService<Route,Long, RouteRepository> {
}
