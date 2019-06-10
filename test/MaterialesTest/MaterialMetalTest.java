package MaterialesTest;

import Herramientas.TipoDeHerramienta.Hacha;
import Herramientas.TipoDeHerramienta.MaterialDeHerramientas.MaterialDeHerramientaMadera;
import Herramientas.TipoDeHerramienta.MaterialDeHerramientas.MaterialDeHerramientaMetal;
import Herramientas.TipoDeHerramienta.MaterialDeHerramientas.MaterialDeHerramientaMetalPiedra;
import Herramientas.TipoDeHerramienta.MaterialDeHerramientas.MaterialDeHerramientaPiedra;
import Herramientas.TipoDeHerramienta.Pico;
import Herramientas.TipoDeHerramienta.PicoFino;
import Materiales.Material;
import Materiales.MaterialMetal;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class MaterialMetalTest {
    @Test
    public void seIntentaRecolesctarMetalElProcesoFallaConTodoTipoDeHachaYNoDisminuyeSuDurabilidad(){
        Hacha hachaDeMadera = new Hacha(new MaterialDeHerramientaMadera());
        Hacha hachaDePiedra = new Hacha(new MaterialDeHerramientaPiedra());
        Hacha hachaDeMetal = new Hacha(new MaterialDeHerramientaMetal());
        Material metal = new MaterialMetal();
        int durabilidadInicial = metal.durabilidadActualDelMaterial();

        metal.recolectadoPor(hachaDeMadera);
        metal.recolectadoPor(hachaDePiedra);
        metal.recolectadoPor(hachaDeMetal);

        assertEquals(durabilidadInicial, metal.durabilidadActualDelMaterial());
    }
    @Test
    public void seIntentaRecolesctarMetalElProcesoFallaConPicoDeMaderaNoDisminuyeSuDurabilidad(){
        Pico picoDeMadera = new Pico(new MaterialDeHerramientaMadera());
        Material metal = new MaterialMetal();
        int durabilidadInicial = metal.durabilidadActualDelMaterial();

        metal.recolectadoPor(picoDeMadera);

        assertEquals(durabilidadInicial, metal.durabilidadActualDelMaterial());
    }
    @Test
    public void seIntentaRecolesctarMetalElProcesoConPicoDePiedraYDisminuyeSuDurabilidadEnLaFuerzaDeLaHerramienta(){
        Pico picoDePiedra = new Pico(new MaterialDeHerramientaPiedra());
        Material metal = new MaterialMetal();
        int durabilidadInicial = metal.durabilidadActualDelMaterial();
        int durabilidadQueDeberiaTenerElMaterial = (durabilidadInicial - picoDePiedra.fuerza());

        metal.recolectadoPor(picoDePiedra);

        assertEquals(durabilidadQueDeberiaTenerElMaterial, metal.durabilidadActualDelMaterial());
    }
    @Test
    public void seIntentaRecolesctarMetalElProcesoCoPicoDeMetalDisminuyeSuDurabilidadEnLaFuerzaDeLaHerramienta(){
        Pico picoDeMetal = new Pico(new MaterialDeHerramientaMetal());
        Material metal = new MaterialMetal();
        int durabilidadInicial = metal.durabilidadActualDelMaterial();
        int durabilidadQueDeberiaTenerElMaterial = (durabilidadInicial - picoDeMetal.fuerza());

        metal.recolectadoPor(picoDeMetal);

        assertEquals(durabilidadQueDeberiaTenerElMaterial, metal.durabilidadActualDelMaterial());
    }
    @Test//supuesto el pico fino no recolecta metal
    public void seIntentaRecolesctarMetalConUnPicoFinoElProcesoFallaNoSeDesgastaElMaterial(){
        PicoFino picoFino = new PicoFino(new MaterialDeHerramientaMetalPiedra());
        Material metal = new MaterialMetal();
        int durabilidadInicial = metal.durabilidadActualDelMaterial();

        metal.recolectadoPor(picoFino);

        assertEquals(durabilidadInicial , metal.durabilidadActualDelMaterial());
    }
    //en los cassos que funciona deben hacerlo varias veces
    @Test
    public void seIntentaRecolesctarRepetidasVecesMetalElProcesoConPicoDePiedraYDisminuyeSuDurabilidadEnLaFuerzaDeLaHerramientaTodasLasVeces(){
        Pico picoDePiedra = new Pico(new MaterialDeHerramientaPiedra());
        Material metal = new MaterialMetal();
        int durabilidadInicial = metal.durabilidadActualDelMaterial();
        int vecesRecolectado = 8;
        int durabilidadQueDeberiaTenerElMaterial = (durabilidadInicial - (picoDePiedra.fuerza() * vecesRecolectado));

        for (int i = 0; i < vecesRecolectado; i++){
            metal.recolectadoPor(picoDePiedra);
        }

        assertEquals(durabilidadQueDeberiaTenerElMaterial, metal.durabilidadActualDelMaterial());
    }
    @Test
    public void seIntentaRecolesctarRepetidasVecesMetalElProcesoCoPicoDeMetalDisminuyeSuDurabilidadEnLaFuerzaDeLaHerramientaTodasLasVeces(){
        Pico picoDeMetal = new Pico(new MaterialDeHerramientaMetal());
        Material metal = new MaterialMetal();
        int durabilidadInicial = metal.durabilidadActualDelMaterial();
        int vecesRecolectado = 3;
        int durabilidadQueDeberiaTenerElMaterial = (durabilidadInicial - (picoDeMetal.fuerza() * vecesRecolectado));

        for (int i = 0; i < vecesRecolectado; i++){
            metal.recolectadoPor(picoDeMetal);
        }

        assertEquals(durabilidadQueDeberiaTenerElMaterial, metal.durabilidadActualDelMaterial());
    }
}
