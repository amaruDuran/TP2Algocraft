package HerramientaTest;
import Herramientas.TipoDeHerramienta.MaterialDeHerramientas.MaterialDeHerramienta;
import Herramientas.TipoDeHerramienta.TipoDeHerramienta;
import Herramientas.TipoDeHerramienta.PicoFino;
import Herramientas.TipoDeHerramienta.MaterialDeHerramientas.MaterialDeHerramientaMetalPiedra;
import Materiales.*;
import org.junit.Test;

import static org.junit.Assert.*;

public class PicoFinoTest {
    //test de atributo de herramienta
    @Test
    public void seVerificaQueUnPicoDeMaderaNuevaTengaDurabilidad1000YFuerza20(){
        MaterialDeHerramienta metalPiedra = new MaterialDeHerramientaMetalPiedra();
        TipoDeHerramienta picoFino = new PicoFino(metalPiedra);
        assertEquals(1000,picoFino.durabilidad());
        assertEquals(20,picoFino.fuerza());
    }
    //test de desgaste
    @Test
    public void laDurabilidadDeUnPicoFinoSeGastaReduciendoseEnUnaDecimaDeSuDurabilidadAnterior(){
        MaterialDeHerramienta metalPiedra = new MaterialDeHerramientaMetalPiedra();
        TipoDeHerramienta picoFino = new PicoFino(metalPiedra);
        Material material = new MaterialDiamante();
        int durabilidadInicial = picoFino.durabilidad();
        int durabilidadQueDeberiaTenerAlUsarseUnaVez = durabilidadInicial - (durabilidadInicial / 10);
        picoFino.usarEn(material);
        assertEquals(durabilidadQueDeberiaTenerAlUsarseUnaVez,picoFino.durabilidad());
    }
    @Test
    public void laDurabilidadDeUnPicoFinoSeGastaReduciendoseEnUnaDecimaDeSuDurabilidadAnteriorCadaVezUsada(){
        MaterialDeHerramienta metalPiedra = new MaterialDeHerramientaMetalPiedra();
        TipoDeHerramienta picoFino = new PicoFino(metalPiedra);
        Material material = new MaterialDiamante();
        int durabilidadInicial = picoFino.durabilidad();
        int durabilidadQueDeberiaTenerAlUsarseUnaVez = durabilidadInicial;
        int vecesUsada = 8;

        for (int i = 0; i < vecesUsada; i++){
            durabilidadQueDeberiaTenerAlUsarseUnaVez = durabilidadQueDeberiaTenerAlUsarseUnaVez - (durabilidadQueDeberiaTenerAlUsarseUnaVez / 10);
            picoFino.usarEn(material);
        }
        assertEquals(durabilidadQueDeberiaTenerAlUsarseUnaVez,picoFino.durabilidad());
    }
    @Test
    public void laDurabilidadDeUnPicoFinoNoSeReduceEnElMaterialMadera(){
        MaterialDeHerramienta metalPiedra = new MaterialDeHerramientaMetalPiedra();
        TipoDeHerramienta picoFino = new PicoFino(metalPiedra);
        Material materialMadera = new MaterialMadera();
        int durabilidadInicial;
        int diferenciaDeDurabilidadQueDeberiaTenerAlUsarseUnaVez;
        durabilidadInicial = picoFino.durabilidad();
        picoFino.usarEn(materialMadera);
        diferenciaDeDurabilidadQueDeberiaTenerAlUsarseUnaVez = durabilidadInicial - picoFino.durabilidad();
        assertEquals(0,diferenciaDeDurabilidadQueDeberiaTenerAlUsarseUnaVez);
    }
    @Test
    public void laDurabilidadDeUnPicoFinoNoSeReduceEnElMaterialPiedra(){
        MaterialDeHerramienta metalPiedra = new MaterialDeHerramientaMetalPiedra();
        TipoDeHerramienta picoFino = new PicoFino(metalPiedra);
        Material materialPiedra = new MaterialPiedra();
        int durabilidadInicial;
        int diferenciaDeDurabilidadQueDeberiaTenerAlUsarseUnaVez;
        durabilidadInicial = picoFino.durabilidad();
        picoFino.usarEn(materialPiedra);
        diferenciaDeDurabilidadQueDeberiaTenerAlUsarseUnaVez = durabilidadInicial - picoFino.durabilidad();
        assertEquals(0,diferenciaDeDurabilidadQueDeberiaTenerAlUsarseUnaVez);
    }
    @Test
    public void laDurabilidadDeUnPicoFinoNoSeReduceEnElMaterialMetal(){
        MaterialDeHerramienta metalPiedra = new MaterialDeHerramientaMetalPiedra();
        TipoDeHerramienta picoFino = new PicoFino(metalPiedra);
        Material materialMetal = new MaterialMetal();
        int durabilidadInicial;
        int diferenciaDeDurabilidadQueDeberiaTenerAlUsarseUnaVez;
        durabilidadInicial = picoFino.durabilidad();
        picoFino.usarEn(materialMetal);
        diferenciaDeDurabilidadQueDeberiaTenerAlUsarseUnaVez = durabilidadInicial - picoFino.durabilidad();
        assertEquals(0,diferenciaDeDurabilidadQueDeberiaTenerAlUsarseUnaVez);
    }
    @Test
    public void laDurabilidadDeUnPicoFinoSiSeReduceEnElMaterialDiamante(){
        MaterialDeHerramienta metalPiedra = new MaterialDeHerramientaMetalPiedra();
        TipoDeHerramienta picoFino = new PicoFino(metalPiedra);
        Material materialDiamante = new MaterialDiamante();
        int durabilidadInicial;
        int diferenciaDeDurabilidadQueDeberiaTenerAlUsarseUnaVez;
        durabilidadInicial = picoFino.durabilidad();
        picoFino.usarEn(materialDiamante);
        diferenciaDeDurabilidadQueDeberiaTenerAlUsarseUnaVez = durabilidadInicial - picoFino.durabilidad();
        assertNotEquals(0,diferenciaDeDurabilidadQueDeberiaTenerAlUsarseUnaVez);
    }
    //desgaste de materiales
    @Test
    public void laDurabilidadDeUnMaterialDiamanteSeReducaConUnPicoFino(){
        MaterialDeHerramienta metalPiedra = new MaterialDeHerramientaMetalPiedra();
        TipoDeHerramienta picoFino = new PicoFino(metalPiedra);
        Material materialDiamante = new MaterialDiamante();
        int durabilidadInicial;
        durabilidadInicial = materialDiamante.durabilidadActualDelMaterial();
        picoFino.usarEn(materialDiamante);
        assertNotEquals(durabilidadInicial,materialDiamante.durabilidadActualDelMaterial());
    }
}
