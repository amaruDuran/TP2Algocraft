package Control.Recetas;

import Modelo.Herramientas.Constructor.Patron.PatronHachaPiedra;

public class RecetaDeHachaDePiedra extends RecetaDeTipoHacha {
    private final String materialBase = "PIEDRA";
    public RecetaDeHachaDePiedra(){
        cantidadDeMaderaNesesaria = new Integer(2);
        cantidadDePiedraNesesaria = new Integer(3);
        cantidadDeMetalNesesaria = new Integer(0);
        this.elementosNesesarios();
        patronCorrespondiente = new PatronHachaPiedra();
    }
    public String nombreDeReceta(){
        return nombreDeTipo + materialBase;
    }
    public String urlDeImagenDeReceta(){
        return "../Vista/Imagenes/Recetas/" + urlDeTipo + materialBase;
    }
}
