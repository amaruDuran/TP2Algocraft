package HerramientaTest;
import Herramientas.TipoDeHerramienta.MaterialDeHerramientas.MaterialDeHerramienta;
import Herramientas.TipoDeHerramienta.TipoDeHerramienta;
import Herramientas.TipoDeHerramienta.TipoDeHerramientaPicoFino;
import Herramientas.TipoDeHerramienta.MaterialDeHerramientas.MaterialDeHerramientaMetalPiedra;
import Materiales.*;
import org.junit.Test;

import static org.junit.Assert.*;

public class TipoDeHerramientaTipoDeHerramientaPicoFinoTest {
    //test de atributo de herramienta
    @Test
    public void seVerificaQueUnPicoDeMaderaNuevaTengaDurabilidad1000YFuerza20(){
        MaterialDeHerramienta metalPiedra = new MaterialDeHerramientaMetalPiedra();
        TipoDeHerramienta picoFino = new TipoDeHerramientaPicoFino(metalPiedra);
        assertEquals(1000,picoFino.durabilidad());
        assertEquals(20,picoFino.fuerza());
    }
    //test de desgaste
    @Test
    public void laDurabilidadDeUnPicoFinoSeGastaReduciendoseEnUnaDecimaDeSuDurabilidadAnterior(){
        MaterialDeHerramienta metalPiedra = new MaterialDeHerramientaMetalPiedra();
        TipoDeHerramienta picoFino = new TipoDeHerramientaPicoFino(metalPiedra);
        Material material = new MaterialDiamante();
        int durabilidadInicial = picoFino.durabilidad();
        int durabilidadQueDeberiaTenerAlUsarseUnaVez = durabilidadInicial - (durabilidadInicial / 10);
        picoFino.usarLaHerramientaEn(material);
        assertEquals(durabilidadQueDeberiaTenerAlUsarseUnaVez,picoFino.durabilidad());
    }
    @Test
    public void laDurabilidadDeUnPicoFinoSeGastaReduciendoseEnUnaDecimaDeSuDurabilidadAnteriorCadaVezUsada(){
        MaterialDeHerramienta metalPiedra = new MaterialDeHerramientaMetalPiedra();
        TipoDeHerramienta picoFino = new TipoDeHerramientaPicoFino(metalPiedra);
        Material material = new MaterialDiamante();
        int durabilidadInicial = picoFino.durabilidad();
        int durabilidadQueDeberiaTenerAlUsarseUnaVez = durabilidadInicial;
        int vecesUsada = 8;

        for (int i = 0; i < vecesUsada; i++){
            durabilidadQueDeberiaTenerAlUsarseUnaVez = durabilidadQueDeberiaTenerAlUsarseUnaVez - (durabilidadQueDeberiaTenerAlUsarseUnaVez / 10);
            picoFino.usarLaHerramientaEn(material);
        }
        assertEquals(durabilidadQueDeberiaTenerAlUsarseUnaVez,picoFino.durabilidad());
    }
    @Test
    public void laDurabilidadDeUnPicoFinoNoSeReduceEnElMaterialMadera(){
        MaterialDeHerramienta metalPiedra = new MaterialDeHerramientaMetalPiedra();
        TipoDeHerramienta picoFino = new TipoDeHerramientaPicoFino(metalPiedra);
        Material materialMadera = new MaterialMadera();
        int durabilidadInicial;
        int diferenciaDeDurabilidadQueDeberiaTenerAlUsarseUnaVez;
        durabilidadInicial = picoFino.durabilidad();
        picoFino.usarLaHerramientaEn(materialMadera);
        diferenciaDeDurabilidadQueDeberiaTenerAlUsarseUnaVez = durabilidadInicial - picoFino.durabilidad();
        assertEquals(0,diferenciaDeDurabilidadQueDeberiaTenerAlUsarseUnaVez);
    }
    @Test
    public void laDurabilidadDeUnPicoFinoNoSeReduceEnElMaterialPiedra(){
        MaterialDeHerramienta metalPiedra = new MaterialDeHerramientaMetalPiedra();
        TipoDeHerramienta picoFino = new TipoDeHerramientaPicoFino(metalPiedra);
        Material materialPiedra = new MaterialPiedra();
        int durabilidadInicial;
        int diferenciaDeDurabilidadQueDeberiaTenerAlUsarseUnaVez;
        durabilidadInicial = picoFino.durabilidad();
        picoFino.usarLaHerramientaEn(materialPiedra);
        diferenciaDeDurabilidadQueDeberiaTenerAlUsarseUnaVez = durabilidadInicial - picoFino.durabilidad();
        assertEquals(0,diferenciaDeDurabilidadQueDeberiaTenerAlUsarseUnaVez);
    }
    @Test
    public void laDurabilidadDeUnPicoFinoNoSeReduceEnElMaterialMetal(){
        MaterialDeHerramienta metalPiedra = new MaterialDeHerramientaMetalPiedra();
        TipoDeHerramienta picoFino = new TipoDeHerramientaPicoFino(metalPiedra);
        Material materialMetal = new MaterialMetal();
        int durabilidadInicial;
        int diferenciaDeDurabilidadQueDeberiaTenerAlUsarseUnaVez;
        durabilidadInicial = picoFino.durabilidad();
        picoFino.usarLaHerramientaEn(materialMetal);
        diferenciaDeDurabilidadQueDeberiaTenerAlUsarseUnaVez = durabilidadInicial - picoFino.durabilidad();
        assertEquals(0,diferenciaDeDurabilidadQueDeberiaTenerAlUsarseUnaVez);
    }
    @Test
    public void laDurabilidadDeUnPicoFinoSiSeReduceEnElMaterialDiamante(){
        MaterialDeHerramienta metalPiedra = new MaterialDeHerramientaMetalPiedra();
        TipoDeHerramienta picoFino = new TipoDeHerramientaPicoFino(metalPiedra);
        Material materialDiamante = new MaterialDiamante();
        int durabilidadInicial;
        int diferenciaDeDurabilidadQueDeberiaTenerAlUsarseUnaVez;
        durabilidadInicial = picoFino.durabilidad();
        picoFino.usarLaHerramientaEn(materialDiamante);
        diferenciaDeDurabilidadQueDeberiaTenerAlUsarseUnaVez = durabilidadInicial - picoFino.durabilidad();
        assertNotEquals(0,diferenciaDeDurabilidadQueDeberiaTenerAlUsarseUnaVez);
    }
}
