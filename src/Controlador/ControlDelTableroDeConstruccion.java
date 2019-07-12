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

    public ControlDelTableroDeConstruccion(){
        this.tableroConstructorModelo = new TableroDeConstruccion();
        cantidades = new ArrayList<Integer>();
        elementos = new ArrayList<UnidadElemental>();
        botones = new ArrayList<BotonDeSelector>();
    }

    public void cargarControladorDelInventario(ControladorInventario controladorInventario){
        inventario = controladorInventario;
        completarCantidades();
        //iniciarBotonesVacios();
    }

    public void eventoAgregarElementoEnTablero(UnidadElemental unidadElemental, int fila, int columna){
        tableroDeConstruccionVista.dibujarEnPosicion(unidadElementalVacia, fila, columna);
        tableroDeConstruccionVista.dibujarEnPosicion(unidadElemental, fila, columna);
        tableroConstructorModelo.agregarElementoEnCelda(fila,columna,unidadElemental);
    }

    public void vaciarTodo(){
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
/*
    private void iniciarBotonesVacios(){
        for (int i = 0; i < elementos.size(); i++){
            botones.add(null);
        }
    }*/

    public void cargarVista(VistaTableroDeConstruccion vista){
        tableroDeConstruccionVista = vista;
    }

    public int cantidad() {
        int cantidad = 0;
        /*for (int i = 0; i < elementos.size(); i++){
            UnidadElemental posible = elementos.get(i);
            if (unidadElemental.equivalenteA(posible)){
                cantidad = cantidades.get(i);
                break;
            }
        }*///absurdo ya que se lo pide antes de obtener el inventario
        return cantidad;
    }/*
    public int cantidad(UnidadElemental unidadElemental) {
        int cantidad = -1;
        for (int i = 0; i < elementos.size(); i++){
            UnidadElemental posible = elementos.get(i);
            if (unidadElemental.equivalenteA(posible)){
                cantidad = cantidades.get(i);
                break;
            }
        }
        return cantidad;
    }*/

    public void iniciacion(){
        tableroDeConstruccionVista.iniciacion();
    }

    public void actualizarCantidades(){
        for (int i = 0; i < elementos.size(); i++){
            UnidadElemental elemento = elementos.get(i);
            BotonDeSelector boton = botones.get(i);
            int cantidad = inventario.cantidadesDeLaUnidad(elemento);
            boton.setCantidadDeElementosDisponibles(cantidad);
        }
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
        inventario.quitarUnidadesDelInventario(listadoDeUnidadesConsumidas());
        vaciarTodo();
        actualizarCantidades();
    }

    private List<UnidadElemental> listadoDeUnidadesConsumidas() {
        return tableroConstructorModelo.obtenerTodosLosElementos();
    }

    public boolean estaEnLaPoscicion(UnidadElemental unidadElemental ,int fila, int columna){
        UnidadElemental unidadEnPos = tableroConstructorModelo.obtenerElementoDe(fila,columna);
        if (unidadEnPos == null){
            return false;
        }
        return unidadEnPos.equivalenteA(unidadElemental);
    }
}
