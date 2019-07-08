package Vista;

import Controlador.ControlDelTableroDeConstruccion;
import Modelo.Materiales.UnidadElemental.*;
import Vista.Botones.Boton;
import Vista.Botones.BotonDeSelector;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class VistaTableroDeConstruccion extends Application {
    private ControlDelTableroDeConstruccion control;
    Scene escenaDeTablero;
    private VBox constructor;
    private GridPane tablero;
    private HBox selector;
    private final int tamanioDelCuadro = 3;
    private final int separacionDeCuadros = 5;
    private final int tamanioDeBotones = 50;
    private Stage ventana = new Stage();

    public VistaTableroDeConstruccion(ControlDelTableroDeConstruccion controlador){
        control = controlador;

        constructor = new VBox();

        tablero = new GridPane();
        inicioDeTablero();

        selector = new HBox();
        inicioDelSelector();
        escenaDeTablero = new Scene(constructor);
    }

    private void inicioDeTablero(){
        tablero.setHgap(separacionDeCuadros);
        tablero.setVgap(separacionDeCuadros);
    }

    private void inicioDelSelector(){
        UnidadElemental madera = new UnidadElementalMadera();
        BotonDeSelector botonMadera = crearBotonDeSeleccion(madera);
        UnidadElemental piedra = new UnidadElementalPiedra();
        BotonDeSelector botonPiedra = crearBotonDeSeleccion(piedra);
        UnidadElemental metal = new UnidadElementalMetal();
        BotonDeSelector botonMetal = crearBotonDeSeleccion(metal);
        UnidadElemental diamante = new UnidadElementalDiamante();
        BotonDeSelector botonDiamante = crearBotonDeSeleccion(diamante);

        control.agregarBoton(botonMadera);
        control.agregarBoton(botonPiedra);
        control.agregarBoton(botonMetal);
        control.agregarBoton(botonDiamante);

        eventoSeleccion(botonMadera);
        eventoSeleccion(botonPiedra);
        eventoSeleccion(botonMetal);
        eventoSeleccion(botonDiamante);

        selector.getChildren().addAll(botonMadera,botonPiedra,botonMetal,botonDiamante);
        constructor.getChildren().add(selector);
    }

    private void eventoSeleccion(BotonDeSelector boton){
        boton.setOnMouseClicked(evento -> {
            control.deseleccionarTodo();
            boton.seleccionar();
        });
    }

    private BotonDeSelector crearBotonDeSeleccion(UnidadElemental unidadElemental){
        int cantidad = control.cantidad(unidadElemental);
        BotonDeSelector boton = new BotonDeSelector(unidadElemental,tamanioDeBotones,cantidad);
        boton.deseleccionar();
        //evento de boton
        return boton;
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        Stage miTablero = primaryStage;
        miTablero.setScene(escenaDeTablero);
        miTablero.setTitle("CONSTRUCTOR");
        miTablero.show();
    }

    public void iniciar(){
        try {
            start(ventana);
        }catch (Exception e){
            System.out.println("falle IVista");
            return;
        }
    }
}
