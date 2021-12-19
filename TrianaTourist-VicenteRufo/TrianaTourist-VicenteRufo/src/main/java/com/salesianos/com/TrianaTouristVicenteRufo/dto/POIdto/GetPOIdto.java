package com.salesianos.com.TrianaTouristVicenteRufo.dto.POIdto;

import com.salesianos.com.TrianaTouristVicenteRufo.modelo.Categoria;
import com.salesianos.com.TrianaTouristVicenteRufo.modelo.Route;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@Data
@NoArgsConstructor @AllArgsConstructor
@Builder
public class GetPOIdto {

    private Long id;
    private String name;
    private String location;
    private String description;
    private LocalDateTime date;
    private Categoria category;
    private String coverPhoto;
    private String photo2;
    private String photo3;
    private List<Route> routes;
}
