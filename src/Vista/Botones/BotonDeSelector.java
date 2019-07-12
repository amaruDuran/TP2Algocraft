package Vista.Botones;

import Modelo.Materiales.UnidadElemental.UnidadElemental;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.Text;

public class BotonDeSelector extends Boton {
    private UnidadElemental objeto;
    private final int margen = 3;
    private final int disminucionDeTexto = 6;
    private boolean seleccionado;
    private int cantidadDeElementosDisponibles;
    private int tamanioDeTexto;
    private Color colorDeTexto;

    public BotonDeSelector(UnidadElemental unidadElemental, int tamanio, int cantidad) {
        this.objeto = unidadElemental;
        this.seleccionado = false;
        cantidadDeElementosDisponibles = cantidad;
        colorSecundarioDelBoton = Color.LIGHTBLUE;//cuando esta seleccionado cambia a este
        colorActualDelBoton = Color.DARKBLUE;
        colorDeTexto = Color.LIGHTYELLOW;
        int anchoDelBoton = tamanio;
        int largoDelBoton = tamanio;
        this.fondo = new Rectangle(anchoDelBoton, largoDelBoton);
        tamanioDeTexto = tamanio - disminucionDeTexto;
        String nombre = objeto.nombreDeElemento();
        int anchoDeLaImagen = tamanio - margen;
        int largoDeLaImagen = tamanio - margen;
        this.agregarImagen(nombre,anchoDeLaImagen,largoDeLaImagen);
        this.agregarTextoCantidad();

    }

    private void agregarImagen(String nombre, int ancho, int largo){
        String urlDelIcono = "Vista/Imagenes/Inventario/" + nombre + ".png";
        ImageView icono;
        icono = new ImageView(urlDelIcono);
        icono.setFitHeight(ancho);
        icono.setFitWidth(largo);
        this.getChildren().addAll(icono);
    }

    private void agregarTextoCantidad(){
        String cantidad = new Integer(cantidadDeElementosDisponibles).toString();
        texto = new Text(cantidad);
        texto.setFont(Font.font(tamanioDeTexto));
        if (cantidadDeElementosDisponibles > 0){
            texto.setFill(colorDeTexto);
        }else{
            texto.setFill(Color.RED);
        }
        this.getChildren().add(texto);
    }

    public UnidadElemental seleccionar(){
        seleccionado = true;
        cambioDeColorASeleccionado();
        return objeto;
    }

    public void deseleccionar(){
        seleccionado = false;
        cambioDeColorANoSeleccionado();
    }

    public void incrementarCantidad(){
        cantidadDeElementosDisponibles++;
        actualizarTextoCantidad();
    }

    public void decrementarCantidad(){
        cantidadDeElementosDisponibles--;
        actualizarTextoCantidad();
    }

    public void setCantidadDeElementosDisponibles(int catidad){
        cantidadDeElementosDisponibles = catidad;
        actualizarTextoCantidad();
    }

    private void actualizarTextoCantidad(){
        this.getChildren().remove(texto);
        agregarTextoCantidad();
    }

    /*private void swapColores(){
        Color aux = colorSecundarioDelBoton;
        colorSecundarioDelBoton = colorActualDelBoton;
        colorActualDelBoton = aux;
    }*/

    private void cambioDeColorASeleccionado(){
        //swapColores();
        Color colorSeleccionado = this.colorSecundarioDelBoton;
        //Color colorSeleccionado = this.colorActualDelBoton;
        fondo.setFill(colorSeleccionado);
        colorDeTexto = Color.YELLOW;
        actualizarTextoCantidad();
    }
    private void cambioDeColorANoSeleccionado(){
        //swapColores();
        Color colorNoSeleccionado = this.colorActualDelBoton;
        fondo.setFill(colorNoSeleccionado);
        colorDeTexto = Color.DARKBLUE;
        actualizarTextoCantidad();
    }

    public boolean contieneAUnidad(UnidadElemental unidadElemental){
        return objeto.equivalenteA(unidadElemental);
    }

    public boolean tieneSuficientes(){
        return (cantidadDeElementosDisponibles > 0);
    }
}
