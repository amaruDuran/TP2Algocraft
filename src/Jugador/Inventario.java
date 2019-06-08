package Jugador;

import java.util.ArrayList;
import java.util.List;

public class Inventario {
    private List<ObjeosDelInventario> objetosEnElInventario;
    private int totalActualDeElementos;
    private int limiteDeElementos;

    public Inventario(){
        this.objetosEnElInventario = new ArrayList();
        this.totalActualDeElementos = 0;
        this.limiteDeElementos = 30;//elegir el max
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
}
