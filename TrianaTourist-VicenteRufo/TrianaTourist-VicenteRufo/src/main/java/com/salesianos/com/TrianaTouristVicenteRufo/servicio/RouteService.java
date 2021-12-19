package com.salesianos.com.TrianaTouristVicenteRufo.servicio;

import com.salesianos.com.TrianaTouristVicenteRufo.errores.excepciones.EntityNotFoundException;
import com.salesianos.com.TrianaTouristVicenteRufo.errores.excepciones.ListEntityNotFoundException;
import com.salesianos.com.TrianaTouristVicenteRufo.modelo.Route;
import com.salesianos.com.TrianaTouristVicenteRufo.repositorio.RouteRepository;
import com.salesianos.com.TrianaTouristVicenteRufo.servicio.base.BaseService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class RouteService extends {


    private final RouteRepository routeRepository;


    public List<Route> findAll(){
        if( routeRepository.findAll().isEmpty()) {
            throw new ListEntityNotFoundException(RouteService.class);
        }else{
            return routeRepository.findAll();
        }
    }

    public Optional<Route> findById(Long id){
        if( routeRepository.findById(id).isEmpty()){
            throw new EntityNotFoundException(id,Route.class);
        }else{
            return this.routeRepository.findById(id);
        }
    }

    public Route save(Route route){return routeRepository.save(route);}

    public void deleteById(Long id){
        if(routeRepository.findById(id).isEmpty()){
            throw new EntityNotFoundException(id,Route.class);
        }else{
            routeRepository.deleteById(id);
        }
    }

    public Route edit(Route route){return routeRepository.save(route);}

}
