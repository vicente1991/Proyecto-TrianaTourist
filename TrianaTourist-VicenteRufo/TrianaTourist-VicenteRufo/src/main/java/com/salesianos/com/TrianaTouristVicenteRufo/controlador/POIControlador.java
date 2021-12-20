package com.salesianos.com.TrianaTouristVicenteRufo.controlador;

import com.salesianos.com.TrianaTouristVicenteRufo.dto.POIdto.ConverterPOIdto;
import com.salesianos.com.TrianaTouristVicenteRufo.dto.POIdto.CreatePOIdto;
import com.salesianos.com.TrianaTouristVicenteRufo.dto.POIdto.GetPOIdto;
import com.salesianos.com.TrianaTouristVicenteRufo.dto.categoriaDTO.GetDTOCategoria;
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
        Optional<POI> p= poiService.findById(id);
        return ResponseEntity.ok().body(converterPOIdto.converterPOIToPOIdto(p.get()));//mirar si funciona
    }

    @DeleteMapping("{id}")
    public ResponseEntity<?> delete(@PathVariable Long id){
        poiService.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    @PostMapping("/")
    public ResponseEntity<CreatePOIdto> crear(@Valid @RequestBody CreatePOIdto c){
        POI poi = converterPOIdto.converterPOIdtoToPOI(c);
        poiService.save(poi);
        return ResponseEntity.ok().body(c);
    }

    @PutMapping("/{id}")
    public ResponseEntity<CreatePOIdto> edit(@PathVariable Long id, @Valid @RequestBody CreatePOIdto c){
        poiService.edit(id, c);
       return ResponseEntity.ok().body(c);
    }

}
