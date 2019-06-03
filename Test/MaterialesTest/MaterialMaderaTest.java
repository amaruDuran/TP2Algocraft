package MaterialesTest;

import Herramientas.TipoDeHerramienta.MaterialDeHerramientas.MaterialDeHerramientaMadera;
import Herramientas.TipoDeHerramienta.MaterialDeHerramientas.MaterialDeHerramientaMetal;
import Herramientas.TipoDeHerramienta.MaterialDeHerramientas.MaterialDeHerramientaMetalPiedra;
import Herramientas.TipoDeHerramienta.MaterialDeHerramientas.MaterialDeHerramientaPiedra;
import Herramientas.TipoDeHerramienta.TipoDeHerramientaHacha;
import Herramientas.TipoDeHerramienta.TipoDeHerramientaPico;
import Herramientas.TipoDeHerramienta.TipoDeHerramientaPicoFino;
import Materiales.Material;
import Materiales.MaterialMadera;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class MaterialMaderaTest {
    @Test
    public void seIntentaRecolesctarMaderaConHachaDeMaderaYDisminuyeSuDurabilidadLaFuerzaDeLaHerramienta(){
        TipoDeHerramientaHacha hachaDeMadera = new TipoDeHerramientaHacha(new MaterialDeHerramientaMadera());
        Material madera = new MaterialMadera();
        int durabilidadInicial = madera.durabilidadActualDelMaterial();
        int durabilidadQueDeberiaTenerElMaterial = (durabilidadInicial - hachaDeMadera.fuerza());
        madera.recolectadoPorHacha(hachaDeMadera);
        assertEquals(durabilidadQueDeberiaTenerElMaterial, madera.durabilidadActualDelMaterial());
    }
    @Test
    public void seIntentaRecolesctarMaderaConHachaDePiedraYDisminuyeSuDurabilidadLaFuerzaDeLaHerramienta(){
        TipoDeHerramientaHacha hachaDePiedra = new TipoDeHerramientaHacha(new MaterialDeHerramientaPiedra());
        Material madera = new MaterialMadera();
        int durabilidadInicial = madera.durabilidadActualDelMaterial();
        int durabilidadQueDeberiaTenerElMaterial = (durabilidadInicial - hachaDePiedra.fuerza());
        madera.recolectadoPorHacha(hachaDePiedra);
        assertEquals(durabilidadQueDeberiaTenerElMaterial, madera.durabilidadActualDelMaterial());
    }
    @Test
    public void seIntentaRecolesctarMaderaConHachaDeMetalYDisminuyeSuDurabilidadLaFuerzaDeLaHerramienta(){
        TipoDeHerramientaHacha hachaDeMetal = new TipoDeHerramientaHacha(new MaterialDeHerramientaMetal());
        Material madera = new MaterialMadera();
        int durabilidadInicial = madera.durabilidadActualDelMaterial();
        int durabilidadQueDeberiaTenerElMaterial = (durabilidadInicial - hachaDeMetal.fuerza());
        madera.recolectadoPorHacha(hachaDeMetal);
        assertEquals(durabilidadQueDeberiaTenerElMaterial, madera.durabilidadActualDelMaterial());
    }
    @Test
    public void seIntentaRecolesctarMaderaElProcesoFallaConTodoTipoDePicoYNoDisminuyeSuDurabilidad(){
        TipoDeHerramientaPico picoDeMadera = new TipoDeHerramientaPico(new MaterialDeHerramientaMadera());
        TipoDeHerramientaPico picoDePiedra = new TipoDeHerramientaPico(new MaterialDeHerramientaPiedra());
        TipoDeHerramientaPico picoDeMetal = new TipoDeHerramientaPico(new MaterialDeHerramientaMetal());
        Material madera = new MaterialMadera();
        int durabilidadInicial = madera.durabilidadActualDelMaterial();
        madera.recolectadoPorPico(picoDeMadera);
        madera.recolectadoPorPico(picoDePiedra);
        madera.recolectadoPorPico(picoDeMetal);
        assertEquals(durabilidadInicial, madera.durabilidadActualDelMaterial());
    }
    @Test
    public void seIntentaRecolesctarMaderaConUnPicoFinoElProcesoFallaNoSeDesgastaElMaterial(){
        TipoDeHerramientaPicoFino picoFino = new TipoDeHerramientaPicoFino(new MaterialDeHerramientaMetalPiedra());
        Material madera = new MaterialMadera();
        int durabilidadInicial = madera.durabilidadActualDelMaterial();
        madera.recolectadoPorPicoFino(picoFino);
        assertEquals(durabilidadInicial , madera.durabilidadActualDelMaterial());
    }
    //en los cassos que funciona deben hacerlo varias veces
    @Test
    public void seIntentaRecolectarRepetidasVecesMaderaConHachaDeMaderaYDisminuyeSuDurabilidadLaFuerzaDeLaHerramientaTodasLasVeces(){
        TipoDeHerramientaHacha hachaDeMadera = new TipoDeHerramientaHacha(new MaterialDeHerramientaMadera());
        Material madera = new MaterialMadera();
        int durabilidadInicial = madera.durabilidadActualDelMaterial();
        int vecesRecolectado = 3;
        int durabilidadQueDeberiaTenerElMaterial = (durabilidadInicial - (hachaDeMadera.fuerza() * vecesRecolectado));
        for (int i = 0; i < vecesRecolectado; i++){
            madera.recolectadoPorHacha(hachaDeMadera);
        }
        assertEquals(durabilidadQueDeberiaTenerElMaterial, madera.durabilidadActualDelMaterial());
    }
    @Test
    public void seIntentaRecolectarRepetidasVecesMaderaConHachaDePiedraYDisminuyeSuDurabilidadLaFuerzaDeLaHerramientaTodasLasVeces(){
        TipoDeHerramientaHacha hachaDePiedra = new TipoDeHerramientaHacha(new MaterialDeHerramientaPiedra());
        Material madera = new MaterialMadera();
        int durabilidadInicial = madera.durabilidadActualDelMaterial();
        int vecesRecolectado = 3;
        int durabilidadQueDeberiaTenerElMaterial = (durabilidadInicial - (hachaDePiedra.fuerza() * vecesRecolectado));
        for (int i = 0; i < vecesRecolectado; i++){
            madera.recolectadoPorHacha(hachaDePiedra);
        }
        assertEquals(durabilidadQueDeberiaTenerElMaterial, madera.durabilidadActualDelMaterial());
    }
    @Test
    public void seIntentaRecolectarRepetidasVecesMaderaConHachaDeMetalYDisminuyeSuDurabilidadLaFuerzaDeLaHerramientaTodasLasVeces(){
        TipoDeHerramientaHacha hachaDeMetal = new TipoDeHerramientaHacha(new MaterialDeHerramientaMetal());
        Material madera = new MaterialMadera();
        int durabilidadInicial = madera.durabilidadActualDelMaterial();
        int vecesRecolectado = 3;
        int durabilidadQueDeberiaTenerElMaterial = (durabilidadInicial - (hachaDeMetal.fuerza() * vecesRecolectado));
        for (int i = 0; i < vecesRecolectado; i++){
            madera.recolectadoPorHacha(hachaDeMetal);
        }
        assertEquals(durabilidadQueDeberiaTenerElMaterial, madera.durabilidadActualDelMaterial());
    }
}
