package Controlador;

import Modelo.Herramientas.TipoDeHerramienta.TipoDeHerramienta;
import Modelo.Jugador.Jugador;
import Modelo.Jugador.ObjeosDelInventario;
import Vista.IVista;
import Vista.VistaHerramientaEnMano;

import java.util.HashMap;
import java.util.List;

public class ControladorDeHerramientasDelJugador {
    private Jugador jugador;
    private List<ObjeosDelInventario> inventario;
    private int proximaHerramientaEquipable = -1;
    private VistaHerramientaEnMano vistaHerramientaEnMano;
    private IVista vistaDeInventario;

    public ControladorDeHerramientasDelJugador(Jugador jugador){
        this.jugador = jugador;
        inventario = jugador.listadoDeInventario();
    }

    public void cargarActualizacionDeVista(VistaHerramientaEnMano vista){
        vistaHerramientaEnMano = vista;
    }

    public void actualizacionPorDesgaste(){
        if (jugador.obtenerHerramientaEnMano() == null){
            return;
        }
        //colocar algo por si se desgasto
        vistaHerramientaEnMano.actualizarCajaDeInformacion();
    }

    public void cargarVistaDeInventario(IVista iVista){
        vistaDeInventario = iVista;
    }

    private void actualizarProximaEquipable(){
        for (int i = 0; i < inventario.size(); i++){
            ObjeosDelInventario objeto = inventario.get(i);
            if (!objeto.equipable()){
                continue;
            }
            proximaHerramientaEquipable = i;
            return;
        }
        proximaHerramientaEquipable = -1;
    }

    public boolean existeOtraHerramientaAEquipar(){
        this.actualizarProximaEquipable();
        return (proximaHerramientaEquipable >= 0);
    }

    public TipoDeHerramienta herramientaEnMano(){
        return jugador.obtenerHerramientaEnMano();
    }

    public void equiparSiguiente(){
        this.desequipar();
        TipoDeHerramienta herramientaSiguiente = (TipoDeHerramienta)jugador.quitarObjetoDelInventario(proximaHerramientaEquipable);
        vistaDeInventario.actualizarCasilleros(proximaHerramientaEquipable);
        jugador.equipar(herramientaSiguiente);
        vistaHerramientaEnMano.actualizarVista();
    }

    public void desequipar(){
        jugador.desequipar();
        vistaDeInventario.actualizarCasillero();
        vistaHerramientaEnMano.actualizarVista();
    }
}
