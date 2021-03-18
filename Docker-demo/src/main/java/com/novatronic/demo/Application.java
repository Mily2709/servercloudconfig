package com.novatronic.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

/**
 * Clase utilizada por spring-boot para arrancar la aplicación.
 *
 * @author Omar
 */
@ComponentScan(basePackages = "com.novatronic.demo")
@SpringBootApplication
public class Application {
    /**
     * Metodo para arrancar la aplicación
     * @param args 
     */
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

}
