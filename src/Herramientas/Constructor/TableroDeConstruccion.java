package Herramientas.Constructor;

import Herramientas.Constructor.Patron.PatronDeConstruccion;
import Herramientas.TipoDeHerramienta.TipoDeHerramienta;
import Jugador.Inventario;
import Materiales.UnidadElemental.UnidadElemental;

import java.util.ArrayList;
import java.util.List;

public class TableroDeConstruccion {
    private List<CeldaDeConstruccion> celdas;
    private PatronDeConstruccion construccion;
    private int cantidadDeFilas;
    private int cantidadDeColumnas;
    //orden de celdas en cuadro
    // C1  C2  C3 Columnas
    //(11)(12)(13)Fila1
    //(21)(22)(23)Fila2
    //(31)(32)(33)Fila3
    //en la lista [(11)(12)(13)(21)(22)(23)(31)(32)(33)]
    public TableroDeConstruccion(){
        celdas = new ArrayList<CeldaDeConstruccion>();
        cantidadDeFilas = 3;
        cantidadDeColumnas = 3;
        int cantidadDeCeldas = cantidadDeFilas * cantidadDeColumnas;
        for (int i = 0; i < cantidadDeCeldas; i++){
            CeldaDeConstruccion celda = new CeldaDeConstruccion();
            celdas.add(celda);
        }
        construccion = new PatronDeConstruccion();
    }

    private int posicionDeLaCelda(int fila, int columna){
        int numeroDeFila = (fila % cantidadDeFilas);
        int numeroDeColumna = (columna % cantidadDeColumnas);
        int posicion = (numeroDeFila * 3) + numeroDeColumna;
        return posicion;
    }

    public UnidadElemental obtenerElementoDe(int fila, int columna){
        UnidadElemental unidadElem = this.verCelda(fila, columna).verElemento();
        return unidadElem;
    }

    public boolean posicionEstaVacia(int fila, int columna){
        return this.verCelda(fila,columna).estaVacia();
    }

    private CeldaDeConstruccion verCelda(int fila, int columna){
        int posicion = this.posicionDeLaCelda(fila,columna);
        CeldaDeConstruccion celda = celdas.get(posicion);
        return celda;
    }

    public boolean agregarElementoEnCelda(int fila, int columna, UnidadElemental elemento){
        //se supone que el elemento fue removido del inventario
        CeldaDeConstruccion celdaAAgregar = this.verCelda(fila,columna);
        if(!celdaAAgregar.estaVacia()){
            return false;//la celda esta ocupada hay que vaciarla primero
        }
        celdaAAgregar.agregarElemento(elemento);
        return true;
    }

    //util para la interfaz de usuario.
    public boolean quitarElementoEnCelda(int fila, int columna, Inventario inventario){
        CeldaDeConstruccion celdaAQuitar = this.verCelda(fila,columna);
        if(celdaAQuitar.estaVacia()){
            return false;//la celda esta vacia no se puede quitar nada
        }
        celdaAQuitar.quitarElemento(inventario);
        return true;
    }

    //idem interfaz de usuario.
    public TipoDeHerramienta construir(){
        TipoDeHerramienta herramienta = construccion.construir(celdas);
        return herramienta;
    }

    public void consumirElemento(int fila, int columna){
        CeldaDeConstruccion celdaAConsumir = this.verCelda(fila,columna);
        celdaAConsumir.agregarElemento(null);
    }
}
