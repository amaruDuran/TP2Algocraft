package Juego;

import Materiales.Material;

public class Casillero{
    private  boolean ocupado;
    private ObjetoDelTablero objeto;

    public Casillero(){
        this.ocupado = false;
    }

    public Casillero(Material material){
        this.ocupado = true;
    }

    public String indicador(){
        return this.indicador();
    }

    public boolean estaOcupado(){
        return this.ocupado;
    }

    public boolean asignar(ObjetoDelTablero objeto) {
        if (this.ocupado == false){
            this.objeto = objeto;
            this.ocupado = true;
            return true;
        }
        return false;

    }

}
