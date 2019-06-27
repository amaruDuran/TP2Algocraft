package Vista;

import Control.Eventos.PantallaCompleta;
import Control.Eventos.SalirDelJuego;
import Vista.Botones.Boton;
import Vista.Botones.BotonParaToolBar;
import javafx.scene.Node;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class BarraDeHerramientas implements Dibujable {
    private HBox toolBar;
    private final String textoPantallaCompleta = "Pantalla Completa";
    private final String textoSalir = "Salir Del Juego";
    private Boton pantallaCompleta;
    private Boton salir;

    public BarraDeHerramientas(Stage stage){
        toolBar = new HBox();
        toolBar.setSpacing(1);
        this.generarBotones(stage);
        this.ordenarToolBar();
    }

    @Override
    public void dibujar(){}

    @Override
    public Node getVista() {
        return toolBar;
    }

    private void generarBotones(Stage stage){
        //pantallacompleta
        pantallaCompleta = new BotonParaToolBar(textoPantallaCompleta);
        new PantallaCompleta(pantallaCompleta,stage);
        //salir del juego
        salir = new BotonParaToolBar(textoSalir);
        new SalirDelJuego(salir,stage);
    }

    private void ordenarToolBar(){
        toolBar.getChildren().add(pantallaCompleta);
        toolBar.getChildren().add(salir);
    }
}
