package Modelo.Jugador;

public class ObjetoDelInventarioVacio implements ObjeosDelInventario {
    public String nombreDeElemento(){
        return "VACIO";
    }

    @Override
    public Boolean equipable() {
        return false;
    }
}
