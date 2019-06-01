package HerramientaTest.MaterialDeHerramientaTest;

import Herramientas.TipoDeHerramienta.MaterialDeHerramientas.MaterialDeHerramienta;
import Herramientas.TipoDeHerramienta.MaterialDeHerramientas.MaterialDeHerramientaMetal;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class MaterialDeHerramientaMetalTest {
    @Test
    public void materialDeHerramientaMetalDaUnaFuerzaDe10ParaHachas(){
        MaterialDeHerramienta materialDeHerramientaMetal = new MaterialDeHerramientaMetal();
        materialDeHerramientaMetal.setFuerzaDeHacha();
        assertEquals(10, materialDeHerramientaMetal.fuerza());
    }
    @Test
    public void materialDeHerramientaMetalDaUnaFuerzaDe12ParaPicos(){
        MaterialDeHerramienta materialDeHerramientaMetal = new MaterialDeHerramientaMetal();
        materialDeHerramientaMetal.setFuerzaDePico();
        assertEquals(12, materialDeHerramientaMetal.fuerza());
    }
    @Test
    public void materialDeHerramientaMetalDaUnaFuerzaDe0ParaPicosFinos(){
        MaterialDeHerramienta materialDeHerramientaMetal = new MaterialDeHerramientaMetal();
        materialDeHerramientaMetal.setFuerzaDePicoFino();
        assertEquals(0, materialDeHerramientaMetal.fuerza());
    }
    @Test
    public void materialDeHerramientaMetalTieneUnaDurabilidadDe400(){
        MaterialDeHerramienta materialDeHerramientaMetal = new MaterialDeHerramientaMetal();
        materialDeHerramientaMetal.setFuerzaDePicoFino();
        assertEquals(400, materialDeHerramientaMetal.durabilidad());
    }
}
