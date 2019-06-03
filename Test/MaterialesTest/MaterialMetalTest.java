package MaterialesTest;

import Herramientas.TipoDeHerramienta.MaterialDeHerramientas.MaterialDeHerramientaMadera;
import Herramientas.TipoDeHerramienta.MaterialDeHerramientas.MaterialDeHerramientaMetal;
import Herramientas.TipoDeHerramienta.MaterialDeHerramientas.MaterialDeHerramientaMetalPiedra;
import Herramientas.TipoDeHerramienta.MaterialDeHerramientas.MaterialDeHerramientaPiedra;
import Herramientas.TipoDeHerramienta.TipoDeHerramientaHacha;
import Herramientas.TipoDeHerramienta.TipoDeHerramientaPico;
import Herramientas.TipoDeHerramienta.TipoDeHerramientaPicoFino;
import Materiales.Material;
import Materiales.MaterialMetal;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class MaterialMetalTest {
    @Test
    public void seIntentaRecolesctarMetalElProcesoFallaConTodoTipoDeHachaYNoDisminuyeSuDurabilidad(){
        TipoDeHerramientaHacha hachaDeMadera = new TipoDeHerramientaHacha(new MaterialDeHerramientaMadera());
        TipoDeHerramientaHacha hachaDePiedra = new TipoDeHerramientaHacha(new MaterialDeHerramientaPiedra());
        TipoDeHerramientaHacha hachaDeMetal = new TipoDeHerramientaHacha(new MaterialDeHerramientaMetal());
        Material metal = new MaterialMetal();
        int durabilidadInicial = metal.durabilidadActualDelMaterial();
        metal.recolectadoPorHacha(hachaDeMadera);
        metal.recolectadoPorHacha(hachaDePiedra);
        metal.recolectadoPorHacha(hachaDeMetal);
        assertEquals(durabilidadInicial, metal.durabilidadActualDelMaterial());
    }
    @Test
    public void seIntentaRecolesctarMetalElProcesoFallaConPicoDeMaderaNoDisminuyeSuDurabilidad(){
        TipoDeHerramientaPico picoDeMadera = new TipoDeHerramientaPico(new MaterialDeHerramientaMadera());
        Material metal = new MaterialMetal();
        int durabilidadInicial = metal.durabilidadActualDelMaterial();
        metal.recolectadoPorPico(picoDeMadera);
        assertEquals(durabilidadInicial, metal.durabilidadActualDelMaterial());
    }
    @Test
    public void seIntentaRecolesctarMetalElProcesoConPicoDePiedraYDisminuyeSuDurabilidadEnLaFuerzaDeLaHerramienta(){
        TipoDeHerramientaPico picoDePiedra = new TipoDeHerramientaPico(new MaterialDeHerramientaPiedra());
        Material metal = new MaterialMetal();
        int durabilidadInicial = metal.durabilidadActualDelMaterial();
        int durabilidadQueDeberiaTenerElMaterial = (durabilidadInicial - picoDePiedra.fuerza());
        metal.recolectadoPorPico(picoDePiedra);
        assertEquals(durabilidadQueDeberiaTenerElMaterial, metal.durabilidadActualDelMaterial());
    }
    @Test
    public void seIntentaRecolesctarMetalElProcesoCoPicoDeMetalDisminuyeSuDurabilidadEnLaFuerzaDeLaHerramienta(){
        TipoDeHerramientaPico picoDeMetal = new TipoDeHerramientaPico(new MaterialDeHerramientaMetal());
        Material metal = new MaterialMetal();
        int durabilidadInicial = metal.durabilidadActualDelMaterial();
        int durabilidadQueDeberiaTenerElMaterial = (durabilidadInicial - picoDeMetal.fuerza());
        metal.recolectadoPorPico(picoDeMetal);
        assertEquals(durabilidadQueDeberiaTenerElMaterial, metal.durabilidadActualDelMaterial());
    }
    @Test//supuesto el pico fino no recolecta metal
    public void seIntentaRecolesctarMetalConUnPicoFinoElProcesoFallaNoSeDesgastaElMaterial(){
        TipoDeHerramientaPicoFino picoFino = new TipoDeHerramientaPicoFino(new MaterialDeHerramientaMetalPiedra());
        Material metal = new MaterialMetal();
        int durabilidadInicial = metal.durabilidadActualDelMaterial();
        metal.recolectadoPorPicoFino(picoFino);
        assertEquals(durabilidadInicial , metal.durabilidadActualDelMaterial());
    }
    //en los cassos que funciona deben hacerlo varias veces
    @Test
    public void seIntentaRecolesctarRepetidasVecesMetalElProcesoConPicoDePiedraYDisminuyeSuDurabilidadEnLaFuerzaDeLaHerramientaTodasLasVeces(){
        TipoDeHerramientaPico picoDePiedra = new TipoDeHerramientaPico(new MaterialDeHerramientaPiedra());
        Material metal = new MaterialMetal();
        int durabilidadInicial = metal.durabilidadActualDelMaterial();
        int vecesRecolectado = 8;
        int durabilidadQueDeberiaTenerElMaterial = (durabilidadInicial - (picoDePiedra.fuerza() * vecesRecolectado));
        for (int i = 0; i < vecesRecolectado; i++){
            metal.recolectadoPorPico(picoDePiedra);
        }
        assertEquals(durabilidadQueDeberiaTenerElMaterial, metal.durabilidadActualDelMaterial());
    }
    @Test
    public void seIntentaRecolesctarRepetidasVecesMetalElProcesoCoPicoDeMetalDisminuyeSuDurabilidadEnLaFuerzaDeLaHerramientaTodasLasVeces(){
        TipoDeHerramientaPico picoDeMetal = new TipoDeHerramientaPico(new MaterialDeHerramientaMetal());
        Material metal = new MaterialMetal();
        int durabilidadInicial = metal.durabilidadActualDelMaterial();
        int vecesRecolectado = 3;
        int durabilidadQueDeberiaTenerElMaterial = (durabilidadInicial - (picoDeMetal.fuerza() * vecesRecolectado));
        for (int i = 0; i < vecesRecolectado; i++){
            metal.recolectadoPorPico(picoDeMetal);
        }
        assertEquals(durabilidadQueDeberiaTenerElMaterial, metal.durabilidadActualDelMaterial());
    }
}
