package Vista;

import Modelo.Juego.Mapa;
import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;

import java.awt.*;

public class MapaVista implements Dibujable {
    private GridPane mapa;
    private Mapa mapaModelo;

    public MapaVista(Mapa mapaJuego){
        //GridPane Objeto que sirve para construir tableros según fila y columna.
        mapaModelo = mapaJuego;
        mapa = new GridPane();
        //Para que las imagenes estén separadas y no estén tan juntas.
        mapa.setPadding(new Insets(10,10,10,10));

        /*Debería estar en Carpeta de Controlador o vista y encapsulado en una clase.*/
        //Casillero casillero = mapaModelo.obtenerCasillero(new Point(1,9));
        //casillero.asignar(new Jugador());
    }


    @Override
    public void dibujar() {
        mapa.setHgap(mapaModelo.cantidadDeColumnas());
        mapa.setVgap(mapaModelo.cantidadDeFilas());

        //todo: esto sería el mapa.dibujar().
        for (int i = 0; i < mapa.getHgap(); i++) {
            for (int j = 0; j < mapa.getVgap(); j++) {
                String elementoMapaVista = mapaModelo.obtenerCasillero(new Point(i,j)).identificador();
                javafx.scene.image.Image imagenUnidadElemental= new Image("Vista/Imagenes/" + elementoMapaVista + ".png");
                ImageView imagenUnidadElementalVista = new ImageView(imagenUnidadElemental);
                mapa.setConstraints(imagenUnidadElementalVista, i, j);
                mapa.getChildren().add(imagenUnidadElementalVista);
            }
        }
    }

    @Override
    public Node getVista() {
        return mapa;
    }


}
