package org.exad.examenad_postgresql;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class ExamenAdPostgreSqlApplication {

    public static void main(String[] args) {
        SpringApplication.run(ExamenAdPostgreSqlApplication.class, args);
    }

}
