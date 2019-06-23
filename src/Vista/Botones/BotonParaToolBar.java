package Vista.Botones;

import javafx.geometry.Pos;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.Text;

public class BotonParaToolBar extends Boton {
    public BotonParaToolBar(String nombre){
        //el texto del boton
        texto = new Text(nombre);
        texto.setFont(Font.font(12));
        texto.setFill(Color.BLACK);
        //el fondo y forma del boton
        this.colorActualDelBoton = Color.GREY;
        this.colorSecundarioDelBoton = Color.WHITESMOKE;
        this.fondo = new Rectangle(120,14);
        this.fondo.setOpacity(1);
        this.fondo.setFill(colorActualDelBoton);
        //agregar el texto al fondo
        this.setAlignment(Pos.CENTER);
        //this.setRotate(-0.5);
        this.getChildren().addAll(fondo,texto);
    }
}
