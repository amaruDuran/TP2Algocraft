package Herramientas.Constructor.Patron;

import Herramientas.Constructor.TableroDeConstruccion;
import Herramientas.TipoDeHerramienta.MaterialDeHerramientas.MaterialDeHerramienta;
import Herramientas.TipoDeHerramienta.MaterialDeHerramientas.MaterialDeHerramientaMetal;
import Herramientas.TipoDeHerramienta.Pico;
import Herramientas.TipoDeHerramienta.TipoDeHerramienta;

import java.util.ArrayList;

public class PatronPicoMetal extends PatronMaterialTipoHerramienta{

    private ArrayList<String> cargarPatronPicoMetal(){
        ArrayList<String> patronPicoMetal = new ArrayList<>();
        patronPicoMetal.add(materialMetal);
        patronPicoMetal.add(materialMetal);
        patronPicoMetal.add(materialMetal);
        patronPicoMetal.add(materialVacio);
        patronPicoMetal.add(materialMadera);
        patronPicoMetal.add(materialVacio);
        patronPicoMetal.add(materialVacio);
        patronPicoMetal.add(materialMadera);
        patronPicoMetal.add(materialVacio);

        return patronPicoMetal;
    }


    public PatronPicoMetal(){
        patronConstructorActual = cargarPatronPicoMetal();
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
        MaterialDeHerramienta metal = new MaterialDeHerramientaMetal();
        TipoDeHerramienta picoDeMetal = new Pico(metal);
        return picoDeMetal;
    }
}
