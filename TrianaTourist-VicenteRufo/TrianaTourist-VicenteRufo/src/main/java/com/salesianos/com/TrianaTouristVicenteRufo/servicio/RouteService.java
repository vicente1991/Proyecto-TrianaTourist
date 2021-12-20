package com.salesianos.com.TrianaTouristVicenteRufo.servicio;

import com.salesianos.com.TrianaTouristVicenteRufo.dto.routeDTO.ConverterDTORoute;
import com.salesianos.com.TrianaTouristVicenteRufo.dto.routeDTO.CreateDTORoutes;
import com.salesianos.com.TrianaTouristVicenteRufo.dto.routeDTO.GetDTORoutes;
import com.salesianos.com.TrianaTouristVicenteRufo.errores.excepciones.EntityNotFoundException;
import com.salesianos.com.TrianaTouristVicenteRufo.errores.excepciones.ListEntityNotFoundException;
import com.salesianos.com.TrianaTouristVicenteRufo.modelo.Route;
import com.salesianos.com.TrianaTouristVicenteRufo.repositorio.RouteRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.swing.text.html.Option;
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

    public void save(Route r){routeRepository.save(r);}


    public void deleteById(Long id){
        if(routeRepository.findById(id).isEmpty()){
            throw new EntityNotFoundException(id,Route.class);
        }else{
            routeRepository.deleteById(id);
        }
    }

    public Optional<GetDTORoutes> edit (Long id, CreateDTORoutes c){
        return findById(id).map(nuevo -> {
            nuevo.setName(c.getName());
            nuevo.setPoiList(c.getPoiList());
            save(nuevo);
            return dtoRoute.createRouteToRouteDTO(nuevo);
        });
    }
}
