package Vista;

import Modelo.Juego.Algocraft;
import Modelo.Juego.Mapa;
import Modelo.Jugador.Jugador;
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

public class Aplicacion<ventanaAlgocraft> extends Application {
    public static double ancho;
    public static double alto;

    public static Stage ventanaAlgocraft;

    public static InventarioVista inventarioVista;
    public static MapaVista mapa;
    //private MenuPrincipal menuJuego;
    //private LibreriaDeSonidos sonidos;

    private Algocraft algocraftModelo;
    private Mapa mapaModelo;
    public static Jugador jugadorModelo;

    //public static tableroDeConstruccionVista tableroDeConstruccion;
    //public static TableroDeConstruccion tableroDeConstruccionModelo;

    //Podría existir una clase AlgocraftVista que encapsule los panelesDeJuego.
    public static BorderPane panelesDeJuego;


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

        // Border pane es la distribucion de las distintas partes del ventanaAlgocraft.
        panelesDeJuego = new BorderPane();
        BienvenidaVista bienvenida = new BienvenidaVista();
        VBox escenaBienvenida = bienvenida.getBienvenida();

        setFondoDePantalla();


        panelesDeJuego.setCenter(mapa.getVista());

        //todo: Podrían ir los patrones disponiblees para la creación de herramientas.
        //panelesDeJuego.setLeft();


        //List<ObjeosDelInventario> listaDelInventario = jugadorModelo.listadoDeInventario();
        inventarioVista = new InventarioVista(jugadorModelo);
        panelesDeJuego.setRight(inventarioVista.getVista());


        Scene escenaPrincipal = new Scene(escenaBienvenida);
        ventanaAlgocraft.setScene(escenaPrincipal);

        BarraDeHerramientas barraDeHerramientas = new BarraDeHerramientas(ventanaAlgocraft);
        panelesDeJuego.setTop(barraDeHerramientas.getVista());

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
