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
    public ResponseEntity<List<Categoria>> findAll(){ return ResponseEntity.ok().body(categoriaService.findAll());}

    @GetMapping("/{id}")
    public ResponseEntity<GetDTOCategoria> findOne(Long id){
        return ResponseEntity.ok().body(converterDTOCategoria.createCategoriaToCategoriaDTO(categoriaService.findById(id).get()));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteById(@PathVariable Long id){
        categoriaService.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    @PostMapping("/")
    public ResponseEntity<GetDTOCategoria> crear(@Valid @RequestBody CreateDTOCategoria c){
        categoriaService.save(converterDTOCategoria.createCategoriaDTOToCategoria(c));
        return ResponseEntity.status(HttpStatus.CREATED).body(converterDTOCategoria.createCategoriaToCategoriaDTO(converterDTOCategoria.createCategoriaDTOToCategoria(c)));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Optional<GetDTOCategoria>> editar(@PathVariable Long id,@Valid @RequestBody CreateDTOCategoria c){
        return ResponseEntity.ok().body(categoriaService.findById(id).map(nuevonombre ->{
            nuevonombre.setName(c.getName());
            categoriaService.edit(nuevonombre);
            return converterDTOCategoria.createCategoriaToCategoriaDTO(nuevonombre);
        }));
    }
}
