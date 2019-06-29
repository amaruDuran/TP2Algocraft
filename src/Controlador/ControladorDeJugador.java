package Controlador;

import Modelo.Jugador.Jugador;
import Vista.IVista;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;

import java.awt.*;

public class ControladorDeJugador {
    private final Jugador jugadorModelo;
    private final ControladorDeMapa mapaVista;
    private final Scene escenaPrincipal;

    public ControladorDeJugador(Jugador jugador,ControladorDeMapa mapaVista,Scene escena) {
        this.jugadorModelo = jugador;
        this.mapaVista = mapaVista;
        this.escenaPrincipal = escena;
    }

    public void movimientos(IVista  invetarioVista){
        escenaPrincipal.setOnKeyPressed(new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent event) {
                Point posicion = jugadorModelo.posicion();
                if(event.getCode() == KeyCode.D){
                    jugadorModelo.intentarRomperADerecha();
                    jugadorModelo.moverALaDerecha();
                }

                if(event.getCode() == KeyCode.A){
                    jugadorModelo.intentarRomperAIzquierda();
                    jugadorModelo.moverALaIzquierda();
                }

                if(event.getCode() == KeyCode.W){
                    jugadorModelo.intentarRomperArriba();
                    jugadorModelo.moverParaArriba();
                }

                if(event.getCode() == KeyCode.S){
                    jugadorModelo.intentarRomperAbajo();
                    jugadorModelo.moverParaAbajo();
                }
                mapaVista.dibujarPosiciones(jugadorModelo.posicion(),posicion);
                invetarioVista.actualizarCasillero();

            }
        });
    }
}
