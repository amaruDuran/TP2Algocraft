package Juego;

import Jugador.Jugador;
import Materiales.Material;

public class Casillero{
    private  boolean ocupado;
    private Material objeto;

    public Casillero(){
        this.ocupado = false;
    }

    public Casillero(Material material){
        this.ocupado = true;
        this.objeto = material;
    }

    public String indicador(){
        return this.objeto.indentificador();
    }

    public boolean estaOcupado(){
        return this.ocupado;
    }

    public void asignar(Jugador jugador) {
    }
}
