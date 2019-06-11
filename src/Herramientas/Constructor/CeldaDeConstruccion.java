package Herramientas.Constructor;

import Jugador.Inventario;
import Materiales.UnidadElemental.UnidadElemental;

public class CeldaDeConstruccion {
    private UnidadElemental elemento;

    public CeldaDeConstruccion(){
        elemento = null;
    }

    public UnidadElemental verElemento(){
        return elemento;
    }

    public boolean estaVacia(){
        return (elemento == null);
    }
    //el tablero se encarga de verificar que no este vacia 
    //el tablero al agregar un elemento pisa el anterior
    public void agregarElemento(UnidadElemental unidadElemental){
        elemento = unidadElemental;
    }

    public void quitarElemento(Inventario inventario){
        UnidadElemental unidadElemental = elemento;
        elemento = null;
        inventario.agregarObjetosAlInventario(unidadElemental);
    }
}
