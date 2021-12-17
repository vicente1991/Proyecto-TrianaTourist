package com.salesianos.com.TrianaTouristVicenteRufo.modelo;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.List;

@Entity
@NoArgsConstructor @AllArgsConstructor
@Getter @Setter @Builder
public class Route implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;

    private List<POI> poiList;
}
