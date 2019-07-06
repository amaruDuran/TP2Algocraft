package MVC;

import Controlador.ControladorDeHerramientasDelJugador;
import Controlador.ControladorDeJugador;
import Controlador.ControladorDeMapa;
import Controlador.ControladorInventario;
import Modelo.Juego.Mapa;
import Modelo.Jugador.Jugador;
import Vista.BarraDeHerramientas;
import Vista.IVista;
import Vista.InventarioVista;
import Vista.VistaHerramientaEnMano;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class MiJuego extends Application {
    private ControladorDeMapa controladorDeMapa;
    private BorderPane miPanel;
    private Jugador jugador = new Jugador();

    @Override
    public void start(Stage primaryStage) throws Exception {
        this.miPanel = new BorderPane();
        setFondoDePantalla(miPanel);
        Stage miJuego = primaryStage;
        miJuego.setTitle("ALGOCRAFT TP2");

        //IVista inventarioVista = new IVista(jugador.listadoDeInventario());
        IVista inventarioVista = new IVista();
        ControladorInventario controladorInventario = new ControladorInventario(jugador.listadoDeInventario(),inventarioVista);
        inventarioVista.incorporarControl(controladorInventario);
        Scene escenaDeMapa = new Scene(this.miPanel);
        Mapa mapa = new Mapa(11,11);
        jugador.iniciar(mapa);

        ControladorDeHerramientasDelJugador controladorDeHerramientasDelJugador = new ControladorDeHerramientasDelJugador(jugador);
        VistaHerramientaEnMano vistaHerramientaEnMano = new VistaHerramientaEnMano(controladorDeHerramientasDelJugador);

        this.controladorDeMapa = new ControladorDeMapa(mapa);
        this.controladorDeMapa.iniciar();
        ControladorDeJugador jugadorControlado = new ControladorDeJugador(jugador,controladorDeMapa,escenaDeMapa,controladorDeHerramientasDelJugador);
        jugadorControlado.movimientos(inventarioVista);
        this.miPanel.setCenter(this.controladorDeMapa.getVista());
        BarraDeHerramientas barraDeHerramientas = new BarraDeHerramientas(primaryStage,inventarioVista,vistaHerramientaEnMano);
        this.miPanel.setTop(barraDeHerramientas.getVista());
        miJuego.setScene(escenaDeMapa);
        miJuego.show();
    }

    private void setFondoDePantalla(BorderPane miPanel) {
        ImageView fondo= new ImageView();
        fondo.setImage(new Image("Vista/Imagenes/fondo.jpg"));
        fondo.setFitHeight(720);
        fondo.setFitWidth(1400);
        miPanel.getChildren().add(fondo);
    }


}


