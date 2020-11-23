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

    @JoinColumn(name = "Name")
    private String name;

    @JoinColumn(name = "User_Email")
    @OneToOne(targetEntity = Email.class, cascade = CascadeType.ALL)
    private Email email;

    @JoinColumn(name = "User_Pet")
    @OneToOne(targetEntity = Pet.class, cascade = CascadeType.ALL)
    private Pet pet;


}
