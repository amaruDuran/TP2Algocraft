package Controlador;

import Modelo.Herramientas.TipoDeHerramienta.TipoDeHerramienta;
import Modelo.Jugador.Inventario;
import Modelo.Jugador.ObjeosDelInventario;
import Modelo.Jugador.ObjetoDelInventarioVacio;
import Modelo.Materiales.UnidadElemental.UnidadElemental;
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

    public Integer cantidadesDeLaUnidad(UnidadElemental unidad){
        Integer cantidad = 0;
        //ObjeosDelInventario vacio = new ObjetoDelInventarioVacio();
        for (int i = 0; i < inventarioModelo.size(); i++){
            if (inventarioModelo.get(i).equipable()){
                continue;
            }
            //se supone que no hay objetos vacios
            //if (inventarioModelo.get(i).nombreDeElemento() == vacio.nombreDeElemento()){
            //    continue;
            //}
            if (!unidad.equivalenteA((UnidadElemental) inventarioModelo.get(i))){
                continue;
            }
            cantidad++;
        }
        return cantidad;
    }

    public void agregar(ObjeosDelInventario objeto) {
        inventarioModelo.add(objeto);
        inventarioVista.actualizarCasillero();
    }

    public void quitarUnidadesDelInventario(List<UnidadElemental> objetosAQuitar){
        int cantidadARemover = objetosAQuitar.size();
        for (int i = 0; i < cantidadARemover; i++){
            removerObjetoDelInventario(objetosAQuitar.get(i));
        }
        inventarioVista.actualizarCasilleros(0,inventarioVista.tamanioDeInventario());
    }

    private void removerObjetoDelInventario(UnidadElemental objetoARemover){
        for (int i = 0;i < inventarioModelo.size(); i++){
            ObjeosDelInventario objeto = inventarioModelo.get(i);
            if (objeto.equipable()){
                continue;
            }
            UnidadElemental unidadElemental = (UnidadElemental)objeto;
            if (!unidadElemental.equivalenteA(objetoARemover)){
                continue;
            }
            inventarioModelo.remove(i);
            break;
        }
    }
}
