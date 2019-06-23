package Vista;

import Modelo.Juego.Algocraft;
import Modelo.Juego.Casillero;
import Modelo.Juego.Mapa;
import Modelo.Jugador.Jugador;
import Modelo.Jugador.ObjeosDelInventario;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.stage.Screen;
import javafx.stage.Stage;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class Aplicacion extends Application {
    public static double ancho;
    public static double alto;

    // todo: estas debrían ser las clases que utilizaremos para encapsular como modelaremos
    //  la vista de jugador ante los posibles movimientos.
    //  o la vista del tablero de construccion, por ejemplo.
    public JugadorVista jugador;
    public Jugador jugadorModelo;

    //public static tableroDeConstruccionVista tableroDeConstruccion;
    //public static TableroDeConstruccion tableroDeConstruccionModelo;

    private Stage juego;
    private BorderPane panelesDeJuego;
    private Algocraft algocraftModelo;

    private MapaVista mapa;
    //private MenuPrincipal menuJuego;
    //private LibreriaDeSonidos sonidos;
    //private LibreriaDeImagenes imagenes;

    @Override
    public void start(Stage ventanaAlgocraft) throws Exception {
        ancho = Screen.getPrimary().getVisualBounds().getWidth();
        alto = Screen.getPrimary().getVisualBounds().getHeight();

        juego = ventanaAlgocraft;
        juego.setTitle("AlgoCraft");

        algocraftModelo = new Algocraft();

        mapa = new MapaVista(algocraftModelo.obtenerMapaDelJuego());
        mapa.dibujar();





        // Border pane es la distribucion de las distintas partes del juego.
        panelesDeJuego = new BorderPane();

        setFondoDePantalla();

        //todo Acá es donde tendrían que poner las distintas vistas de el juego.
        // en el casso del mapa lo puse en el centro, pueden poner las demás funcionalidades
        // en alguna otra de las partes.
        //

        panelesDeJuego.setCenter(mapa.getVista());
        panelesDeJuego.setLeft(new TextField("Nombre de jugador!, herramienta equipada,  datos de herramienta (durabilidad,fuerza, ect..)"));
        panelesDeJuego.setBottom(new TextField("Botones de inventario, ect.."));

        // todo aquí tranquilamente podría ir el inventario con otro GridPane.
        //panelesDeJuego.setRight(new TextField("inventarioo, pegado al mapa para probar."));
        List<ObjeosDelInventario> prueva = new ArrayList<>();
        InventarioVista inventarioVista = new InventarioVista(prueva);//esto es una prueva
        panelesDeJuego.setRight(inventarioVista.getVista());

        Scene escenaPrincipal = new Scene(panelesDeJuego);

        juego.setScene(escenaPrincipal);

        //para dibujar la ventana con lo que tiene dentro.
        juego.show();
    }

    private void setFondoDePantalla() {
        ImageView fondo= new ImageView();
        fondo.setImage(new Image("Vista/Imagenes/fondo.jpg"));
        fondo.setFitHeight(alto);
        fondo.setFitWidth(ancho);
        panelesDeJuego.getChildren().add(fondo);
    }

}
