package Herramientas.TipoDeHerramienta.MaterialDeHerramientas;

public class MaterialDeHerramientaMadera implements MaterialDeHerramienta {

    private int fuerza;
    private int durabilidad;

    public MaterialDeHerramientaMadera(){
        this.durabilidad = 100;
    }

    @Override
    public void setFuerzaDeHacha() {
        this.fuerza = 2;
    }

    @Override
    public void setFuerzaDePico() {
        this.fuerza = 2;
    }

    @Override
    public void setFuerzaDePicoFino() {
        this.fuerza = 0;
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
