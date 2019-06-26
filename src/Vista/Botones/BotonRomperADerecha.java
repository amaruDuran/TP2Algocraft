package Vista.Botones;

import Vista.Aplicacion;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;

public class BotonRomperADerecha extends Button {
    public BotonRomperADerecha(){
        super ();
        setText("ROMPER DERECHA");
        this.setTranslateY(100);
        this.setTranslateX(5);
        this.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event) {
                Aplicacion.jugadorModelo.romperADerecha();
                Aplicacion.mapa.dibujar();

            }
        });
    }
}
