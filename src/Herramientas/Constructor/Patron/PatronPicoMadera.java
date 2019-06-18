package Herramientas.Constructor.Patron;

import Herramientas.Constructor.TableroDeConstruccion;
import Herramientas.TipoDeHerramienta.MaterialDeHerramientas.MaterialDeHerramienta;
import Herramientas.TipoDeHerramienta.MaterialDeHerramientas.MaterialDeHerramientaMadera;
import Herramientas.TipoDeHerramienta.Pico;
import Herramientas.TipoDeHerramienta.TipoDeHerramienta;

import java.util.ArrayList;

public class PatronPicoMadera extends PatronMaterialTipoHerramienta{

    private ArrayList<String> cargarPatronPicoMadera(){
        ArrayList<String> patronPicoMadera = new ArrayList<>();
        patronPicoMadera.add(materialMadera);
        patronPicoMadera.add(materialMadera);
        patronPicoMadera.add(materialMadera);
        patronPicoMadera.add(materialVacio);
        patronPicoMadera.add(materialMadera);
        patronPicoMadera.add(materialVacio);
        patronPicoMadera.add(materialVacio);
        patronPicoMadera.add(materialMadera);
        patronPicoMadera.add(materialVacio);

        return patronPicoMadera;
    }

    public PatronPicoMadera(){
        patronConstructorActual = cargarPatronPicoMadera();
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
        MaterialDeHerramienta madera = new MaterialDeHerramientaMadera();
        TipoDeHerramienta picoDeMadera = new Pico(madera);
        return picoDeMadera;
    }
}
