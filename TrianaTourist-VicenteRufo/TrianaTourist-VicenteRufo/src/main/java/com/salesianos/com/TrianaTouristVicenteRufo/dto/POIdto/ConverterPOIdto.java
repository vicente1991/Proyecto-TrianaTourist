package com.salesianos.com.TrianaTouristVicenteRufo.dto.POIdto;

import com.salesianos.com.TrianaTouristVicenteRufo.modelo.Categoria;
import com.salesianos.com.TrianaTouristVicenteRufo.modelo.POI;
import com.salesianos.com.TrianaTouristVicenteRufo.servicio.CategoriaService;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class ConverterPOIdto {

    private CategoriaService categoriaService;

    public POI converterPOIdtoToPOI(CreatePOIdto c){
        Optional<Categoria> categoria = categoriaService.findById(c.getCategoria());
        return POI.builder()
                .name(c.getName())
                .location(c.getLocation())
                .date(c.getDateTime())
                .description(c.getDescription())
                .categoria(categoria.get())
                .coverPhoto(c.getCoverPhoto())
                .photo2(c.getPhoto2())
                .photo3(c.getPhoto3())
                .routeList(c.getRouteList())
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
                .routes(p.getRouteList())
                .build();
    }
}
