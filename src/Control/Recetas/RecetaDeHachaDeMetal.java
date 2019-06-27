package Control.Recetas;

import Control.TableroDeConstruccionControl;
import Modelo.Herramientas.Constructor.Patron.PatronHachaMetal;

public class RecetaDeHachaDeMetal extends RecetaDeTipoHacha{
    private final String materialBase = "METAL";
    public RecetaDeHachaDeMetal(){
        cantidadDeMaderaNesesaria = new Integer(2);
        cantidadDePiedraNesesaria = new Integer(0);
        cantidadDeMetalNesesaria = new Integer(3);
        this.elementosNesesarios();
        patronCorrespondiente = new PatronHachaMetal();
    }
    public String nombreDeReceta(){
        return nombreDeTipo + materialBase;
    }
    public String urlDeImagenDeReceta(){
        return "../Vista/Imagenes/Recetas/" + urlDeTipo + materialBase;
    }
}
