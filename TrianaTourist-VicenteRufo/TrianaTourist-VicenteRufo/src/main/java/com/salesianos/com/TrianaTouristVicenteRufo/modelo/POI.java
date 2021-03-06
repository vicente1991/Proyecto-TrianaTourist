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


    public void add(Route route){
        route.getPoiList().add(this);
    }
    public void delete(Route route){
        route.getPoiList().remove(this);
    }
}
