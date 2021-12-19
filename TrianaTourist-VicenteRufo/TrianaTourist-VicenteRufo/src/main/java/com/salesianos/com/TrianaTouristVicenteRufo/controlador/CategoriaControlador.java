package com.salesianos.com.TrianaTouristVicenteRufo.controlador;

import com.salesianos.com.TrianaTouristVicenteRufo.dto.POIdto.ConverterPOIdto;
import com.salesianos.com.TrianaTouristVicenteRufo.dto.POIdto.GetPOIdto;
import com.salesianos.com.TrianaTouristVicenteRufo.dto.categoriaDTO.ConverterDTOCategoria;
import com.salesianos.com.TrianaTouristVicenteRufo.dto.categoriaDTO.CreateDTOCategoria;
import com.salesianos.com.TrianaTouristVicenteRufo.dto.categoriaDTO.GetDTOCategoria;
import com.salesianos.com.TrianaTouristVicenteRufo.modelo.Categoria;
import com.salesianos.com.TrianaTouristVicenteRufo.repositorio.CategoriaRepository;
import com.salesianos.com.TrianaTouristVicenteRufo.servicio.CategoriaService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/categoria")
@RequiredArgsConstructor
public class CategoriaControlador {

    private final CategoriaService categoriaService;
    private final ConverterDTOCategoria converterDTOCategoria;

    @GetMapping("/")
    public ResponseEntity<List<GetDTOCategoria>> findAll(){ return categoriaService.findAlll();}

    @GetMapping("/{id}")
    public ResponseEntity<List<GetDTOCategoria>> findOne(Long id){
        return categoriaService.findById(id);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteById(@PathVariable Long id){
        return categoriaService.delete(id);
    }

    @PostMapping("/")
    public ResponseEntity<Categoria> crear(@Valid @RequestBody CreateDTOCategoria c){
        return categoriaService.save(c);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Categoria> editar(@PathVariable("id") Long id,@Valid @RequestBody CreateDTOCategoria c){
      return categoriaService.edit(c,id);
    }
}
