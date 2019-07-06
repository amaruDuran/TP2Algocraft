package Controlador;

import Modelo.Jugador.Inventario;
import Modelo.Jugador.ObjeosDelInventario;
import Modelo.Jugador.ObjetoDelInventarioVacio;
import Vista.IVista;

import java.util.List;

public class ControladorInventario {
    private IVista inventarioVista;
    private List<ObjeosDelInventario> inventarioModelo;
    private List<ObjeosDelInventario> inventarioCompletado;
    private final ObjeosDelInventario casilleroVacio = new ObjetoDelInventarioVacio();
    private final int tamanioTotal;

    public ControladorInventario(List<ObjeosDelInventario> inventario , IVista vistaDelInventario){
        inventarioVista = vistaDelInventario;
        tamanioTotal = inventarioVista.tamanioDeInventario();
        inventarioModelo = inventario;
    }

    private void completarElInventario(){
        this.inventarioCompletado.clear();
        this.inventarioCompletado.addAll(inventarioModelo);
        int cantidadDeElementosFaltantes = tamanioTotal - inventarioCompletado.size();
        for (int i = 0; i < cantidadDeElementosFaltantes; i++){
            inventarioCompletado.add(casilleroVacio);
        }
    }

    public List<ObjeosDelInventario> obtenerInventarioCompletado(List<ObjeosDelInventario> inventario){
        inventarioCompletado = inventario;
        completarElInventario();
        return inventarioCompletado;
    }

    public List<ObjeosDelInventario> getInventarioModelo() {
        return inventarioModelo;
    }
}
