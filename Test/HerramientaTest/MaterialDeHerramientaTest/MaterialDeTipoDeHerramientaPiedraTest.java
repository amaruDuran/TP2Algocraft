package HerramientaTest.MaterialDeHerramientaTest;

import Herramientas.TipoDeHerramienta.MaterialDeHerramientas.MaterialDeHerramienta;
import Herramientas.TipoDeHerramienta.MaterialDeHerramientas.MaterialDeHerramientaPiedra;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class MaterialDeTipoDeHerramientaPiedraTest {
    @Test
    public void materialDeHerramientaPiedraDaUnaFuerzaDe5ParaHachas(){
        MaterialDeHerramienta materialDeHerramientaPiedra = new MaterialDeHerramientaPiedra();
        materialDeHerramientaPiedra.setAtributosDeHacha();
        assertEquals(5, materialDeHerramientaPiedra.fuerza());
    }
    @Test
    public void materialDeHerramientaPiedraDaUnaFuerzaDe4ParaPicos(){
        MaterialDeHerramienta materialDeHerramientaPiedra = new MaterialDeHerramientaPiedra();
        materialDeHerramientaPiedra.setAtributosDePico();
        assertEquals(4, materialDeHerramientaPiedra.fuerza());
    }
    @Test
    public void materialDeHerramientaPiedraDaUnaFuerzaDe0ParaPicosFinos(){
        MaterialDeHerramienta materialDeHerramientaPiedra = new MaterialDeHerramientaPiedra();
        materialDeHerramientaPiedra.setAtributosDePicoFino();
        assertEquals(0, materialDeHerramientaPiedra.fuerza());
    }
    @Test
    public void materialDeHerramientaPiedraTieneUnaDurabilidadDe200(){
        MaterialDeHerramienta materialDeHerramientaPiedra = new MaterialDeHerramientaPiedra();
        materialDeHerramientaPiedra.setAtributosDePicoFino();
        assertEquals(200, materialDeHerramientaPiedra.durabilidad());
    }
}
