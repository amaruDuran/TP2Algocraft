package MaterialesTest;

import Herramientas.TipoDeHerramienta.MaterialDeHerramientas.MaterialDeHerramientaMadera;
import Herramientas.TipoDeHerramienta.MaterialDeHerramientas.MaterialDeHerramientaMetal;
import Herramientas.TipoDeHerramienta.MaterialDeHerramientas.MaterialDeHerramientaMetalPiedra;
import Herramientas.TipoDeHerramienta.MaterialDeHerramientas.MaterialDeHerramientaPiedra;
import Herramientas.TipoDeHerramienta.TipoDeHerramientaHacha;
import Herramientas.TipoDeHerramienta.TipoDeHerramientaPico;
import Herramientas.TipoDeHerramienta.TipoDeHerramientaPicoFino;
import Materiales.Material;
import Materiales.MaterialDiamante;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class MaterialDiamanteTest {
    @Test
    public void seIntentaRecolesctarDiamanteElProcesoFallaConTodoTipoDeHachaYNoDisminuyeSuDurabilidad(){
        TipoDeHerramientaHacha hachaDeMadera = new TipoDeHerramientaHacha(new MaterialDeHerramientaMadera());
        TipoDeHerramientaHacha hachaDePiedra = new TipoDeHerramientaHacha(new MaterialDeHerramientaPiedra());
        TipoDeHerramientaHacha hachaDeMetal = new TipoDeHerramientaHacha(new MaterialDeHerramientaMetal());
        Material diamante = new MaterialDiamante();
        int durabilidadInicial = diamante.durabilidadActualDelMaterial();
        diamante.recolectadoPorHacha(hachaDeMadera);
        diamante.recolectadoPorHacha(hachaDePiedra);
        diamante.recolectadoPorHacha(hachaDeMetal);
        assertEquals(durabilidadInicial, diamante.durabilidadActualDelMaterial());
    }
    @Test
    public void seIntentaRecolesctarDiamanteElProcesoFallaConTodoTipoDePicoYNoDisminuyeSuDurabilidad(){
        TipoDeHerramientaPico picoDeMadera = new TipoDeHerramientaPico(new MaterialDeHerramientaMadera());
        TipoDeHerramientaPico picoDePiedra = new TipoDeHerramientaPico(new MaterialDeHerramientaPiedra());
        TipoDeHerramientaPico picoDeMetal = new TipoDeHerramientaPico(new MaterialDeHerramientaMetal());
        Material diamante = new MaterialDiamante();
        int durabilidadInicial = diamante.durabilidadActualDelMaterial();
        diamante.recolectadoPorPico(picoDeMadera);
        diamante.recolectadoPorPico(picoDePiedra);
        diamante.recolectadoPorPico(picoDeMetal);
        assertEquals(durabilidadInicial, diamante.durabilidadActualDelMaterial());
    }
    @Test
    public void seIntentaRecolesctarDiamanteConUnPicoFinoElCualDesgastaElMaterial(){
        TipoDeHerramientaPicoFino picoFino = new TipoDeHerramientaPicoFino(new MaterialDeHerramientaMetalPiedra());
        Material diamante = new MaterialDiamante();
        int durabilidadInicial = diamante.durabilidadActualDelMaterial();
        diamante.recolectadoPorPicoFino(picoFino);
        int durabilidadQueDeberiaTenerElMaterial = (durabilidadInicial - picoFino.fuerza());
        assertEquals(durabilidadQueDeberiaTenerElMaterial , diamante.durabilidadActualDelMaterial());
    }
    //en los cassos que funciona deben hacerlo varias veces
    @Test
    public void seIntentaRecolesctarRepetidasVecesDiamanteConUnPicoFinoElCualDesgastaElMaterialTodasLasVeces(){
        TipoDeHerramientaPicoFino picoFino = new TipoDeHerramientaPicoFino(new MaterialDeHerramientaMetalPiedra());
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
