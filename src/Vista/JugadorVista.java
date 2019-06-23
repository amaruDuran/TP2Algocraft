package Vista;

import Modelo.Juego.Algocraft;
import Modelo.Juego.Mapa;
import Modelo.Juego.ObjetoDelTablero;
import Modelo.Jugador.Jugador;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.Node;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;

import java.awt.*;

public class JugadorVista implements Dibujable {
    MapaVista mapa;
    Mapa mapaModelo;
    Jugador jugadorModelo;



    public JugadorVista(Algocraft algocraftModelo, MapaVista pmapa){
        jugadorModelo = algocraftModelo.obtenerJugador();
        mapaModelo = algocraftModelo.obtenerMapaDelJuego();
        jugadorModelo.iniciar(mapaModelo);
        mapa = pmapa;
    }

    @Override
    public void dibujar() {

        Node mapaMovimiento = mapa.getVista();

        mapaMovimiento.setOnKeyPressed(new EventHandler<KeyEvent>() {
            public void handle(KeyEvent event) {
                if(event.getCode() == KeyCode.UP) {
                    jugadorModelo.moverParaArriba();
                    System.out.println("Me moví para arriba");
                }
                if( event.getCode() == KeyCode.DOWN) {
                    jugadorModelo.moverParaAbajo();
                    System.out.println("Me moví para abajo");
                }
                if (event.getCode() == KeyCode.RIGHT) {
                    jugadorModelo.moverALaDerecha();
                    System.out.println("Me moví  a derecha");
                }
                if (event.getCode() == KeyCode.LEFT) {
                    jugadorModelo.moverALaIzquierda();
                    System.out.println("Me moví para Izquierda");
                }
                event.consume();
            }
        });

    }

    @Override
    public Node getVista() {
        return null;
    }
}
