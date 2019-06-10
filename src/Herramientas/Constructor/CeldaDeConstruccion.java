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

    public void agregarElemento(UnidadElemental unidadElemental){
        elemento = unidadElemental;
    }

    public void quitarElemento(Inventario inventario){
        UnidadElemental unidadElemental = elemento;
        elemento = null;
        inventario.agregarObjetosAlInventario(unidadElemental);
    }
}
