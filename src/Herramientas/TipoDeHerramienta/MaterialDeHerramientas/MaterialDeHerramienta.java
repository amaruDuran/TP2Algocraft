package Herramientas.TipoDeHerramienta.MaterialDeHerramientas;

import Materiales.Material;

public interface MaterialDeHerramienta {
    public void setAtributosDeHacha();
    public void setAtributosDePico();
    public void setAtributosDePicoFino();
    public int fuerza();
    public int durabilidad();
    public boolean usarLaHerramientaEn(Material material);
}
