package HerramientaTest.MaterialDeHerramientaTest;

import Herramientas.TipoDeHerramienta.MaterialDeHerramientas.MaterialDeHerramienta;
import Herramientas.TipoDeHerramienta.MaterialDeHerramientas.MaterialDeHerramientaMetalPiedra;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class MaterialDeTipoDeHerramientaMetalPiedraTest {
    @Test
    public void materialDeHerramientaMetalPiedraDaUnaFuerzaDe0ParaHachas(){
        MaterialDeHerramienta materialDeHerramientaMetalPiedra = new MaterialDeHerramientaMetalPiedra();
        materialDeHerramientaMetalPiedra.setAtributosDeHacha();
        assertEquals(0, materialDeHerramientaMetalPiedra.fuerza());
    }
    @Test
    public void materialDeHerramientaMetalPiedraDaUnaFuerzaDe0ParaPicos(){
        MaterialDeHerramienta materialDeHerramientaMetalPiedra = new MaterialDeHerramientaMetalPiedra();
        materialDeHerramientaMetalPiedra.setAtributosDePico();
        assertEquals(0, materialDeHerramientaMetalPiedra.fuerza());
    }
    @Test
    public void materialDeHerramientaMetalPiedraDaUnaFuerzaDe20ParaPicosFinos(){
        MaterialDeHerramienta materialDeHerramientaMetalPiedra = new MaterialDeHerramientaMetalPiedra();
        materialDeHerramientaMetalPiedra.setAtributosDePicoFino();
        assertEquals(20, materialDeHerramientaMetalPiedra.fuerza());
    }
    @Test
    public void materialDeHerramientaMetalPiedraTieneUnaDurabilidadDe1000(){
        MaterialDeHerramienta materialDeHerramientaMetalPiedra = new MaterialDeHerramientaMetalPiedra();
        materialDeHerramientaMetalPiedra.setAtributosDePicoFino();
        assertEquals(1000, materialDeHerramientaMetalPiedra.durabilidad());
    }
}
