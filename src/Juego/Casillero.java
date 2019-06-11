package Juego;

import Materiales.Material;

public class Casillero{
    private  boolean ocupado;
    private ObjetoDelTablero objeto;
    private int posicionI;
    private int posicionJ;

    public Casillero(int i,int j){
        this.ocupado = false;
        this.posicionI = i;
        this.posicionJ = j;
    }

    public Casillero(Material material,int i,int j){
        this.ocupado = true;
        this.posicionI = i;
        this.posicionJ = j;
    }

    public String identificador(){
        String identificador = this.objeto.indentificador();
        return identificador;
    }

    public boolean estaOcupado(){
        return this.ocupado;
    }

    public boolean asignar(ObjetoDelTablero objeto) {
        if (this.ocupado == false){
            this.objeto = objeto;
            this.ocupado = true;
            return this.ocupado;
        }
        return false;

    }

    public int posicionI(){
        return this.posicionI;
    }

    public int posicionJ(){
        return this.posicionJ;
    }

}
