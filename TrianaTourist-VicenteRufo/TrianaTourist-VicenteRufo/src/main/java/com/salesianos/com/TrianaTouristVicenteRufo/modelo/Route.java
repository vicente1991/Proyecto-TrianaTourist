package com.salesianos.com.TrianaTouristVicenteRufo.modelo;

import lombok.*;

import javax.persistence.*;
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

    @ManyToMany
    @JoinTable(
            joinColumns = @JoinColumn(name = "poi_id"),
            inverseJoinColumns = @JoinColumn(name = "route_id")
    )
    private List<POI> poiList;
}
