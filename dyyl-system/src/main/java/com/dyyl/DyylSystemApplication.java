package com.dyyl;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan(basePackages = "com.dyyl.**.mapper")
public class DyylSystemApplication {

    public static void main(String[] args) {
        SpringApplication.run(DyylSystemApplication.class, args);
    }

}
