package com.dyyl.dao;

import com.dyyl.dto.LoginUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserDao extends JpaRepository<LoginUser,Long> {

    LoginUser getLoginUserByUsername(String name);
}
