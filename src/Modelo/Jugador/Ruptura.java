package Modelo.Jugador;

import Modelo.Juego.Casillero;
import Modelo.Juego.Mapa;
import Modelo.Materiales.Material;

import java.awt.*;

public class Ruptura {
    private final Movimiento movimiento;
    private final Mapa mapa;
    private final Jugador jugador;

    public Ruptura(Movimiento movimiento, Mapa mapa,Jugador jugador) {
        this.movimiento = movimiento;
        this.mapa = mapa;
        this.jugador = jugador;
    }

    public void aDerecha(){
        int posx = this.movimiento.getPosicionHorizontal();
        int posy = this.movimiento.getPosicionVertical();
        Point posicionAMoverme = new Point(posx+1,posy);
        if (this.mapa.existeUbicacion(posicionAMoverme)){
            actualizarCasillero(posicionAMoverme);
        }
    }

    private void actualizarCasillero(Point posicionAMoverme) {
        if (this.mapa.estaOcupado(posicionAMoverme)) {
            Casillero casilleroARomper = this.mapa.obtenerCasillero(posicionAMoverme);
            verificar(casilleroARomper);
        }
        return;
    }

    private void verificar(Casillero casilleroARomper) {
        Material material = (Material)casilleroARomper.getObjeto();
        this.jugador.obtenerHerramientaEnMano().usarEn(material);
        if(material.durabilidadActualDelMaterial() <= 0){
            casilleroARomper.vaciarCasillero();
            jugador.agregarAlInventario(material);
        }

    }


    public void aIzquierda() {
        int posx = this.movimiento.getPosicionHorizontal();
        int posy = this.movimiento.getPosicionVertical();
        Point posicionAMoverme = new Point(posx-1,posy);
        if (this.mapa.existeUbicacion(posicionAMoverme)){
            actualizarCasillero(posicionAMoverme);
        }
    }

    public void Arriba() {
        int posx = this.movimiento.getPosicionHorizontal();
        int posy = this.movimiento.getPosicionVertical();
        Point posicionAMoverme = new Point(posx,posy-1);
        if (this.mapa.existeUbicacion(posicionAMoverme)){
            actualizarCasillero(posicionAMoverme);
        }
    }

    public void Abajo() {
        int posx = this.movimiento.getPosicionHorizontal();
        int posy = this.movimiento.getPosicionVertical();
        Point posicionAMoverme = new Point(posx,posy+1);
        if (this.mapa.existeUbicacion(posicionAMoverme)){
            actualizarCasillero(posicionAMoverme);
        }
    }
}

