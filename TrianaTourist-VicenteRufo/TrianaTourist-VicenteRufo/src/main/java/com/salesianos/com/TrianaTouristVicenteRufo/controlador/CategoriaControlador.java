package com.salesianos.com.TrianaTouristVicenteRufo.controlador;

import com.salesianos.com.TrianaTouristVicenteRufo.dto.POIdto.ConverterPOIdto;
import com.salesianos.com.TrianaTouristVicenteRufo.dto.POIdto.GetPOIdto;
import com.salesianos.com.TrianaTouristVicenteRufo.dto.categoriaDTO.ConverterDTOCategoria;
import com.salesianos.com.TrianaTouristVicenteRufo.dto.categoriaDTO.GetDTOCategoria;
import com.salesianos.com.TrianaTouristVicenteRufo.modelo.Categoria;
import com.salesianos.com.TrianaTouristVicenteRufo.repositorio.CategoriaRepository;
import com.salesianos.com.TrianaTouristVicenteRufo.servicio.CategoriaService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/categoria")
@RequiredArgsConstructor
public class CategoriaControlador {

    private final CategoriaService categoriaService;
    private final ConverterDTOCategoria converterDTOCategoria;

    @GetMapping("/")
    public ResponseEntity<List<Categoria>> findAll(){ return ResponseEntity.ok().body(categoriaService.findAll());}

    @GetMapping("/{id}")
    public ResponseEntity<GetDTOCategoria> findOne(Long id){
        return ResponseEntity.ok().body(converterDTOCategoria.createCategoriaToCategoriaDTO(categoriaService.findById(id).get()));
    }
}
