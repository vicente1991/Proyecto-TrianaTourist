package com.salesianos.com.TrianaTouristVicenteRufo.controlador;

import com.salesianos.com.TrianaTouristVicenteRufo.dto.routeDTO.ConverterDTORoute;
import com.salesianos.com.TrianaTouristVicenteRufo.dto.routeDTO.CreateDTORoutes;
import com.salesianos.com.TrianaTouristVicenteRufo.dto.routeDTO.GetDTORoutes;
import com.salesianos.com.TrianaTouristVicenteRufo.modelo.POI;
import com.salesianos.com.TrianaTouristVicenteRufo.modelo.Route;
import com.salesianos.com.TrianaTouristVicenteRufo.servicio.POIService;
import com.salesianos.com.TrianaTouristVicenteRufo.servicio.RouteService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/route")
public class RouteControlador {

    private final RouteService routeService;
    private final ConverterDTORoute dtoRoute;
    private final POIService poiService;


    @GetMapping("/")
    public ResponseEntity<List<Route>> findAll(){return ResponseEntity.ok().body(routeService.findAll());}

    @PostMapping("/")
    public ResponseEntity<GetDTORoutes> crear(@Valid @PathVariable Long id, @Valid @RequestBody CreateDTORoutes c){
        routeService.save(dtoRoute.createRouteDTOToRoute(c));
        return ResponseEntity.status(HttpStatus.CREATED).body(dtoRoute.createRouteToRouteDTO(dtoRoute.createRouteDTOToRoute(c)));
    }

    @PostMapping("/{id}/poi/{id2}")
    public ResponseEntity<GetDTORoutes> añadirPOI(@Valid @PathVariable("id") Long id,@PathVariable("id2") Long id2){
        poiService.findById(id2).get().add(routeService.findById(id).get());
        poiService.save(poiService.findById(id2).get());
        return ResponseEntity.ok().body(dtoRoute.createRouteToRouteDTO(routeService.findById(id).get()));
    }

    @DeleteMapping("/{id}/poi/{id2}")
    public ResponseEntity<GetDTORoutes> eliminarPOI(@Valid @PathVariable("id") Long id,@PathVariable("id2") Long id2){
        poiService.findById(id2).get().delete(routeService.findById(id).get());
        poiService.save(poiService.findById(id2).get());
        return ResponseEntity.ok().body(dtoRoute.createRouteToRouteDTO(routeService.findById(id).get()));
    }
}
