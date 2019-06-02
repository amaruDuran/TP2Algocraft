package HerramientaTest;

import Herramientas.TipoDeHerramienta.TipoDeHerramienta;
import Herramientas.TipoDeHerramienta.TipoDeHerramientaHacha;
import Herramientas.TipoDeHerramienta.MaterialDeHerramientas.MaterialDeHerramienta;
import Herramientas.TipoDeHerramienta.MaterialDeHerramientas.MaterialDeHerramientaMadera;
import Herramientas.TipoDeHerramienta.MaterialDeHerramientas.MaterialDeHerramientaMetal;
import Herramientas.TipoDeHerramienta.MaterialDeHerramientas.MaterialDeHerramientaPiedra;
import Materiales.Material;
import org.junit.Test;
import static org.junit.Assert.*;

public class TipoDeHerramientaHachaTest {
    //test de desgaste
    @Test
    public void laDurabilidadDeUnHachaDeMaderaSeGastaReduciendoseEnSuFuerzaConElUso(){
        MaterialDeHerramienta madera = new MaterialDeHerramientaMadera();
        TipoDeHerramienta hacha = new TipoDeHerramientaHacha(madera);
        int durabilidadInicial = hacha.durabilidad();
        int durabilidadQueDeberiaTenerAlUsarseUnaVez = durabilidadInicial - hacha.fuerza();
    }
}
