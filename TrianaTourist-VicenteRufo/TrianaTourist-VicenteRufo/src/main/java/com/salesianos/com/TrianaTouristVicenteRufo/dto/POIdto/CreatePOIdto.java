package com.salesianos.com.TrianaTouristVicenteRufo.dto.POIdto;

import com.salesianos.com.TrianaTouristVicenteRufo.modelo.Categoria;
import com.salesianos.com.TrianaTouristVicenteRufo.modelo.Route;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Lob;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import java.time.LocalDateTime;
import java.util.List;

@Data
@NoArgsConstructor @AllArgsConstructor
public class CreatePOIdto {

    @NotBlank
    private String name;
    @Pattern(regexp ="^([-+]?\\d{1,2}[.]\\d+),\\s*([-+]?\\d{1,3}[.]\\d+)$",message = "Cambia al formato correcto")
    private String location;
    private String description;
    private Long categoria;
    private LocalDateTime dateTime;
    @NotBlank
    @Pattern(regexp = "(http)?s?:?(\\/\\/[^\"']*\\.(?:png|jpg|jpeg|gif|png|svg))")
    private String coverPhoto;
    @Pattern(regexp = "(http)?s?:?(\\/\\/[^\"']*\\.(?:png|jpg|jpeg|gif|png|svg))")
    private String photo2;
    @Pattern(regexp = "(http)?s?:?(\\/\\/[^\"']*\\.(?:png|jpg|jpeg|gif|png|svg))")
    private String photo3;

}
