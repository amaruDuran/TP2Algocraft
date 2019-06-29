package Controlador;

import Modelo.Juego.Mapa;
import Vista.Dibujable;
import javafx.scene.Node;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;

import java.awt.*;

public class ControladorDeMapa implements Dibujable {
    private final Mapa mapaModelo;
    private final GridPane mapaVista;

    public ControladorDeMapa(Mapa mapa) {
        this.mapaModelo = mapa;
        this.mapaVista = new GridPane();
    }

    public void iniciar(){
        dibujar();
    }

    @Override
    public void dibujar() {
        mapaVista.setHgap(0);
        mapaVista.setVgap(0);


        //todo: esto sería el mapa.dibujar().
        for (int i = 0; i < mapaModelo.cantidadDeFilas(); i++) {
            for (int j = 0; j < mapaModelo.cantidadDeColumnas(); j++) {
                Point ubicacion = new Point(i,j);
                dibujarFondo(ubicacion);
                String elementoMapaVista = mapaModelo.obtenerCasillero(ubicacion).identificador();
                javafx.scene.image.Image imagenUnidadElemental= new Image("Vista/Imagenes/" + elementoMapaVista + ".png");
                ImageView imagenUnidadElementalVista = new ImageView(imagenUnidadElemental);
                imagenUnidadElementalVista.setFitWidth(50);
                imagenUnidadElementalVista.setFitHeight(50);
                mapaVista.setConstraints(imagenUnidadElementalVista, i, j);
                mapaVista.getChildren().add(imagenUnidadElementalVista);
            }
        }
    }

    @Override
    public Node getVista() {
        return mapaVista;
    }

    public void dibujarPosicion(Point posicion) {
        if (mapaModelo.existeUbicacion(posicion)){
            dibujarFondo(posicion);
            String elementoMapaVista = mapaModelo.obtenerCasillero(posicion).identificador();
            //Image imagen = new Image("Vista/Imagenes/"+elementoMapaVista+".png");
            ImageView imagenVista = dibujarImagen(elementoMapaVista);
            mapaVista.setConstraints(imagenVista, posicion.x, posicion.y);
            mapaVista.getChildren().remove(imagenVista);
            mapaVista.getChildren().add(imagenVista);
        }
    }

    private void dibujarFondo(Point posicion){
        ImageView imagenVista = dibujarImagen("VACIO");
        mapaVista.setConstraints(imagenVista, posicion.x, posicion.y);
        mapaVista.getChildren().remove(imagenVista);
        mapaVista.getChildren().add(imagenVista);
    }

    private ImageView dibujarImagen(String nombre){
        Image imagen = new Image("Vista/Imagenes/"+nombre+".png");
        ImageView imagenVista = new ImageView(imagen);
        imagenVista.setFitWidth(50);
        imagenVista.setFitHeight(50);
        return imagenVista;
    }

    public void dibujarPosiciones(Point posicion,Point posicionAnterior){
        dibujarPosicion(posicionAnterior);
        dibujarPosicion(posicion);
    }
}


