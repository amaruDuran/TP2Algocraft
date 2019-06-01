package Herramientas.TipoDeHerramienta.MaterialDeHerramientas;

public class MaterialDeHerramientaMetal implements MaterialDeHerramienta {
    private int durabilidad;
    private int fuerza;

    public MaterialDeHerramientaMetal(){
        this.durabilidad = 400;
    }

    @Override
    public void setFuerzaDeHacha() {
        this.fuerza = 10;
    }

    @Override
    public void setFuerzaDePico() {
        this.fuerza = 12;
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
