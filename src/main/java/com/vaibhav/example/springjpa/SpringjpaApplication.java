package com.vaibhav.example.springjpa;

import com.vaibhav.example.springjpa.Config.DBConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;

import javax.sql.DataSource;

@SpringBootApplication
@Import({DBConfig.class})
public class SpringjpaApplication {


    public static void main(String[] args) {

        SpringApplication.run(SpringjpaApplication.class, args);

    }

}
