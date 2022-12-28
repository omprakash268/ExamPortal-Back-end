package com.exam.Entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@NoArgsConstructor
@Getter
@Setter
@ToString
@Table(name = "UserRoles")
public class UserRole {

    @Id
    @GeneratedValue
    private  Long roleId;
    @ManyToOne(fetch = FetchType.EAGER)
    private  User user;

    @ManyToOne
    private  Role role;


}
