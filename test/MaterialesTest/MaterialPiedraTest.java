package MaterialesTest;

import Modelo.Herramientas.TipoDeHerramienta.Hacha;
import Modelo.Herramientas.TipoDeHerramienta.MaterialDeHerramientas.MaterialDeHerramientaMadera;
import Modelo.Herramientas.TipoDeHerramienta.MaterialDeHerramientas.MaterialDeHerramientaMetal;
import Modelo.Herramientas.TipoDeHerramienta.MaterialDeHerramientas.MaterialDeHerramientaMetalPiedra;
import Modelo.Herramientas.TipoDeHerramienta.MaterialDeHerramientas.MaterialDeHerramientaPiedra;
import Modelo.Herramientas.TipoDeHerramienta.Pico;
import Modelo.Herramientas.TipoDeHerramienta.PicoFino;
import Modelo.Materiales.Material;
import Modelo.Materiales.MaterialPiedra;
import Modelo.Materiales.UnidadElemental.UnidadElementalPiedra;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class MaterialPiedraTest {
    @Test
    public void seIntentaRecolesctarPiedraElProcesoFallaConTodoTipoDeHachaYNoDisminuyeSuDurabilidad(){
        Hacha hachaDeMadera = new Hacha(new MaterialDeHerramientaMadera());
        Hacha hachaDePiedra = new Hacha(new MaterialDeHerramientaPiedra());
        Hacha hachaDeMetal = new Hacha(new MaterialDeHerramientaMetal());
        Material Piedra = new MaterialPiedra();
        int durabilidadInicial = Piedra.durabilidadActualDelMaterial();

        Piedra.recolectadoPor(hachaDeMadera);
        Piedra.recolectadoPor(hachaDePiedra);
        Piedra.recolectadoPor(hachaDeMetal);

        assertEquals(durabilidadInicial, Piedra.durabilidadActualDelMaterial());
    }
    @Test
    public void seIntentaRecolesctarPiedraElProcesoConPicoDeMaderaYDisminuyeSuDurabilidadEnLaFuerzaDeLaHerramienta(){
        Pico picoDeMadera = new Pico(new MaterialDeHerramientaMadera());
        Material Piedra = new MaterialPiedra();
        int durabilidadInicial = Piedra.durabilidadActualDelMaterial();
        int durabilidadQueDeberiaTenerElMaterial = (durabilidadInicial - picoDeMadera.fuerza());

        Piedra.recolectadoPor(picoDeMadera);

        assertEquals(durabilidadQueDeberiaTenerElMaterial, Piedra.durabilidadActualDelMaterial());
    }
    @Test
    public void seIntentaRecolesctarPiedraElProcesoConPicoDePiedraYDisminuyeSuDurabilidadEnLaFuerzaDeLaHerramienta(){
        Pico picoDePiedra = new Pico(new MaterialDeHerramientaPiedra());
        Material Piedra = new MaterialPiedra();
        int durabilidadInicial = Piedra.durabilidadActualDelMaterial();
        int durabilidadQueDeberiaTenerElMaterial = (durabilidadInicial - picoDePiedra.fuerza());

        Piedra.recolectadoPor(picoDePiedra);

        assertEquals(durabilidadQueDeberiaTenerElMaterial, Piedra.durabilidadActualDelMaterial());
    }
    @Test
    public void seIntentaRecolesctarPiedraElProcesoCoPicoDeMetalDisminuyeSuDurabilidadEnLaFuerzaDeLaHerramienta(){
        Pico picoDeMetal = new Pico(new MaterialDeHerramientaMetal());
        Material Piedra = new MaterialPiedra();
        int durabilidadInicial = Piedra.durabilidadActualDelMaterial();
        int durabilidadQueDeberiaTenerElMaterial = (durabilidadInicial - picoDeMetal.fuerza());

        Piedra.recolectadoPor(picoDeMetal);

        assertEquals(durabilidadQueDeberiaTenerElMaterial, Piedra.durabilidadActualDelMaterial());
    }
    @Test//supuesto el pico fino no recolecta metal
    public void seIntentaRecolesctarPiedraConUnPicoFinoElProcesoFallaNoSeDesgastaElMaterial(){
        PicoFino picoFino = new PicoFino(new MaterialDeHerramientaMetalPiedra());
        Material Piedra = new MaterialPiedra();
        int durabilidadInicial = Piedra.durabilidadActualDelMaterial();

        Piedra.recolectadoPor(picoFino);

        assertEquals(durabilidadInicial , Piedra.durabilidadActualDelMaterial());
    }
    //en los cassos que funciona deben hacerlo varias veces
    @Test
    public void seIntentaRecolectarPiedraRepetidasVecesElProcesoConPicoDeMaderaYDisminuyeSuDurabilidadEnLaFuerzaDeLaHerramientaTodasLasVeces(){
        Pico picoDeMadera = new Pico(new MaterialDeHerramientaMadera());
        Material Piedra = new MaterialPiedra();
        int durabilidadInicial = Piedra.durabilidadActualDelMaterial();
        int vecesRecolectado = 3;
        int durabilidadQueDeberiaTenerElMaterial = (durabilidadInicial - (picoDeMadera.fuerza() * vecesRecolectado));

        for (int i = 0; i < vecesRecolectado; i++){
            Piedra.recolectadoPor(picoDeMadera);
        }

        assertEquals(durabilidadQueDeberiaTenerElMaterial, Piedra.durabilidadActualDelMaterial());
    }
    @Test
    public void seIntentaRecolesctarPiedraRepetidasVecesElProcesoConPicoDePiedraYDisminuyeSuDurabilidadEnLaFuerzaDeLaHerramientaTodasLasVeces(){
        Pico picoDePiedra = new Pico(new MaterialDeHerramientaPiedra());
        Material Piedra = new MaterialPiedra();
        int durabilidadInicial = Piedra.durabilidadActualDelMaterial();
        int vecesRecolectado = 3;
        int durabilidadQueDeberiaTenerElMaterial = (durabilidadInicial - (picoDePiedra.fuerza() * vecesRecolectado));

        for (int i = 0; i < vecesRecolectado; i++){
            Piedra.recolectadoPor(picoDePiedra);
        }

        assertEquals(durabilidadQueDeberiaTenerElMaterial, Piedra.durabilidadActualDelMaterial());
    }
    @Test
    public void seIntentaRecolesctarPiedraRepetidasVecesElProcesoCoPicoDeMetalDisminuyeSuDurabilidadEnLaFuerzaDeLaHerramientaTodasLasVeces(){
        Pico picoDeMetal = new Pico(new MaterialDeHerramientaMetal());
        Material Piedra = new MaterialPiedra();
        int durabilidadInicial = Piedra.durabilidadActualDelMaterial();
        int vecesRecolectado = 3;
        int durabilidadQueDeberiaTenerElMaterial = (durabilidadInicial - (picoDeMetal.fuerza() * vecesRecolectado));

        for (int i = 0; i < vecesRecolectado; i++){
            Piedra.recolectadoPor(picoDeMetal);
        }

        assertEquals(durabilidadQueDeberiaTenerElMaterial, Piedra.durabilidadActualDelMaterial());
    }
    @Test
    public void daSuUnidadElementalDePiedra(){
        Material Piedra = new MaterialPiedra();
        assertTrue(new UnidadElementalPiedra().equivalenteA(Piedra.getUnidadElemental()));
    }
}
