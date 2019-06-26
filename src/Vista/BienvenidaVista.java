package Vista;


import Vista.Botones.BotonJugar;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;

public class BienvenidaVista {
    private VBox bienvenida;


    public BienvenidaVista(){
        this.bienvenida = new VBox();
        this.setFondoDePantalla();
        this.bienvenida.getChildren().add(new BotonJugar());
    }

    private void setFondoDePantalla() {
        ImageView fondo= new ImageView();
        fondo.setImage(new Image("Vista/Imagenes/bienvenida.jpg"));
        fondo.setFitHeight(720);
        fondo.setFitWidth(1400);
        bienvenida.getChildren().add(fondo);
    }

    public VBox getBienvenida() {
        return bienvenida;
    }
}