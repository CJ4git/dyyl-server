package com.dyyl.dao;

import com.dyyl.dto.user.SysUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserDao extends JpaRepository<SysUser,Long> {

    SysUser getSysUserByName(String name);
}
