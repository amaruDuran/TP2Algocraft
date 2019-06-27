package Vista;

import Control.TableroDeConstruccionControl;
import Modelo.Jugador.Inventario;
import Vista.Botones.Boton;
import Vista.Botones.BotonParaToolBar;
import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.image.Image;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class TableroDeConstruccionVista implements Dibujable {
    private GridPane tablaDeConstruccion;
    private VBox caja;
    private TableroDeConstruccionControl control;
    private RecetaVista recetaVista;
    private final int tamBordes = 3;

    public TableroDeConstruccionVista(Inventario inventario){
        control = new TableroDeConstruccionControl(inventario, this);
        recetaVista = new RecetaVista(control,100);//el 20 esta hardcodeado remplazar
        this.generarTableroVista();
        caja = new VBox();
        caja.getChildren().add(tablaDeConstruccion);
        this.generarBotones();
        caja.getChildren().add(recetaVista.visualizar());
    }

    private void generarTableroVista(){
        tablaDeConstruccion = new GridPane();
        tablaDeConstruccion.setPadding(new Insets(1,1,1,1));
        tablaDeConstruccion.setHgap(tamBordes);
        tablaDeConstruccion.setVgap(tamBordes);
    }

    private void actualizarElTablero(){
        for (int i = 0; i < tamBordes;i++){
            for (int j = 0; j < tamBordes;j++){
                //de alguna forma hacer que se vean las celdas con imagenes
            }
        }
    }

    private void generarBotones(){
        Boton crear = new BotonParaToolBar("crear");
        Boton vaciar = new BotonParaToolBar("vaciar");
        crear.setOnMouseClicked(evento -> {
            control.crear();
        });
        vaciar.setOnMouseClicked(evento -> {
            control.vaciar();
        });
        HBox botonera = new HBox();
        botonera.getChildren().add(crear);
        botonera.getChildren().add(vaciar);
        caja.getChildren().add(botonera);
    }

    @Override
    public void dibujar() {

    }

    @Override
    public Node getVista() {
        return caja;
    }
}
