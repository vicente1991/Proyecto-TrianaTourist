package com.salesianos.com.TrianaTouristVicenteRufo.dto.POIdto;

import com.salesianos.com.TrianaTouristVicenteRufo.modelo.Categoria;
import com.salesianos.com.TrianaTouristVicenteRufo.modelo.POI;
import com.salesianos.com.TrianaTouristVicenteRufo.repositorio.CategoriaRepository;
import com.salesianos.com.TrianaTouristVicenteRufo.servicio.CategoriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class ConverterPOIdto {

    @Autowired
    private CategoriaRepository categoriaRepository;

    public POI converterPOIdtoToPOI(CreatePOIdto c){
        return POI.builder()
                .name(c.getName())
                .location(c.getLocation())
                .date(c.getDateTime())
                .description(c.getDescription())
                .categoria(categoriaRepository.findById(c.getCategoria()).get())
                .coverPhoto(c.getCoverPhoto())
                .photo2(c.getPhoto2())
                .photo3(c.getPhoto3())
                .build();
    }

    public GetPOIdto converterPOIToPOIdto(POI p){
        return GetPOIdto.builder()
                .id(p.getId())
                .name(p.getName())
                .description(p.getDescription())
                .category(p.getCategoria())
                .location(p.getLocation())
                .date(p.getDate())
                .coverPhoto(p.getCoverPhoto())
                .photo2(p.getPhoto2())
                .photo3(p.getPhoto3())
                .build();
    }
}
