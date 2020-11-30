package ru.itsjava.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @JoinColumn(name = "Name")
    private String name;

    @JoinColumn(name = "Email_id")
    @OneToOne(targetEntity = Email.class, cascade = CascadeType.ALL)
    private Email email;

    @JoinColumn(name = "Pet_id")
    @OneToOne(targetEntity = Pet.class, cascade = CascadeType.ALL)
    private Pet pet;


}
