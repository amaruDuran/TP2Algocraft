package MaterialesTest.UnidadElemental;

import Herramientas.TipoDeHerramienta.MaterialDeHerramientas.*;
import Materiales.UnidadElemental.UnidadElemental;
import Materiales.UnidadElemental.UnidadElementalDiamante;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

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
}
