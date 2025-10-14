public class Principal {
    public static void main(String[] args) {
        Pelicula miPelicula = new Pelicula();
        miPelicula.nombre = "F1";
        miPelicula.fechaLanzamiento = 2025;
        miPelicula.duracionEnMinutos = 150;


        miPelicula.muestraFichaTecnica();
        miPelicula.evalua(10);
        miPelicula.evalua(10);

        System.out.println(miPelicula.getTotalEvaluaciones());
        System.out.println(miPelicula.getSumaDeLasEvaluaciones());
        System.out.println(miPelicula.calculaMedia());




    }
}
