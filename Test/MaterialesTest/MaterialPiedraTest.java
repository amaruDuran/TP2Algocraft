package MaterialesTest;

import Herramientas.TipoDeHerramienta.Hacha;
import Herramientas.TipoDeHerramienta.MaterialDeHerramientas.MaterialDeHerramientaMadera;
import Herramientas.TipoDeHerramienta.MaterialDeHerramientas.MaterialDeHerramientaMetal;
import Herramientas.TipoDeHerramienta.MaterialDeHerramientas.MaterialDeHerramientaMetalPiedra;
import Herramientas.TipoDeHerramienta.MaterialDeHerramientas.MaterialDeHerramientaPiedra;
import Herramientas.TipoDeHerramienta.Pico;
import Herramientas.TipoDeHerramienta.PicoFino;
import Materiales.Material;
import Materiales.MaterialPiedra;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class MaterialPiedraTest {
    @Test
    public void seIntentaRecolesctarPiedraElProcesoFallaConTodoTipoDeHachaYNoDisminuyeSuDurabilidad(){
        Hacha hachaDeMadera = new Hacha(new MaterialDeHerramientaMadera());
        Hacha hachaDePiedra = new Hacha(new MaterialDeHerramientaPiedra());
        Hacha hachaDeMetal = new Hacha(new MaterialDeHerramientaMetal());
        Material Piedra = new MaterialPiedra();
        int durabilidadInicial = Piedra.durabilidadActualDelMaterial();
        Piedra.recolectadoPorHacha(hachaDeMadera);
        Piedra.recolectadoPorHacha(hachaDePiedra);
        Piedra.recolectadoPorHacha(hachaDeMetal);
        assertEquals(durabilidadInicial, Piedra.durabilidadActualDelMaterial());
    }
    @Test
    public void seIntentaRecolesctarPiedraElProcesoConPicoDeMaderaYDisminuyeSuDurabilidadEnLaFuerzaDeLaHerramienta(){
        Pico picoDeMadera = new Pico(new MaterialDeHerramientaMadera());
        Material Piedra = new MaterialPiedra();
        int durabilidadInicial = Piedra.durabilidadActualDelMaterial();
        int durabilidadQueDeberiaTenerElMaterial = (durabilidadInicial - picoDeMadera.fuerza());
        Piedra.recolectadoPorPico(picoDeMadera);
        assertEquals(durabilidadQueDeberiaTenerElMaterial, Piedra.durabilidadActualDelMaterial());
    }
    @Test
    public void seIntentaRecolesctarPiedraElProcesoConPicoDePiedraYDisminuyeSuDurabilidadEnLaFuerzaDeLaHerramienta(){
        Pico picoDePiedra = new Pico(new MaterialDeHerramientaPiedra());
        Material Piedra = new MaterialPiedra();
        int durabilidadInicial = Piedra.durabilidadActualDelMaterial();
        int durabilidadQueDeberiaTenerElMaterial = (durabilidadInicial - picoDePiedra.fuerza());
        Piedra.recolectadoPorPico(picoDePiedra);
        assertEquals(durabilidadQueDeberiaTenerElMaterial, Piedra.durabilidadActualDelMaterial());
    }
    @Test
    public void seIntentaRecolesctarPiedraElProcesoCoPicoDeMetalDisminuyeSuDurabilidadEnLaFuerzaDeLaHerramienta(){
        Pico picoDeMetal = new Pico(new MaterialDeHerramientaMetal());
        Material Piedra = new MaterialPiedra();
        int durabilidadInicial = Piedra.durabilidadActualDelMaterial();
        int durabilidadQueDeberiaTenerElMaterial = (durabilidadInicial - picoDeMetal.fuerza());
        Piedra.recolectadoPorPico(picoDeMetal);
        assertEquals(durabilidadQueDeberiaTenerElMaterial, Piedra.durabilidadActualDelMaterial());
    }
    @Test//supuesto el pico fino no recolecta metal
    public void seIntentaRecolesctarPiedraConUnPicoFinoElProcesoFallaNoSeDesgastaElMaterial(){
        PicoFino picoFino = new PicoFino(new MaterialDeHerramientaMetalPiedra());
        Material Piedra = new MaterialPiedra();
        int durabilidadInicial = Piedra.durabilidadActualDelMaterial();
        Piedra.recolectadoPorPicoFino(picoFino);
        assertEquals(durabilidadInicial , Piedra.durabilidadActualDelMaterial());
    }
    //en los cassos que funciona deben hacerlo varias veces
   /* @Test
    public void seIntentaRecolectarRepetidasVecesMaderaConHachaDeMaderaYDisminuyeSuDurabilidadLaFuerzaDeLaHerramientaTodasLasVeces(){
        Hacha hachaDeMadera = new Hacha(new MaterialDeHerramientaMadera());
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
        Pico picoDeMadera = new Pico(new MaterialDeHerramientaMadera());
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
        Pico picoDePiedra = new Pico(new MaterialDeHerramientaPiedra());
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
        Pico picoDeMetal = new Pico(new MaterialDeHerramientaMetal());
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
