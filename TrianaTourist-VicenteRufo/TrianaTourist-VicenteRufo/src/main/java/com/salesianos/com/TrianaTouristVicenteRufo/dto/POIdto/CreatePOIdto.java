package com.salesianos.com.TrianaTouristVicenteRufo.dto.POIdto;

import com.salesianos.com.TrianaTouristVicenteRufo.modelo.Categoria;
import com.salesianos.com.TrianaTouristVicenteRufo.modelo.Route;
import com.salesianos.com.TrianaTouristVicenteRufo.validaciones.multiple.NoPhotoRepeat;
import com.salesianos.com.TrianaTouristVicenteRufo.validaciones.simple.UniqueLocation;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.URL;

import javax.persistence.Lob;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import java.time.LocalDateTime;
import java.util.List;

@Data
@NoArgsConstructor @AllArgsConstructor
@NoPhotoRepeat(fields = {"coverPhoto", "photo2", "photo3"})
public class CreatePOIdto {

    @NotBlank
    private String name;
    @UniqueLocation
    @Pattern(regexp ="^([-+]?\\d{1,2}[.]\\d+),\\s*([-+]?\\d{1,3}[.]\\d+)$",message = "Cambia al formato correcto")
    private String location;
    private String description;
    private Long categoria;
    private LocalDateTime dateTime;
    @NotBlank
    @URL
    private String coverPhoto;
    @URL
    private String photo2;
    @URL
    private String photo3;

}
