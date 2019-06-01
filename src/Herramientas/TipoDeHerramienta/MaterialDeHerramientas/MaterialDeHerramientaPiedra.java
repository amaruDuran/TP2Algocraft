package Herramientas.TipoDeHerramienta.MaterialDeHerramientas;

public class MaterialDeHerramientaPiedra implements MaterialDeHerramienta {
    private int durabilidad;
    private int fuerza;

    public MaterialDeHerramientaPiedra(){
        this.durabilidad = 200;
    }

    @Override
    public void setFuerzaDeHacha(){
        this.fuerza = 5;
    }

    @Override
    public void setFuerzaDePico(){
        this.fuerza = 4;
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
