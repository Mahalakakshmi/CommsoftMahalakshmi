package me.app.aircraft;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import me.app.aircraft.domain.Aircraft;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;
import org.springframework.beans.factory.BeanFactory;


@SpringBootApplication
@EnableSwagger2
@ComponentScan({"me.app.aircraft.service","me.app.aircraft.controller"})
@EntityScan({"me.app.aircraft.domain","me.app.flight","me.app.component"})
@EnableJpaRepositories("me.app.aircraft.repo")


public class AircraftApp {
	
	


    public static void main(String[] args) {
        SpringApplication.run(AircraftApp.class, args);
        
    }
    

    /**
     * Autowire swagger bean to
     * enable UI.
     * @return swagger config bean
     */
   
    
    @Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.any())
                .paths(PathSelectors.any())
                .build();
    }
}
