package Vista.Botones;

import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;

public abstract class Boton extends StackPane {
    protected Text texto; //tuve que ponerlo public para acceder en los efectos
    protected Rectangle fondo;
    protected Color colorActualDelBoton;
    protected Color colorSecundarioDelBoton;
    private Color colorDesabilitado = Color.GRAY;

    public void deshabilitarBoton(){
        this.fondo.setFill(colorDesabilitado);
        this.setDisable(true);
    }
    public void habilitarBoton(){
        this.fondo.setFill(colorActualDelBoton);
        this.setDisable(false);
    }
}
