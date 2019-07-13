package Vista;

import Controlador.ControlDelTableroDeConstruccion;
import Modelo.Materiales.UnidadElemental.*;
import Vista.Botones.Boton;
import Vista.Botones.BotonDeSelector;
import Vista.Botones.BotonParaToolBar;
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

import java.util.List;

public class VistaTableroDeConstruccion extends Application {
    private UnidadElementalVacia unidadVaciaTablero = new UnidadElementalVacia();
    private ControlDelTableroDeConstruccion control;
    private UnidadElemental elementoConstructor = null;
    private BotonDeSelector botonActivo = null;
    Scene escenaDeTablero;
    private VBox constructor;
    private GridPane tableroContructorVista;
    private HBox selector;
    private HBox botonesDeConstruccion;
    private final int tamanioDelCuadro = 3;
    private final int separacionDeCuadros = 5;
    private final int tamanioDeBotones = 50;
    private Stage ventana = new Stage();
    private final String textoParaConstruir = "FABRICAR";
    private final String textoParaVaciarTablero = "VACIAR";

    public VistaTableroDeConstruccion(ControlDelTableroDeConstruccion controlTableroConstructor){
        control = controlTableroConstructor;
        constructor = new VBox();

        tableroContructorVista = new GridPane();
        //inicioDeTablero();

        selector = new HBox();
        //inicioDelSelector();

        botonesDeConstruccion = new HBox();
        //inicioDeBotoneraDeConstruccion();
        escenaDeTablero = new Scene(constructor);
    }

    private void inicioDeBotoneraDeConstruccion(){
        Boton construir = new BotonParaToolBar(textoParaConstruir);
        construir.addEventFilter(MouseEvent.MOUSE_PRESSED, event ->{
            control.construir();
            this.vaciarTablero();
        });

        Boton reinicioDeTablero = new BotonParaToolBar(textoParaVaciarTablero);
        reinicioDeTablero.addEventFilter(MouseEvent.MOUSE_PRESSED, event ->{
            this.vaciarTablero();
        });

        botonesDeConstruccion.getChildren().addAll(construir,reinicioDeTablero);
        constructor.getChildren().add(botonesDeConstruccion);
    }

    private void vaciarTablero() {
        setCasillasDelTableroVacias();
        control.vaciarTodo();
        control.actualizarCantidades();
    }

    private void inicioDeTablero(){
        tableroContructorVista.setHgap(separacionDeCuadros);
        tableroContructorVista.setVgap(separacionDeCuadros);
        tableroContructorVista.setPadding(new Insets(1,1,1,1));
        setCasillasDelTableroVacias();
        constructor.getChildren().add(tableroContructorVista);
    }

    private void setCasillasDelTableroVacias(){
        for(int fila = 1; fila < tamanioDelCuadro + 1; fila++){
            for(int columna = 1; columna < tamanioDelCuadro + 1; columna++){
                UnidadElemental unidadElemActual = unidadVaciaTablero;
                dibujarEnPosicion(unidadElemActual, fila, columna);
            }
        }
    }

    public void dibujarEnPosicion( UnidadElemental unidadElem, int fila, int columna){
        String nombreElementoDeTableroConstrucctor = unidadElem.nombreDeElemento();
        Image imagen = new Image("Vista/Imagenes/Inventario/"+nombreElementoDeTableroConstrucctor+".png");
        ImageView imagenUnidadElementalTableroConstructor = new ImageView(imagen);
        agregarEventoDeObtencionPosicionDeLaImagenEnTablero(imagenUnidadElementalTableroConstructor);

        imagenUnidadElementalTableroConstructor.setFitWidth(40);
        imagenUnidadElementalTableroConstructor.setFitHeight(40);
        tableroContructorVista.setConstraints(imagenUnidadElementalTableroConstructor, columna, fila);
        tableroContructorVista.getChildren().add(imagenUnidadElementalTableroConstructor);
    }


    private void agregarEventoDeObtencionPosicionDeLaImagenEnTablero(ImageView imagenTablero){
            imagenTablero.addEventFilter(MouseEvent.MOUSE_PRESSED, event ->{
                if (elementoConstructor == null){
                    return;
                }
                int fila = tableroContructorVista.getRowIndex( imagenTablero);
                int columna = tableroContructorVista.getColumnIndex( imagenTablero);
                if (control.estaEnLaPoscicion(elementoConstructor,fila,columna) || !botonActivo.tieneSuficientes()) {
                    return;
                }
                control.eventoAgregarElementoEnTablero(elementoConstructor, fila, columna);
                botonActivo.decrementarCantidad();
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

        selector.getChildren().addAll(botonMadera,botonPiedra,botonMetal,botonDiamante);
        constructor.getChildren().add(selector);
    }

    private void reinicioDeActividad(){
        elementoConstructor = null;
        botonActivo = null;
    }

    private void eventoSeleccion(BotonDeSelector boton){
        boton.setOnMouseClicked(evento -> {
            control.deseleccionarTodo();
            reinicioDeActividad();
            if (boton.tieneSuficientes()) {
                elementoConstructor = boton.seleccionar();
                botonActivo = boton;
            }
        });
    }

    private BotonDeSelector crearBotonDeSeleccion(UnidadElemental unidadElemental){
        int cantidad = control.cantidad();
        BotonDeSelector boton = new BotonDeSelector(unidadElemental, tamanioDeBotones, cantidad);
        boton.deseleccionar();
        //evento de boton
        control.agregarBoton(boton);
        eventoSeleccion(boton);
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

    public void iniciacion() {
        inicioDeTablero();
        inicioDelSelector();
        inicioDeBotoneraDeConstruccion();
    }
}
