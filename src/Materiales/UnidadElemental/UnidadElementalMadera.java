package Materiales.UnidadElemental;

import Herramientas.TipoDeHerramienta.MaterialDeHerramientas.MaterialDeHerramienta;
import Herramientas.TipoDeHerramienta.MaterialDeHerramientas.MaterialDeHerramientaMadera;

public class UnidadElementalMadera extends UnidadElemental {
    public MaterialDeHerramienta materialDeConstruccion(){
        MaterialDeHerramientaMadera madera = new MaterialDeHerramientaMadera();
        return madera;
    }

    @Override
    public String nombre() {
        return "MADERA";
    }
}
