package MaterialesTest.UnidadElemental;

import Modelo.Herramientas.TipoDeHerramienta.MaterialDeHerramientas.*;
import Modelo.Materiales.UnidadElemental.*;
import org.junit.Test;

import static org.junit.Assert.*;
import static org.junit.Assert.assertFalse;

public class UnidadElementalMetalTest {
    @Test
    public void seLePideALaUnidadDeMetalElMaterialDeHerramientaQueSeConsigueAlConstruirConEllaDaMaderaConDurabilidad400(){
        UnidadElemental unidadElementalMetal = new UnidadElementalMetal();
        MaterialDeHerramienta materialDeHerramienta = unidadElementalMetal.materialDeConstruccion();
        assertEquals(400, materialDeHerramienta.durabilidad());
    }

    @Test
    public void seLePideALaUnidadDeMetalElMaterialDeHerramientaQueSeConsigueAlConstruirConElConjuntoDeEllaYOtroMaterialMaderaDaMetalConDurabilidad400(){
        UnidadElemental unidadElementalMetal = new UnidadElementalMetal();
        MaterialDeHerramientaMadera madera = new MaterialDeHerramientaMadera();
        MaterialDeHerramienta materialDeHerramienta = unidadElementalMetal.materialDeConstruccion(madera);
        assertEquals(400, materialDeHerramienta.durabilidad());
    }

    @Test
    public void seLePideALaUnidadDeMetalElMaterialDeHerramientaQueSeConsigueAlConstruirConElConjuntoDeEllaYOtroMaterialPiedraDaMetalPiedraConDurabilidad1000(){
        UnidadElemental unidadElementalMetal = new UnidadElementalMetal();
        MaterialDeHerramientaPiedra piedra = new MaterialDeHerramientaPiedra();
        MaterialDeHerramienta materialDeHerramienta = unidadElementalMetal.materialDeConstruccion(piedra);
        assertEquals(1000, materialDeHerramienta.durabilidad());
    }
    @Test
    public void seLePideALaUnidadDeMetalElMaterialDeHerramientaQueSeConsigueAlConstruirConElConjuntoDeEllaYOtroMaterialMetalDaMetalConDurabilidad400(){
        UnidadElemental unidadElementalMetal = new UnidadElementalMetal();
        MaterialDeHerramientaMetal metal = new MaterialDeHerramientaMetal();
        MaterialDeHerramienta materialDeHerramienta = unidadElementalMetal.materialDeConstruccion(metal);
        assertEquals(400, materialDeHerramienta.durabilidad());
    }
    @Test
    public void seLePideALaUnidadDeMetalElMaterialDeHerramientaQueSeConsigueAlConstruirConElConjuntoDeEllaYOtroMaterialMetalPiedraDaMetalPiedraConDurabilidad1000(){
        UnidadElemental unidadElementalMetal = new UnidadElementalMetal();
        MaterialDeHerramientaMetalPiedra metalPiedra = new MaterialDeHerramientaMetalPiedra();
        MaterialDeHerramienta materialDeHerramienta = unidadElementalMetal.materialDeConstruccion(metalPiedra);
        assertEquals(1000, materialDeHerramienta.durabilidad());
    }
    @Test
    public void elMetalEsEquivalenteAOtroDiferenteYViceversa(){
        UnidadElemental unidadElemental = new UnidadElementalMetal();
        UnidadElemental otraUnidadElemental = new UnidadElementalMetal();
        assertNotEquals(unidadElemental,otraUnidadElemental);
        assertTrue(unidadElemental.equivalenteA(otraUnidadElemental));
        assertTrue(otraUnidadElemental.equivalenteA(unidadElemental));
    }
    @Test
    public void elMetalNoEsEquivalenteAOtroMaterialQueNoSeaElMismoYVisceversa(){
        UnidadElemental unidadElemental = new UnidadElementalMetal();
        UnidadElemental otraUnidadElemental1 = new UnidadElementalMadera();
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
