package Eventos;

import Vista.Botones.Boton;
import javafx.stage.Stage;

public class PantallaCompleta {
    public PantallaCompleta(Boton botonDeCambio, Stage stage){
        botonDeCambio.setOnMouseClicked(evento -> {
            boolean pantallaCompleta = stage.isFullScreen();
            stage.setFullScreen(!pantallaCompleta);
        });
    }
}
