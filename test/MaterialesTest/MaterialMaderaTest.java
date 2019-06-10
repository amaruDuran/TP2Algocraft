package MaterialesTest;

import Herramientas.TipoDeHerramienta.Hacha;
import Herramientas.TipoDeHerramienta.MaterialDeHerramientas.MaterialDeHerramientaMadera;
import Herramientas.TipoDeHerramienta.MaterialDeHerramientas.MaterialDeHerramientaMetal;
import Herramientas.TipoDeHerramienta.MaterialDeHerramientas.MaterialDeHerramientaMetalPiedra;
import Herramientas.TipoDeHerramienta.MaterialDeHerramientas.MaterialDeHerramientaPiedra;
import Herramientas.TipoDeHerramienta.Pico;
import Herramientas.TipoDeHerramienta.PicoFino;
import Materiales.Material;
import Materiales.MaterialMadera;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class MaterialMaderaTest {
    @Test
    public void seIntentaRecolesctarMaderaConHachaDeMaderaYDisminuyeSuDurabilidadLaFuerzaDeLaHerramienta(){
        Hacha hachaDeMadera = new Hacha(new MaterialDeHerramientaMadera());
        Material madera = new MaterialMadera();
        int durabilidadInicial = madera.durabilidadActualDelMaterial();
        int durabilidadQueDeberiaTenerElMaterial = (durabilidadInicial - hachaDeMadera.fuerza());

        madera.recolectadoPor(hachaDeMadera);

        assertEquals(durabilidadQueDeberiaTenerElMaterial, madera.durabilidadActualDelMaterial());
    }
    @Test
    public void seIntentaRecolesctarMaderaConHachaDePiedraYDisminuyeSuDurabilidadLaFuerzaDeLaHerramienta(){
        Hacha hachaDePiedra = new Hacha(new MaterialDeHerramientaPiedra());
        Material madera = new MaterialMadera();
        int durabilidadInicial = madera.durabilidadActualDelMaterial();
        int durabilidadQueDeberiaTenerElMaterial = (durabilidadInicial - hachaDePiedra.fuerza());

        madera.recolectadoPor(hachaDePiedra);

        assertEquals(durabilidadQueDeberiaTenerElMaterial, madera.durabilidadActualDelMaterial());
    }
    @Test
    public void seIntentaRecolesctarMaderaConHachaDeMetalYDisminuyeSuDurabilidadLaFuerzaDeLaHerramienta(){
        Hacha hachaDeMetal = new Hacha(new MaterialDeHerramientaMetal());
        Material madera = new MaterialMadera();
        int durabilidadInicial = madera.durabilidadActualDelMaterial();
        int durabilidadQueDeberiaTenerElMaterial = (durabilidadInicial - hachaDeMetal.fuerza());

        madera.recolectadoPor(hachaDeMetal);

        assertEquals(durabilidadQueDeberiaTenerElMaterial, madera.durabilidadActualDelMaterial());
    }
    @Test
    public void seIntentaRecolesctarMaderaElProcesoFallaConTodoTipoDePicoYNoDisminuyeSuDurabilidad(){
        Pico picoDeMadera = new Pico(new MaterialDeHerramientaMadera());
        Pico picoDePiedra = new Pico(new MaterialDeHerramientaPiedra());
        Pico picoDeMetal = new Pico(new MaterialDeHerramientaMetal());
        Material madera = new MaterialMadera();
        int durabilidadInicial = madera.durabilidadActualDelMaterial();

        madera.recolectadoPor(picoDeMadera);
        madera.recolectadoPor(picoDePiedra);
        madera.recolectadoPor(picoDeMetal);

        assertEquals(durabilidadInicial, madera.durabilidadActualDelMaterial());
    }
    @Test
    public void seIntentaRecolesctarMaderaConUnPicoFinoElProcesoFallaNoSeDesgastaElMaterial(){
        PicoFino picoFino = new PicoFino(new MaterialDeHerramientaMetalPiedra());
        Material madera = new MaterialMadera();
        int durabilidadInicial = madera.durabilidadActualDelMaterial();

        madera.recolectadoPor(picoFino);

        assertEquals(durabilidadInicial , madera.durabilidadActualDelMaterial());
    }
    //en los cassos que funciona deben hacerlo varias veces
    @Test
    public void seIntentaRecolectarRepetidasVecesMaderaConHachaDeMaderaYDisminuyeSuDurabilidadLaFuerzaDeLaHerramientaTodasLasVeces(){
        Hacha hachaDeMadera = new Hacha(new MaterialDeHerramientaMadera());
        Material madera = new MaterialMadera();
        int durabilidadInicial = madera.durabilidadActualDelMaterial();
        int vecesRecolectado = 3;
        int durabilidadQueDeberiaTenerElMaterial = (durabilidadInicial - (hachaDeMadera.fuerza() * vecesRecolectado));

        for (int i = 0; i < vecesRecolectado; i++){
            madera.recolectadoPor(hachaDeMadera);
        }

        assertEquals(durabilidadQueDeberiaTenerElMaterial, madera.durabilidadActualDelMaterial());
    }
    @Test
    public void seIntentaRecolectarRepetidasVecesMaderaConHachaDePiedraYDisminuyeSuDurabilidadLaFuerzaDeLaHerramientaTodasLasVeces(){
        Hacha hachaDePiedra = new Hacha(new MaterialDeHerramientaPiedra());
        Material madera = new MaterialMadera();
        int durabilidadInicial = madera.durabilidadActualDelMaterial();
        int vecesRecolectado = 3;
        int durabilidadQueDeberiaTenerElMaterial = (durabilidadInicial - (hachaDePiedra.fuerza() * vecesRecolectado));

        for (int i = 0; i < vecesRecolectado; i++){
            madera.recolectadoPor(hachaDePiedra);
        }

        assertEquals(durabilidadQueDeberiaTenerElMaterial, madera.durabilidadActualDelMaterial());
    }
    @Test
    public void seIntentaRecolectarRepetidasVecesMaderaConHachaDeMetalYDisminuyeSuDurabilidadLaFuerzaDeLaHerramientaTodasLasVeces(){
        Hacha hachaDeMetal = new Hacha(new MaterialDeHerramientaMetal());
        Material madera = new MaterialMadera();
        int durabilidadInicial = madera.durabilidadActualDelMaterial();
        int vecesRecolectado = 3;
        int durabilidadQueDeberiaTenerElMaterial = (durabilidadInicial - (hachaDeMetal.fuerza() * vecesRecolectado));

        for (int i = 0; i < vecesRecolectado; i++){
            madera.recolectadoPor(hachaDeMetal);
        }

        assertEquals(durabilidadQueDeberiaTenerElMaterial, madera.durabilidadActualDelMaterial());
    }
}
