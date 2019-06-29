package Vista;

import Modelo.Jugador.Inventario;
import Modelo.Jugador.ObjeosDelInventario;
import Modelo.Jugador.ObjetoDelInventarioVacio;
import Vista.Botones.Boton;
import Vista.Botones.BotonDeInventario;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class IVista extends Application {
    private List<ObjeosDelInventario> inventarioModelo;
    private List<ObjeosDelInventario> inventarioCompletado;
    private GridPane inventarioVista;
    private final int tamanioHorizontal = 5;
    private final int tamanioVertical = 6;
    private final ObjeosDelInventario casilleroVacio = new ObjetoDelInventarioVacio();
    private final int tamanioDeBotones = 50;
    private Stage ventana = new Stage();
    Scene escenaDeInventario;
    private int anteriorTamanio;


    public IVista(List<ObjeosDelInventario> inventario){
        this.inventarioVista = new GridPane();
        inventarioVista.setPadding(new Insets(1,1,1,1));
        inventarioVista.setHgap(tamanioHorizontal);
        inventarioVista.setVgap(tamanioVertical);
        this.inventarioModelo = inventario;
        this.anteriorTamanio = inventarioModelo.size();
        this.inventarioCompletado = new ArrayList<ObjeosDelInventario>();
        this.escenaDeInventario = new Scene(inventarioVista);
    }

    private void completarElInventario(){
        this.inventarioCompletado.clear();
        this.inventarioCompletado.addAll(inventarioModelo);
        int tamanioDelInventario = (tamanioHorizontal * tamanioVertical);
        int cantidadDeElementosFaltantes = tamanioDelInventario - inventarioCompletado.size();
        for (int i = 0; i < cantidadDeElementosFaltantes; i++){
            inventarioCompletado.add(casilleroVacio);
        }
    }

    private void dibujar() {

        inventarioVista.setHgap(0);
        inventarioVista.setVgap(0);

        for(int columna=0; columna<tamanioHorizontal; columna++){
            for(int fila=0; fila< tamanioVertical;fila++){
                int posicionDelObjetoEnInventario = this.posicionDelObjetoEnInventario(fila,columna);
                ObjeosDelInventario objeto = inventarioCompletado.get(posicionDelObjetoEnInventario);
                dibujarEnPosicion(objeto,columna,fila);
            }
        }
        //this.escenaDeInventario = new Scene(inventarioVista);
    }


    private int posicionDelObjetoEnInventario(int fila, int columna){
        int posicionDelObjetoEnInventario = (fila * tamanioHorizontal) + columna;
        return posicionDelObjetoEnInventario;
    }
    private Point posicionDelObjetoEnCuadrado(int posicion){
        posicion--;
        int x = posicion % tamanioVertical;
        int y = (posicion) / (tamanioVertical );
        Point posicionDelObjetoEnInventario = new Point(x,y);
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
        miInventario.show();
    }

    public void actualizarCasillero(){
         int posicion = inventarioModelo.size() - 1;
         if (posicion < 0) {
            return;
         }
         this.completarElInventario();
         ObjeosDelInventario objeto = inventarioCompletado.get(posicion);
         inventarioCompletado.remove(posicion);
         inventarioCompletado.add(posicion,objeto);
         Point pos = this.posicionDelObjetoEnCuadrado(posicion);
         dibujarEnPosicion(objeto,pos.x,pos.y);
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
        this.completarElInventario();
        dibujar();
        try {
            start(ventana);
        }catch (Exception e){
            System.out.println("entre");
            return;
        }
    }



}
