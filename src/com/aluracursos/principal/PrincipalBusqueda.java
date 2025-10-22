package com.aluracursos.principal;

import com.aluracursos.modelos.Titulo;
import com.google.gson.Gson;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Scanner;

public class PrincipalBusqueda {

    public static void main(String[] args) throws IOException, InterruptedException {

        Scanner lectura = new Scanner(System.in);

        System.out.print("Ingrese el nombre de la pelicula: ");
        String busqueda = lectura.nextLine();

        String direccion = "http://www.omdbapi.com/?t="+busqueda+"&apikey=572a7fd8";
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder().uri(URI.create(direccion)).build();
        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());


        String json = response.body();  // response.body() -> tiene la informacion del Json que se recupera de la busqueda de la API
        System.out.println("Nuevo Json\n" +json);

        Gson gson = new Gson();

        Titulo titulo = gson.fromJson(json, Titulo.class);

        System.out.println(titulo);

    }
}
