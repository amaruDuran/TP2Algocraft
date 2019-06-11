package Materiales.UnidadElemental;

import Herramientas.TipoDeHerramienta.MaterialDeHerramientas.*;
import Jugador.ObjeosDelInventario;

public abstract class UnidadElemental implements ObjeosDelInventario {
    public MaterialDeHerramienta materialDeConstruccion(){
        return null;
    }
    public MaterialDeHerramienta materialDeConstruccion(MaterialDeHerramientaMetal metal){
        return metal;
    }
    public MaterialDeHerramienta materialDeConstruccion(MaterialDeHerramientaMadera madera){
        return madera;
    }
    public MaterialDeHerramienta materialDeConstruccion(MaterialDeHerramientaPiedra piedra){
        return piedra;
    }
    public MaterialDeHerramienta materialDeConstruccion(MaterialDeHerramientaMetalPiedra metalPiedra){
        return metalPiedra;
    }
    public abstract String generarNombre();
}
