package com.salesianos.com.TrianaTouristVicenteRufo.dto.routeDTO;

import com.salesianos.com.TrianaTouristVicenteRufo.modelo.POI;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor @AllArgsConstructor
@Builder
public class CreateDTORoutes {

    private String name;

    private List<POI> poiList;
}
