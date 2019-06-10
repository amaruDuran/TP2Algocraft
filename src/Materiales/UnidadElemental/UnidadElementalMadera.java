package Materiales.UnidadElemental;

import Herramientas.TipoDeHerramienta.MaterialDeHerramientas.MaterialDeHerramienta;
import Herramientas.TipoDeHerramienta.MaterialDeHerramientas.MaterialDeHerramientaMadera;
import Herramientas.TipoDeHerramienta.MaterialDeHerramientas.MaterialDeHerramientaMetalPiedra;

public class UnidadElementalMadera extends UnidadElemental {
    public MaterialDeHerramienta materialDeConstruccion(){
        MaterialDeHerramientaMadera madera = new MaterialDeHerramientaMadera();
        return madera;
    }
}
