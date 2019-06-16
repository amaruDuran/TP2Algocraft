package Vista;

import Vista.Imagenes.LibreriaDeImagenes;
import Vista.Sonidos.LibreriaDeSonidos;
import javafx.scene.image.Image;
import javafx.scene.layout.*;
import javafx.stage.Stage;

public class MenuPrincipal extends StackPane {
    private Stage stage;
    private LibreriaDeSonidos sonidos;
    private LibreriaDeImagenes imagenes;
    private VBox menuPrincipal;//BorderPane XBox


    public MenuPrincipal(Stage stage, LibreriaDeSonidos sonidos, LibreriaDeImagenes imagenes) {
        this.stage = stage;
        this.sonidos = sonidos;
        this.imagenes = imagenes;

        Image imagen = imagenes.darFondoDeMenu();
        BackgroundSize size = new BackgroundSize(Constantes.altoImagenFondo,Constantes.anchoImagenFondo, false,false,true,true);
        BackgroundImage imagenDeFondo = new BackgroundImage(imagen, BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT,size);
        this.setBackground(new Background(imagenDeFondo));

        this.menuPrincipal = this.crearSubmenu();
    }

    private VBox crearSubmenu(){
        VBox submenu = new VBox(10);
        submenu.setTranslateX(100);
        submenu.setTranslateY(200);
        return submenu;
    }
}
