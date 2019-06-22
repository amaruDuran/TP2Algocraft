package Modelo.Materiales.UnidadElemental;

import Modelo.Herramientas.TipoDeHerramienta.MaterialDeHerramientas.MaterialDeHerramienta;
import Modelo.Herramientas.TipoDeHerramienta.MaterialDeHerramientas.MaterialDeHerramientaMadera;

public class UnidadElementalMadera extends UnidadElemental {
    public UnidadElementalMadera(){
        this.nombreDeElemento = "MADERA";
    }
    public MaterialDeHerramienta materialDeConstruccion(){
        MaterialDeHerramientaMadera madera = new MaterialDeHerramientaMadera();
        return madera;
    }
}
