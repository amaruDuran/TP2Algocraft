package HerramientaTest.MaterialDeHerramientaTest;

import Herramientas.TipoDeHerramienta.MaterialDeHerramientas.MaterialDeHerramienta;
import Herramientas.TipoDeHerramienta.MaterialDeHerramientas.MaterialDeHerramientaPiedra;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class MaterialDeHerramientaPiedraTest {
    @Test
    public void materialDeHerramientaPiedraDaUnaFuerzaDe5ParaHachas(){
        MaterialDeHerramienta materialDeHerramientaPiedra = new MaterialDeHerramientaPiedra();
        materialDeHerramientaPiedra.setFuerzaDeHacha();
        assertEquals(5, materialDeHerramientaPiedra.fuerza());
    }
    @Test
    public void materialDeHerramientaPiedraDaUnaFuerzaDe4ParaPicos(){
        MaterialDeHerramienta materialDeHerramientaPiedra = new MaterialDeHerramientaPiedra();
        materialDeHerramientaPiedra.setFuerzaDePico();
        assertEquals(4, materialDeHerramientaPiedra.fuerza());
    }
    @Test
    public void materialDeHerramientaPiedraDaUnaFuerzaDe0ParaPicosFinos(){
        MaterialDeHerramienta materialDeHerramientaPiedra = new MaterialDeHerramientaPiedra();
        materialDeHerramientaPiedra.setFuerzaDePicoFino();
        assertEquals(0, materialDeHerramientaPiedra.fuerza());
    }
    @Test
    public void materialDeHerramientaPiedraTieneUnaDurabilidadDe200(){
        MaterialDeHerramienta materialDeHerramientaPiedra = new MaterialDeHerramientaPiedra();
        materialDeHerramientaPiedra.setFuerzaDePicoFino();
        assertEquals(200, materialDeHerramientaPiedra.durabilidad());
    }
}
