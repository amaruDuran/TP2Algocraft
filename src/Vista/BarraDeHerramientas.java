package Vista;

import Eventos.PantallaCompleta;
import Eventos.SalirDelJuego;

import Vista.Botones.Boton;
import Vista.Botones.BotonParaToolBar;
import javafx.scene.Node;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class BarraDeHerramientas implements Dibujable {
    private HBox toolBar;
    private final String textoPantallaCompleta = "Pantalla Completa";
    private final String textoSalir = "Salir Del Juego";
    private final String textoInventario = "Inventario";
    private final String textoHerramientaEnMano = "Herramienta En Mano";
    private final String textoConstructor = "Construccion De Herramientas";
    private Boton pantallaCompleta;
    private Boton salir;
    private Boton inventario;
    private Boton herramientaEnMano;
    private Boton constructor;
    private InventarioVista miInventarioVista;
    private VistaHerramientaEnMano vistaHerramientaEnMano;
    private VistaTableroDeConstruccion tableroDeConstruccion;

    public BarraDeHerramientas(Stage stage, InventarioVista inventarioVista, VistaHerramientaEnMano vistaHerramientaEnMano, VistaTableroDeConstruccion tableroDeConstruccion){
        toolBar = new HBox();
        toolBar.setSpacing(1);
        this.generarBotones(stage);
        this.ordenarToolBar();
        this.miInventarioVista = inventarioVista;
        this.vistaHerramientaEnMano = vistaHerramientaEnMano;
        this.tableroDeConstruccion = tableroDeConstruccion;
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
        new PantallaCompleta(pantallaCompleta, stage);

        //inventario
        inventario = new BotonParaToolBar(textoInventario);

        inventario.setOnMouseClicked(evento -> {
            miInventarioVista.iniciar();
        });

        //herramienta en mano
        herramientaEnMano = new BotonParaToolBar(textoHerramientaEnMano);
        herramientaEnMano.setOnMouseClicked(evento -> {
            vistaHerramientaEnMano.iniciar();
        });

        //constructor
        constructor = new BotonParaToolBar(textoConstructor);
        constructor.setOnMouseClicked(evento -> {
            tableroDeConstruccion.iniciar();
        });

        //salir del juego
        salir = new BotonParaToolBar(textoSalir);
        new SalirDelJuego(salir, stage);
    }

    private void ordenarToolBar(){
        toolBar.getChildren().addAll(pantallaCompleta,inventario,herramientaEnMano,constructor,salir);
    }
}
