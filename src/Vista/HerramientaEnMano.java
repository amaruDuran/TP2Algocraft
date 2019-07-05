package Vista;

import Modelo.Herramientas.TipoDeHerramienta.TipoDeHerramienta;
import javafx.scene.Node;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;

public class HerramientaEnMano {/*
    private TipoDeHerramienta herramientaEnMano;
    private String sinHerramientaEnMano;//caso de que se rompa la herramienta
    private int tamanioDeLaHerramientaEnMano;
    private VBox cajaDeHerramienta;
    private VBox cajaDeInformacion;
    private final String durabilidad = "durabilidad: ";
    private final String fuerza = "fuerza: ";

    public HerramientaEnMano(TipoDeHerramienta herramienta, int tamanioDeLaImagen, String vacio){
        tamanioDeLaHerramientaEnMano = tamanioDeLaImagen;
        sinHerramientaEnMano = vacio;
        this.actualizar(herramienta);
    }

    private ImageView verHerramientaEnMano(){
        ImageView vistaDeLaHerramienta;
        String nombre;
        if (herramientaEnMano == null){//caso de que la herramienta se rompa
            nombre = sinHerramientaEnMano;
        }else{
            nombre = herramientaEnMano.nombreDeElemento();
        }
        String urlDeLaImagen = "Vista/Imagenes/Inventario/" + nombre + ".png";
        //String urlDeLaImagen = "Vista/Imagenes/Inventario/VACIO.png";
        vistaDeLaHerramienta = new ImageView( urlDeLaImagen );
        vistaDeLaHerramienta.setFitHeight(tamanioDeLaHerramientaEnMano);
        vistaDeLaHerramienta.setFitWidth(tamanioDeLaHerramientaEnMano);
        return vistaDeLaHerramienta;
    }

    private void actualizarCajaDeHerrameintaEnMano(){
        Text nombre,durabilidad,fuerza;
        if (herramientaEnMano != null) {
            Integer durabilidadNumerica = new Integer(herramientaEnMano.durabilidad());
            Integer fuerzaNumerica = new Integer(herramientaEnMano.fuerza());
            //info general
            String nombreDeLaEntidad = "" + herramientaEnMano.nombreDeElemento();
            String vidaActualDeLaEntidad = this.durabilidad + durabilidadNumerica.toString();
            String fuerzaDeLaHerramienta = this.fuerza + fuerzaNumerica.toString();

            //pasar a text
            nombre = new Text(nombreDeLaEntidad);
            durabilidad = new Text(vidaActualDeLaEntidad);
            fuerza = new Text(fuerzaDeLaHerramienta);

            //subrayado
            nombre.setUnderline(true);

            //color
            nombre.setFill(Color.YELLOW);
            durabilidad.setFill(Color.YELLOW);
            fuerza.setFill(Color.YELLOW);
        }else {
            String nombreDeLaEntidad = "sin herramienta en mano";
            String vidaActualDeLaEntidad = this.durabilidad + "-";
            String fuerzaDeLaHerramienta = this.fuerza + "-";

            nombre = new Text(nombreDeLaEntidad);
            durabilidad = new Text(vidaActualDeLaEntidad);
            fuerza = new Text(fuerzaDeLaHerramienta);

            nombre.setFill(Color.DARKGRAY);
            durabilidad.setFill(Color.DARKGRAY);
            fuerza.setFill(Color.DARKGRAY);
        }
        cajaDeInformacion.getChildren().add(nombre);
        cajaDeInformacion.getChildren().add(durabilidad);
        cajaDeInformacion.getChildren().add(fuerza);
    }

    public void actualizar(TipoDeHerramienta herramienta) {
        this.herramientaEnMano = herramienta;
        cajaDeHerramienta = new VBox();
        cajaDeInformacion = new VBox();
        ImageView herramientaVista = this.verHerramientaEnMano();
        cajaDeHerramienta.getChildren().add(herramientaVista);
        this.actualizarCajaDeHerrameintaEnMano();
        cajaDeHerramienta.getChildren().add(cajaDeInformacion);
    }

    public VBox darCaja() {
        return cajaDeHerramienta;
    }*/
}
