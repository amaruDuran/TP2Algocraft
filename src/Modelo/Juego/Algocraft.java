package Modelo.Juego;

import Modelo.Jugador.Jugador;

public class Algocraft {
    private Mapa mapa;
    private  Jugador jugador;

    public Algocraft() {
        this.mapa = new Mapa(11,11);
        this.jugador = new Jugador();
    }

    public Mapa obtenerMapaDelJuego(){
        return this.mapa;
    }

    public void iniciar() {
        jugador.iniciar(mapa);
    }

    public Jugador obtenerJugador() {
        return this.jugador;
    }
}