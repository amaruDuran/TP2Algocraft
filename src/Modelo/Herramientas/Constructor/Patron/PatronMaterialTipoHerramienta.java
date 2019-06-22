package Modelo.Herramientas.Constructor.Patron;

import Modelo.Herramientas.Constructor.TableroDeConstruccion;
import Modelo.Herramientas.TipoDeHerramienta.TipoDeHerramienta;
import Modelo.Materiales.UnidadElemental.*;

import java.util.ArrayList;

public abstract class PatronMaterialTipoHerramienta {

    /*protected String materialMadera = "MADERA";
    protected String materialPiedra = "PIEDRA";
    protected String materialMetal = "METAL";
    protected String materialVacio = "VACIO";*/
    protected UnidadElemental materialMadera = new UnidadElementalMadera();
    protected UnidadElemental materialPiedra = new UnidadElementalPiedra();
    protected UnidadElemental materialMetal = new UnidadElementalMetal();
    protected UnidadElemental materialVacio = new UnidadElementalVacia();

    //ArrayList<String> patronConstructorActual;
    ArrayList<UnidadElemental> patronConstructorActual;


    public abstract boolean esPatronValido(TableroDeConstruccion tablero);

    public abstract TipoDeHerramienta construir();
}
