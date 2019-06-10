package Juego;

import Materiales.Material;

import java.util.List;

public class Mapa {
    private int filas;
    private int columnas;
    private Casillero[][] mapa;
    private int cantDeMateriales;

    public Mapa(List<Material> materiales){
        this.filas = 10;
        this.columnas = 10;
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
        if ((aleatorio != 5) && (this.cantDeMateriales < 30)){
            casillero = new Casillero(materiales.get(aleatorio));
            this.cantDeMateriales++;
        }
        else {
            casillero = new Casillero();
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

    public boolean existeMaterialEnMapa() {
        for (int i = 0; i<this.columnas; i++){
            for (int j = 0; j<this.filas; j++){
                Casillero casillero = this.mapa[i][j];
                if(casillero.estaOcupado()){
                    return true;
                }
            }
        }
        return false;
    }

    public Casillero[][] indicar() {
        return this.mapa;
    }
}
