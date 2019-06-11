package Juego;

import Materiales.Material;

import java.util.List;

public class Mapa {
    private int filas;
    private int columnas;
    private Casillero[][] mapa;
    private int cantDeMateriales;

    public Mapa(List<Material> materiales,int filas , int columnas){
        this.filas = filas;
        this.columnas = columnas;
        this.cantDeMateriales = 0;
        this.inicializacion(materiales);
    }

    private void inicializacion(List<Material> materiales) {
        this.mapa = new Casillero[this.filas][this.columnas];
        for (int col = 0; col<this.columnas; col++){
            for (int fil = 0; fil<this.filas; fil++){
                eleccion(fil,col,materiales);
            }
        }
    }

    //ELIGE SI UN CASILLERO SE CREA VACIO O CON ALGUN MATERIAL ALEATORIO
    private void eleccion(int fil , int col, List<Material> materiales) {
        Casillero casillero;
        int aleatorio = (int) (Math.random() * 4);
        if ((aleatorio != 4) && (this.cantDeMateriales < 30)){
            casillero = new Casillero(materiales.get(aleatorio),fil,col);
            this.cantDeMateriales++;
        }
        else {
            casillero = new Casillero(fil,col);
        }

        this.mapa[fil][col] = casillero;
    }

    public int cantidadDeFilas() {
        return this.filas;
    }

    public int cantidadDeColumnas() {
        return this.columnas;
    }

    public int cantidadDeMateriales() {
        return this.cantDeMateriales;
    }

    public boolean estaOcupado(int i, int j) {
        Casillero casillero = this.mapa[i][j];
        return casillero.estaOcupado();
    }

    public Casillero obtenerCasillero(int i ,int j) {
        Casillero casillero = this.mapa[i][j];
        return casillero;
    }


}
