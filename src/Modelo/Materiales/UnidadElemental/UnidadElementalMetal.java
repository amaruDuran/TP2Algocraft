package Modelo.Materiales.UnidadElemental;

import Modelo.Herramientas.TipoDeHerramienta.MaterialDeHerramientas.*;

public class UnidadElementalMetal extends UnidadElemental {
    public UnidadElementalMetal(){
        this.nombreDeElemento = "METAL";
    }
    public MaterialDeHerramienta materialDeConstruccion(){
        MaterialDeHerramienta metal = new MaterialDeHerramientaMetal();
        return metal;
    }
    public MaterialDeHerramienta materialDeConstruccion(MaterialDeHerramientaPiedra piedra){
        MaterialDeHerramientaMetalPiedra metalPiedra = new MaterialDeHerramientaMetalPiedra();
        return metalPiedra;
    }
    public MaterialDeHerramienta materialDeConstruccion(MaterialDeHerramientaMadera madera){
        MaterialDeHerramienta metal = new MaterialDeHerramientaMetal();
        return metal;
    }
}
