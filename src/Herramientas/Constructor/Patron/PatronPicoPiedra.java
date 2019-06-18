package Herramientas.Constructor.Patron;

import Herramientas.Constructor.TableroDeConstruccion;
import Herramientas.TipoDeHerramienta.MaterialDeHerramientas.MaterialDeHerramienta;
import Herramientas.TipoDeHerramienta.MaterialDeHerramientas.MaterialDeHerramientaPiedra;
import Herramientas.TipoDeHerramienta.Pico;
import Herramientas.TipoDeHerramienta.TipoDeHerramienta;

import java.util.ArrayList;

public class PatronPicoPiedra extends PatronMaterialTipoHerramienta {

    private ArrayList<String> cargarPatronPicoPiedra(){
        ArrayList<String> patronPicoPiedra = new ArrayList<>();
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

    public PatronPicoPiedra(){
        patronConstructorActual = cargarPatronPicoPiedra();
    }

    @Override
    public boolean esPatronValido(TableroDeConstruccion tablero) {
        ArrayList<String> patronDeTablero = tablero.parsearPatron();
        for (int i = 0; i < patronConstructorActual.size(); i++) {
            if (!(patronConstructorActual.get(i).equalsIgnoreCase(patronDeTablero.get(i)))) {
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
