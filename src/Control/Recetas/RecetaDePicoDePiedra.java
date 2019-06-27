package Control.Recetas;

import Control.TableroDeConstruccionControl;
import Modelo.Herramientas.Constructor.Patron.PatronPicoPiedra;

public class RecetaDePicoDePiedra extends RecetaDeTipoPico{
    private final String materialBase = "PIEDRA";
    public RecetaDePicoDePiedra(){
        cantidadDeMaderaNesesaria = new Integer(2);
        cantidadDePiedraNesesaria = new Integer(3);
        cantidadDeMetalNesesaria = new Integer(0);
        this.elementosNesesarios();
        patronCorrespondiente = new PatronPicoPiedra();
    }
    public String nombreDeReceta(){
        return nombreDeTipo + materialBase;
    }
    public String urlDeImagenDeReceta(){
        return "../Vista/Imagenes/Recetas/" + urlDeTipo + materialBase;
    }
}
