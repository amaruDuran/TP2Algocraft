package Modelo.Materiales;

import Modelo.Herramientas.TipoDeHerramienta.Pico;
import Modelo.Materiales.UnidadElemental.UnidadElementalMetal;

public class MaterialMetal extends Material {

    public MaterialMetal(){
        durabilidad = 50;
        this.setUnidadElemental();
        this.identificador = "METAL";
    }

    @Override
    public boolean recolectadoPor(Pico herramienta) {
        if (herramienta.fuerza() < 4){
            /*si es mayor a 4 es un pico de metal si es 4 es de piedra...
            * buscar otra forma de impedir que pico de madera extraiga metal*/
            return false;
        }
        herramientaGastaMaterial(herramienta.fuerza());
        return true;
    }

    @Override
    protected void setUnidadElemental() {
        unidadElemental = new UnidadElementalMetal();
    }
}
