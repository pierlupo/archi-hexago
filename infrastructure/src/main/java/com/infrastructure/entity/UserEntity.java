package com.infrastructure.entity;


import jakarta.persistence.*;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Entity
@Table(name = "users")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UserEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name="name")
    @Size(min=4, message ="Username too short; must have at least {min} characters")
    private String name;

    @Column(name="user_name")
    private String username;

    @Column(name="password")
    private String password;

    @Column(name="email")
    private String email;


}
