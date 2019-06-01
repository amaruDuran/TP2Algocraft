package Herramientas.TipoDeHerramienta.MaterialDeHerramientas;

public class MaterialDeHerramientaMetalPiedra implements MaterialDeHerramienta {
    private int durabilidad;
    private int fuerza;

    public MaterialDeHerramientaMetalPiedra(){
        this.durabilidad = 1000;
    }

    @Override
    public void setFuerzaDeHacha() {
        this.fuerza = 0;
    }

    @Override
    public void setFuerzaDePico() {
        this.fuerza = 0;
    }

    @Override
    public void setFuerzaDePicoFino() {
        this.fuerza = 20;
    }

    @Override
    public int fuerza(){
        return this.fuerza;
    }

    @Override
    public int durabilidad() {
        return durabilidad;
    }
}
