package Modelo.Herramientas.Constructor.Patron;

import Modelo.Herramientas.Constructor.TableroDeConstruccion;
import Modelo.Herramientas.TipoDeHerramienta.MaterialDeHerramientas.MaterialDeHerramienta;
import Modelo.Herramientas.TipoDeHerramienta.MaterialDeHerramientas.MaterialDeHerramientaPiedra;
import Modelo.Herramientas.TipoDeHerramienta.Pico;
import Modelo.Herramientas.TipoDeHerramienta.TipoDeHerramienta;
import Modelo.Materiales.UnidadElemental.UnidadElemental;

import java.util.ArrayList;

public class PatronPicoPiedra extends PatronMaterialTipoHerramienta {

    private ArrayList<UnidadElemental> cargarPatronPicoPiedra(){
        ArrayList<UnidadElemental> patronPicoPiedra = new ArrayList<>();
        patronPicoPiedra.add(materialPiedra);
        patronPicoPiedra.add(materialPiedra);
        patronPicoPiedra.add(materialPiedra);
        patronPicoPiedra.add(materialVacio);
        patronPicoPiedra.add(materialMadera);
        patronPicoPiedra.add(materialVacio);
        patronPicoPiedra.add(materialVacio);
        patronPicoPiedra.add(materialMadera);
        patronPicoPiedra.add(materialVacio);

        return patronPicoPiedra;
    }
    public ArrayList<UnidadElemental> cargarPatron(){
        return this.cargarPatronPicoPiedra();
    }

    public PatronPicoPiedra(){
        patronConstructorActual = cargarPatronPicoPiedra();
    }

    @Override
    public boolean esPatronValido(TableroDeConstruccion tablero) {
        ArrayList<UnidadElemental>patronDeTablero = tablero.parsearPatron();
        for (int i = 0; i < patronConstructorActual.size(); i++) {
            if (!(patronConstructorActual.get(i).equivalenteA(patronDeTablero.get(i)))) {
                return false;
            }
        }
        return true;
    }

    @Override
    public TipoDeHerramienta construir() {
        MaterialDeHerramienta piedra = new MaterialDeHerramientaPiedra();
        TipoDeHerramienta picoDePiedra = new Pico(piedra);
        return picoDePiedra;
    }
}
