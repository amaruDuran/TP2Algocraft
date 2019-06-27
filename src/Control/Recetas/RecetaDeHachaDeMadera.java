package Control.Recetas;

import Modelo.Herramientas.Constructor.Patron.PatronHachaMadera;

public class RecetaDeHachaDeMadera extends RecetaDeTipoHacha {
    private final String materialBase = "MADERA";
    public RecetaDeHachaDeMadera(){
        cantidadDeMaderaNesesaria = new Integer(5);
        cantidadDePiedraNesesaria = new Integer(0);
        cantidadDeMetalNesesaria = new Integer(0);
        this.elementosNesesarios();
        patronCorrespondiente = new PatronHachaMadera();
    }
    public String nombreDeReceta(){
        return nombreDeTipo + materialBase;
    }
    public String urlDeImagenDeReceta(){
        return "../Vista/Imagenes/Recetas/" + urlDeTipo + materialBase;
    }
}
