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


    public abstract boolean esPatronValido(TableroDeConstruccion tablero);

    public abstract TipoDeHerramienta construir();

    public abstract ArrayList<UnidadElemental> cargarPatron();
}
