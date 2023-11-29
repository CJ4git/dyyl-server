package com.dyyl.dto.user;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
public class SysUser {

    private Long id;

    private String name;

    private String password;
}
