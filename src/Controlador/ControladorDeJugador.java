package Controlador;

import Modelo.Jugador.Jugador;
import Vista.InventarioVista;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;

import java.awt.*;

public class ControladorDeJugador {
    private final Jugador jugadorModelo;
    private final ControladorDeMapa mapaVista;
    private final Scene escenaPrincipal;
    private final ControladorDeHerramientasDelJugador controlDeHerramientas;
    private ControlDelTableroDeConstruccion controlDelTableroDeConstruccion;

    public ControladorDeJugador(Jugador jugador,ControladorDeMapa mapaVista,Scene escena,ControladorDeHerramientasDelJugador controladorDeHerramientasDelJugador) {
        this.jugadorModelo = jugador;
        this.mapaVista = mapaVista;
        this.escenaPrincipal = escena;
        this.controlDeHerramientas = controladorDeHerramientasDelJugador;
    }

    public void cargarControlDelTableroDeConstrucion(ControlDelTableroDeConstruccion control){
        controlDelTableroDeConstruccion = control;
        controlDelTableroDeConstruccion.iniciacion();
    }

    public void movimientos(InventarioVista invetarioVista){
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
                controlDeHerramientas.actualizacionPorDesgaste();
                controlDelTableroDeConstruccion.actualizarCantidades();
            }
        });
    }
}
