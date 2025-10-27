package com.aluracursos.principal;

import com.aluracursos.modelos.Titulo;
import com.aluracursos.modelos.TituloOmd;
import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

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

        Gson gson = new GsonBuilder().setFieldNamingPolicy(FieldNamingPolicy.UPPER_CAMEL_CASE).create();    //Crea el Gson coincidiendo el nombre de las variables como: titulo -> Titulo
        TituloOmd miTituloOmdb = gson.fromJson(json, TituloOmd.class);  //Solo captura y guarda los datos que nececito, es decir solo nombre, año y tiempo

        System.out.println(miTituloOmdb);

        try {
            Titulo miTitulo = new Titulo(miTituloOmdb);         //Se convierte el recod en un objeto con el que puedo cambiar sus valores y usar metodos setter
            System.out.println(miTitulo);
        }catch (NumberFormatException e){
            System.out.println("Ocurrio un error: ");
            System.out.println(e.getMessage());
        }

        System.out.println("Finalizo la ejecucion del programa!!");



    }
}
