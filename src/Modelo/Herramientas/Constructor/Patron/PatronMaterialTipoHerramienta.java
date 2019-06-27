package Modelo.Herramientas.Constructor.Patron;

import Modelo.Herramientas.Constructor.TableroDeConstruccion;
import Modelo.Herramientas.TipoDeHerramienta.TipoDeHerramienta;
import Modelo.Materiales.UnidadElemental.*;

import java.util.ArrayList;

public abstract class PatronMaterialTipoHerramienta {

    protected UnidadElemental materialMadera = new UnidadElementalMadera();
    protected UnidadElemental materialPiedra = new UnidadElementalPiedra();
    protected UnidadElemental materialMetal = new UnidadElementalMetal();
    protected UnidadElemental materialVacio = new UnidadElementalVacia();

    ArrayList<UnidadElemental> patronConstructorActual;

    public boolean esPatronValido(TableroDeConstruccion tablero){
        ArrayList<UnidadElemental> patronDeTablero = tablero.parsearPatron();
        for (int i = 0; i < patronConstructorActual.size(); i++) {
            if (!(patronConstructorActual.get(i).equivalenteA(patronDeTablero.get(i)))) {
                return false;
            }
        }
        return true;
    }

    public abstract TipoDeHerramienta construir();
}
