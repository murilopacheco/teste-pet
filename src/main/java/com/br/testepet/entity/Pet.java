package com.br.testepet.entity;

import com.br.testepet.enums.Porte;
import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class Pet {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(unique = true)
    private String nome;

    private String especie;

    private LocalDate dataNascimento;

    private Porte porte;

    private boolean ativo;
}
