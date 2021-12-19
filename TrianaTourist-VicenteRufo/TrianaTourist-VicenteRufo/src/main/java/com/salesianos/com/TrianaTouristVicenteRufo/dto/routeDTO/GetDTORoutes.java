package com.salesianos.com.TrianaTouristVicenteRufo.dto.routeDTO;

import com.salesianos.com.TrianaTouristVicenteRufo.modelo.POI;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor @NoArgsConstructor
@Builder
public class GetDTORoutes {

    private Long id;

    private String name;

    private List<POI> poiList;
}
