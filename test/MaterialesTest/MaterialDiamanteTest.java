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
        diamante.recolectadoPor(hachaDeMadera);
        diamante.recolectadoPor(hachaDePiedra);
        diamante.recolectadoPor(hachaDeMetal);
        assertEquals(durabilidadInicial, diamante.durabilidadActualDelMaterial());
    }
    @Test
    public void seIntentaRecolesctarDiamanteElProcesoFallaConTodoTipoDePicoYNoDisminuyeSuDurabilidad(){
        Pico picoDeMadera = new Pico(new MaterialDeHerramientaMadera());
        Pico picoDePiedra = new Pico(new MaterialDeHerramientaPiedra());
        Pico picoDeMetal = new Pico(new MaterialDeHerramientaMetal());
        Material diamante = new MaterialDiamante();
        int durabilidadInicial = diamante.durabilidadActualDelMaterial();
        diamante.recolectadoPor(picoDeMadera);
        diamante.recolectadoPor(picoDePiedra);
        diamante.recolectadoPor(picoDeMetal);
        assertEquals(durabilidadInicial, diamante.durabilidadActualDelMaterial());
    }
    @Test
    public void seIntentaRecolesctarDiamanteConUnPicoFinoElCualDesgastaElMaterial(){
        PicoFino picoFino = new PicoFino(new MaterialDeHerramientaMetalPiedra());
        Material diamante = new MaterialDiamante();
        int durabilidadInicial = diamante.durabilidadActualDelMaterial();
        diamante.recolectadoPor(picoFino);
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
            diamante.recolectadoPor(picoFino);
        }
        assertEquals(durabilidadQueDeberiaTenerElMaterial , diamante.durabilidadActualDelMaterial());
    }
}
