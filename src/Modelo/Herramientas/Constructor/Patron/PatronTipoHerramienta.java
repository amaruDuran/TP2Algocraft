package Modelo.Herramientas.Constructor.Patron;

import Modelo.Herramientas.Constructor.TableroDeConstruccion;
import Modelo.Herramientas.TipoDeHerramienta.TipoDeHerramienta;

import java.util.ArrayList;

public class PatronTipoHerramienta {

    ArrayList<PatronMaterialTipoHerramienta> patrones;

    public PatronTipoHerramienta(){
        patrones = new ArrayList<>();
        PatronMaterialTipoHerramienta hachaMadera = new PatronHachaMadera();
        PatronMaterialTipoHerramienta hachaPiedra = new PatronHachaPiedra();
        PatronMaterialTipoHerramienta hachaMetal = new PatronHachaMetal();
        patrones.add(hachaMadera);
        patrones.add(hachaPiedra);
        patrones.add(hachaMetal);

        PatronMaterialTipoHerramienta picoMadera = new PatronPicoMadera();
        PatronMaterialTipoHerramienta picoPiedra = new PatronPicoPiedra();
        PatronMaterialTipoHerramienta picoMetal = new PatronPicoMetal();
        patrones.add(picoMadera);
        patrones.add(picoPiedra);
        patrones.add(picoMetal);

        PatronMaterialTipoHerramienta picoFino = new PatronPicoFino();
        patrones.add(picoFino);

    }

    public TipoDeHerramienta construir(TableroDeConstruccion tablero){
        for (int i = 0; i < patrones.size() ; i++) {
            PatronMaterialTipoHerramienta patronActual = patrones.get(i);
            if (patronActual.esPatronValido(tablero)){
                TipoDeHerramienta herramienta = patronActual.construir();
                return herramienta;
            }
        }
        return null;
    }
}
