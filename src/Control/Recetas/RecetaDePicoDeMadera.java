package Control.Recetas;

import Control.TableroDeConstruccionControl;
import Modelo.Herramientas.Constructor.Patron.PatronPicoMadera;

public class RecetaDePicoDeMadera extends RecetaDeTipoPico {
    private final String materialBase = "MADERA";
    public RecetaDePicoDeMadera(){
        cantidadDeMaderaNesesaria = new Integer(5);
        cantidadDePiedraNesesaria = new Integer(0);
        cantidadDeMetalNesesaria = new Integer(0);
        this.elementosNesesarios();
        patronCorrespondiente = new PatronPicoMadera();
    }
    public String nombreDeReceta(){
        return nombreDeTipo + materialBase;
    }
    public String urlDeImagenDeReceta(){
        return "../Vista/Imagenes/Recetas/" + urlDeTipo + materialBase;
    }
}
