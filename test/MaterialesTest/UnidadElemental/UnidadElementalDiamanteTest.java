package MaterialesTest.UnidadElemental;

import Herramientas.TipoDeHerramienta.MaterialDeHerramientas.*;
import Materiales.UnidadElemental.*;
import org.junit.Test;

import static org.junit.Assert.*;

public class UnidadElementalDiamanteTest {

    @Test
    public void seLePideALaUnidadDeMaderaElMaterialDeHerramientaQueSeConsigueAlConstruirConEllaDaNull(){
        UnidadElemental diamante = new UnidadElementalDiamante();
        MaterialDeHerramienta materialDeHerramienta = diamante.materialDeConstruccion();
        assertNull(materialDeHerramienta);
    }

    @Test
    public void seLePideALaUnidadDeMaderaElMaterialDeHerramientaQueSeConsigueAlConstruirConElConjuntoDeEllaYOtroMaterialMaderaDaNull(){
        UnidadElemental diamante = new UnidadElementalDiamante();
        MaterialDeHerramientaMadera madera = new MaterialDeHerramientaMadera();
        MaterialDeHerramienta materialDeHerramienta = diamante.materialDeConstruccion(madera);
        assertNull(materialDeHerramienta);
    }

    @Test
    public void seLePideALaUnidadDeMaderaElMaterialDeHerramientaQueSeConsigueAlConstruirConElConjuntoDeEllaYOtroMaterialPiedraDaNull(){
        UnidadElemental diamante = new UnidadElementalDiamante();
        MaterialDeHerramientaPiedra piedra = new MaterialDeHerramientaPiedra();
        MaterialDeHerramienta materialDeHerramienta = diamante.materialDeConstruccion(piedra);
        assertNull(materialDeHerramienta);
    }
    @Test
    public void seLePideALaUnidadDeMaderaElMaterialDeHerramientaQueSeConsigueAlConstruirConElConjuntoDeEllaYOtroMaterialMetalDaNull(){
        UnidadElemental diamante = new UnidadElementalDiamante();
        MaterialDeHerramientaMetal metal = new MaterialDeHerramientaMetal();
        MaterialDeHerramienta materialDeHerramienta = diamante.materialDeConstruccion(metal);
        assertNull(materialDeHerramienta);
    }
    @Test
    public void seLePideALaUnidadDeMaderaElMaterialDeHerramientaQueSeConsigueAlConstruirConElConjuntoDeEllaYOtroMaterialMetalPiedraDaNull(){
        UnidadElemental diamante = new UnidadElementalDiamante();
        MaterialDeHerramientaMetalPiedra metalPiedra = new MaterialDeHerramientaMetalPiedra();
        MaterialDeHerramienta materialDeHerramienta = diamante.materialDeConstruccion(metalPiedra);
        assertNull(materialDeHerramienta);
    }
    @Test
    public void elDiamanteEsEquivalenteAOtroDiferenteYViceversa(){
        UnidadElemental unidadElemental = new UnidadElementalDiamante();
        UnidadElemental otraUnidadElemental = new UnidadElementalDiamante();
        assertNotEquals(unidadElemental,otraUnidadElemental);
        assertTrue(unidadElemental.equivalenteA(otraUnidadElemental));
        assertTrue(otraUnidadElemental.equivalenteA(unidadElemental));
    }
    @Test
    public void elDiamanteNoEsEquivalenteAOtroMaterialQueNoSeaElMismoYVisceversa(){
        UnidadElemental unidadElemental = new UnidadElementalDiamante();
        UnidadElemental otraUnidadElemental1 = new UnidadElementalMetal();
        UnidadElemental otraUnidadElemental2 = new UnidadElementalMadera();
        UnidadElemental otraUnidadElemental3 = new UnidadElementalPiedra();
        assertFalse(unidadElemental.equivalenteA(otraUnidadElemental1));
        assertFalse(unidadElemental.equivalenteA(otraUnidadElemental2));
        assertFalse(unidadElemental.equivalenteA(otraUnidadElemental3));
        assertFalse(otraUnidadElemental1.equivalenteA(unidadElemental));
        assertFalse(otraUnidadElemental2.equivalenteA(unidadElemental));
        assertFalse(otraUnidadElemental3.equivalenteA(unidadElemental));
    }
}
