package Controlador;

import Modelo.Jugador.Inventario;
import Modelo.Jugador.ObjeosDelInventario;
import Vista.IVista;

import java.util.List;

public class ControladorInventario {
    private IVista inventarioVista;
    private Inventario inventarioModelo;

    public ControladorInventario(List<ObjeosDelInventario> inventario , IVista inventarioVista){
        this.inventarioVista = inventarioVista;

    }
}
