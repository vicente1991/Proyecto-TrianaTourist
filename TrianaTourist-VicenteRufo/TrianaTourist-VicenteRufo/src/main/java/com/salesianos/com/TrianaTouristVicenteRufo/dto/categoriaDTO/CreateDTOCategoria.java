package com.salesianos.com.TrianaTouristVicenteRufo.dto.categoriaDTO;

import com.salesianos.com.TrianaTouristVicenteRufo.validaciones.simple.UniqueName;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Data
@AllArgsConstructor @NoArgsConstructor
@Builder
public class CreateDTOCategoria {

    private Long id;
    @NotBlank
    @NotNull
    @UniqueName
    private String name;

}
