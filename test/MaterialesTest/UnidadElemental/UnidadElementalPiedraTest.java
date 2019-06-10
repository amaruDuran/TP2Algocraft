package MaterialesTest.UnidadElemental;

import Herramientas.TipoDeHerramienta.MaterialDeHerramientas.*;
import Materiales.UnidadElemental.UnidadElemental;
import Materiales.UnidadElemental.UnidadElementalPiedra;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

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
}
