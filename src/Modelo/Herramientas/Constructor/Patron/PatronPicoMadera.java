package Modelo.Herramientas.Constructor.Patron;

import Modelo.Herramientas.Constructor.TableroDeConstruccion;
import Modelo.Herramientas.TipoDeHerramienta.MaterialDeHerramientas.MaterialDeHerramienta;
import Modelo.Herramientas.TipoDeHerramienta.MaterialDeHerramientas.MaterialDeHerramientaMadera;
import Modelo.Herramientas.TipoDeHerramienta.Pico;
import Modelo.Herramientas.TipoDeHerramienta.TipoDeHerramienta;
import Modelo.Materiales.UnidadElemental.UnidadElemental;

import java.util.ArrayList;

public class PatronPicoMadera extends PatronMaterialTipoHerramienta{

    private ArrayList<UnidadElemental> cargarPatronPicoMadera(){
        ArrayList<UnidadElemental> patronPicoMadera = new ArrayList<>();
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
    public ArrayList<UnidadElemental> cargarPatron(){
        return this.cargarPatronPicoMadera();
    }

    public PatronPicoMadera(){
        patronConstructorActual = cargarPatronPicoMadera();
    }


    @Override
    public boolean esPatronValido(TableroDeConstruccion tablero) {
        ArrayList<UnidadElemental> patronDeTablero = tablero.parsearPatron();
        for (int i = 0; i < patronConstructorActual.size(); i++) {
            if (!(patronConstructorActual.get(i).equivalenteA(patronDeTablero.get(i)))) {
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
