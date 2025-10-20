package com.aluracursos.principal;

import com.aluracursos.modelos.Pelicula;
import com.aluracursos.modelos.Serie;
import com.aluracursos.modelos.Titulo;

import java.util.ArrayList;
import java.util.Collections;

public class PrincipalConListas {
    public static void main(String[] args) {
        Pelicula miPelicula = new Pelicula("F1", 2025);
        miPelicula.evalua(10);
        Pelicula otraPelicula = new Pelicula("Avatar", 2020);
        otraPelicula.evalua(8);
        Pelicula peliculaDeBruno = new Pelicula("Ford Vs Ferrari", 2022);
        peliculaDeBruno.evalua(9.9);
        Serie casaDragon = new Serie("Casa del dragon", 2002);
        casaDragon.evalua(6);


        ArrayList<Titulo> listaDePeliculas = new ArrayList<>();
        listaDePeliculas.add(miPelicula);

        listaDePeliculas.add(otraPelicula);
        listaDePeliculas.add(peliculaDeBruno);
        listaDePeliculas.add(casaDragon);

        for (Titulo item: listaDePeliculas) {
            System.out.println(item.getNombre());
            if (item instanceof Pelicula pelicula && pelicula.getClasificacion() > 3) {
                System.out.println(pelicula.getClasificacion());
            }
        }

        ArrayList <String> listaDeArtistas = new ArrayList<>();
        listaDeArtistas.add("Penelope Cruz");
        listaDeArtistas.add("Antonio Banderas");
        listaDeArtistas.add("Ricardo Darin");
        System.out.println(listaDeArtistas);

        Collections.sort(listaDeArtistas);
        System.out.println("Lista de artistas ordenada: " + listaDeArtistas);

        System.out.println("La lista de peliculas ordenada: "+ listaDePeliculas);

    }
}
