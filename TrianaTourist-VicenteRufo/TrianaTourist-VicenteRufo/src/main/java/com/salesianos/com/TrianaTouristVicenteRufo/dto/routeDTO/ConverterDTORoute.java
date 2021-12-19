package com.salesianos.com.TrianaTouristVicenteRufo.dto.routeDTO;

import com.salesianos.com.TrianaTouristVicenteRufo.modelo.Route;
import org.springframework.stereotype.Component;

@Component
public class ConverterDTORoute {

    public Route createRouteDTOToRoute(CreateDTORoutes c){
        return Route.builder()
                .name(c.getName())
                .poiList(c.getPoiList())
                .build();
    }

    public GetDTORoutes createRouteToRouteDTO(Route r){
        return GetDTORoutes.builder()
                .id(r.getId())
                .name(r.getName())
                .poiList(r.getPoiList())
                .build();
    }
}
