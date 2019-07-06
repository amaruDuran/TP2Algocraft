package Controlador;

import Modelo.Herramientas.TipoDeHerramienta.TipoDeHerramienta;
import Modelo.Jugador.Jugador;
import Modelo.Jugador.ObjeosDelInventario;
import Vista.VistaHerramientaEnMano;

import java.util.HashMap;
import java.util.List;

public class ControladorDeHerramientasDelJugador {
    private Jugador jugador;
    private List<ObjeosDelInventario> inventario;
    private int proximaHerramientaEquipable = -1;
    private VistaHerramientaEnMano vistaHerramientaEnMano;

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
        jugador.equipar(herramientaSiguiente);
        vistaHerramientaEnMano.actualizarVista();
    }

    public void desequipar(){
        jugador.desequipar();
        vistaHerramientaEnMano.actualizarVista();
    }
}
