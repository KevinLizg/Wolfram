package cc.wolfram;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

public class ServerInitializer extends SpringBootServletInitializer {
    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder app){
        return app.sources(ServerInitializer.class);
    }

    public static void main(String[] args){
        SpringApplication.run(ServerInitializer.class, args);
    }
}
