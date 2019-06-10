package MaterialesTest.UnidadElemental;

import Herramientas.TipoDeHerramienta.MaterialDeHerramientas.*;
import Materiales.UnidadElemental.UnidadElemental;
import Materiales.UnidadElemental.UnidadElementalMetal;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

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
}
