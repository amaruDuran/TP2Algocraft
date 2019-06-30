package Vista;

import Eventos.PantallaCompleta;
import Eventos.SalirDelJuego;
import Modelo.Jugador.Inventario;
import Modelo.Jugador.ObjeosDelInventario;
import Vista.Botones.Boton;
import Vista.Botones.BotonParaToolBar;
import javafx.event.EventHandler;
import javafx.scene.Node;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

import java.awt.*;
import java.util.List;

public class BarraDeHerramientas implements Dibujable {
    private HBox toolBar;
    private final String textoPantallaCompleta = "Pantalla Completa";
    private final String textoSalir = "Salir Del Juego";
    private final String textoInventario = "Inventario";
    private Boton pantallaCompleta;
    private Boton salir;
    private Boton inventario;
    private  List<ObjeosDelInventario> miInventario;
    private IVista miInventarioVista;

    public BarraDeHerramientas(Stage stage, IVista inventarioVista){
        toolBar = new HBox();
        toolBar.setSpacing(1);
        this.generarBotones(stage);
        this.ordenarToolBar();
        this.miInventarioVista = inventarioVista;
    }

    @Override
    public void dibujar(){}

    @Override
    public Node getVista() {
        return toolBar;
    }

    private void generarBotones(Stage stage){
        //pantallacompleta
        pantallaCompleta = new BotonParaToolBar(textoPantallaCompleta);
        new PantallaCompleta(pantallaCompleta, stage);
        //salir del juego
        salir = new BotonParaToolBar(textoSalir);
        new SalirDelJuego(salir, stage);
        //inventario
        inventario = new BotonParaToolBar(textoInventario);

        inventario.setOnMouseClicked(evento -> {
            miInventarioVista.iniciar();
        });

        /* En alguna otra clase se utilizará para poder Entrar
        al Inventario con tecla Cercana a Tecla de Movimiento
        inventario.setOnKeyPressed(new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent event) {
                if(event.getCode() == KeyCode.I){
                    miInventarioVista.iniciar();
                }
            }
        });

         */
    }

    private void ordenarToolBar(){
        toolBar.getChildren().addAll(salir, pantallaCompleta,inventario);
    }
}
