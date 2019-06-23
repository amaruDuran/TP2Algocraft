package Vista.Botones;

import Modelo.Jugador.ObjeosDelInventario;
import javafx.scene.image.ImageView;
import javafx.scene.shape.Rectangle;

import java.awt.*;

public class BotonDeInventario extends Boton {
    private ObjeosDelInventario objeto;
    //private final int tamanioHorizontal = 20;
    //private final int tamanioVertical = 20;

    public BotonDeInventario(ObjeosDelInventario objeto, int tamanio){
        this.objeto = objeto;

        //int anchoDelBoton = tamanioHorizontal - 1;
        //int largoDelBoton = tamanioVertical - 1;
        int anchoDelBoton = tamanio - 1;
        int largoDelBoton = tamanio - 1;
        this.fondo = new Rectangle(anchoDelBoton,largoDelBoton);

        ImageView icono;
        String nombre = objeto.nombreDeElemento();
        String urlDelIcono = "Vista/Imagenes/Inventario/" + nombre + ".png";
        icono = new ImageView( urlDelIcono );
        icono.setFitHeight(anchoDelBoton);
        icono.setFitWidth(largoDelBoton);
        this.getChildren().addAll(icono);


        /*this.setOnMouseClicked(evento -> {
            //evento
        });*/
    }
}
