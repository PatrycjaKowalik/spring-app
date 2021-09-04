package com.wine;

import com.wine.wines.CommentRepository;
import com.wine.wines.WineRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class MyWebAppApplication {

    public static void main(String[] args) {
        SpringApplication.run(MyWebAppApplication.class, args);
    }

}
