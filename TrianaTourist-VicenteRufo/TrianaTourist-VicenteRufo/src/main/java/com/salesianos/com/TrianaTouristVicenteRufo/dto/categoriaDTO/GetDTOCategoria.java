package com.salesianos.com.TrianaTouristVicenteRufo.dto.categoriaDTO;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor @AllArgsConstructor
@Builder
public class GetDTOCategoria {

    private Long id;
    private String name;
}
