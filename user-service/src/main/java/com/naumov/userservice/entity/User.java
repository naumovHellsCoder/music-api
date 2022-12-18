package com.naumov.userservice.entity;

import lombok.*;
import org.hibernate.validator.constraints.Length;
import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "user")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userId;

    @Length(min = 5, max = 15)
    @NotNull
    private String username;

    @Column(unique = true)
    @Length(min = 6, max = 30)
    @Email
    @NotNull
    private String email;

    @Length(min = 5, max = 25)
    @NotNull
    private String password;

    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "avatar_id")
    private Avatar avatar;

}
