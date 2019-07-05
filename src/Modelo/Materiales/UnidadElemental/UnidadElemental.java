package Modelo.Materiales.UnidadElemental;

import Modelo.Herramientas.TipoDeHerramienta.MaterialDeHerramientas.*;
import Modelo.Jugador.ObjeosDelInventario;

import java.util.Objects;

public abstract class UnidadElemental implements ObjeosDelInventario {
    protected String nombreDeElemento;

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


    public String nombreDeElemento() {
        return nombreDeElemento;
    }

    public boolean equivalenteA(UnidadElemental unidadElemental) {
        if (this == unidadElemental) return true;
        return Objects.equals(nombreDeElemento, unidadElemental.nombreDeElemento);
    }

    public Boolean equipable(){
        return false;
    }
}
