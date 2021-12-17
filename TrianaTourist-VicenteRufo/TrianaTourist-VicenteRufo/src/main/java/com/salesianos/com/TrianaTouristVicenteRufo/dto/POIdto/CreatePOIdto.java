package com.salesianos.com.TrianaTouristVicenteRufo.dto.POIdto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Lob;

@Data
@NoArgsConstructor @AllArgsConstructor
public class CreatePOIdto {

    private String name;
    @Lob
    private String description;
}
