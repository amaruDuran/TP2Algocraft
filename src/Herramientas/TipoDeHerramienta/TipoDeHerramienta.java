package Herramientas.TipoDeHerramienta;

import Herramientas.TipoDeHerramienta.MaterialDeHerramientas.MaterialDeHerramienta;
import Materiales.Material;

public interface TipoDeHerramienta {
    int durabilidad();
    int fuerza();
    boolean usarLaHerramientaEn(Material material);
}
