package MVC;

import Controlador.*;
import Modelo.Juego.Mapa;
import Modelo.Jugador.Jugador;
import Vista.BarraDeHerramientas;
import Vista.InventarioVista;
import Vista.VistaHerramientaEnMano;
import Vista.VistaTableroDeConstruccion;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class MiJuego extends Application {
    private ControladorDeMapa controladorDeMapa;
    private ControladorInventario controladorInventario;
    private ControladorDeHerramientasDelJugador controladorDeHerramientasDelJugador;
    private ControladorDeJugador jugadorControlado;
    private ControlDelTableroDeConstruccion controlDelTableroDeConstruccion;
    private BorderPane miPanel;
    private Jugador jugador = new Jugador();
    private Mapa mapa;
    private InventarioVista inventarioVista;
    private VistaHerramientaEnMano vistaHerramientaEnMano;
    private VistaTableroDeConstruccion tableroDeConstruccion;

    @Override
    public void start(Stage primaryStage) throws Exception {
        this.miPanel = new BorderPane();
        setFondoDePantalla(miPanel);
        Stage miJuego = primaryStage;
        miJuego.setTitle("ALGOCRAFT TP2");

        Scene escenaDeMapa = new Scene(this.miPanel);
        this.controlInventario();
        this.controlMapa();
        this.controlHerramientas();
        this.controlJugador(escenaDeMapa);
        this.controlConstrutor();
        this.anexionarControlesFaltantes();

        this.miPanel.setCenter(this.controladorDeMapa.getVista());
        BarraDeHerramientas barraDeHerramientas = new BarraDeHerramientas(primaryStage,inventarioVista,vistaHerramientaEnMano,tableroDeConstruccion);
        this.miPanel.setTop(barraDeHerramientas.getVista());
        miJuego.setScene(escenaDeMapa);
        miJuego.show();
    }

    private void anexionarControlesFaltantes(){
        controladorDeHerramientasDelJugador.cargarVistaDeInventario(inventarioVista);
        inventarioVista.incorporarControl(controladorInventario);
        controlDelTableroDeConstruccion.cargarControladorDelInventario(controladorInventario);
        jugadorControlado.cargarControlDelTableroDeConstrucion(controlDelTableroDeConstruccion);
    }

    private void controlConstrutor() {
        controlDelTableroDeConstruccion = new ControlDelTableroDeConstruccion();
        tableroDeConstruccion = new VistaTableroDeConstruccion(controlDelTableroDeConstruccion);
        controlDelTableroDeConstruccion.cargarVista(tableroDeConstruccion);
    }

    private void controlInventario(){
        inventarioVista = new InventarioVista();
        controladorInventario = new ControladorInventario(jugador.listadoDeInventario(),inventarioVista);
    }

    private void controlMapa(){
        mapa = new Mapa(10,10);
        jugador.iniciar(mapa);
        this.controladorDeMapa = new ControladorDeMapa(mapa);
        this.controladorDeMapa.iniciar();
    }

    private void controlHerramientas(){
        controladorDeHerramientasDelJugador = new ControladorDeHerramientasDelJugador(jugador);
        vistaHerramientaEnMano = new VistaHerramientaEnMano(controladorDeHerramientasDelJugador);
    }

    private void controlJugador(Scene escenaDeMapa){
        jugadorControlado = new ControladorDeJugador(jugador,controladorDeMapa,escenaDeMapa,controladorDeHerramientasDelJugador);
        jugadorControlado.movimientos(inventarioVista);
    }

    private void setFondoDePantalla(BorderPane miPanel) {
        ImageView fondo= new ImageView();
        fondo.setImage(new Image("Vista/Imagenes/fondo.jpg"));
        fondo.setFitHeight(720);
        fondo.setFitWidth(1400);
        miPanel.getChildren().add(fondo);
    }


}


