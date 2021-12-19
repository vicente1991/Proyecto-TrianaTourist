package com.salesianos.com.TrianaTouristVicenteRufo.dto.categoriaDTO;

import com.salesianos.com.TrianaTouristVicenteRufo.validaciones.simple.UniqueName;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;

@Data
@AllArgsConstructor @NoArgsConstructor
@Builder
public class CreateDTOCategoria {

    @NotBlank
    @UniqueName
    private String name;

}
