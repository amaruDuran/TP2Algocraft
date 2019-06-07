package HerramientaTest;

import Herramientas.TipoDeHerramienta.MaterialDeHerramientas.MaterialDeHerramienta;
import Herramientas.TipoDeHerramienta.TipoDeHerramienta;
import Herramientas.TipoDeHerramienta.Pico;
import Herramientas.TipoDeHerramienta.MaterialDeHerramientas.MaterialDeHerramientaMadera;
import Herramientas.TipoDeHerramienta.MaterialDeHerramientas.MaterialDeHerramientaMetal;
import Herramientas.TipoDeHerramienta.MaterialDeHerramientas.MaterialDeHerramientaPiedra;
import Materiales.*;
import org.junit.Test;
import static org.junit.Assert.*;

public class PicoTest {
    //test de atributo de herramienta
    @Test
    public void seVerificaQueUnPicoDeMaderaNuevaTengaDurabilidad100YFuerza2(){
        MaterialDeHerramienta madera = new MaterialDeHerramientaMadera();
        TipoDeHerramienta pico = new Pico(madera);
        assertEquals(100,pico.durabilidad());
        assertEquals(2,pico.fuerza());
    }
    @Test
    public void seVerificaQueUnPicoDePiedraNuevaTengaDurabilidad200YFuerza4(){
        MaterialDeHerramienta piedra = new MaterialDeHerramientaPiedra();
        TipoDeHerramienta pico = new Pico(piedra);
        assertEquals(200,pico.durabilidad());
        assertEquals(4,pico.fuerza());
    }
    @Test
    public void seVerificaQueUnPicoDeMetalNuevaTengaDurabilidad400YFuerza12(){
        MaterialDeHerramienta metal = new MaterialDeHerramientaMetal();
        TipoDeHerramienta pico = new Pico(metal);
        assertEquals(400,pico.durabilidad());
        assertEquals(12,pico.fuerza());
    }

    //test de desgaste
    //pico de madera
    @Test
    public void laDurabilidadDeUnPicoDeMaderaSeGastaReduciendoseEnSuFuerzaConElUso(){
        MaterialDeHerramienta madera = new MaterialDeHerramientaMadera();
        TipoDeHerramienta pico = new Pico(madera);
        Material material = new MaterialPiedra();
        int durabilidadInicial = pico.durabilidad();
        int durabilidadQueDeberiaTenerAlUsarseUnaVez = durabilidadInicial - pico.fuerza();
        pico.usarEn(material);
        assertEquals(durabilidadQueDeberiaTenerAlUsarseUnaVez,pico.durabilidad());
    }
    @Test
    public void laDurabilidadDeUnPicoDeMaderaSeGastaReduciendoseEnSuFuerzaConCadaUso(){
        MaterialDeHerramienta madera = new MaterialDeHerramientaMadera();
        TipoDeHerramienta pico = new Pico(madera);
        Material material = new MaterialPiedra();
        int durabilidadInicial = pico.durabilidad();
        int vecesUsada = 8;
        int durabilidadQueDeberiaTenerAlUsarseUnaVez = durabilidadInicial - (pico.fuerza() * vecesUsada);
        for (int i = 0; i < vecesUsada; i++){
            pico.usarEn(material);
        }
        assertEquals(durabilidadQueDeberiaTenerAlUsarseUnaVez,pico.durabilidad());
    }
    @Test
    public void laDurabilidadDeUnPicoDeMaderaSeReduceEnElMaterialMadera(){
        MaterialDeHerramienta madera = new MaterialDeHerramientaMadera();
        TipoDeHerramienta pico = new Pico(madera);
        Material materialMadera = new MaterialMadera();
        int durabilidadInicial;
        int diferenciaDeDurabilidadQueDeberiaTenerAlUsarseUnaVez;
        durabilidadInicial = pico.durabilidad();
        pico.usarEn(materialMadera);
        diferenciaDeDurabilidadQueDeberiaTenerAlUsarseUnaVez = durabilidadInicial - pico.durabilidad();
        assertNotEquals(0,diferenciaDeDurabilidadQueDeberiaTenerAlUsarseUnaVez);
    }
    @Test
    public void laDurabilidadDeUnPicoDeMaderaSeReduceEnElMaterialPiedra(){
        MaterialDeHerramienta madera = new MaterialDeHerramientaMadera();
        TipoDeHerramienta pico = new Pico(madera);
        Material materialPiedra = new MaterialPiedra();
        int durabilidadInicial;
        int diferenciaDeDurabilidadQueDeberiaTenerAlUsarseUnaVez;
        durabilidadInicial = pico.durabilidad();
        pico.usarEn(materialPiedra);
        diferenciaDeDurabilidadQueDeberiaTenerAlUsarseUnaVez = durabilidadInicial - pico.durabilidad();
        assertNotEquals(0,diferenciaDeDurabilidadQueDeberiaTenerAlUsarseUnaVez);
    }
    @Test
    public void laDurabilidadDeUnPicoDeMaderaSeReduceEnElMaterialMetal(){
        MaterialDeHerramienta madera = new MaterialDeHerramientaMadera();
        TipoDeHerramienta pico = new Pico(madera);
        Material materialMetal = new MaterialMetal();
        int durabilidadInicial;
        int diferenciaDeDurabilidadQueDeberiaTenerAlUsarseUnaVez;
        durabilidadInicial = pico.durabilidad();
        pico.usarEn(materialMetal);
        diferenciaDeDurabilidadQueDeberiaTenerAlUsarseUnaVez = durabilidadInicial - pico.durabilidad();
        assertNotEquals(0,diferenciaDeDurabilidadQueDeberiaTenerAlUsarseUnaVez);
    }
    @Test
    public void laDurabilidadDeUnPicoDeMaderaSeReduceEnElMaterialDiamante(){
        MaterialDeHerramienta madera = new MaterialDeHerramientaMadera();
        TipoDeHerramienta pico = new Pico(madera);
        Material materialDiamante = new MaterialDiamante();
        int durabilidadInicial;
        int diferenciaDeDurabilidadQueDeberiaTenerAlUsarseUnaVez;
        durabilidadInicial = pico.durabilidad();
        pico.usarEn(materialDiamante);
        diferenciaDeDurabilidadQueDeberiaTenerAlUsarseUnaVez = durabilidadInicial - pico.durabilidad();
        assertNotEquals(0,diferenciaDeDurabilidadQueDeberiaTenerAlUsarseUnaVez);
    }
    //pico de piedra
    @Test
    public void laDurabilidadDeUnPicoDePiedraSeGastaReduciendoseEnDosTerciosDeSuFuerzaConElUso(){
        MaterialDeHerramienta piedra = new MaterialDeHerramientaPiedra();
        TipoDeHerramienta pico = new Pico(piedra);
        Material material = new MaterialPiedra();
        int durabilidadInicial = pico.durabilidad();
        int durabilidadQueDeberiaTenerAlUsarseUnaVez = durabilidadInicial - ((pico.fuerza() * 2) / 3);
        pico.usarEn(material);
        assertEquals(durabilidadQueDeberiaTenerAlUsarseUnaVez,pico.durabilidad());
    }
    @Test
    public void laDurabilidadDeUnPicoDePiedraSeGastaReduciendoseEnDosTerciosDeSuFuerzaConCadaUso(){
        MaterialDeHerramienta piedra = new MaterialDeHerramientaPiedra();
        TipoDeHerramienta pico = new Pico(piedra);
        Material material = new MaterialPiedra();
        int durabilidadInicial = pico.durabilidad();
        int vecesUsada = 8;
        int durabilidadQueDeberiaTenerAlUsarseUnaVez = durabilidadInicial - (((pico.fuerza() * 2) / 3) * vecesUsada);
        for (int i = 0; i < vecesUsada; i++){
            pico.usarEn(material);
        }
        assertEquals(durabilidadQueDeberiaTenerAlUsarseUnaVez,pico.durabilidad());
    }
    @Test
    public void laDurabilidadDeUnPicoDePiedraSeReduceEnElMaterialMadera(){
        MaterialDeHerramienta piedra = new MaterialDeHerramientaPiedra();
        TipoDeHerramienta pico = new Pico(piedra);
        Material materialMadera = new MaterialMadera();
        int durabilidadInicial;
        int diferenciaDeDurabilidadQueDeberiaTenerAlUsarseUnaVez;
        durabilidadInicial = pico.durabilidad();
        pico.usarEn(materialMadera);
        diferenciaDeDurabilidadQueDeberiaTenerAlUsarseUnaVez = durabilidadInicial - pico.durabilidad();
        assertNotEquals(0,diferenciaDeDurabilidadQueDeberiaTenerAlUsarseUnaVez);
    }
    @Test
    public void laDurabilidadDeUnPicoDePiedraSeReduceEnElMaterialPiedra(){
        MaterialDeHerramienta piedra = new MaterialDeHerramientaPiedra();
        TipoDeHerramienta pico = new Pico(piedra);
        Material materialPiedra = new MaterialPiedra();
        int durabilidadInicial;
        int diferenciaDeDurabilidadQueDeberiaTenerAlUsarseUnaVez;
        durabilidadInicial = pico.durabilidad();
        pico.usarEn(materialPiedra);
        diferenciaDeDurabilidadQueDeberiaTenerAlUsarseUnaVez = durabilidadInicial - pico.durabilidad();
        assertNotEquals(0,diferenciaDeDurabilidadQueDeberiaTenerAlUsarseUnaVez);
    }
    @Test
    public void laDurabilidadDeUnPicoDePiedraSeReduceEnElMaterialMetal(){
        MaterialDeHerramienta piedra = new MaterialDeHerramientaPiedra();
        TipoDeHerramienta pico = new Pico(piedra);
        Material materialMetal = new MaterialMetal();
        int durabilidadInicial;
        int diferenciaDeDurabilidadQueDeberiaTenerAlUsarseUnaVez;
        durabilidadInicial = pico.durabilidad();
        pico.usarEn(materialMetal);
        diferenciaDeDurabilidadQueDeberiaTenerAlUsarseUnaVez = durabilidadInicial - pico.durabilidad();
        assertNotEquals(0,diferenciaDeDurabilidadQueDeberiaTenerAlUsarseUnaVez);
    }
    @Test
    public void laDurabilidadDeUnPicoDePiedraSeReduceEnElMaterialDiamante(){
        MaterialDeHerramienta piedra = new MaterialDeHerramientaPiedra();
        TipoDeHerramienta pico = new Pico(piedra);
        Material materialDiamante = new MaterialDiamante();
        int durabilidadInicial;
        int diferenciaDeDurabilidadQueDeberiaTenerAlUsarseUnaVez;
        durabilidadInicial = pico.durabilidad();
        pico.usarEn(materialDiamante);
        diferenciaDeDurabilidadQueDeberiaTenerAlUsarseUnaVez = durabilidadInicial - pico.durabilidad();
        assertNotEquals(0,diferenciaDeDurabilidadQueDeberiaTenerAlUsarseUnaVez);
    }
    //pico de metal
    @Test
    public void laDurabilidadDeUnPicoDeMetalNoSeGastaConElUso(){
        MaterialDeHerramienta metal = new MaterialDeHerramientaMetal();
        TipoDeHerramienta pico = new Pico(metal);
        Material material = new MaterialPiedra();
        int durabilidadInicial = pico.durabilidad();
        pico.usarEn(material);
        assertEquals(durabilidadInicial,pico.durabilidad());
    }
    @Test
    public void laDurabilidadDeUnPicoDeMetalNoSeGastaConAlMenos9Usos(){
        MaterialDeHerramienta metal = new MaterialDeHerramientaMetal();
        TipoDeHerramienta pico = new Pico(metal);
        Material material = new MaterialPiedra();
        int durabilidadInicial = pico.durabilidad();
        int vecesUsada = 9;
        for (int i = 0; i < vecesUsada; i++){
            pico.usarEn(material);
        }
        assertEquals(durabilidadInicial,pico.durabilidad());
    }
    @Test
    public void laDurabilidadDeUnPicoDeMetalEs0Tras10Usos(){
        MaterialDeHerramienta metal = new MaterialDeHerramientaMetal();
        TipoDeHerramienta pico = new Pico(metal);
        Material material = new MaterialPiedra();
        int vecesUsada = 10;
        for (int i = 0; i < vecesUsada; i++){
            pico.usarEn(material);
        }
        assertEquals(0,pico.durabilidad());
    }
    @Test
    public void laDurabilidadDeUnPicoDeMetalNoSeReduceEnElMaterialMaderaPeroSeRompeAlDecimoUso(){
        MaterialDeHerramienta metal = new MaterialDeHerramientaMetal();
        TipoDeHerramienta pico = new Pico(metal);
        Material materialMadera = new MaterialMadera();
        int durabilidadInicial = pico.durabilidad();
        int vecesUsada = 9;
        for (int i = 0; i < vecesUsada; i++){
            pico.usarEn(materialMadera);
            assertEquals(durabilidadInicial,pico.durabilidad());
        }
        pico.usarEn(materialMadera);
        assertEquals(0,pico.durabilidad());
    }
    @Test
    public void laDurabilidadDeUnPicoDeMetalNOSeReduceEnElMaterialPiedraPeroSeRompeAlDecimoUso(){
        MaterialDeHerramienta metal = new MaterialDeHerramientaMetal();
        TipoDeHerramienta pico = new Pico(metal);
        Material materialPiedra = new MaterialPiedra();
        int durabilidadInicial = pico.durabilidad();
        int vecesUsada = 9;
        for (int i = 0; i < vecesUsada; i++){
            pico.usarEn(materialPiedra);
            assertEquals(durabilidadInicial,pico.durabilidad());
        }
        pico.usarEn(materialPiedra);
        assertEquals(0,pico.durabilidad());
    }
    @Test
    public void laDurabilidadDeUnPicoDeMetalNoSeReduceEnElMaterialMetalPeroSeRompeAlDecimoUso(){
        MaterialDeHerramienta metal = new MaterialDeHerramientaMetal();
        TipoDeHerramienta pico = new Pico(metal);
        Material materialMetal = new MaterialMetal();
        int durabilidadInicial = pico.durabilidad();
        int vecesUsada = 9;
        for (int i = 0; i < vecesUsada; i++){
            pico.usarEn(materialMetal);
            assertEquals(durabilidadInicial,pico.durabilidad());
        }
        pico.usarEn(materialMetal);
        assertEquals(0,pico.durabilidad());
    }
    @Test
    public void laDurabilidadDeUnPicoDeMetalNoSeReduceEnElMaterialDiamantePeroSeRompeAlDecimoUso(){
        MaterialDeHerramienta metal = new MaterialDeHerramientaMetal();
        TipoDeHerramienta pico = new Pico(metal);
        Material materialDiamante = new MaterialDiamante();
        int durabilidadInicial = pico.durabilidad();
        int vecesUsada = 9;
        for (int i = 0; i < vecesUsada; i++){
            pico.usarEn(materialDiamante);
            assertEquals(durabilidadInicial,pico.durabilidad());
        }
        pico.usarEn(materialDiamante);
        assertEquals(0,pico.durabilidad());
    }
}
