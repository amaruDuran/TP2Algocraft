package Juego;


import Materiales.MaterialDiamante;
import Materiales.MaterialMadera;
import Materiales.MaterialMetal;
import Materiales.MaterialPiedra;

import java.util.ArrayList;
import java.util.List;

public class Tablero {
    private List<Celda> celdas;

    public Tablero(){
        this.celdas = new ArrayList<>();
        inicialicacionDeCeldas();
        inicialicacionDeMateriales();

    }

    private void inicialicacionDeMateriales() {
        this.celdas.get(15).agregar(new MaterialMetal());
        this.celdas.get(16).agregar(new MaterialMetal());
        this.celdas.get(28).agregar(new MaterialMetal());
        this.celdas.get(29).agregar(new MaterialMetal());

        this.celdas.get(19).agregar(new MaterialDiamante());
        this.celdas.get(20).agregar(new MaterialDiamante());
        this.celdas.get(32).agregar(new MaterialDiamante());
        this.celdas.get(33).agregar(new MaterialDiamante());

        this.celdas.get(55).agregar(new MaterialMadera());
        this.celdas.get(56).agregar(new MaterialDiamante());
        this.celdas.get(57).agregar(new MaterialDiamante());
        this.celdas.get(58).agregar(new MaterialDiamante());
        this.celdas.get(68).agregar(new MaterialDiamante());
        this.celdas.get(69).agregar(new MaterialDiamante());
        this.celdas.get(70).agregar(new MaterialDiamante());
        this.celdas.get(71).agregar(new MaterialDiamante());

        this.celdas.get(19).agregar(new MaterialPiedra());
    }

    private void inicialicacionDeCeldas() {
        for (int i=0 ; i< 9*13; i++){
            Celda celda = new Celda(i);
            this.celdas.add(celda);
        }
    }

    private int posicionDeLaCelda(int fila, int columna){
        int numeroDeFila = (fila % 9);
        int numeroDeColumna = (columna % 13);
        int posicion = (numeroDeFila * 3) + numeroDeColumna;
        return posicion;
    }

    public Celda obtener(int i, int j){
        int posicion = this.posicionDeLaCelda(i,j);
        return this.celdas.get(posicion);

    }


    public int numeroDeCeldas() {
        return this.celdas.size();
    }

    public int numeroDeMateriales() {
        int n = 0;
        for (int i=0; i< this.celdas.size(); i++){
            if (this.celdas.get(i).estaOcupado() == true){
                n++;
            }
        }
        return n;
    }

    public boolean agregar(int i, int j, ObjetoDelTablero objeto) {
        int pos = this.posicionDeLaCelda(i,j);
        if (! this.celdas.get(pos).estaOcupado()){
            this.celdas.get(pos).agregar(objeto);
            return true;
        }
        else return false;
    }
}
