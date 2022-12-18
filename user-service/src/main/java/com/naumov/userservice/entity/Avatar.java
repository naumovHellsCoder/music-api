package com.naumov.userservice.entity;

import lombok.*;
import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "avatar")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class Avatar {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long avatarId;

    private String originalFileName;

    @NotNull
    private String uniqueFileName;

    @NotNull
    private String fullPath;

    @NotNull
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;
}
