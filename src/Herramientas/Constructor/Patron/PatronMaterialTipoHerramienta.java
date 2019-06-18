package Herramientas.Constructor.Patron;

import Herramientas.Constructor.TableroDeConstruccion;
import Herramientas.TipoDeHerramienta.TipoDeHerramienta;

import java.util.ArrayList;

public abstract class PatronMaterialTipoHerramienta {

    protected String materialMadera = "MADERA";
    protected String materialPiedra = "PIEDRA";
    protected String materialMetal = "METAL";
    protected String materialVacio = "VACIO";

    ArrayList<String> patronConstructorActual;


    public abstract boolean esPatronValido(TableroDeConstruccion tablero);

    public abstract TipoDeHerramienta construir();
}
