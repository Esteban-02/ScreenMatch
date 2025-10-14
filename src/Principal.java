import com.aluracursos.calculos.CalculadoraDeTiempo;
import com.aluracursos.calculos.FiltrosRecomendaciones;
import com.aluraursos.screenmatch.modelos.Episodios;
import com.aluraursos.screenmatch.modelos.Pelicula;
import com.aluraursos.screenmatch.modelos.Serie;

public class Principal {
    public static void main(String[] args) {
        Pelicula miPelicula = new Pelicula();
        miPelicula.setNombre("F1");
        miPelicula.setFechaLanzamiento(2025);
        miPelicula.setDuracionEnMinutos(150);
        miPelicula.setIncluidoEnElPlan(true);


        Serie casaDragon = new Serie();
        casaDragon.setNombre("Casa del dragon");
        casaDragon.setFechaLanzamiento(2022);
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


    }
}
