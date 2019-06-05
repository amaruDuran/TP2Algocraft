package MaterialesTest;

import Herramientas.TipoDeHerramienta.Hacha;
import Herramientas.TipoDeHerramienta.MaterialDeHerramientas.MaterialDeHerramientaMadera;
import Herramientas.TipoDeHerramienta.MaterialDeHerramientas.MaterialDeHerramientaMetal;
import Herramientas.TipoDeHerramienta.MaterialDeHerramientas.MaterialDeHerramientaMetalPiedra;
import Herramientas.TipoDeHerramienta.MaterialDeHerramientas.MaterialDeHerramientaPiedra;
import Herramientas.TipoDeHerramienta.Pico;
import Herramientas.TipoDeHerramienta.PicoFino;
import Materiales.Material;
import Materiales.MaterialDiamante;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class MaterialDiamanteTest {
    @Test
    public void seIntentaRecolesctarDiamanteElProcesoFallaConTodoTipoDeHachaYNoDisminuyeSuDurabilidad(){
        Hacha hachaDeMadera = new Hacha(new MaterialDeHerramientaMadera());
        Hacha hachaDePiedra = new Hacha(new MaterialDeHerramientaPiedra());
        Hacha hachaDeMetal = new Hacha(new MaterialDeHerramientaMetal());
        Material diamante = new MaterialDiamante();
        int durabilidadInicial = diamante.durabilidadActualDelMaterial();
        diamante.recolectadoPorHacha(hachaDeMadera);
        diamante.recolectadoPorHacha(hachaDePiedra);
        diamante.recolectadoPorHacha(hachaDeMetal);
        assertEquals(durabilidadInicial, diamante.durabilidadActualDelMaterial());
    }
    @Test
    public void seIntentaRecolesctarDiamanteElProcesoFallaConTodoTipoDePicoYNoDisminuyeSuDurabilidad(){
        Pico picoDeMadera = new Pico(new MaterialDeHerramientaMadera());
        Pico picoDePiedra = new Pico(new MaterialDeHerramientaPiedra());
        Pico picoDeMetal = new Pico(new MaterialDeHerramientaMetal());
        Material diamante = new MaterialDiamante();
        int durabilidadInicial = diamante.durabilidadActualDelMaterial();
        diamante.recolectadoPorPico(picoDeMadera);
        diamante.recolectadoPorPico(picoDePiedra);
        diamante.recolectadoPorPico(picoDeMetal);
        assertEquals(durabilidadInicial, diamante.durabilidadActualDelMaterial());
    }
    @Test
    public void seIntentaRecolesctarDiamanteConUnPicoFinoElCualDesgastaElMaterial(){
        PicoFino picoFino = new PicoFino(new MaterialDeHerramientaMetalPiedra());
        Material diamante = new MaterialDiamante();
        int durabilidadInicial = diamante.durabilidadActualDelMaterial();
        diamante.recolectadoPorPicoFino(picoFino);
        int durabilidadQueDeberiaTenerElMaterial = (durabilidadInicial - picoFino.fuerza());
        assertEquals(durabilidadQueDeberiaTenerElMaterial , diamante.durabilidadActualDelMaterial());
    }
    //en los cassos que funciona deben hacerlo varias veces
    @Test
    public void seIntentaRecolesctarRepetidasVecesDiamanteConUnPicoFinoElCualDesgastaElMaterialTodasLasVeces(){
        PicoFino picoFino = new PicoFino(new MaterialDeHerramientaMetalPiedra());
        Material diamante = new MaterialDiamante();
        int durabilidadInicial = diamante.durabilidadActualDelMaterial();
        int vecesRecolectado = 3;
        int durabilidadQueDeberiaTenerElMaterial = (durabilidadInicial - (picoFino.fuerza() * vecesRecolectado));
        for (int i = 0; i < vecesRecolectado; i++){
            diamante.recolectadoPorPicoFino(picoFino);
        }
        assertEquals(durabilidadQueDeberiaTenerElMaterial , diamante.durabilidadActualDelMaterial());
    }
}
