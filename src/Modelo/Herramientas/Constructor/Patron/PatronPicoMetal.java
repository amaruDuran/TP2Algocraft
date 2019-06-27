package Modelo.Herramientas.Constructor.Patron;

import Modelo.Herramientas.Constructor.TableroDeConstruccion;
import Modelo.Herramientas.TipoDeHerramienta.MaterialDeHerramientas.MaterialDeHerramienta;
import Modelo.Herramientas.TipoDeHerramienta.MaterialDeHerramientas.MaterialDeHerramientaMetal;
import Modelo.Herramientas.TipoDeHerramienta.Pico;
import Modelo.Herramientas.TipoDeHerramienta.TipoDeHerramienta;
import Modelo.Materiales.UnidadElemental.UnidadElemental;

import java.util.ArrayList;

public class PatronPicoMetal extends PatronMaterialTipoHerramienta{

    private ArrayList<UnidadElemental> cargarPatronPicoMetal(){
        ArrayList<UnidadElemental> patronPicoMetal = new ArrayList<>();
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
    public ArrayList<UnidadElemental> cargarPatron(){
        return this.cargarPatronPicoMetal();
    }


    public PatronPicoMetal(){
        patronConstructorActual = cargarPatronPicoMetal();
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
        MaterialDeHerramienta metal = new MaterialDeHerramientaMetal();
        TipoDeHerramienta picoDeMetal = new Pico(metal);
        return picoDeMetal;
    }
}
