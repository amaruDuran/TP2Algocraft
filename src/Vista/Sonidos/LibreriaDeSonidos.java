package Vista.Sonidos;

import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;

import java.io.File;

public class LibreriaDeSonidos {
    private MediaPlayer caminar;
    private final String carpetaSonidos = "src/vista/sonidos/";//se le agrega final para que NO se pueda modificar

    public LibreriaDeSonidos(){
        this.caminar = new MediaPlayer(new Media(new File(carpetaSonidos + "caminar.mp3").toURI().toString()));
    }
}
