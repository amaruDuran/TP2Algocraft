package Vista;

import Modelo.Juego.Algocraft;
import Modelo.Juego.Mapa;
import Modelo.Jugador.Jugador;
import Modelo.Jugador.ObjeosDelInventario;
import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.stage.Screen;
import javafx.stage.Stage;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class Aplicacion<ventanaAlgocraft> extends Application {
    public static double ancho;
    public static double alto;

    // todo: estas debrían ser las clases que utilizaremos para encapsular como modelaremos
    //  la vista de jugador ante los posibles movimientos.
    //  o la vista del tablero de construccion, por ejemplo.
    public JugadorVista jugador;
    public static Jugador jugadorModelo;

    //public static tableroDeConstruccionVista tableroDeConstruccion;
    //public static TableroDeConstruccion tableroDeConstruccionModelo;
    public static BorderPane panelesDeJuego;
    private Algocraft algocraftModelo;
    private Mapa mapaModelo;
    public static Stage ventanaAlgocraft;

    private static MapaVista mapa;
    //private MenuPrincipal menuJuego;
    //private LibreriaDeSonidos sonidos;
    //private LibreriaDeImagenes imagenes;

    @Override
    public void start(Stage ventana) throws Exception {
        ancho = Screen.getPrimary().getVisualBounds().getWidth();
        alto = Screen.getPrimary().getVisualBounds().getHeight();
        ventanaAlgocraft = ventana;

        ventanaAlgocraft.setTitle("AlgoCraft");

        algocraftModelo = new Algocraft();

        jugadorModelo = algocraftModelo.obtenerJugador();

        mapaModelo = algocraftModelo.obtenerMapaDelJuego();

        mapa = new MapaVista(mapaModelo);
        jugadorModelo.iniciar(algocraftModelo.obtenerMapaDelJuego());

        mapa.dibujar();
        //jugador = new JugadorVista(algocraftModelo, mapa);


        // Border pane es la distribucion de las distintas partes del ventanaAlgocraft.
        panelesDeJuego = new BorderPane();
        BienvenidaVista bienvenida = new BienvenidaVista();
        VBox escenaBienvenida = bienvenida.getBienvenida();

        setFondoDePantalla();

        //todo Acá es donde tendrían que poner las distintas vistas de el ventanaAlgocraft.
        // en el casso del mapa lo puse en el centro, pueden poner las demás funcionalidades
        // en alguna otra de las partes.
        //

        panelesDeJuego.setCenter(mapa.getVista());
        //panelesDeJuego.setLeft(new TextField("Nombre de jugador!, herramienta equipada,  datos de herramienta (durabilidad,fuerza, ect..)"));
        //panelesDeJuego.setBottom(new TextField("Botones de inventario, ect.."));

        // todo aquí tranquilamente podría ir el inventario con otro GridPane.
        //panelesDeJuego.setRight(new TextField("inventarioo, pegado al mapa para probar."));

        List<ObjeosDelInventario> prueva = new ArrayList<>();
        InventarioVista inventarioVista = new InventarioVista(prueva);//esto es una prueva
        panelesDeJuego.setRight(inventarioVista.getVista());



        Scene escenaPrincipal = new Scene(escenaBienvenida);
        ventanaAlgocraft.setScene(escenaPrincipal);
        /*
        escenaPrincipal.setOnKeyPressed(new EventHandler<KeyEvent>() {
            public void handle(KeyEvent event) {
                if (event.getCode() == KeyCode.UP) {
                    jugadorModelo.moverParaArriba();
                    //System.out.println("Me moví para arriba");
                    mapa.dibujar();
                }
                if (event.getCode() == KeyCode.DOWN) {
                    jugadorModelo.moverParaAbajo();
                    //System.out.println("Me moví para abajo");
                    mapa.dibujar();
                }
                if (event.getCode() == KeyCode.RIGHT) {
                    jugadorModelo.moverALaDerecha();
                    //System.out.println("Me moví  a derecha");
                    mapa.dibujar();
                }
                if (event.getCode() == KeyCode.LEFT) {
                    jugadorModelo.moverALaIzquierda();
                    //System.out.println("Me moví para Izquierda");
                    mapa.dibujar();
                }
                event.consume();
            }
        });*/

        //para dibujar la ventana con lo que tiene dentro.
        ventanaAlgocraft.show();

    }

    private void setFondoDePantalla() {
        ImageView fondo= new ImageView();
        fondo.setImage(new Image("Vista/Imagenes/fondo.jpg"));
        fondo.setFitHeight(alto);
        fondo.setFitWidth(ancho);
        panelesDeJuego.getChildren().add(fondo);
    }

    public static void movimientos(Scene escenaPrincipal){
        escenaPrincipal.setOnKeyPressed(new EventHandler<KeyEvent>() {
            public void handle(KeyEvent event) {
                if (event.getCode() == KeyCode.UP) {
                    jugadorModelo.moverParaArriba();
                    //System.out.println("Me moví para arriba");
                    mapa.dibujar();
                }
                if (event.getCode() == KeyCode.DOWN) {
                    jugadorModelo.moverParaAbajo();
                    //System.out.println("Me moví para abajo");
                    mapa.dibujar();
                }
                if (event.getCode() == KeyCode.RIGHT) {
                    jugadorModelo.moverALaDerecha();
                    //System.out.println("Me moví  a derecha");
                    mapa.dibujar();
                }
                if (event.getCode() == KeyCode.LEFT) {
                    jugadorModelo.moverALaIzquierda();
                    //System.out.println("Me moví para Izquierda");
                    mapa.dibujar();
                }
                event.consume();
            }
        });
    }

}
