package Modelo.Jugador;

import Modelo.Herramientas.TipoDeHerramienta.Hacha;
import Modelo.Herramientas.TipoDeHerramienta.TipoDeHerramienta;
import Modelo.Materiales.UnidadElemental.UnidadElemental;

import java.util.ArrayList;
import java.util.List;

public class Inventario {
    private List<ObjeosDelInventario> objetosEnElInventario;
    private int totalActualDeElementos;
    private final int limiteDeElementos = 30;

    public Inventario(){
        this.objetosEnElInventario = new ArrayList();
        this.totalActualDeElementos = 0;
    }

    public int cantidadDeElementos() {
        return totalActualDeElementos;
    }

    public boolean agregarObjetosAlInventario(ObjeosDelInventario objetoDelInventario){
        if (totalActualDeElementos >= limiteDeElementos || objetosEnElInventario.contains(objetoDelInventario)){
            return false;
        }
        totalActualDeElementos = totalActualDeElementos + 1;
        objetosEnElInventario.add(objetoDelInventario);
        return true;
    }

    public ObjeosDelInventario quitarObjetoDelInventario(int posicion){
        ObjeosDelInventario elementoADevolver = objetosEnElInventario.remove(posicion);
        totalActualDeElementos = totalActualDeElementos - 1;
        return elementoADevolver;
    }

    public List<ObjeosDelInventario> listadoDeInventario(){
        return objetosEnElInventario;
    }

    private boolean esUnaHerramienta(ObjeosDelInventario objeto){
        return (objeto.equipable(objeto));
    }

    public List<TipoDeHerramienta> listadoDeHerramientasDelInventario(){
        List<TipoDeHerramienta> herramientas = new ArrayList<>();
        for (int i = 0; i < totalActualDeElementos; i++){
            ObjeosDelInventario objeto = objetosEnElInventario.get(i);
            if (!this.esUnaHerramienta(objeto)){
                continue;
            }
            herramientas.add((TipoDeHerramienta) objeto);
        }
        return herramientas;
    }
    public List<UnidadElemental> listadoDeUnidadesElementalesDelInventario(){
        List<UnidadElemental> unidades = new ArrayList<>();
        for (int i = 0; i < totalActualDeElementos; i++){
            ObjeosDelInventario objeto = objetosEnElInventario.get(i);
            if (this.esUnaHerramienta(objeto)){
                continue;
            }
            unidades.add((UnidadElemental) objeto);
        }
        return unidades;
    }
}
