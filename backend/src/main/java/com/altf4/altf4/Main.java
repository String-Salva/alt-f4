
package com.altf4.altf4;
import com.altf4.altf4.entity.Equipo;
import com.altf4.altf4.repository.EquipoRepository;
import java.util.ArrayList;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class Main {

    public static void main(String[] args) {
        SpringApplication.run(Altf4Application.class, args);
    }

    @Bean
    CommandLineRunner initData(EquipoRepository repository) {

        return args -> {

            Equipo e1 = new Equipo(
                    null,
                    "Real Madrid",
                    "Madrid",
                    new ArrayList<>());

            Equipo e2 = new Equipo(
                    null,
                    "FC Barcelona",
                    "Barcelona",
                    new ArrayList<>());

            Equipo e3 = new Equipo(
                    null,
                    "Sevilla FC",
                    "Sevilla",
                    new ArrayList<>());

            repository.save(e1);
            repository.save(e2);
            repository.save(e3);

        };
    }
}
