package com.aluracursos.principal;

import com.aluracursos.excepcion.ErrorConversionTiempoExcepcion;
import com.aluracursos.modelos.Titulo;
import com.aluracursos.modelos.TituloOmd;
import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.FileWriter;
import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class PrincipalBusqueda {

    public static void main(String[] args) throws IOException, InterruptedException {

        Scanner lectura = new Scanner(System.in);
        List<Titulo> titulos = new ArrayList<>();
        Gson gson = new GsonBuilder()
                .setFieldNamingPolicy(FieldNamingPolicy.UPPER_CAMEL_CASE)
                .setPrettyPrinting()
                .create();    //Crea el Gson coincidiendo el nombre de las variables como: titulo -> Titulo

            while(true){
            System.out.print("Ingrese el nombre de la pelicula: ");
            String busqueda = lectura.nextLine();

            if (busqueda.equalsIgnoreCase("salir")){
                break;
            }

            String direccion = "http://www.omdbapi.com/?t=" + busqueda.replace(" ", "+") + "&apikey=572a7fd8";

            try {
                HttpClient client = HttpClient.newHttpClient();
                HttpRequest request = HttpRequest.newBuilder().uri(URI.create(direccion)).build();
                HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());


                String json = response.body();  // response.body() -> tiene la informacion del Json que se recupera de la busqueda de la API
                System.out.println("Nuevo Json\n" + json);


                TituloOmd miTituloOmdb = gson.fromJson(json, TituloOmd.class);  //Solo captura y guarda los datos que nececito, es decir solo nombre, año y tiempo

                System.out.println(miTituloOmdb);


                Titulo miTitulo = new Titulo(miTituloOmdb);         //Se convierte el recod en un objeto con el que puedo cambiar sus valores y usar metodos setter
                System.out.println("Titulo ya convertido: " + miTitulo);

                titulos.add(miTitulo);
            } catch (NumberFormatException e) {
                System.out.println("Ocurrio un error: ");
                System.out.println(e.getMessage());
            } catch (IllegalArgumentException e) {
                System.out.println("Error en la URI, verifique la direccion: " + e.getMessage());
            } catch (ErrorConversionTiempoExcepcion e) {
                System.out.println(e.getMessage());
            }
        }
        System.out.println(titulos);

            FileWriter escritura = new FileWriter("titulos.json");
            escritura.write(gson.toJson(titulos));
            escritura.close();



        System.out.println("Finalizo la ejecucion del programa!!");

    }
}
