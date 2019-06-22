package Modelo.Materiales.UnidadElemental;


import Modelo.Herramientas.TipoDeHerramienta.MaterialDeHerramientas.*;


public class UnidadElementalPiedra extends UnidadElemental {
    public UnidadElementalPiedra(){
        this.nombreDeElemento = "PIEDRA";
    }
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
}
