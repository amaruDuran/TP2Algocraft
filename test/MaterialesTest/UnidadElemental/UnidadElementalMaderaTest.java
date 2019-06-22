package MaterialesTest.UnidadElemental;

import Modelo.Herramientas.TipoDeHerramienta.MaterialDeHerramientas.*;
import Modelo.Materiales.UnidadElemental.*;
import org.junit.Test;

import static org.junit.Assert.*;
import static org.junit.Assert.assertFalse;

public class UnidadElementalMaderaTest {

    @Test
    public void seLePideALaUnidadDeMaderaElMaterialDeHerramientaQueSeConsigueAlConstruirConEllaDaMaderaConDurabilidad100(){
        UnidadElemental unidadElementalMadera = new UnidadElementalMadera();
        MaterialDeHerramienta materialDeHerramienta = unidadElementalMadera.materialDeConstruccion();
        assertEquals(100, materialDeHerramienta.durabilidad());
    }

    @Test
    public void seLePideALaUnidadDeMaderaElMaterialDeHerramientaQueSeConsigueAlConstruirConElConjuntoDeEllaYOtroMaterialMaderaDaMaderaConDurabilidad100(){
        UnidadElemental unidadElementalMadera = new UnidadElementalMadera();
        MaterialDeHerramientaMadera madera = new MaterialDeHerramientaMadera();
        MaterialDeHerramienta materialDeHerramienta = unidadElementalMadera.materialDeConstruccion(madera);
        assertEquals(100, materialDeHerramienta.durabilidad());
    }

    @Test
    public void seLePideALaUnidadDeMaderaElMaterialDeHerramientaQueSeConsigueAlConstruirConElConjuntoDeEllaYOtroMaterialPiedraDaPiedraConDurabilidad200(){
        UnidadElemental unidadElementalMadera = new UnidadElementalMadera();
        MaterialDeHerramientaPiedra piedra = new MaterialDeHerramientaPiedra();
        MaterialDeHerramienta materialDeHerramienta = unidadElementalMadera.materialDeConstruccion(piedra);
        assertEquals(200, materialDeHerramienta.durabilidad());
    }

    @Test
    public void seLePideALaUnidadDeMaderaElMaterialDeHerramientaQueSeConsigueAlConstruirConElConjuntoDeEllaYOtroMaterialMetalDaMetalConDurabilidad400(){
        UnidadElemental unidadElementalMadera = new UnidadElementalMadera();
        MaterialDeHerramientaMetal metal = new MaterialDeHerramientaMetal();
        MaterialDeHerramienta materialDeHerramienta = unidadElementalMadera.materialDeConstruccion(metal);
        assertEquals(400, materialDeHerramienta.durabilidad());
    }

    @Test
    public void seLePideALaUnidadDeMaderaElMaterialDeHerramientaQueSeConsigueAlConstruirConElConjuntoDeEllaYOtroMaterialMetalPiedraDaMetalPiedraConDurabilidad1000(){
        UnidadElemental unidadElementalMadera = new UnidadElementalMadera();
        MaterialDeHerramientaMetalPiedra metalPiedra = new MaterialDeHerramientaMetalPiedra();
        MaterialDeHerramienta materialDeHerramienta = unidadElementalMadera.materialDeConstruccion(metalPiedra);
        assertEquals(1000, materialDeHerramienta.durabilidad());
    }
    @Test
    public void laMaderaEsEquivalenteAOtroDiferenteYViceversa(){
        UnidadElemental unidadElemental = new UnidadElementalMadera();
        UnidadElemental otraUnidadElemental = new UnidadElementalMadera();
        assertNotEquals(unidadElemental,otraUnidadElemental);
        assertTrue(unidadElemental.equivalenteA(otraUnidadElemental));
        assertTrue(otraUnidadElemental.equivalenteA(unidadElemental));
    }
    @Test
    public void laMaderaNoEsEquivalenteAOtroMaterialQueNoSeaElMismoYVisceversa(){
        UnidadElemental unidadElemental = new UnidadElementalMadera();
        UnidadElemental otraUnidadElemental1 = new UnidadElementalMetal();
        UnidadElemental otraUnidadElemental2 = new UnidadElementalDiamante();
        UnidadElemental otraUnidadElemental3 = new UnidadElementalPiedra();
        assertFalse(unidadElemental.equivalenteA(otraUnidadElemental1));
        assertFalse(unidadElemental.equivalenteA(otraUnidadElemental2));
        assertFalse(unidadElemental.equivalenteA(otraUnidadElemental3));
        assertFalse(otraUnidadElemental1.equivalenteA(unidadElemental));
        assertFalse(otraUnidadElemental2.equivalenteA(unidadElemental));
        assertFalse(otraUnidadElemental3.equivalenteA(unidadElemental));
    }
}
