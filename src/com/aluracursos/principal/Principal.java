package com.aluracursos.principal;

import com.aluracursos.calculos.CalculadoraDeTiempo;
import com.aluracursos.calculos.FiltrosRecomendaciones;
import com.aluracursos.modelos.Episodios;
import com.aluracursos.modelos.Pelicula;
import com.aluracursos.modelos.Serie;

import java.util.ArrayList;

public class Principal {
    public static void main(String[] args) {
        Pelicula miPelicula = new Pelicula("F1", 2025);
        miPelicula.setDuracionEnMinutos(150);
        miPelicula.setIncluidoEnElPlan(true);


        Serie casaDragon = new Serie("Casa del dragon", 2002);
        casaDragon.setTemporadas(1);
        casaDragon.setMinutosPorEpisodio(50);
        casaDragon.setEpisodiosPorTemporada(10);

        casaDragon.muestraFichaTecnica();

        System.out.println(casaDragon.getDuracionEnMinutos());

        CalculadoraDeTiempo calculadora = new CalculadoraDeTiempo();
        calculadora.incluye(miPelicula);
        calculadora.incluye(casaDragon);
        System.out.println("Tiempo de peliculas y series para ver: " + calculadora.getTiempoTotal() + " minutos");

        FiltrosRecomendaciones filtrosRecomendaciones = new FiltrosRecomendaciones();
        filtrosRecomendaciones.filtrar(miPelicula);

        Episodios episodios = new Episodios();
        episodios.setNumero(1);
        episodios.setNombre("Reuniendo a la banda");
        episodios.setSerie(casaDragon);
        episodios.setTotalVisualizaciones(50);

        filtrosRecomendaciones.filtrar(episodios);

        var peliculaDeBruno = new Pelicula("El señor de los anillos", 2001);
        peliculaDeBruno.setDuracionEnMinutos(180);
        peliculaDeBruno.setFechaLanzamiento(2001);

        ArrayList<Pelicula> listaDePeliculas = new ArrayList<>();
        listaDePeliculas.add(miPelicula);
        listaDePeliculas.add(peliculaDeBruno);

        System.out.println("El tamaño de la lista es: " + listaDePeliculas.size());
        System.out.println("La primera pelicula es: " + listaDePeliculas.get(0).getNombre());

        System.out.println("toString de la pelicula: " + listaDePeliculas.get(0).toString());

    }
}
