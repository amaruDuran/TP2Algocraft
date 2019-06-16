package Vista;

import Vista.Imagenes.LibreriaDeImagenes;
import Vista.Sonidos.LibreriaDeSonidos;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.input.KeyCombination;
import javafx.stage.Stage;

public class Aplicacion extends Application {
    private Stage stage;
    private MenuPrincipal menuJuego;
    private LibreriaDeSonidos sonidos;
    private LibreriaDeImagenes imagenes;

    @Override
    public void start(Stage primaryStage) throws Exception {
        this.stage = primaryStage;
        this.sonidos = new LibreriaDeSonidos();
        this.imagenes = new LibreriaDeImagenes();
        //se crea la ventana de la interfaz
        stage.setFullScreen(false);
        stage.setFullScreenExitKeyCombination(KeyCombination.NO_MATCH);
        stage.setMinWidth(1200);
        stage.setMinHeight(750);
        stage.setTitle("AlgoCraft");
        //se crea lo que muestra la interfaz
        this.menuJuego = new MenuPrincipal(stage,sonidos,imagenes);
        //se crea la interfaz
        Scene scene = new Scene(menuJuego);
        //se muestra la interfaz
        stage.setScene(scene);
        stage.show();
    }
}
