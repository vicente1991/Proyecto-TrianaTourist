package com.salesianos.com.TrianaTouristVicenteRufo.dto.categoriaDTO;

import com.salesianos.com.TrianaTouristVicenteRufo.modelo.Categoria;
import org.springframework.stereotype.Component;

@Component
public class ConverterDTOCategoria {

    public Categoria createCategoriaDTOToCategoria(CreateDTOCategoria c){
        return Categoria.builder()
                .name(c.getName())
                .build();
    }


    public GetDTOCategoria createCategoriaToCategoriaDTO(Categoria ca){
        return GetDTOCategoria.builder()
                .id(ca.getId())
                .name(ca.getName())
                .build();
    }
}

