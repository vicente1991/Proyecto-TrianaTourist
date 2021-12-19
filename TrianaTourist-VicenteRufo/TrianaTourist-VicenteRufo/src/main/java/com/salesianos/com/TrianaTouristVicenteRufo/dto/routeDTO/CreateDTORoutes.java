package com.salesianos.com.TrianaTouristVicenteRufo.dto.routeDTO;

import com.salesianos.com.TrianaTouristVicenteRufo.modelo.POI;
import com.salesianos.com.TrianaTouristVicenteRufo.validaciones.simple.UniqueRouteName;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import java.util.List;

@Data
@NoArgsConstructor @AllArgsConstructor
@Builder
public class CreateDTORoutes {

    @NotBlank
    @UniqueRouteName
    private String name;

    private List<POI> poiList;
}
