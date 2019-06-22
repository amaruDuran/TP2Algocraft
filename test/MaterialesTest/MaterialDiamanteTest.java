package MaterialesTest;

import Modelo.Herramientas.TipoDeHerramienta.Hacha;
import Modelo.Herramientas.TipoDeHerramienta.MaterialDeHerramientas.MaterialDeHerramientaMadera;
import Modelo.Herramientas.TipoDeHerramienta.MaterialDeHerramientas.MaterialDeHerramientaMetal;
import Modelo.Herramientas.TipoDeHerramienta.MaterialDeHerramientas.MaterialDeHerramientaMetalPiedra;
import Modelo.Herramientas.TipoDeHerramienta.MaterialDeHerramientas.MaterialDeHerramientaPiedra;
import Modelo.Herramientas.TipoDeHerramienta.Pico;
import Modelo.Herramientas.TipoDeHerramienta.PicoFino;
import Modelo.Materiales.Material;
import Modelo.Materiales.MaterialDiamante;
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
        int durabilidadQueDeberiaTenerElMaterial = (durabilidadInicial - picoFino.fuerza());

        diamante.recolectadoPor(picoFino);

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
