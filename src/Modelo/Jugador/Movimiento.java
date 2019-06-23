package Modelo.Jugador;


import Modelo.Juego.Casillero;
import Modelo.Juego.Mapa;

import java.awt.*;

public class Movimiento {
    private Casillero ubicacion;
    private int posicionVertical;
    private int posicionHorizontal;

    public Movimiento() {
        this.ubicacion = null;
        this.posicionVertical = 0;
        this.posicionHorizontal = 0;
    }

    public void iniciar(Mapa mapa, Jugador  jugador) {
        Point ubicacionInicial = new Point(posicionVertical, posicionHorizontal);
        this.ubicacion =  mapa.obtenerCasillero(ubicacionInicial);
        this.ubicacion.asignar(jugador);
    }

    private void mover(Mapa mapa, Jugador jugador, Point unicacionAMoverse){
        this.ubicacion.vaciarCasillero();
        this.ubicacion = mapa.obtenerCasillero(unicacionAMoverse);
        this.ubicacion.asignar(jugador);
    }

    private boolean seCumplenLasCondicionesParaPoderMoverse(Mapa mapa,Point ubicacionAMoverse){
        return (mapa.existeUbicacion(ubicacionAMoverse) && !mapa.estaOcupado(ubicacionAMoverse ));
    }

    public void moverHaciaLaDerecha(Mapa mapa, Jugador jugador) {
        Point unicacionAMoverse = new Point(posicionHorizontal +1, posicionVertical);
        if (!this.seCumplenLasCondicionesParaPoderMoverse(mapa,unicacionAMoverse)){
            return;
        }
        this.mover(mapa,jugador,unicacionAMoverse);
        this.posicionHorizontal++;
    }

    public void moverHaciaArriba(Mapa mapa, Jugador jugador) {
        Point unicacionAMoverse = new Point(posicionHorizontal, posicionVertical - 1);
        if (!this.seCumplenLasCondicionesParaPoderMoverse(mapa,unicacionAMoverse)){
            return;
        }
        this.mover(mapa,jugador,unicacionAMoverse);
        this.posicionVertical--;
    }

    public void moverHaciaAbajo(Mapa mapa, Jugador jugador) {
        Point unicacionAMoverse = new Point(posicionHorizontal, posicionVertical + 1);
        if (!this.seCumplenLasCondicionesParaPoderMoverse(mapa,unicacionAMoverse)){
            return;
        }
        this.mover(mapa,jugador,unicacionAMoverse);
        this.posicionVertical++;
    }

    public void moverHaciaLaIzquierda(Mapa mapa, Jugador jugador) {
        Point unicacionAMoverse = new Point(posicionHorizontal - 1, posicionVertical);
        if (!this.seCumplenLasCondicionesParaPoderMoverse(mapa,unicacionAMoverse)){
            return;
        }
        this.mover(mapa,jugador,unicacionAMoverse);
        this.posicionHorizontal--;
    }
}
