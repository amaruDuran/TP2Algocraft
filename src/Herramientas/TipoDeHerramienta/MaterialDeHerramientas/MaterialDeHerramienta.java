package Herramientas.TipoDeHerramienta.MaterialDeHerramientas;

public interface MaterialDeHerramienta {
    public void setAtributosDeHacha();
    public void setAtributosDePico();
    public void setAtributosDePicoFino();
    public int fuerza();
    public int durabilidad();
    public boolean usarLaHerramientaEn(/* aca iria la clase mineral que es la que esta en el mapa */);
}
