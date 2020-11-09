package ru.itsjava.domain;

import lombok.AllArgsConstructor;
import lombok.Data;

import javax.persistence.*;

@Data
@AllArgsConstructor
@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @JoinColumn(name = "Name")
    private String name;

    @JoinColumn(name = "Email")
    private Email email;

    @JoinColumn(name = "Pet")
    private Pet pet;
}
