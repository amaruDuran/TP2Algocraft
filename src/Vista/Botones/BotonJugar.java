package Vista.Botones;


import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;

public class BotonJugar extends Button {
    public BotonJugar(){
        super();
        this.setText("JUGAR");
        this.setTranslateX(600);

        this.setMinHeight(40);
        this.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event) {
                //Scene escenaPrincipal = new Scene(Aplicacion.panelesDeJuego);
                //Aplicacion.ventanaAlgocraft.setScene(escenaPrincipal);
                //Aplicacion.movimientos(escenaPrincipal);

            }

        });
    }
}