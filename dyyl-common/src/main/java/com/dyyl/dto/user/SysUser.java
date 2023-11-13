package com.dyyl.dto.user;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@Entity
public class SysUser {

    @Id
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "password")
    private String password;
}
