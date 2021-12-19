package com.salesianos.com.TrianaTouristVicenteRufo.controlador;

import com.salesianos.com.TrianaTouristVicenteRufo.dto.POIdto.ConverterPOIdto;
import com.salesianos.com.TrianaTouristVicenteRufo.dto.POIdto.CreatePOIdto;
import com.salesianos.com.TrianaTouristVicenteRufo.dto.POIdto.GetPOIdto;
import com.salesianos.com.TrianaTouristVicenteRufo.modelo.POI;
import com.salesianos.com.TrianaTouristVicenteRufo.servicio.CategoriaService;
import com.salesianos.com.TrianaTouristVicenteRufo.servicio.POIService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
@RequestMapping("/poi")
public class POIControlador {

    private final POIService poiService;
    private final ConverterPOIdto converterPOIdto;
    private final CategoriaService categoriaService;


    @GetMapping("/")
    public ResponseEntity<List<POI>> findAll(){return ResponseEntity.ok().body(poiService.findAll());}

    @GetMapping("/{id}")
    public ResponseEntity<GetPOIdto> findOne(@PathVariable Long id){
        return ResponseEntity.ok().body(converterPOIdto.converterPOIToPOIdto(poiService.findById(id).get()));//mirar si funciona
    }

    @DeleteMapping("{id}")
    public ResponseEntity<?> delete(@PathVariable Long id){
        poiService.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    @PostMapping("/")
    public ResponseEntity<GetPOIdto> crear(@Valid @RequestBody CreatePOIdto c){
        poiService.save(converterPOIdto.converterPOIdtoToPOI(c));
        return ResponseEntity.ok().body(converterPOIdto.converterPOIToPOIdto(converterPOIdto.converterPOIdtoToPOI(c)));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Optional<GetPOIdto>> edit(@PathVariable Long id, @Valid @RequestBody CreatePOIdto c){
        return ResponseEntity.ok().body(poiService.findById(id).map(nuevo ->{
            nuevo.setName(c.getName());
            nuevo.setLocation(c.getLocation());
            nuevo.setCategoria(categoriaService.findById(c.getCategoria()).get());
            nuevo.setDescription(c.getDescription());
            nuevo.setCoverPhoto(c.getCoverPhoto());
            nuevo.setPhoto2(c.getPhoto2());
            nuevo.setPhoto3(c.getPhoto3());
            poiService.save(nuevo);
            return converterPOIdto.converterPOIToPOIdto(nuevo);
        }));
    }

}
