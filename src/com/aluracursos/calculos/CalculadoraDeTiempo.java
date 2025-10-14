package com.aluracursos.calculos;

import com.aluraursos.screenmatch.modelos.Pelicula;
import com.aluraursos.screenmatch.modelos.Serie;
import com.aluraursos.screenmatch.modelos.Titulo;

public class CalculadoraDeTiempo {

    private int tiempoTotal;

    public int getTiempoTotal() {
        return tiempoTotal;
    }

    public void incluye(Titulo titulo){
        tiempoTotal += titulo.getDuracionEnMinutos();
    }
}
