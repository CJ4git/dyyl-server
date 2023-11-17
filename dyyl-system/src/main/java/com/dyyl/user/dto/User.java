package com.dyyl.user.dto;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@Entity
@Table(name = "sys_user")
public class User {
    @Id
    private Long id;

    private String name;

    private String password;
}
