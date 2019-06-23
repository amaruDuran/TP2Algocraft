package Vista;

import Modelo.Jugador.ObjeosDelInventario;
import Modelo.Jugador.ObjetoDelInventarioVacio;
import Vista.Botones.Boton;
import Vista.Botones.BotonDeInventario;
import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;

import java.util.List;

public class InventarioVista implements Dibujable {
    private List<ObjeosDelInventario> elementosDelInventario;
    private final ObjeosDelInventario casilleroVacio = new ObjetoDelInventarioVacio();
    private final int tamanioHorizontalDelInventario = 5;
    private final int tamanioVerticalDelInventario = 6;
    //private final int tamanioDelInventario = (tamanioHorizontalDelInventario * tamanioVerticalDelInventario);
    private GridPane inventario;
    private VBox caja;

    public InventarioVista(List<ObjeosDelInventario> inventarioDeJugador){
        inventario = new GridPane();
        inventario.setPadding(new Insets(1,1,1,1));
        inventario.setHgap(tamanioHorizontalDelInventario);
        inventario.setVgap(tamanioVerticalDelInventario);
        caja = new VBox();//en la caja se pueden agregar mas cosas al inventario
        this.actualizarInventario(inventarioDeJugador);
    }

    private void completar(){
        int tamanioDelInventario = (tamanioHorizontalDelInventario * tamanioVerticalDelInventario);
        int cantidadDeElementosFaltantes = tamanioDelInventario - elementosDelInventario.size();
        /*if (cantidadDeElementosFaltantes > 0){
            return;
        }*/
        for (int i = 0; i < cantidadDeElementosFaltantes; i++){
            elementosDelInventario.add(casilleroVacio);
        }
    }

    private Boton convertirEnBotones(ObjeosDelInventario objeto){
        Boton boton = new BotonDeInventario(objeto);
        return boton;
    }

    private int posicionDelObjetoEnInventario(int fila, int columna){
        int posicionDelObjetoEnInventario = (fila * tamanioHorizontalDelInventario) + columna;
        return posicionDelObjetoEnInventario;
    }

    @Override
    public void dibujar() {
        for (int fila = 0; fila < tamanioVerticalDelInventario; fila++){
            for (int columna = 0; columna < tamanioHorizontalDelInventario; columna++){
                int posicionDelObjetoEnInventario = this.posicionDelObjetoEnInventario(fila,columna);
                ObjeosDelInventario objeto = elementosDelInventario.get(posicionDelObjetoEnInventario);
                Boton botonDelObjeto = this.convertirEnBotones(objeto);
                inventario.add(botonDelObjeto,columna,fila,1,1);
            }
        }
    }
    public void actualizarInventario(List<ObjeosDelInventario> inventarioDeJugador){
        elementosDelInventario = inventarioDeJugador;
        this.completar();
        //this.pasarALaGrilla();
        this.dibujar();
        caja.getChildren().add(inventario);
    }

    //public VBox visualizacionDelInventario(){
    //    return caja;
    //}

    @Override
    public Node getVista() {
        //return inventario;
        return caja;
    }
}
