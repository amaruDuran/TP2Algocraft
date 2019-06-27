package Vista;

import Control.Recetas.*;
import Control.TableroDeConstruccionControl;
import Vista.Botones.Boton;
import Vista.Botones.BotonDeRecetas;
import Vista.Botones.BotonParaToolBar;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

import java.util.ArrayList;

import javafx.scene.paint.Color;
import javafx.scene.text.Text;

public class RecetaVista {
    private VBox caja;
    private int tamanioHorizontalDeRecetas;
    private ArrayList<RecetasDelTableroDeConstruccion> recetasDisponibles;
    private TableroDeConstruccionControl tablero;
    private final Color colorDelTexto = Color.ORANGE;

    public RecetaVista(TableroDeConstruccionControl tablero, int tamanio){
        caja = new VBox();
        tamanioHorizontalDeRecetas = tamanio;
        this.tablero = tablero;
        this.generarRecetas();
        this.agregarRecetaVista();
    }

    private void generarRecetas(){
        recetasDisponibles.add(0,new RecetaDeHachaDeMadera());
        recetasDisponibles.add(1,new RecetaDeHachaDePiedra());
        recetasDisponibles.add(2,new RecetaDeHachaDeMetal());
        recetasDisponibles.add(3,new RecetaDePicoDeMadera());
        recetasDisponibles.add(4,new RecetaDePicoDePiedra());
        recetasDisponibles.add(5,new RecetaDePicoDeMetal());
        recetasDisponibles.add(6,new RecetaDePicoFino());
    }

    private void agregarRecetaVista(){
        for (int i = 0; i < recetasDisponibles.size(); i++){
            RecetasDelTableroDeConstruccion receta = recetasDisponibles.get(i);
            BotonDeRecetas boton = this.generarBotonReceta(receta);
            this.caja.getChildren().add(boton);
            Text nombre = this.generarNombreDeReceta(receta);
            this.caja.getChildren().add(nombre);
        }
    }

    private BotonDeRecetas generarBotonReceta(RecetasDelTableroDeConstruccion receta){
        BotonDeRecetas boton = new BotonDeRecetas(receta,tablero,tamanioHorizontalDeRecetas);
        return boton;
    }

    private Text generarNombreDeReceta(RecetasDelTableroDeConstruccion receta){
        String nombreDeReceta = receta.nombreDeReceta();
        Text nombre = new Text(nombreDeReceta);
        nombre.setFill(colorDelTexto);
        return nombre;
    }

    public VBox visualizar(){
        return caja;
    }
}
