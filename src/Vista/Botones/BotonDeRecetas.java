package Vista.Botones;

import Control.Recetas.RecetasDelTableroDeConstruccion;
import Control.TableroDeConstruccionControl;
import javafx.scene.image.ImageView;
import javafx.scene.shape.Rectangle;

public class BotonDeRecetas extends Boton {
    //private RecetasDelTableroDeConstruccion receta;

    public BotonDeRecetas(RecetasDelTableroDeConstruccion receta, TableroDeConstruccionControl tablero, int tamanio){
        //this.receta = receta;

        int anchoDelBoton = tamanio - 1;
        int largoDelBoton = tamanio - 1;
        this.fondo = new Rectangle(anchoDelBoton,largoDelBoton);

        ImageView icono;
        String urlDelIcono = receta.urlDeImagenDeReceta();
        icono = new ImageView( urlDelIcono );
        icono.setFitHeight(anchoDelBoton);
        icono.setFitWidth(largoDelBoton);
        this.getChildren().addAll(icono);


        this.setOnMouseClicked(evento -> {
            receta.acomodar(tablero);
        });
    }
}
