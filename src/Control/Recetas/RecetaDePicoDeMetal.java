package Control.Recetas;

import Control.TableroDeConstruccionControl;
import Modelo.Herramientas.Constructor.Patron.PatronPicoMetal;

public class RecetaDePicoDeMetal extends RecetaDeTipoPico{
    private final String materialBase = "METAL";
    public RecetaDePicoDeMetal(){
        cantidadDeMaderaNesesaria = new Integer(2);
        cantidadDePiedraNesesaria = new Integer(0);
        cantidadDeMetalNesesaria = new Integer(3);
        this.elementosNesesarios();
        patronCorrespondiente = new PatronPicoMetal();
    }
    public String nombreDeReceta(){
        return nombreDeTipo + materialBase;
    }
    public String urlDeImagenDeReceta(){
        return "../Vista/Imagenes/Recetas/" + urlDeTipo + materialBase;
    }
}
