public class Pelicula {
    String nombre;
    int fechaLanzamiento;
    int duracionEnMinutos;
    boolean incluidoEnElPlan;
    private double sumaDeLasEvaluaciones;
    private int totalEvaluaciones;


    void muestraFichaTecnica(){
        System.out.println("\nEl nombre de la pelicula es: "+ nombre);
        System.out.println("SU fecha de lanzamiento es: "+ fechaLanzamiento);
        System.out.println("Duracion en minutos: " + duracionEnMinutos );
    }

    void evalua(double nota){
        sumaDeLasEvaluaciones += nota;
        totalEvaluaciones++;
    }

    double calculaMedia(){
        return sumaDeLasEvaluaciones/totalEvaluaciones;
    }

    int getTotalEvaluaciones (){
        return totalEvaluaciones;
    }

    double getSumaDeLasEvaluaciones(){
        return sumaDeLasEvaluaciones;
    }
}
