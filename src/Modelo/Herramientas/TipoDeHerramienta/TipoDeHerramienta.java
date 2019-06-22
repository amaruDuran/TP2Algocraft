package Modelo.Herramientas.TipoDeHerramienta;

import Modelo.Jugador.ObjeosDelInventario;
import Modelo.Materiales.Material;

public interface TipoDeHerramienta extends ObjeosDelInventario {
    int durabilidad();
    int fuerza();
    boolean usarEn(Material material);
}
