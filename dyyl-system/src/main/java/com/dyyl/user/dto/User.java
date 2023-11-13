package com.dyyl.user.dto;

import com.dyyl.dto.user.SysUser;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Table;

@Data
@Entity
@Table(name = "sys_user")
public class User extends SysUser {
}
