package net.strocamp.stadsspel.main;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.context.web.SpringBootServletInitializer;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan(basePackages = {"net.strocamp.stadsspel.controllers", "net.strocamp.stadsspel.providers"})
@EnableAutoConfiguration
public class Stadsspel extends SpringBootServletInitializer {

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
        return builder.sources(Stadsspel.class);
    }

    public static void main(String[] args) throws Exception {
        SpringApplication.run(Stadsspel.class, args);
    }
}
