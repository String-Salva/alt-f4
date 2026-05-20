package com.altf4.altf4;

import java.util.ArrayList;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.altf4.altf4.entity.Equipo;
import com.altf4.altf4.entity.Jugador;
import com.altf4.altf4.repository.EquipoRepository;
import com.altf4.altf4.repository.JugadorRepository;

@SpringBootApplication
public class Main {

    public static void main(String[] args) {
        SpringApplication.run(Main.class, args);
    }

    @Bean
    CommandLineRunner initData(
            EquipoRepository equipoRepository,
            JugadorRepository jugadorRepository) {

        return args -> {

            // EQUIPOS

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

            // Guardamos equipos primero
            e1 = equipoRepository.save(e1);
            e2 = equipoRepository.save(e2);
            e3 = equipoRepository.save(e3);


            // JUGADORES

            Jugador j1 = new Jugador();
            j1.setNombre("Jude Bellingham");
            j1.setDorsal(5);
            j1.setPosicion("Centrocampista");
            j1.setEquipo(e1);

            Jugador j2 = new Jugador();
            j2.setNombre("Vinicius Jr");
            j2.setDorsal(7);
            j2.setPosicion("Delantero");
            j2.setEquipo(e1);

            Jugador j3 = new Jugador();
            j3.setNombre("Lamine Yamal");
            j3.setDorsal(19);
            j3.setPosicion("Extremo");
            j3.setEquipo(e2);

            Jugador j4 = new Jugador();
            j4.setNombre("Lewandowski");
            j4.setDorsal(9);
            j4.setPosicion("Delantero");
            j4.setEquipo(e2);

            Jugador j5 = new Jugador();
            j5.setNombre("Jesús Navas");
            j5.setDorsal(16);
            j5.setPosicion("Lateral");
            j5.setEquipo(e3);

            Jugador j6 = new Jugador();
            j6.setNombre("Isaac Romero");
            j6.setDorsal(7);
            j6.setPosicion("Delantero");
            j6.setEquipo(e3);


            jugadorRepository.save(j1);
            jugadorRepository.save(j2);
            jugadorRepository.save(j3);
            jugadorRepository.save(j4);
            jugadorRepository.save(j5);
            jugadorRepository.save(j6);

        };
    }
}