package Vista.Imagenes;

import javafx.scene.image.Image;

public class LibreriaDeImagenes {
    private String carpetaImagenes = "file:src/vista/Imagenes/";
    private final Image fondoDeMenu;//se le agrega final para que NO se pueda modificar

    public LibreriaDeImagenes(){
        this.fondoDeMenu = new Image(carpetaImagenes + "fondo_de_menu.jpg");
    }

    public Image darFondoDeMenu(){
        return fondoDeMenu;
    }
}
