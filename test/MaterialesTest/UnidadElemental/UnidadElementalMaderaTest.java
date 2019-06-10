package MaterialesTest.UnidadElemental;

import Herramientas.TipoDeHerramienta.MaterialDeHerramientas.*;
import Materiales.UnidadElemental.UnidadElemental;
import Materiales.UnidadElemental.UnidadElementalMadera;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

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
}
