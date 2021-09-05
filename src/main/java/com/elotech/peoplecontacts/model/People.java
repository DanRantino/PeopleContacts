package com.elotech.peoplecontacts.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.persistence.Id;
import java.math.BigInteger;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Entity
public class People {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int Id;
    @Column
    private String Nome;
    @Column
    private long CPF;
    @Column
    private String dataNasc;

}
