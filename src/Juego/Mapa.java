package Juego;
import Materiales.MaterialDiamante;
import Materiales.MaterialMadera;
import Materiales.MaterialMetal;
import Materiales.MaterialPiedra;

public class Mapa {
    private int filas;
    private int columnas;
    private Casillero[][] mapa;

    public Mapa(int filas , int columnas){
        this.filas = filas;
        this.columnas = columnas;
        this.inicializacionDeCasilleros();
        this.inicializacionDeMaterialesEnElMapa();
    }

    private void inicializacionDeMaterialesEnElMapa() {
        this.mapa[2][1].asignar(new MaterialMetal());
        this.mapa[2][2].asignar(new MaterialMetal());
        this.mapa[3][1].asignar(new MaterialMetal());
        this.mapa[3][2].asignar(new MaterialMetal());

        this.mapa[2][5].asignar(new MaterialDiamante());
        this.mapa[2][6].asignar(new MaterialDiamante());
        this.mapa[3][5].asignar(new MaterialDiamante());
        this.mapa[3][6].asignar(new MaterialDiamante());

        this.mapa[5][1].asignar(new MaterialMadera());
        this.mapa[5][2].asignar(new MaterialMadera());
        this.mapa[5][3].asignar(new MaterialMadera());
        this.mapa[5][4].asignar(new MaterialMadera());

        this.mapa[8][7].asignar(new MaterialPiedra());
        this.mapa[8][8].asignar(new MaterialPiedra());
    }

    private void inicializacionDeCasilleros() {
        this.mapa = new Casillero[this.filas][this.columnas];
        for (int fil = 0; fil<this.filas; fil++){
            for (int col = 0; col<this.columnas; col++){
                Casillero casillero = new Casillero();
                this.mapa[fil][col] = casillero;
            }
        }
    }

    public int cantidadDeFilas() {
        return this.filas;
    }

    public int cantidadDeColumnas() {
        return this.columnas;
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
