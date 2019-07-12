package Controlador;

import Modelo.Herramientas.Constructor.TableroDeConstruccion;
import Modelo.Herramientas.TipoDeHerramienta.TipoDeHerramienta;
import Modelo.Materiales.UnidadElemental.*;
import Vista.Botones.BotonDeSelector;
import Vista.VistaTableroDeConstruccion;

import java.util.ArrayList;
import java.util.List;

public class ControlDelTableroDeConstruccion {
    private VistaTableroDeConstruccion tableroDeConstruccionVista;
    private TableroDeConstruccion tableroConstructorModelo;
    private final UnidadElemental unidadElementalVacia = new UnidadElementalVacia();
    private List<Integer> cantidades;
    private List<UnidadElemental> elementos;
    private List<BotonDeSelector> botones;
    private ControladorInventario inventario;
    private int numeroDeFilas;
    private int numeroDeColumnas;

    public ControlDelTableroDeConstruccion(){
        this.tableroConstructorModelo = new TableroDeConstruccion();
        numeroDeFilas = tableroConstructorModelo.cantidadFilas();
        numeroDeColumnas = tableroConstructorModelo.cantidadDeColumnas();
        cantidades = new ArrayList<Integer>();
        elementos = new ArrayList<UnidadElemental>();
        botones = new ArrayList<BotonDeSelector>();
    }

    public void cargarControladorDelInventario(ControladorInventario controladorInventario){
        inventario = controladorInventario;
        completarCantidades();
    }

    public void eventoAgregarElementoEnTablero(UnidadElemental unidadElemental, int fila, int columna){
        /*UnidadElemental unidadElementalEnLaPosAnterior = tableroConstructorModelo.obtenerElementoDe(fila,columna);//esto falla por algun motivo
        if (unidadElementalEnLaPosAnterior != null){
            if (unidadElemental.equivalenteA(unidadElementalEnLaPosAnterior)){
                return;
            }
        }*/
        tableroDeConstruccionVista.dibujarEnPosicion(unidadElementalVacia, fila, columna);
        tableroDeConstruccionVista.dibujarEnPosicion(unidadElemental, fila, columna);
        tableroConstructorModelo.agregarElementoEnCelda(fila,columna,unidadElemental);
    }

    public void vaciarTodo(){
        /*for (int fila = 1 ; fila <= numeroDeFilas; fila++){
            for (int columna = 1; columna <= numeroDeColumnas; columna++){
                tableroConstructorModelo.quitarElementoEnCelda(fila,columna);
            }
        }*/
        tableroConstructorModelo.vaciarTodo();
    }

    private void completarCantidades(){
        UnidadElemental madera = new UnidadElementalMadera();
        elementos.add(madera);
        cantidades.add(inventario.cantidadesDeLaUnidad(madera));

        UnidadElemental piedra = new UnidadElementalPiedra();
        elementos.add(piedra);
        cantidades.add(inventario.cantidadesDeLaUnidad(piedra));

        UnidadElemental metal = new UnidadElementalMetal();
        elementos.add(metal);
        cantidades.add(inventario.cantidadesDeLaUnidad(metal));

        UnidadElemental diamante = new UnidadElementalDiamante();
        elementos.add(diamante);
        cantidades.add(inventario.cantidadesDeLaUnidad(diamante));
    }

    public void cargarVista(VistaTableroDeConstruccion vista){
        tableroDeConstruccionVista = vista;
    }

    public int cantidad(UnidadElemental unidadElemental) {
        int cantidad = 1;
        /*for (int i = 0; i < elementos.size(); i++){
            UnidadElemental posible = elementos.get(i);
            if (unidadElemental.equivalenteA(posible)){
                cantidad = cantidades.get(i);
                break;
            }
        }*///absurdo ya que se lo pide antes de obtener el inventario
        return cantidad;
    }

    public void deseleccionarTodo() {
        for (int i = 0; i < botones.size(); i++){
            BotonDeSelector boton = botones.get(i);
            boton.deseleccionar();
        }
    }

    public void agregarBoton(BotonDeSelector boton) {
        for (int i = 0; i < elementos.size(); i++){
            if (!boton.contieneAUnidad(elementos.get(i))){
                continue;
            }
            botones.add(i, boton);
            break;
        }
    }

    public void construir() {
        TipoDeHerramienta herramienta = tableroConstructorModelo.construir();
        if (herramienta == null){
            return;
        }
        inventario.agregar(herramienta);
        vaciarTodo();
    }
}
