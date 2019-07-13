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

    @Override
    public void start(Stage primaryStage) throws Exception {
        Stage miInventario = primaryStage;
        //Scene escenaDeInventario = new Scene(inventarioVista);
        miInventario.setScene(escenaDeInventario);
        miInventario.setTitle("INVENTARIO");
        miInventario.show();
    }

    public void actualizarCasillero(){
        int ultimaPosicion = controladorInventario.getInventarioModelo().size() - 1;
        actualizarCasillero(ultimaPosicion);
    }

    public void actualizarCasilleros(int desde){//sacar cosas desde la mitad del inventario
        int hasta = controladorInventario.getInventarioModelo().size() + 1;//+1 por que tiene que figurar vacio el proximo elemento
        for (int pos = desde; pos < hasta; pos++){
            actualizarCasillero(pos);
        }
    }
    public void actualizarCasilleros(int desde, int hasta){//sacar cosas desde la mitad del inventario
        if (hasta < desde || hasta > tamanioDeInventario()){
            return;
        }
        for (int pos = desde; pos < hasta; pos++){
            actualizarCasillero(pos);
        }
    }

    private void actualizarCasillero(int posicion){
        if (posicion < 0 || posicion >= this.tamanioDeInventario()) {
            return;
        }
        //controladorInventario.actualizarCantidades();
        inventarioCompletado = controladorInventario.obtenerInventarioCompletado(inventarioCompletado);
        ObjeosDelInventario objeto = inventarioCompletado.get(posicion);
        inventarioCompletado.remove(posicion);
        inventarioCompletado.add(posicion, objeto);
        Point pos = this.posicionDelObjetoEnCuadrado(posicion);
        dibujarEnPosicion(casilleroVacio, pos.x, pos.y);
        dibujarEnPosicion(objeto, pos.x, pos.y);
    }

    private void dibujarEnPosicion(ObjeosDelInventario objeto, int columna, int fila){
        String urlDelObjetoDelInventario = objeto.nombreDeElemento();
        Image imagen = new Image("Vista/Imagenes/Inventario/"+urlDelObjetoDelInventario+".png");
        ImageView imagenObjetoDelInventarioVista = new ImageView(imagen);
        imagenObjetoDelInventarioVista.setFitWidth(40);
        imagenObjetoDelInventarioVista.setFitHeight(40);
        inventarioVista.setConstraints(imagenObjetoDelInventarioVista, columna, fila);
        inventarioVista.getChildren().add(imagenObjetoDelInventarioVista);
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
