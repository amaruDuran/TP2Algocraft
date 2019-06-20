package Materiales.UnidadElemental;

import Herramientas.TipoDeHerramienta.MaterialDeHerramientas.*;

public class UnidadElementalDiamante  extends UnidadElemental {
    public MaterialDeHerramienta materialDeConstruccion(MaterialDeHerramientaMetal metal){
        return null;
    }
    public MaterialDeHerramienta materialDeConstruccion(MaterialDeHerramientaMadera madera){
        return null;
    }
    public MaterialDeHerramienta materialDeConstruccion(MaterialDeHerramientaPiedra piedra){
        return null;
    }
    public MaterialDeHerramienta materialDeConstruccion(MaterialDeHerramientaMetalPiedra metalPiedra){
        return null;
    }

    @Override
    public String nombreDeElemento() {
        return "DIAMANTE";
    }
}
