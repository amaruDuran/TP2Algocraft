package HerramientaTest.FormasDeDesgaste;

import Herramientas.TipoDeHerramienta.FormaDeDesgaste.Desgaste;
import Herramientas.TipoDeHerramienta.FormaDeDesgaste.DesgasteAbrupta;
import Herramientas.TipoDeHerramienta.MaterialDeHerramientas.MaterialDeHerramienta;
import Herramientas.TipoDeHerramienta.MaterialDeHerramientas.MaterialDeHerramientaMetal;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class DesgasteAbruptaTest {
    @Test
    public void seGastaUnMaterialDeHerramientaYSuDurabilidadPermaneceIntacta(){
        MaterialDeHerramienta metal = new MaterialDeHerramientaMetal();
        int durabilidadInicial = metal.durabilidad();
        Desgaste desgasteAbrupto = new DesgasteAbrupta();

        int durabilidadFinal = desgasteAbrupto.desgastarElMaterialDeHerramienta(metal);

        assertEquals(durabilidadInicial, durabilidadFinal);
    }
    @Test
    public void seGasta9VecesUnMaterialDeHerramientaYSuDurabilidadPermaneceIntacta(){
        MaterialDeHerramienta materialDeHerramienta = new MaterialDeHerramientaMetal();
        int durabilidadInicial = materialDeHerramienta.durabilidad();
        Desgaste desgasteAbrupto = new DesgasteAbrupta();
        int durabilidadFinal = -1;

        for (int i = 0; i < 9; i++){
            durabilidadFinal = desgasteAbrupto.desgastarElMaterialDeHerramienta(materialDeHerramienta);
        }

        assertEquals(durabilidadInicial, durabilidadFinal);
    }
    @Test
    public void seGasta10VecesUnMaterialDeHerramientaYSuDurabilidadEsCero(){
        MaterialDeHerramienta materialDeHerramienta = new MaterialDeHerramientaMetal();
        Desgaste desgasteAbrupto = new DesgasteAbrupta();
        int durabilidadFinal = -1;

        for (int i = 0; i < 10; i++){
            durabilidadFinal = desgasteAbrupto.desgastarElMaterialDeHerramienta(materialDeHerramienta);
        }

        assertEquals(0, durabilidadFinal);
    }
}
