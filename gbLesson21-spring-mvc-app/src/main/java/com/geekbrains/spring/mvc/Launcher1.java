package com.geekbrains.spring.mvc;

import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.webapp.WebAppContext;

import java.net.URL;
import java.security.ProtectionDomain;

public class Launcher1 {

    public static void main(String[] args) throws Exception {
        Server server = new Server(8189);

        ProtectionDomain domain = Launcher1.class.getProtectionDomain();
        URL location = domain.getCodeSource().getLocation();

        WebAppContext webAppContext = new WebAppContext();
        webAppContext.setContextPath("/app");
        //http://localhost:8189/app/....
        webAppContext.setWar(location.toExternalForm());

        server.setHandler(webAppContext);
        server.start();
        server.join();
    }
}