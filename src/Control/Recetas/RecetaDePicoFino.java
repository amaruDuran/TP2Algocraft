package Control.Recetas;

import Control.TableroDeConstruccionControl;
import Modelo.Herramientas.Constructor.Patron.PatronPicoFino;

public class RecetaDePicoFino extends RecetasDelTableroDeConstruccion {

    public RecetaDePicoFino(){
        cantidadDeMaderaNesesaria = new Integer(2);
        cantidadDePiedraNesesaria = new Integer(1);
        cantidadDeMetalNesesaria = new Integer(3);
        this.elementosNesesarios();
        patronCorrespondiente = new PatronPicoFino();
    }
    public String nombreDeReceta(){
        return "PICO FINO";
    }
    public String urlDeImagenDeReceta(){
        return "../Vista/Imagenes/Recetas/recetaPICOFINO.png";
    }
}
