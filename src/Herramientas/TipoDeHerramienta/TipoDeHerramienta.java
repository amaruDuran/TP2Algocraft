package Herramientas.TipoDeHerramienta;

import Jugador.ObjeosDelInventario;
import Materiales.Material;

public interface TipoDeHerramienta extends ObjeosDelInventario {
    int durabilidad();
    int fuerza();
    boolean usarEn(Material material);
}
