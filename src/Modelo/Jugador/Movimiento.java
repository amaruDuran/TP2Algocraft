package Modelo.Jugador;


import Modelo.Juego.Casillero;
import Modelo.Juego.Mapa;
import Modelo.Materiales.Material;
import Vista.Aplicacion;

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
            this.romperADerecha(mapa,jugador);
            return;
        }
        this.mover(mapa,jugador,unicacionAMoverse);
        this.posicionHorizontal++;
    }

    private void romperADerecha(Mapa mapa,Jugador jugador) {
        Casillero casilleroARomper = mapa.obtenerCasillero(new Point(posicionHorizontal+1,posicionVertical));
        if(casilleroARomper.estaOcupado()) {
            actualizarCasillero(jugador,casilleroARomper);
        }
    }

    private void romperAIzquierda(Mapa mapa,Jugador jugador) {
        Casillero casilleroARomper = mapa.obtenerCasillero(new Point(posicionHorizontal-1,posicionVertical));
        if(casilleroARomper.estaOcupado()) {
            actualizarCasillero(jugador,casilleroARomper);
        }
    }

    private void romperAbajo(Mapa mapa,Jugador jugador) {
        Casillero casilleroARomper = mapa.obtenerCasillero(new Point(posicionHorizontal,posicionVertical+1));
        if(casilleroARomper.estaOcupado()) {
            actualizarCasillero(jugador,casilleroARomper);
        }
    }

    private void romperArriba(Mapa mapa,Jugador jugador) {
        Casillero casilleroARomper = mapa.obtenerCasillero(new Point(posicionHorizontal,posicionVertical-1));
        if(casilleroARomper.estaOcupado()) {
            actualizarCasillero(jugador,casilleroARomper);
        }
    }

    private void actualizarCasillero(Jugador jugador,Casillero casilleroARomper){
        Material material = (Material)casilleroARomper.getObjeto();
        jugador.obtenerHerramientaEnMano().usarEn(material);//refactorizar el uso agregando metodo en jugador
        if (material.durabilidadActualDelMaterial() == 0) {
            casilleroARomper.vaciarCasillero();
            jugador.agregarAlInventario(material);
            Aplicacion.inventarioVista.dibujar();  //SACARLO URGENTE
        }
    }


    public void moverHaciaArriba(Mapa mapa, Jugador jugador) {
        Point unicacionAMoverse = new Point(posicionHorizontal, posicionVertical - 1);
        if (!this.seCumplenLasCondicionesParaPoderMoverse(mapa,unicacionAMoverse)){
            this.romperArriba(mapa,jugador);
            return;
        }
        this.mover(mapa,jugador,unicacionAMoverse);
        this.posicionVertical--;
    }

    public void moverHaciaAbajo(Mapa mapa, Jugador jugador) {
        Point unicacionAMoverse = new Point(posicionHorizontal, posicionVertical + 1);
        if (!this.seCumplenLasCondicionesParaPoderMoverse(mapa,unicacionAMoverse)){
            this.romperAbajo(mapa,jugador);
            return;
        }
        this.mover(mapa,jugador,unicacionAMoverse);
        this.posicionVertical++;
    }

    public void moverHaciaLaIzquierda(Mapa mapa, Jugador jugador) {
        Point unicacionAMoverse = new Point(posicionHorizontal - 1, posicionVertical);
        if (!this.seCumplenLasCondicionesParaPoderMoverse(mapa,unicacionAMoverse)){
            this.romperAIzquierda(mapa,jugador);
            return;
        }
        this.mover(mapa,jugador,unicacionAMoverse);
        this.posicionHorizontal--;
    }

    public int getPosicionVertical() {
        return posicionVertical;
    }

    public int getPosicionHorizontal() {
        return posicionHorizontal;
    }
}
