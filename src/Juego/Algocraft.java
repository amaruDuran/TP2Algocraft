package Juego;

import Jugador.Jugador;

public class Algocraft {
    private Mapa mapa;
    private  Jugador jugador;

    public Algocraft() {
        this.mapa = new Mapa(13,13);
        this.jugador = new Jugador();
    }

    public Mapa obtenerMapaDelJuego(){
        return this.mapa;
    }

    public void iniciar() {
        jugador.iniciar(mapa);
    }
}