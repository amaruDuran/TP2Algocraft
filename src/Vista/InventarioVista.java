package Vista;

import Modelo.Herramientas.TipoDeHerramienta.TipoDeHerramienta;
import Modelo.Jugador.Jugador;
import Modelo.Jugador.ObjeosDelInventario;
import Modelo.Jugador.ObjetoDelInventarioVacio;
import Vista.Botones.Boton;
import Vista.Botones.BotonDeInventario;
import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;

import java.util.ArrayList;
import java.util.List;

public class InventarioVista implements Dibujable {
    private List<ObjeosDelInventario> elementosDelInventario;
    private List<ObjeosDelInventario> inventarioDelJugador;
    private final ObjeosDelInventario casilleroVacio = new ObjetoDelInventarioVacio();
    private final int tamanioHorizontalDelInventario = 5;
    private final int tamanioVerticalDelInventario = 6;
    //private final int tamanioDelInventario = (tamanioHorizontalDelInventario * tamanioVerticalDelInventario);
    private GridPane inventario;
    private VBox caja;
    private final int tamanioDeBotonesDelInventario = 20;
    private VBox cajaHerramienta;
    private HerramientaEnMano herramientaEnManoVista;
    private TipoDeHerramienta herramienta;
    private Jugador jugador;

    public InventarioVista(Jugador jugadorModelo){
        jugador = jugadorModelo;
        List inventarioDeJugador = jugadorModelo.listadoDeInventario();
        herramienta = jugadorModelo.obtenerHerramientaEnMano();
        //inventario de objetos
        inventario = new GridPane();
        inventario.setPadding(new Insets(1,1,1,1));
        inventario.setHgap(tamanioHorizontalDelInventario);
        inventario.setVgap(tamanioVerticalDelInventario);
        caja = new VBox();//en la caja se pueden agregar mas cosas al inventario
        this.herramientaEnManoVista = new HerramientaEnMano(herramienta, tamanioHorizontalDelInventario * tamanioDeBotonesDelInventario, casilleroVacio.nombreDeElemento());
        this.cajaHerramienta = herramientaEnManoVista.darCaja();
        this.actualizarInventario(inventarioDeJugador, herramienta);
    }

    private void completar(){
        int tamanioDelInventario = (tamanioHorizontalDelInventario * tamanioVerticalDelInventario);
        int cantidadDeElementosFaltantes = tamanioDelInventario - elementosDelInventario.size();
        for (int i = 0; i < cantidadDeElementosFaltantes; i++){
            elementosDelInventario.add(casilleroVacio);
        }
    }

    private Boton convertirEnBotones(ObjeosDelInventario objeto){
        Boton boton = new BotonDeInventario(objeto,tamanioDeBotonesDelInventario);
        return boton;
    }

    private int posicionDelObjetoEnInventario(int fila, int columna){
        int posicionDelObjetoEnInventario = (fila * tamanioHorizontalDelInventario) + columna;
        return posicionDelObjetoEnInventario;
    }

    @Override
    public void dibujar() {
        herramienta = jugador.obtenerHerramientaEnMano();
        inventarioDelJugador = jugador.listadoDeInventario();
        this.actualizarInventario(inventarioDelJugador,this.herramienta);
    }

    private void dibujarGrilla() {
        for (int fila = 0; fila < tamanioVerticalDelInventario; fila++){
            for (int columna = 0; columna < tamanioHorizontalDelInventario; columna++){
                int posicionDelObjetoEnInventario = this.posicionDelObjetoEnInventario(fila,columna);
                ObjeosDelInventario objeto = elementosDelInventario.get(posicionDelObjetoEnInventario);
                Boton botonDelObjeto = this.convertirEnBotones(objeto);
                inventario.add(botonDelObjeto,columna,fila,1,1);
            }
        }
    }
    public void actualizarInventario(List<ObjeosDelInventario> inventarioDeJugador, TipoDeHerramienta herramienta){
        caja.getChildren().remove(inventario);
        caja.getChildren().remove(this.cajaHerramienta);
        inventarioDelJugador = inventarioDeJugador;
        elementosDelInventario = new ArrayList<ObjeosDelInventario>();
        elementosDelInventario.addAll(inventarioDelJugador);
        this.completar();
        this.dibujarGrilla();
        herramientaEnManoVista.actualizar(herramienta);
        this.cajaHerramienta = herramientaEnManoVista.darCaja();
        caja.getChildren().add(inventario);
        caja.getChildren().add(this.cajaHerramienta);
    }

    @Override
    public Node getVista() {
        return caja;
    }
}
