package ru.itsjava.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "Name")
    private String name;

    @Column(name = "User_Email")
    @OneToOne(targetEntity = Email.class, cascade = CascadeType.ALL)
    private Email email;

    @Column(name = "User_Pet")
    @OneToOne(targetEntity = Pet.class, cascade = CascadeType.ALL)
    private Pet pet;


}
