package Herramientas.Constructor.Patron;

import Herramientas.Constructor.CeldaDeConstruccion;
import Herramientas.Herramienta;
import Herramientas.TipoDeHerramienta.Hacha;
import Herramientas.TipoDeHerramienta.MaterialDeHerramientas.MaterialDeHerramienta;
import Herramientas.TipoDeHerramienta.TipoDeHerramienta;
import Materiales.UnidadElemental.UnidadElemental;

import java.util.ArrayList;
import java.util.List;

public class PatronHacha {
    private List<String> patronDeUnHacha;
    private List<String> materialesGeneralesPermitidos;
    private String materialGeneral = "GENERAL";
    private String materialMadera = "MADERA";
    private String materialPiedra = "PIEDRA";
    private String materialMetal = "METAL";
    private String materialDeConsTruccion = "";


    public PatronHacha(){
        patronDeUnHacha = new ArrayList<String>();
        materialesGeneralesPermitidos = new ArrayList<String>();
        materialesGeneralesPermitidos.add(materialMadera);
        materialesGeneralesPermitidos.add(materialPiedra);
        materialesGeneralesPermitidos.add(materialMetal);
        llenarPatronHacha();
    }

    private void llenarPatronHacha(){
        patronDeUnHacha.add(materialGeneral);
        patronDeUnHacha.add(materialGeneral);
        patronDeUnHacha.add("");
        patronDeUnHacha.add(materialGeneral);
        patronDeUnHacha.add(materialMadera);
        patronDeUnHacha.add("");
        patronDeUnHacha.add("");
        patronDeUnHacha.add(materialMadera);
        patronDeUnHacha.add("");
    }

    public TipoDeHerramienta construir(UnidadElemental elemento){
        MaterialDeHerramienta materialDeHerramienta = elemento.materialDeConstruccion();
        Hacha hachaNueva = new Hacha(materialDeHerramienta);
        return hachaNueva;
    }

    public boolean esUnPatronHacha(List<String> patron){
    int tamanioDePatron = patronDeUnHacha.size();
    materialDeConsTruccion = patronDeUnHacha.get(1);
    for (int i = 1; i < (tamanioDePatron + 1); i++) {
        String base = patronDeUnHacha.get(i);
        String cadena = patron.get(i);
        if ((base == materialGeneral && !materialDeConsTruccion.equalsIgnoreCase(cadena)) || !(base.equalsIgnoreCase(cadena) && base == materialGeneral)){
            return false;
        }
    }
    return true;
    }
}
