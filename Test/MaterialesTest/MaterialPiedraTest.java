package MaterialesTest;

import Herramientas.TipoDeHerramienta.MaterialDeHerramientas.MaterialDeHerramientaMadera;
import Herramientas.TipoDeHerramienta.MaterialDeHerramientas.MaterialDeHerramientaMetal;
import Herramientas.TipoDeHerramienta.MaterialDeHerramientas.MaterialDeHerramientaMetalPiedra;
import Herramientas.TipoDeHerramienta.MaterialDeHerramientas.MaterialDeHerramientaPiedra;
import Herramientas.TipoDeHerramienta.TipoDeHerramientaHacha;
import Herramientas.TipoDeHerramienta.TipoDeHerramientaPico;
import Herramientas.TipoDeHerramienta.TipoDeHerramientaPicoFino;
import Materiales.Material;
import Materiales.MaterialPiedra;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class MaterialPiedraTest {
    @Test
    public void seIntentaRecolesctarPiedraElProcesoFallaConTodoTipoDeHachaYNoDisminuyeSuDurabilidad(){
        TipoDeHerramientaHacha hachaDeMadera = new TipoDeHerramientaHacha(new MaterialDeHerramientaMadera());
        TipoDeHerramientaHacha hachaDePiedra = new TipoDeHerramientaHacha(new MaterialDeHerramientaPiedra());
        TipoDeHerramientaHacha hachaDeMetal = new TipoDeHerramientaHacha(new MaterialDeHerramientaMetal());
        Material Piedra = new MaterialPiedra();
        int durabilidadInicial = Piedra.durabilidadActualDelMaterial();
        Piedra.recolectadoPorHacha(hachaDeMadera);
        Piedra.recolectadoPorHacha(hachaDePiedra);
        Piedra.recolectadoPorHacha(hachaDeMetal);
        assertEquals(durabilidadInicial, Piedra.durabilidadActualDelMaterial());
    }
    @Test
    public void seIntentaRecolesctarPiedraElProcesoConPicoDeMaderaYDisminuyeSuDurabilidadEnLaFuerzaDeLaHerramienta(){
        TipoDeHerramientaPico picoDeMadera = new TipoDeHerramientaPico(new MaterialDeHerramientaMadera());
        Material Piedra = new MaterialPiedra();
        int durabilidadInicial = Piedra.durabilidadActualDelMaterial();
        int durabilidadQueDeberiaTenerElMaterial = (durabilidadInicial - picoDeMadera.fuerza());
        Piedra.recolectadoPorPico(picoDeMadera);
        assertEquals(durabilidadQueDeberiaTenerElMaterial, Piedra.durabilidadActualDelMaterial());
    }
    @Test
    public void seIntentaRecolesctarPiedraElProcesoConPicoDePiedraYDisminuyeSuDurabilidadEnLaFuerzaDeLaHerramienta(){
        TipoDeHerramientaPico picoDePiedra = new TipoDeHerramientaPico(new MaterialDeHerramientaPiedra());
        Material Piedra = new MaterialPiedra();
        int durabilidadInicial = Piedra.durabilidadActualDelMaterial();
        int durabilidadQueDeberiaTenerElMaterial = (durabilidadInicial - picoDePiedra.fuerza());
        Piedra.recolectadoPorPico(picoDePiedra);
        assertEquals(durabilidadQueDeberiaTenerElMaterial, Piedra.durabilidadActualDelMaterial());
    }
    @Test
    public void seIntentaRecolesctarPiedraElProcesoCoPicoDeMetalDisminuyeSuDurabilidadEnLaFuerzaDeLaHerramienta(){
        TipoDeHerramientaPico picoDeMetal = new TipoDeHerramientaPico(new MaterialDeHerramientaMetal());
        Material Piedra = new MaterialPiedra();
        int durabilidadInicial = Piedra.durabilidadActualDelMaterial();
        int durabilidadQueDeberiaTenerElMaterial = (durabilidadInicial - picoDeMetal.fuerza());
        Piedra.recolectadoPorPico(picoDeMetal);
        assertEquals(durabilidadQueDeberiaTenerElMaterial, Piedra.durabilidadActualDelMaterial());
    }
    @Test//supuesto el pico fino no recolecta metal
    public void seIntentaRecolesctarPiedraConUnPicoFinoElProcesoFallaNoSeDesgastaElMaterial(){
        TipoDeHerramientaPicoFino picoFino = new TipoDeHerramientaPicoFino(new MaterialDeHerramientaMetalPiedra());
        Material Piedra = new MaterialPiedra();
        int durabilidadInicial = Piedra.durabilidadActualDelMaterial();
        Piedra.recolectadoPorPicoFino(picoFino);
        assertEquals(durabilidadInicial , Piedra.durabilidadActualDelMaterial());
    }
    //en los cassos que funciona deben hacerlo varias veces
   /* @Test
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
    }*/
    @Test
    public void seIntentaRecolectarPiedraRepetidasVecesElProcesoConPicoDeMaderaYDisminuyeSuDurabilidadEnLaFuerzaDeLaHerramientaTodasLasVeces(){
        TipoDeHerramientaPico picoDeMadera = new TipoDeHerramientaPico(new MaterialDeHerramientaMadera());
        Material Piedra = new MaterialPiedra();
        int durabilidadInicial = Piedra.durabilidadActualDelMaterial();
        int vecesRecolectado = 3;
        int durabilidadQueDeberiaTenerElMaterial = (durabilidadInicial - (picoDeMadera.fuerza() * vecesRecolectado));
        for (int i = 0; i < vecesRecolectado; i++){
            Piedra.recolectadoPorPico(picoDeMadera);
        }
        assertEquals(durabilidadQueDeberiaTenerElMaterial, Piedra.durabilidadActualDelMaterial());
    }
    @Test
    public void seIntentaRecolesctarPiedraRepetidasVecesElProcesoConPicoDePiedraYDisminuyeSuDurabilidadEnLaFuerzaDeLaHerramientaTodasLasVeces(){
        TipoDeHerramientaPico picoDePiedra = new TipoDeHerramientaPico(new MaterialDeHerramientaPiedra());
        Material Piedra = new MaterialPiedra();
        int durabilidadInicial = Piedra.durabilidadActualDelMaterial();
        int vecesRecolectado = 3;
        int durabilidadQueDeberiaTenerElMaterial = (durabilidadInicial - (picoDePiedra.fuerza() * vecesRecolectado));
        for (int i = 0; i < vecesRecolectado; i++){
            Piedra.recolectadoPorPico(picoDePiedra);
        }
        assertEquals(durabilidadQueDeberiaTenerElMaterial, Piedra.durabilidadActualDelMaterial());
    }
    @Test
    public void seIntentaRecolesctarPiedraRepetidasVecesElProcesoCoPicoDeMetalDisminuyeSuDurabilidadEnLaFuerzaDeLaHerramientaTodasLasVeces(){
        TipoDeHerramientaPico picoDeMetal = new TipoDeHerramientaPico(new MaterialDeHerramientaMetal());
        Material Piedra = new MaterialPiedra();
        int durabilidadInicial = Piedra.durabilidadActualDelMaterial();
        int vecesRecolectado = 3;
        int durabilidadQueDeberiaTenerElMaterial = (durabilidadInicial - (picoDeMetal.fuerza() * vecesRecolectado));
        for (int i = 0; i < vecesRecolectado; i++){
            Piedra.recolectadoPorPico(picoDeMetal);
        }
        assertEquals(durabilidadQueDeberiaTenerElMaterial, Piedra.durabilidadActualDelMaterial());
    }
}
