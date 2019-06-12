package Jugador;


import Juego.Casillero;
import Juego.Mapa;

public class Movimiento {
    private Casillero ubicacion;
    private  int posicion1;
    private int posicion2;

    public Movimiento() {
        this.ubicacion = null;
        this.posicion1= 0;
        this.posicion2 = 0;
    }

    public void iniciar(Mapa mapa, Jugador  jugador) {
        this.ubicacion =  mapa.obtenerCasillero(0,0);
        this.ubicacion.asignar(jugador);
    }

    public void moverALaDerecha(Mapa mapa, Jugador jugador) {
        if ((this.posicion2 < (mapa.cantidadDeColumnas() - 1)) &&
                !(mapa.obtenerCasillero(1, posicion2 + 1).estaOcupado())) {
            this.ubicacion.eliminar();
            this.ubicacion = mapa.obtenerCasillero(posicion1, posicion2 + 1);
            this.ubicacion.asignar(jugador);
            this.posicion2++;
        }
    }

    public void moverParaAbajo(Mapa mapa, Jugador jugador) {
        if (this.posicion1 < (mapa.cantidadDeFilas()-1) && !(mapa.obtenerCasillero(posicion1+1,posicion2).estaOcupado())){
            this.ubicacion.eliminar();
            this.ubicacion = mapa.obtenerCasillero(posicion1+1, posicion2);
            this.ubicacion.asignar(jugador);
            this.posicion1++;
        }
    }

    public void moverParaArriba(Mapa mapa, Jugador jugador) {
        if(this.posicion1>0 && !(mapa.obtenerCasillero(posicion1-1,posicion2).estaOcupado())){
            this.ubicacion.eliminar();
            this.ubicacion = mapa.obtenerCasillero(posicion1-1, posicion2);
            this.ubicacion.asignar(jugador);
            this.posicion1--;
        }
    }

    public void moverALaIzquierda(Mapa mapa, Jugador jugador) {
        if(this.posicion2>0 && !(mapa.obtenerCasillero(posicion1,posicion2-1).estaOcupado()))
        {
            this.ubicacion.eliminar();
            this.ubicacion = mapa.obtenerCasillero(posicion1, posicion2-1);
            this.ubicacion.asignar(jugador);
            this.posicion2--;
        }
    }
}
