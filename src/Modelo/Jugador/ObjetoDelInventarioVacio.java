package Modelo.Jugador;

public class ObjetoDelInventarioVacio implements ObjeosDelInventario {
    public String nombreDeElemento(){
        return "VACIO";
    }

    @Override
    public boolean equipable(ObjeosDelInventario objeto) {
        return true;
    }

}
