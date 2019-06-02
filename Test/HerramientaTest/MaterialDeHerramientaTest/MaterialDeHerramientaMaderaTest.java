package HerramientaTest.MaterialDeHerramientaTest;

import Herramientas.TipoDeHerramienta.MaterialDeHerramientas.MaterialDeHerramienta;
import Herramientas.TipoDeHerramienta.MaterialDeHerramientas.MaterialDeHerramientaMadera;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class MaterialDeHerramientaMaderaTest {
    //test de fuerza
    @Test
    public void materialDeHerramientaMaderaDaUnaFuerzaDe2ParaHachas(){
        MaterialDeHerramienta materialDeHerramientaMadera = new MaterialDeHerramientaMadera();
        materialDeHerramientaMadera.setAtributosDeHacha();
        assertEquals(2, materialDeHerramientaMadera.fuerza());
    }
    @Test
    public void materialDeHerramientaMaderaDaUnaFuerzaDe2ParaPicos(){
        MaterialDeHerramienta materialDeHerramientaMadera = new MaterialDeHerramientaMadera();
        materialDeHerramientaMadera.setAtributosDePico();
        assertEquals(2, materialDeHerramientaMadera.fuerza());
    }
    @Test
    public void materialDeHerramientaMaderaDaUnaFuerzaDe0ParaPicosFinos(){
        MaterialDeHerramienta materialDeHerramientaMadera = new MaterialDeHerramientaMadera();
        materialDeHerramientaMadera.setAtributosDePicoFino();
        assertEquals(0, materialDeHerramientaMadera.fuerza());
    }
    //test de durabilidad
    @Test
    public void materialDeHerramientaMaderaTieneUnaDurabilidadDe100(){
        MaterialDeHerramienta materialDeHerramientaMadera = new MaterialDeHerramientaMadera();
        materialDeHerramientaMadera.setAtributosDePicoFino();
        assertEquals(100, materialDeHerramientaMadera.durabilidad());
    }
}
