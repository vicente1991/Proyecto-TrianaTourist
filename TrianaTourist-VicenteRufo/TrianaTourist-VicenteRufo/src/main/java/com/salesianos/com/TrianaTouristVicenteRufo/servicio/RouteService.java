package com.salesianos.com.TrianaTouristVicenteRufo.servicio;

import com.salesianos.com.TrianaTouristVicenteRufo.dto.POIdto.GetPOIdto;
import com.salesianos.com.TrianaTouristVicenteRufo.dto.routeDTO.ConverterDTORoute;
import com.salesianos.com.TrianaTouristVicenteRufo.dto.routeDTO.CreateDTORoutes;
import com.salesianos.com.TrianaTouristVicenteRufo.dto.routeDTO.GetDTORoutes;
import com.salesianos.com.TrianaTouristVicenteRufo.errores.excepciones.EntityNotFoundException;
import com.salesianos.com.TrianaTouristVicenteRufo.errores.excepciones.ListEntityNotFoundException;
import com.salesianos.com.TrianaTouristVicenteRufo.modelo.Route;
import com.salesianos.com.TrianaTouristVicenteRufo.repositorio.RouteRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class RouteService {


    private final RouteRepository routeRepository;
    private final ConverterDTORoute dtoRoute;


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

    public Route save(CreateDTORoutes r){
        Route route= dtoRoute.createRouteDTOToRoute(r);
        routeRepository.save(route);
        return route;
    }


    public void deleteById(Long id){
        if(routeRepository.findById(id).isEmpty()){
            throw new EntityNotFoundException(id,Route.class);
        }else{
            routeRepository.deleteById(id);
        }
    }

    public Route edit (Long id, CreateDTORoutes c){
        Optional<Route> r =routeRepository.findById(id);

        if(r.isEmpty()){
            throw new EntityNotFoundException(id, Route.class);
        }
        return r.map(nuevo->{
            nuevo.setName(c.getName());
            nuevo.setPoiList(c.getPoiList());
            routeRepository.save(nuevo);
            return nuevo;
        }).get();

    }


}
