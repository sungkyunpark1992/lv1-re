package com.sparta.lv1restart;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing
//@SpringBootApplication
@SpringBootApplication(exclude = SecurityAutoConfiguration.class)//Security금지
public class Lv1RestartApplication {

    public static void main(String[] args) {
        SpringApplication.run(Lv1RestartApplication.class, args);
    }

}
