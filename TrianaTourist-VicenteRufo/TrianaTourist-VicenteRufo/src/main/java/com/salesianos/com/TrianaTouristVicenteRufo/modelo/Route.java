package com.salesianos.com.TrianaTouristVicenteRufo.modelo;

import lombok.*;
import org.hibernate.validator.constraints.UniqueElements;

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
    @JoinTable(joinColumns = @JoinColumn(name = "POI_id",
            foreignKey = @ForeignKey(name = "FK_RUTA_POI")),
            inverseJoinColumns = @JoinColumn(name = "route_id",
                    foreignKey = @ForeignKey(name = "FK_RUTA_ROUTE")),
            name = "ruta")
    private List<POI> poiList;
}
