package Materiales.UnidadElemental;

import Herramientas.TipoDeHerramienta.MaterialDeHerramientas.*;

public class UnidadElementalMetal extends UnidadElemental {
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

    @Override
    public String nombre() {
        return "METAL";
    }
}
