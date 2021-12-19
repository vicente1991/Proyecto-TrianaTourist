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
import java.util.Optional;

@RestController
@RequiredArgsConstructor
@RequestMapping("/route")
public class RouteControlador {

    private final RouteService routeService;
    private final ConverterDTORoute dtoRoute;
    private final POIService poiService;


    @GetMapping("/")
    public ResponseEntity<List<Route>> findAll(){return ResponseEntity.ok().body(routeService.findAll());}

    @GetMapping("/{id}")
    public ResponseEntity<GetDTORoutes> findById(@PathVariable Long id){
        Route r= routeService.findById(id).get();
        return ResponseEntity.ok().body(dtoRoute.createRouteToRouteDTO(r));
    }

    @PostMapping("/")
    public ResponseEntity<GetDTORoutes> crear(@Valid @PathVariable Long id, @Valid @RequestBody CreateDTORoutes c){
        routeService.save(dtoRoute.createRouteDTOToRoute(c));
        return ResponseEntity.status(HttpStatus.CREATED).body(dtoRoute.createRouteToRouteDTO(dtoRoute.createRouteDTOToRoute(c)));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteById(@PathVariable Long id){
        routeService.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Optional<GetDTORoutes>> edit(@PathVariable Long id, @Valid @RequestBody CreateDTORoutes dto){
        return ResponseEntity.ok().body(routeService.edit(id,dto));
    }

    @PostMapping("/{id}/poi/{id2}")
    public ResponseEntity<GetDTORoutes> añadirPOI(@Valid @PathVariable("id") Long id,@PathVariable("id2") Long id2){
        Route r = routeService.findById(id).get();
        POI p= poiService.findById(id2).get();
        p.add(r);
        return ResponseEntity.ok().body(dtoRoute.createRouteToRouteDTO(r));
    }

    @DeleteMapping("/{id}/poi/{id2}")
    public ResponseEntity<GetDTORoutes> eliminarPOI(@Valid @PathVariable("id") Long id,@PathVariable("id2") Long id2){
        Route r = routeService.findById(id).get();
        POI p= poiService.findById(id2).get();
        p.delete(r);;
        return ResponseEntity.ok().body(dtoRoute.createRouteToRouteDTO(r));
    }
}
