package com.github.keraton;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching
public class ApplicationMain {

    private static Logger logger = LoggerFactory.getLogger(ApplicationMain.class);

    public static void main(String[] args) throws Exception {
        SpringApplication.run(ApplicationMain.class, args);
    }

}
