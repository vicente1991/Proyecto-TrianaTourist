package com.salesianos.com.TrianaTouristVicenteRufo.modelo;


import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.Serializable;

@Entity
@AllArgsConstructor @NoArgsConstructor
@Getter @Setter @Builder
public class Categoria implements Serializable {


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String  name;
}
