package HerramientaTest.MaterialDeHerramientaTest;

import Herramientas.TipoDeHerramienta.MaterialDeHerramientas.MaterialDeHerramienta;
import Herramientas.TipoDeHerramienta.MaterialDeHerramientas.MaterialDeHerramientaMadera;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class MaterialDeHerramientaMaderaTest {
    @Test
    public void materialDeHerramientaMaderaDaUnaFuerzaDe2ParaHachas(){
        MaterialDeHerramienta materialDeHerramientaMadera = new MaterialDeHerramientaMadera();
        materialDeHerramientaMadera.setFuerzaDeHacha();
        assertEquals(2, materialDeHerramientaMadera.fuerza());
    }
    @Test
    public void materialDeHerramientaMaderaDaUnaFuerzaDe2ParaPicos(){
        MaterialDeHerramienta materialDeHerramientaMadera = new MaterialDeHerramientaMadera();
        materialDeHerramientaMadera.setFuerzaDePico();
        assertEquals(2, materialDeHerramientaMadera.fuerza());
    }
    @Test
    public void materialDeHerramientaMaderaDaUnaFuerzaDe0ParaPicosFinos(){
        MaterialDeHerramienta materialDeHerramientaMadera = new MaterialDeHerramientaMadera();
        materialDeHerramientaMadera.setFuerzaDePicoFino();
        assertEquals(0, materialDeHerramientaMadera.fuerza());
    }
    @Test
    public void materialDeHerramientaMaderaTieneUnaDurabilidadDe100(){
        MaterialDeHerramienta materialDeHerramientaMadera = new MaterialDeHerramientaMadera();
        materialDeHerramientaMadera.setFuerzaDePicoFino();
        assertEquals(100, materialDeHerramientaMadera.durabilidad());
    }
}
