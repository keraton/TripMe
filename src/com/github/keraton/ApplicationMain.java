package com.github.keraton;

import com.github.keraton.handler.TripSearchHandler;
import com.sun.net.httpserver.HttpServer;

import java.net.InetSocketAddress;

public class ApplicationMain {

    public static void main(String[] args) throws Exception {
        System.out.println("Start Server");
        HttpServer server = HttpServer.create(new InetSocketAddress(8080), 0);
        server.createContext("/trip", new TripSearchHandler());
        server.setExecutor(null); // creates a default executor
        server.start();
    }

}
