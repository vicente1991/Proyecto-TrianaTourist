package com.salesianos.com.TrianaTouristVicenteRufo.modelo;


import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@NoArgsConstructor @AllArgsConstructor
@Getter @Setter @Builder
public class POI implements Serializable {


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;
    private String location;
    @Lob
    private String description;
    private LocalDateTime date;
    @ManyToOne
    @JoinColumn(name = "categoria_id")
    private Categoria categoria;
    private String coverPhoto;
    private String photo2;
    private String photo3;

    @ManyToMany
    @JoinTable(
            joinColumns = @JoinColumn(name = "poi_id"),
            inverseJoinColumns = @JoinColumn(name = "route_id")
    )
    private List<Route>routeList= new ArrayList<>();
}
