package tn.esprit.examen.entities;


import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Student implements Serializable {
    @Id
    //@GeneratedValue(strategy = GenerationType.IDENTITY)
    private String id; // Clé primaire
    private String nom;
    private Long classe;
}

