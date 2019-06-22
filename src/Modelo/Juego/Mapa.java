package Modelo.Juego;
import Modelo.Materiales.MaterialDiamante;
import Modelo.Materiales.MaterialMadera;
import Modelo.Materiales.MaterialMetal;
import Modelo.Materiales.MaterialPiedra;

import java.awt.*;
import java.util.HashMap;

public class Mapa {
    private int filas;
    private int columnas;
    private HashMap<Point, Casillero> mapa;
    private int limiteMinDeFilasDeTablero = 8;//por la inicializacion de materiales
    private int limiteMinDeColumnasDeTablero = 8;

    public Mapa(int filas , int columnas){
        if (filas < limiteMinDeFilasDeTablero || columnas < limiteMinDeColumnasDeTablero){
            throw (new ErrorDeCreacionDelMapaTamanioInvalido());
        }
        this.mapa = new HashMap<Point, Casillero>();
        this.filas = filas;
        this.columnas = columnas;
        this.inicializacionDeCasilleros();
        this.inicializacionDeMaterialesEnElMapa();
    }

    private void inicializacionDeMaterialesEnElMapa() {
        this.mapa.get(new Point(2,1)).asignar(new MaterialMetal());
        this.mapa.get(new Point(2,2)).asignar(new MaterialMetal());
        this.mapa.get(new Point(3,1)).asignar(new MaterialMetal());
        this.mapa.get(new Point(3,2)).asignar(new MaterialMetal());

        this.mapa.get(new Point(2,5)).asignar(new MaterialDiamante());
        this.mapa.get(new Point(2,6)).asignar(new MaterialDiamante());
        this.mapa.get(new Point(3,5)).asignar(new MaterialDiamante());
        this.mapa.get(new Point(3,6)).asignar(new MaterialDiamante());

        this.mapa.get(new Point(5,1)).asignar(new MaterialMadera());
        this.mapa.get(new Point(5,2)).asignar(new MaterialMadera());
        this.mapa.get(new Point(5,3)).asignar(new MaterialMadera());
        this.mapa.get(new Point(5,4)).asignar(new MaterialMadera());

        this.mapa.get(new Point(8,7)).asignar(new MaterialPiedra());
        this.mapa.get(new Point(8,8)).asignar(new MaterialPiedra());
    }

    private void inicializacionDeCasilleros() {
        for (int fila = 0; fila < this.filas; fila++){
            for (int columna = 0; columna < this.columnas; columna++){
                Casillero casillero = new Casillero();
                Point ubicacion = new Point(fila,columna);
                this.mapa.put(ubicacion,casillero);
            }
        }

    }

    public int cantidadDeFilas() {
        return this.filas;
    }

    public int cantidadDeColumnas() {
        return this.columnas;
    }

    public boolean estaOcupado(Point ubicacion) {
        if(!this.existeUbicacion(ubicacion)){
            return true;
        }
        Casillero casillero = this.mapa.get(ubicacion);
        return casillero.estaOcupado();
    }

    public Casillero obtenerCasillero(Point ubicacion) {
        if(!this.existeUbicacion(ubicacion)){
            return null;
        }
        Casillero casillero = this.mapa.get(ubicacion);
        return casillero;
    }

    public boolean existeUbicacion(Point ubicacion){
        return mapa.containsKey(ubicacion);
    }
}
