package Vista;

import Controlador.ControladorDeHerramientasDelJugador;
import Modelo.Herramientas.TipoDeHerramienta.TipoDeHerramienta;
import Vista.Botones.Boton;
import Vista.Botones.BotonParaToolBar;
import javafx.application.Application;

import javafx.scene.Scene;

import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class VistaHerramientaEnMano extends Application {
    private Scene herramientaEnMano;
    private VBox vistaCompleta;//las tres vistas siguientes combinadas
    private VBox vistaHerramienta;//imagen de la herraminta
    private VBox vistaInformacion;//informacion de la herramienta durabilidad nombre etc
    private HBox vistaBotonera;//boton desequipar boton equipar siguiente
    private final String sinHerramientaEnMano = "VACIO";
    private ControladorDeHerramientasDelJugador controlador;
    private int tamanioDeLaHerramientaEnMano = 300;
    private final String durabilidad = "Durabilidad: ";
    private final String fuerza = "Fuerza: ";
    private Stage ventana = new Stage();

    public VistaHerramientaEnMano(ControladorDeHerramientasDelJugador control){
        controlador = control;
        controlador.cargarActualizacionDeVista(this);
        vistaCompleta = new VBox();

        vistaHerramienta = new VBox();
        this.visulizarHerramientaEnMano();

        vistaInformacion = new VBox();
        this.actualizarCajaDeInformacion();

        vistaBotonera = new HBox();
        this.crearBotonera();

        vistaCompleta.getChildren().addAll(vistaHerramienta,vistaInformacion,vistaBotonera);
        this.herramientaEnMano = new Scene(vistaCompleta);
    }

    private void visulizarHerramientaEnMano(){
        vistaHerramienta.getChildren().clear();
        ImageView imagen = this.imagenDeHerramientaEnMano();
        vistaHerramienta.getChildren().add(imagen);
    }

    private ImageView imagenDeHerramientaEnMano(){
        ImageView vistaDeLaHerramienta;
        String nombre;
        TipoDeHerramienta herramientaEnMano = controlador.herramientaEnMano();
        if (herramientaEnMano == null){
            nombre = sinHerramientaEnMano;
        }else{
            nombre = herramientaEnMano.nombreDeElemento();
        }
        String urlDeLaImagen = "Vista/Imagenes/Inventario/" + nombre + ".png";
        vistaDeLaHerramienta = new ImageView( urlDeLaImagen );
        vistaDeLaHerramienta.setFitHeight(tamanioDeLaHerramientaEnMano);
        vistaDeLaHerramienta.setFitWidth(tamanioDeLaHerramientaEnMano);
        return vistaDeLaHerramienta;
    }

    public void actualizarCajaDeInformacion(){//lo dejo en public para no tener que actualizar la imagen cada vez
        vistaInformacion.getChildren().clear();
        TipoDeHerramienta herramienta = controlador.herramientaEnMano();
        if (herramienta == null){
            this.insertarInformacion();
            return;
        }
        this.insertarInformacion(herramienta);
    }

    private void insertarInformacion(){
        Text nombre,durabilidad,fuerza;
        String nombreDeLaEntidad = "sin herramienta en mano";
        String vidaActualDeLaEntidad = this.durabilidad+ "-";
        String fuerzaDeLaHerramienta = this.fuerza+ "-";

        nombre = new Text(nombreDeLaEntidad);
        durabilidad = new Text(vidaActualDeLaEntidad);
        fuerza = new Text(fuerzaDeLaHerramienta);

        nombre.setFill(Color.DARKGRAY);
        durabilidad.setFill(Color.DARKGRAY);
        fuerza.setFill(Color.DARKGRAY);

        vistaInformacion.getChildren().add(nombre);
        vistaInformacion.getChildren().add(durabilidad);
        vistaInformacion.getChildren().add(fuerza);
    }
    private void insertarInformacion(TipoDeHerramienta herramienta){
        Text nombre,durabilidad,fuerza;
        Integer durabilidadNumerica = new Integer(herramienta.durabilidad());
        Integer fuerzaNumerica = new Integer(herramienta.fuerza());

        String nombreDeLaEntidad = "" + herramienta.nombreDeElemento();
        String vidaActualDeLaEntidad = this.durabilidad + durabilidadNumerica.toString();
        String fuerzaDeLaHerramienta = this.fuerza+ fuerzaNumerica.toString();

        nombre = new Text(nombreDeLaEntidad);
        durabilidad = new Text(vidaActualDeLaEntidad);
        fuerza = new Text(fuerzaDeLaHerramienta);

        nombre.setUnderline(true);

        nombre.setFill(Color.DARKRED);
        durabilidad.setFill(Color.DARKBLUE);
        fuerza.setFill(Color.DARKBLUE);

        nombre.setX(40);

        vistaInformacion.getChildren().add(nombre);
        vistaInformacion.getChildren().add(durabilidad);
        vistaInformacion.getChildren().add(fuerza);
    }

    private void crearBotonera(){
        Boton equipar = this.crearBotonEquipar();
        Boton desequipar = this.crearBotonDesequipar();
        vistaBotonera.getChildren().addAll(equipar,desequipar);
    }

    private Boton crearBotonEquipar(){
        Boton equipar = new BotonParaToolBar("EQUIPAR SIGUIENTE");
        equipar.setOnMouseClicked(evento -> {
            if (!controlador.existeOtraHerramientaAEquipar()){
                /*Alert alert = new Alert(Alert.AlertType.WARNING);
                alert.setTitle("ERROR");
                alert.setHeaderText("OK");
                alert.setContentText("No existe herramienta equipable en el inventario");
                alert.initOwner(miHerramientaEnMano);
                alert.showAndWait();
                if (alert.getResult() == ButtonType.OK){
                    System.exit(0);
                }*/
                return;
            }
            controlador.equiparSiguiente();
            this.actualizarVista();
        });
        return equipar;
    }
    private Boton crearBotonDesequipar(){
        Boton desequipar = new BotonParaToolBar("DESEQUIPAR");
        desequipar.setOnMouseClicked(evento -> {
            controlador.desequipar();
            this.actualizarVista();
        });
        return desequipar;
    }

    public void actualizarVista(){
        this.visulizarHerramientaEnMano();
        this.actualizarCajaDeInformacion();
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        Stage miHerramientaEnMano = primaryStage;
        miHerramientaEnMano.setScene(herramientaEnMano);
        miHerramientaEnMano.setTitle("HERRAMIENTA");
        miHerramientaEnMano.show();
    }

    public void iniciar(){
        this.actualizarVista();
        try {
            start(ventana);
        }catch (Exception e){
            System.out.println("falle InventarioVista");
            return;
        }
    }
}
