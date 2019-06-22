package MaterialesTest.UnidadElemental;

import Modelo.Herramientas.TipoDeHerramienta.MaterialDeHerramientas.*;
import Modelo.Materiales.UnidadElemental.*;
import org.junit.Test;

import static org.junit.Assert.*;
import static org.junit.Assert.assertFalse;

public class UnidadElementalPiedraTest {
    @Test
    public void seLePideALaUnidadDePiedraElMaterialDeHerramientaQueSeConsigueAlConstruirConEllaDaPiedraConDurabilidad200(){
        UnidadElemental unidadElementalPiedra = new UnidadElementalPiedra();
        MaterialDeHerramienta materialDeHerramienta = unidadElementalPiedra.materialDeConstruccion();
        assertEquals(200, materialDeHerramienta.durabilidad());
    }

    @Test
    public void seLePideALaUnidadDePiedraElMaterialDeHerramientaQueSeConsigueAlConstruirConElConjuntoDeEllaYOtroMaterialMaderaDaPiedraConDurabilidad200(){
        UnidadElemental unidadElementalPiedra = new UnidadElementalPiedra();
        MaterialDeHerramientaMadera madera = new MaterialDeHerramientaMadera();
        MaterialDeHerramienta materialDeHerramienta = unidadElementalPiedra.materialDeConstruccion(madera);
        assertEquals(200, materialDeHerramienta.durabilidad());
    }

    @Test
    public void seLePideALaUnidadDePiedraElMaterialDeHerramientaQueSeConsigueAlConstruirConElConjuntoDeEllaYOtroMaterialPiedraDaPiedraConDurabilidad200(){
        UnidadElemental unidadElementalPiedra = new UnidadElementalPiedra();
        MaterialDeHerramientaPiedra piedra = new MaterialDeHerramientaPiedra();
        MaterialDeHerramienta materialDeHerramienta = unidadElementalPiedra.materialDeConstruccion(piedra);
        assertEquals(200, materialDeHerramienta.durabilidad());
    }
    @Test
    public void seLePideALaUnidadDePiedraElMaterialDeHerramientaQueSeConsigueAlConstruirConElConjuntoDeEllaYOtroMaterialMetalDaMetalPiedraConDurabilidad1000(){
        UnidadElemental unidadElementalPiedra = new UnidadElementalPiedra();
        MaterialDeHerramientaMetal metal = new MaterialDeHerramientaMetal();
        MaterialDeHerramienta materialDeHerramienta = unidadElementalPiedra.materialDeConstruccion(metal);
        assertEquals(1000, materialDeHerramienta.durabilidad());
    }
    @Test
    public void seLePideALaUnidadDeMaderaElMaterialDeHerramientaQueSeConsigueAlConstruirConElConjuntoDeEllaYOtroMaterialMetalPiedraDaMetalPiedraConDurabilidad1000(){
        UnidadElemental unidadElementalPiedra = new UnidadElementalPiedra();
        MaterialDeHerramientaMetalPiedra metalPiedra = new MaterialDeHerramientaMetalPiedra();
        MaterialDeHerramienta materialDeHerramienta = unidadElementalPiedra.materialDeConstruccion(metalPiedra);
        assertEquals(1000, materialDeHerramienta.durabilidad());
    }
    @Test
    public void laPiedraEsEquivalenteAOtroDiferenteYViceversa(){
        UnidadElemental unidadElemental = new UnidadElementalPiedra();
        UnidadElemental otraUnidadElemental = new UnidadElementalPiedra();
        assertNotEquals(unidadElemental,otraUnidadElemental);
        assertTrue(unidadElemental.equivalenteA(otraUnidadElemental));
        assertTrue(otraUnidadElemental.equivalenteA(unidadElemental));
    }
    @Test
    public void laPiedraNoEsEquivalenteAOtroMaterialQueNoSeaElMismoYVisceversa(){
        UnidadElemental unidadElemental = new UnidadElementalPiedra();
        UnidadElemental otraUnidadElemental1 = new UnidadElementalMadera();
        UnidadElemental otraUnidadElemental2 = new UnidadElementalDiamante();
        UnidadElemental otraUnidadElemental3 = new UnidadElementalMetal();
        assertFalse(unidadElemental.equivalenteA(otraUnidadElemental1));
        assertFalse(unidadElemental.equivalenteA(otraUnidadElemental2));
        assertFalse(unidadElemental.equivalenteA(otraUnidadElemental3));
        assertFalse(otraUnidadElemental1.equivalenteA(unidadElemental));
        assertFalse(otraUnidadElemental2.equivalenteA(unidadElemental));
        assertFalse(otraUnidadElemental3.equivalenteA(unidadElemental));
    }
}
