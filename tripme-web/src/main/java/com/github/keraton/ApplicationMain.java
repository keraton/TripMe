package com.github.keraton;

import com.github.keraton.configuration.TripmeConfig;
import com.github.keraton.handler.TripSearchHandler;
import com.sun.net.httpserver.HttpServer;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.net.InetSocketAddress;
import java.util.concurrent.Executors;

public class ApplicationMain {

    public static void main(String[] args) throws Exception {
        System.out.println("Start Server");

        ApplicationContext ctxJavaConfig = new AnnotationConfigApplicationContext(TripmeConfig.class);
        TripSearchHandler tripSearchHandler = ctxJavaConfig.getBean(TripSearchHandler.class);


        HttpServer server = HttpServer.create(new InetSocketAddress(8080), 0);
        server.createContext("/trip", tripSearchHandler);
        //server.setExecutor(null); // creates a default executor
        server.setExecutor(Executors.newFixedThreadPool(100)); // creates a default executor
        server.start();
    }

}
