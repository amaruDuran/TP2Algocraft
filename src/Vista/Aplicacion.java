package Vista;

import Juego.Casillero;
import Juego.Mapa;
import Jugador.Jugador;
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

public class Aplicacion extends Application {
    public static double ancho;
    public static double alto;

    /*todo: Aquí debería encapsularse como se dibuja el mapa (mapa.dibujar() o algo así)*/
    //private static MapaVista mapa;

    private static Mapa mapaModelo;

    // todo: estas debrían ser las clases que utilisaremos para encapsular como modelaremos
    //  la vista de jugador ante los posibles movimientos.
    //  o la vista del tablero de construccion, por ejemplo.
    //public static jugadorVista jugador;
    //public static Jugador jugadorModelo;

    //public static tableroDeConstruccionVista tableroDeConstruccion;
    //public static TableroDeConstruccion tableroDeConstruccionModelo;

    private Stage juego;
    private BorderPane panelesDeJuego;

    private GridPane mapa;
    //private MenuPrincipal menuJuego;
    //private LibreriaDeSonidos sonidos;
    //private LibreriaDeImagenes imagenes;

    @Override
    public void start(Stage ventanaAlgocraft) throws Exception {
        ancho = Screen.getPrimary().getVisualBounds().getWidth();
        alto = Screen.getPrimary().getVisualBounds().getHeight();

        juego = ventanaAlgocraft;
        juego.setTitle("AlgoCraft");

        //GridPane Objeto que sirve para construir tableros según fila y collumna.
        mapa = new GridPane();

        //Para que las imagenes estén separadas y no estén tan juntas.
        mapa.setPadding(new Insets(10,10,10,10));



        /*Debería estar en Carpeta de Controlador o vista y encapsulado en una clase.*/
        mapaModelo = new Mapa(10,10);
        Casillero casillero = mapaModelo.obtenerCasillero(new Point(1,9));
        casillero.asignar(new Jugador());

        //Dimensiones del mapaVista.
        mapa.setHgap(mapaModelo.cantidadDeColumnas());
        mapa.setVgap(mapaModelo.cantidadDeFilas());

        //todo: esto sería el mapa.dibujar().
        for (int i = 0; i < mapa.getHgap(); i++) {
            for (int j = 0; j < mapa.getVgap(); j++) {
                String elementoMapaVista = mapaModelo.obtenerCasillero(new Point(i,j)).identificador();
                Image imagenUnidadElemental= new Image("Vista/Imagenes/" + elementoMapaVista + ".png");
                ImageView imagenUnidadElementalVista = new ImageView(imagenUnidadElemental);
                mapa.setConstraints(imagenUnidadElementalVista, i, j);
                mapa.getChildren().add(imagenUnidadElementalVista);
            }
        }



        // Border pane es la distribucion de las distintas partes del juego.
        panelesDeJuego = new BorderPane();

        setFondoDePantalla();

        //todo Acá es donde tendrían que poner las distintas funcionalidades de el juego.
        // en el casso del mapa lo puse en el centro, pueden poner las demás funcionalidades
        // en alguna otra de las partes.
        //

        panelesDeJuego.setCenter(mapa);
        panelesDeJuego.setLeft(new TextField("Nombre de jugador!, herramienta equipada,  datos de herramienta (durabilidad,fuerza, ect..)"));
        panelesDeJuego.setBottom(new TextField("Botones de inventario, ect.."));

        // todo aquí tranquilamente podría ir el inventario con otro GridPane.
        panelesDeJuego.setRight(new TextField("inventarioo, pegado al mapa para probar."));

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
