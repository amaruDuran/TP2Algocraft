package Vista;

import Controlador.ControlDelTableroDeConstruccion;
import Modelo.Materiales.UnidadElemental.*;
import Vista.Botones.BotonDeSelector;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class VistaTableroDeConstruccion extends Application {
    private UnidadElementalVacia unidadVaciaTablero = new UnidadElementalVacia();
    private ControlDelTableroDeConstruccion control;
    private UnidadElemental elementoConstructor = null;
    Scene escenaDeTablero;
    private VBox constructor;
    private GridPane tableroContructorVista;
    private HBox selector;
    private final int tamanioDelCuadro = 3;
    private final int separacionDeCuadros = 5;
    private final int tamanioDeBotones = 50;
    private Stage ventana = new Stage();

    public VistaTableroDeConstruccion(ControlDelTableroDeConstruccion controlTableroConstructor){
        control = controlTableroConstructor;
        constructor = new VBox();

        tableroContructorVista = new GridPane();
        inicioDeTablero();

        selector = new HBox();
        inicioDelSelector();
        escenaDeTablero = new Scene(constructor);
    }

    private void inicioDeTablero(){
        tableroContructorVista.setHgap(separacionDeCuadros);
        tableroContructorVista.setVgap(separacionDeCuadros);
        tableroContructorVista.setPadding(new Insets(1,1,1,1));

        for(int fila = 1; fila < tamanioDelCuadro + 1; fila++){
            for(int columna = 1; columna < tamanioDelCuadro + 1; columna++){
                UnidadElemental unidadElemActual = unidadVaciaTablero;
                dibujarEnPosicion(unidadElemActual, fila, columna);
            }
        }

        constructor.getChildren().add(tableroContructorVista);
    }

    public void dibujarEnPosicion( UnidadElemental unidadElem, int fila, int columna){
        String nombreElementoDeTableroConstrucctor = unidadElem.nombreDeElemento();
        Image imagen = new Image("Vista/Imagenes/"+nombreElementoDeTableroConstrucctor+".png");
        ImageView imagenUnidadElementalTableroConstructor = new ImageView(imagen);
        agregarEventoDeObtencionPosicionDeLaImagenEnTablero(imagenUnidadElementalTableroConstructor);

        imagenUnidadElementalTableroConstructor.setFitWidth(40);
        imagenUnidadElementalTableroConstructor.setFitHeight(40);
        tableroContructorVista.setConstraints(imagenUnidadElementalTableroConstructor, columna, fila);
        tableroContructorVista.getChildren().add(imagenUnidadElementalTableroConstructor);
    }


    private void agregarEventoDeObtencionPosicionDeLaImagenEnTablero(ImageView imagenTablero){
            imagenTablero.addEventFilter(MouseEvent.MOUSE_PRESSED, event ->{
                    System.out.println( "Imagen Clickeada: " + imagenTablero + "en fila/columna : " +
                            tableroContructorVista.getRowIndex( imagenTablero) + "/" +
                            tableroContructorVista.getColumnIndex( imagenTablero));
                if (elementoConstructor != null)
                    control.eventoAgregarElementoEnTablero(elementoConstructor, tableroContructorVista.getRowIndex( imagenTablero), tableroContructorVista.getColumnIndex( imagenTablero) );
            });
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
            elementoConstructor = boton.seleccionar();
        });
    }

    private BotonDeSelector crearBotonDeSeleccion(UnidadElemental unidadElemental){
        int cantidad = control.cantidad(unidadElemental);
        BotonDeSelector boton = new BotonDeSelector(unidadElemental, tamanioDeBotones, cantidad);
        boton.deseleccionar();
        //evento de boton
        return boton;
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        Stage miTablero = primaryStage;
        miTablero.setScene(escenaDeTablero);
        miTablero.setTitle("Constructor de Herramientas");
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
