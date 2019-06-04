package Herramientas.TipoDeHerramienta;

import Herramientas.TipoDeHerramienta.MaterialDeHerramientas.MaterialDeHerramienta;
import Materiales.Material;

public interface Herramienta {
    int durabilidad();
    int fuerza();
    boolean usarEn(Material material);
}
