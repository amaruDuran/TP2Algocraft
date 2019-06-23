package Vista;


import Vista.Botones.BotonJugar;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;

public class BienvenidaVista {
    public static double ancho;
    public static double alto;
    private VBox bienvenida;


    public BienvenidaVista(){
        this.bienvenida = new VBox();
        this.bienvenida.getChildren().add(new BotonJugar());
        this.setFondoDePantalla();

    }

    private void setFondoDePantalla() {
        ImageView fondo= new ImageView();
        fondo.setImage(new Image("Vista/Imagenes/bienvenida.jpeg"));
        bienvenida.getChildren().add(fondo);
    }

    public VBox getBienvenida() {
        return bienvenida;
    }


}