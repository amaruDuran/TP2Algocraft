package Materiales.UnidadElemental;


import Herramientas.TipoDeHerramienta.MaterialDeHerramientas.*;

public class UnidadElementalPiedra extends UnidadElemental {
    public MaterialDeHerramienta materialDeConstruccion(){
        MaterialDeHerramientaPiedra piedra = new MaterialDeHerramientaPiedra();
        return piedra;
    }
    public MaterialDeHerramienta materialDeConstruccion(MaterialDeHerramientaMetal metal){
        MaterialDeHerramientaMetalPiedra metalPiedra = new MaterialDeHerramientaMetalPiedra();
        return metalPiedra;
    }
    public MaterialDeHerramienta materialDeConstruccion(MaterialDeHerramientaMadera madera){
        MaterialDeHerramientaPiedra piedra = new MaterialDeHerramientaPiedra();
        return piedra;
    }

    @Override
    public String nombreDeElemento() {
        return "PIEDRA";
    }
}
