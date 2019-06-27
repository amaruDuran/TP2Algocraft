package Control.Eventos;

import Vista.Botones.Boton;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.stage.Stage;

public class SalirDelJuego {
    public SalirDelJuego(Boton botonParaMenuSalir, Stage stage){
        botonParaMenuSalir.setOnMouseClicked(evento -> {
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setTitle("Salir");
            alert.setHeaderText("salir del juego");
            alert.setContentText("Desea salir del juego");
            alert.initOwner(stage);
            alert.showAndWait();
            if (alert.getResult() == ButtonType.OK){
                System.exit(0);
            }
        });
    }
}
