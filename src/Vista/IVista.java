package Vista;

import Controlador.ControladorInventario;
import Modelo.Jugador.ObjeosDelInventario;
import Modelo.Jugador.ObjetoDelInventarioVacio;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class IVista extends Application {
    //private List<ObjeosDelInventario> inventarioModelo;
    private List<ObjeosDelInventario> inventarioCompletado;
    private GridPane inventarioVista;
    private final int ancho = 6;
    private final int alto = 5;
    private final ObjeosDelInventario casilleroVacio = new ObjetoDelInventarioVacio();
    private final int tamanioDeBotones = 50;
    private Stage ventana = new Stage();
    Scene escenaDeInventario;
    private int anteriorTamanio;
    private ControladorInventario controladorInventario;


    public IVista(){
        //controladorInventario = inventarioControl;
        this.inventarioVista = new GridPane();
        inventarioVista.setPadding(new Insets(1,1,1,1));
        inventarioVista.setHgap(ancho);
        inventarioVista.setVgap(alto);
        this.inventarioCompletado = new ArrayList<>();
        this.escenaDeInventario = new Scene(inventarioVista);
    }

    public void incorporarControl(ControladorInventario inventarioControl){
        controladorInventario = inventarioControl;
        inventarioCompletado = controladorInventario.obtenerInventarioCompletado(inventarioCompletado);
    }

    public int tamanioDeInventario(){
        return (alto * ancho);
    }

    private void dibujar() {

        inventarioVista.setHgap(0);
        inventarioVista.setVgap(0);

        for(int fila = 0; fila < alto; fila++){
            for(int columna = 0; columna < ancho; columna++){
                int posicionDelObjetoEnInventario = this.posicionDelObjetoEnInventario(fila, columna);
                ObjeosDelInventario objeto = inventarioCompletado.get(posicionDelObjetoEnInventario);
                dibujarEnPosicion(objeto, columna, fila);
            }
        }
        //this.escenaDeInventario = new Scene(inventarioVista);
    }


    private int posicionDelObjetoEnInventario(int fila, int columna){
        int posicionDelObjetoEnInventario = (fila * ancho) + columna;
        return posicionDelObjetoEnInventario;
    }
    private Point posicionDelObjetoEnCuadrado(int posicion){
        int x = posicion % ancho;
        int y = (posicion) / (ancho);
        Point posicionDelObjetoEnInventario = new Point(x, y);
        return posicionDelObjetoEnInventario;
    }

    /*
    private Boton convertirEnBotones(ObjeosDelInventario objeto){
        Boton boton = new BotonDeInventario(objeto,tamanioDeBotones);
        return boton;
    }*/
    @Override
    public void start(Stage primaryStage) throws Exception {
        Stage miInventario = primaryStage;
        //Scene escenaDeInventario = new Scene(inventarioVista);
        miInventario.setScene(escenaDeInventario);
        miInventario.setTitle("INVENTARIO");
        miInventario.show();
    }

    public void actualizarCasillero(){
        int posicion = controladorInventario.getInventarioModelo().size() - 1;
        if (posicion < 0) {
           return;
        }
        inventarioCompletado = controladorInventario.obtenerInventarioCompletado(inventarioCompletado);
        ObjeosDelInventario objeto = inventarioCompletado.get(posicion);
        inventarioCompletado.remove(posicion);
        inventarioCompletado.add(posicion, objeto);
        Point pos = this.posicionDelObjetoEnCuadrado(posicion);
        dibujarEnPosicion(objeto, pos.x, pos.y);
    }

    private void dibujarEnPosicion(ObjeosDelInventario objeto, int columna, int fila){
        String imagenElemental = objeto.nombreDeElemento();
        Image imagen = new Image("Vista/Imagenes/Inventario/"+imagenElemental+".png");
        ImageView imagenUnidadElementalVista = new ImageView(imagen);
        imagenUnidadElementalVista.setFitWidth(40);
        imagenUnidadElementalVista.setFitHeight(40);
        inventarioVista.setConstraints(imagenUnidadElementalVista, columna, fila);
        inventarioVista.getChildren().add(imagenUnidadElementalVista);
    }


    public void iniciar(){
        inventarioCompletado = controladorInventario.obtenerInventarioCompletado(inventarioCompletado);
        dibujar();
        try {
            start(ventana);
        }catch (Exception e){
            System.out.println("falle IVista");
            return;
        }
    }



}
