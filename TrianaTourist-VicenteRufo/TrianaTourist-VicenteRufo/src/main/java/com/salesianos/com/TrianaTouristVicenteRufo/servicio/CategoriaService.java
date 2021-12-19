package com.salesianos.com.TrianaTouristVicenteRufo.servicio;

import com.salesianos.com.TrianaTouristVicenteRufo.dto.categoriaDTO.ConverterDTOCategoria;
import com.salesianos.com.TrianaTouristVicenteRufo.dto.categoriaDTO.CreateDTOCategoria;
import com.salesianos.com.TrianaTouristVicenteRufo.dto.categoriaDTO.GetDTOCategoria;
import com.salesianos.com.TrianaTouristVicenteRufo.errores.excepciones.ListEntityNotFoundException;
import com.salesianos.com.TrianaTouristVicenteRufo.errores.excepciones.SingleEntityNotFoundException;
import com.salesianos.com.TrianaTouristVicenteRufo.modelo.Categoria;
import com.salesianos.com.TrianaTouristVicenteRufo.repositorio.CategoriaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;


@Service
@RequiredArgsConstructor
public class CategoriaService {


    private final CategoriaRepository categoriaRepository;
    private final ConverterDTOCategoria converterDTOCategoria;

    public ResponseEntity<List<GetDTOCategoria>> findAlll(){

        if( categoriaRepository.findAll().isEmpty()){
            throw new ListEntityNotFoundException(Categoria.class);
        }else{
            List<GetDTOCategoria> result = categoriaRepository.findAll().stream().map(converterDTOCategoria::createCategoriaToCategoriaDTO )
                    .collect(Collectors.toList());

            return ResponseEntity.ok(result);
        }
    }

    public ResponseEntity<List<GetDTOCategoria>> findById(Long id) {
        Optional<Categoria> dato = categoriaRepository.findById(id);
        if (dato.isEmpty()) {
            throw new SingleEntityNotFoundException(id.toString(), Categoria.class);
        } else {
            List<GetDTOCategoria> result = dato.stream().map(converterDTOCategoria::createCategoriaToCategoriaDTO)
                    .collect(Collectors.toList());
            return ResponseEntity.ok().body(result);
        }
    }

    public ResponseEntity<Categoria> save(CreateDTOCategoria categoriadto){
        Categoria categoria =converterDTOCategoria.createCategoriaDTOToCategoria(categoriadto);

        return ResponseEntity.status(HttpStatus.CREATED).body(categoriaRepository.save(categoria));
    }


    public ResponseEntity<?> delete(Long id) {

        Optional<Categoria> data = categoriaRepository.findById(id);

        if (data.isEmpty()) {
            throw new SingleEntityNotFoundException(id.toString(), Categoria.class);
        } else {
            categoriaRepository.deleteById(id);
            return ResponseEntity.status(204).build();
        }

    }

    public ResponseEntity<Categoria> edit(CreateDTOCategoria categoria,Long id){
        Optional<Categoria> dato = categoriaRepository.findById(id);

        if (dato.isEmpty()) {
            throw new SingleEntityNotFoundException(id.toString(), Categoria.class);
        } else {
            return ResponseEntity.of(categoriaRepository.findById(id).map(
                    m -> {
                        m.setName(categoria.getName());
                        categoriaRepository.save(m);
                        return m;
                    }
            ));
        }}

}
