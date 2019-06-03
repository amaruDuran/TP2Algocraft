package HerramientaTest;

import Herramientas.TipoDeHerramienta.TipoDeHerramienta;
import Herramientas.TipoDeHerramienta.TipoDeHerramientaHacha;
import Herramientas.TipoDeHerramienta.MaterialDeHerramientas.MaterialDeHerramienta;
import Herramientas.TipoDeHerramienta.MaterialDeHerramientas.MaterialDeHerramientaMadera;
import Herramientas.TipoDeHerramienta.MaterialDeHerramientas.MaterialDeHerramientaMetal;
import Herramientas.TipoDeHerramienta.MaterialDeHerramientas.MaterialDeHerramientaPiedra;
import Materiales.*;
import org.junit.Test;
import static org.junit.Assert.*;

public class TipoDeHerramientaHachaTest {
    //test de atributo de herramienta
    @Test
    public void seVerificaQueUnHachaDeMaderaNuevaTengaDurabilidad100YFuerza2(){
        MaterialDeHerramienta madera = new MaterialDeHerramientaMadera();
        TipoDeHerramienta hacha = new TipoDeHerramientaHacha(madera);
        assertEquals(100,hacha.durabilidad());
        assertEquals(2,hacha.fuerza());
    }
    @Test
    public void seVerificaQueUnHachaDePiedraNuevaTengaDurabilidad200YFuerza5(){
        MaterialDeHerramienta piedra = new MaterialDeHerramientaPiedra();
        TipoDeHerramienta hacha = new TipoDeHerramientaHacha(piedra);
        assertEquals(200,hacha.durabilidad());
        assertEquals(5,hacha.fuerza());
    }
    @Test
    public void seVerificaQueUnHachaDeMetalNuevaTengaDurabilidad400YFuerza10(){
        MaterialDeHerramienta metal = new MaterialDeHerramientaMetal();
        TipoDeHerramienta hacha = new TipoDeHerramientaHacha(metal);
        assertEquals(400,hacha.durabilidad());
        assertEquals(10,hacha.fuerza());
    }

    //test de desgaste
    //hacha de madera
    @Test
    public void laDurabilidadDeUnHachaDeMaderaSeGastaReduciendoseEnSuFuerzaConElUso(){
        MaterialDeHerramienta madera = new MaterialDeHerramientaMadera();
        TipoDeHerramienta hacha = new TipoDeHerramientaHacha(madera);
        Material material = new MaterialMadera();
        int durabilidadInicial = hacha.durabilidad();
        int durabilidadQueDeberiaTenerAlUsarseUnaVez = durabilidadInicial - hacha.fuerza();
        hacha.usarLaHerramientaEn(material);
        assertEquals(durabilidadQueDeberiaTenerAlUsarseUnaVez,hacha.durabilidad());
    }
    @Test
    public void laDurabilidadDeUnHachaDeMaderaSeGastaReduciendoseEnSuFuerzaConCadaUso(){
        MaterialDeHerramienta madera = new MaterialDeHerramientaMadera();
        TipoDeHerramienta hacha = new TipoDeHerramientaHacha(madera);
        Material material = new MaterialMadera();
        int durabilidadInicial = hacha.durabilidad();
        int vecesUsada = 8;
        int durabilidadQueDeberiaTenerAlUsarseUnaVez = durabilidadInicial - (hacha.fuerza() * vecesUsada);
        for (int i = 0; i < vecesUsada; i++){
            hacha.usarLaHerramientaEn(material);
        }
        assertEquals(durabilidadQueDeberiaTenerAlUsarseUnaVez,hacha.durabilidad());
    }
    //materiales que desgastan
    @Test
    public void laDurabilidadDeUnHachaDeMaderaSeReduceEnElMaterialMadera(){
        MaterialDeHerramienta madera = new MaterialDeHerramientaMadera();
        TipoDeHerramienta hacha = new TipoDeHerramientaHacha(madera);
        Material materialMadera = new MaterialMadera();
        int durabilidadInicial;
        int diferenciaDeDurabilidadQueDeberiaTenerAlUsarseUnaVez;
        durabilidadInicial = hacha.durabilidad();
        hacha.usarLaHerramientaEn(materialMadera);
        diferenciaDeDurabilidadQueDeberiaTenerAlUsarseUnaVez = durabilidadInicial - hacha.durabilidad();
        assertNotEquals(0,diferenciaDeDurabilidadQueDeberiaTenerAlUsarseUnaVez);
    }
    @Test
    public void laDurabilidadDeUnHachaDeMaderaSeReduceEnElMaterialPiedra(){
        MaterialDeHerramienta madera = new MaterialDeHerramientaMadera();
        TipoDeHerramienta hacha = new TipoDeHerramientaHacha(madera);
        Material materialPiedra = new MaterialPiedra();
        int durabilidadInicial;
        int diferenciaDeDurabilidadQueDeberiaTenerAlUsarseUnaVez;
        durabilidadInicial = hacha.durabilidad();
        hacha.usarLaHerramientaEn(materialPiedra);
        diferenciaDeDurabilidadQueDeberiaTenerAlUsarseUnaVez = durabilidadInicial - hacha.durabilidad();
        assertNotEquals(0,diferenciaDeDurabilidadQueDeberiaTenerAlUsarseUnaVez);
    }
    @Test
    public void laDurabilidadDeUnHachaDeMaderaSeReduceEnElMaterialMetal(){
        MaterialDeHerramienta madera = new MaterialDeHerramientaMadera();
        TipoDeHerramienta hacha = new TipoDeHerramientaHacha(madera);
        Material materialMetal = new MaterialMetal();
        int durabilidadInicial;
        int diferenciaDeDurabilidadQueDeberiaTenerAlUsarseUnaVez;
        durabilidadInicial = hacha.durabilidad();
        hacha.usarLaHerramientaEn(materialMetal);
        diferenciaDeDurabilidadQueDeberiaTenerAlUsarseUnaVez = durabilidadInicial - hacha.durabilidad();
        assertNotEquals(0,diferenciaDeDurabilidadQueDeberiaTenerAlUsarseUnaVez);
    }
    @Test
    public void laDurabilidadDeUnHachaDeMaderaSeReduceEnElMaterialDiamante(){
        MaterialDeHerramienta madera = new MaterialDeHerramientaMadera();
        TipoDeHerramienta hacha = new TipoDeHerramientaHacha(madera);
        Material materialDiamante = new MaterialDiamante();
        int durabilidadInicial;
        int diferenciaDeDurabilidadQueDeberiaTenerAlUsarseUnaVez;
        durabilidadInicial = hacha.durabilidad();
        hacha.usarLaHerramientaEn(materialDiamante);
        diferenciaDeDurabilidadQueDeberiaTenerAlUsarseUnaVez = durabilidadInicial - hacha.durabilidad();
        assertNotEquals(0,diferenciaDeDurabilidadQueDeberiaTenerAlUsarseUnaVez);
    }
    //hacha de piedra
    @Test
    public void laDurabilidadDeUnHachaDePiedraSeGastaReduciendoseEnFuerzaConElUso(){
        MaterialDeHerramienta piedra = new MaterialDeHerramientaPiedra();
        TipoDeHerramienta hacha = new TipoDeHerramientaHacha(piedra);
        Material material = new MaterialMadera();
        int durabilidadInicial = hacha.durabilidad();
        int durabilidadQueDeberiaTenerAlUsarseUnaVez = durabilidadInicial - hacha.fuerza();
        hacha.usarLaHerramientaEn(material);
        assertEquals(durabilidadQueDeberiaTenerAlUsarseUnaVez,hacha.durabilidad());
    }
    @Test
    public void laDurabilidadDeUnHachaDePiedraSeGastaReduciendoseEnSuFuerzaConCadaUso(){
        MaterialDeHerramienta piedra = new MaterialDeHerramientaPiedra();
        TipoDeHerramienta hacha = new TipoDeHerramientaHacha(piedra);
        Material material = new MaterialMadera();
        int durabilidadInicial = hacha.durabilidad();
        int vecesUsada = 8;
        int durabilidadQueDeberiaTenerAlUsarseUnaVez = durabilidadInicial - (hacha.fuerza() * vecesUsada);
        for (int i = 0; i < vecesUsada; i++){
            hacha.usarLaHerramientaEn(material);
        }
        assertEquals(durabilidadQueDeberiaTenerAlUsarseUnaVez,hacha.durabilidad());
    }
    //materiales que desgastan
    @Test
    public void laDurabilidadDeUnHachaDePiedraSeReduceEnElMaterialMadera(){
        MaterialDeHerramienta piedra = new MaterialDeHerramientaPiedra();
        TipoDeHerramienta hacha = new TipoDeHerramientaHacha(piedra);
        Material materialMadera = new MaterialMadera();
        int durabilidadInicial;
        int diferenciaDeDurabilidadQueDeberiaTenerAlUsarseUnaVez;
        durabilidadInicial = hacha.durabilidad();
        hacha.usarLaHerramientaEn(materialMadera);
        diferenciaDeDurabilidadQueDeberiaTenerAlUsarseUnaVez = durabilidadInicial - hacha.durabilidad();
        assertNotEquals(0,diferenciaDeDurabilidadQueDeberiaTenerAlUsarseUnaVez);
    }
    @Test
    public void laDurabilidadDeUnHachaDePiedraSeReduceEnElMaterialPiedra(){
        MaterialDeHerramienta piedra = new MaterialDeHerramientaPiedra();
        TipoDeHerramienta hacha = new TipoDeHerramientaHacha(piedra);
        Material materialPiedra = new MaterialPiedra();
        int durabilidadInicial;
        int diferenciaDeDurabilidadQueDeberiaTenerAlUsarseUnaVez;
        durabilidadInicial = hacha.durabilidad();
        hacha.usarLaHerramientaEn(materialPiedra);
        diferenciaDeDurabilidadQueDeberiaTenerAlUsarseUnaVez = durabilidadInicial - hacha.durabilidad();
        assertNotEquals(0,diferenciaDeDurabilidadQueDeberiaTenerAlUsarseUnaVez);
    }
    @Test
    public void laDurabilidadDeUnHachaDePiedraSeReduceEnElMaterialMetal(){
        MaterialDeHerramienta piedra = new MaterialDeHerramientaPiedra();
        TipoDeHerramienta hacha = new TipoDeHerramientaHacha(piedra);
        Material materialMetal = new MaterialMetal();
        int durabilidadInicial;
        int diferenciaDeDurabilidadQueDeberiaTenerAlUsarseUnaVez;
        durabilidadInicial = hacha.durabilidad();
        hacha.usarLaHerramientaEn(materialMetal);
        diferenciaDeDurabilidadQueDeberiaTenerAlUsarseUnaVez = durabilidadInicial - hacha.durabilidad();
        assertNotEquals(0,diferenciaDeDurabilidadQueDeberiaTenerAlUsarseUnaVez);
    }
    @Test
    public void laDurabilidadDeUnHachaDePiedraSeReduceEnElMaterialDiamante(){
        MaterialDeHerramienta piedra = new MaterialDeHerramientaPiedra();
        TipoDeHerramienta hacha = new TipoDeHerramientaHacha(piedra);
        Material materialDiamante = new MaterialDiamante();
        int durabilidadInicial;
        int diferenciaDeDurabilidadQueDeberiaTenerAlUsarseUnaVez;
        durabilidadInicial = hacha.durabilidad();
        hacha.usarLaHerramientaEn(materialDiamante);
        diferenciaDeDurabilidadQueDeberiaTenerAlUsarseUnaVez = durabilidadInicial - hacha.durabilidad();
        assertNotEquals(0,diferenciaDeDurabilidadQueDeberiaTenerAlUsarseUnaVez);
    }
    //hacha de metal
    @Test
    public void laDurabilidadDeUnHachaDeMetalSeGastaReduciendoseEnLaMitadDeSuFuerzaConElUso(){
        MaterialDeHerramienta metal = new MaterialDeHerramientaMetal();
        TipoDeHerramienta hacha = new TipoDeHerramientaHacha(metal);
        Material material = new MaterialMadera();
        int durabilidadInicial = hacha.durabilidad();
        int durabilidadQueDeberiaTenerAlUsarseUnaVez = durabilidadInicial - (hacha.fuerza() / 2);
        hacha.usarLaHerramientaEn(material);
        assertEquals(durabilidadQueDeberiaTenerAlUsarseUnaVez,hacha.durabilidad());
    }
    @Test
    public void laDurabilidadDeUnHachaDeMetalSeGastaReduciendoseEnLaMitadDeSuFuerzaConCadaUso(){
        MaterialDeHerramienta metal = new MaterialDeHerramientaMetal();
        TipoDeHerramienta hacha = new TipoDeHerramientaHacha(metal);
        Material material = new MaterialMadera();
        int durabilidadInicial = hacha.durabilidad();
        int vecesUsada = 8;
        int durabilidadQueDeberiaTenerAlUsarseUnaVez = durabilidadInicial - ((hacha.fuerza() / 2) * vecesUsada);
        for (int i = 0; i < vecesUsada; i++){
            hacha.usarLaHerramientaEn(material);
        }
        assertEquals(durabilidadQueDeberiaTenerAlUsarseUnaVez,hacha.durabilidad());
    }
    //materiales que desgastan
    @Test
    public void laDurabilidadDeUnHachaDeMetalSeReduceEnElMaterialMadera(){
        MaterialDeHerramienta metal = new MaterialDeHerramientaMetal();
        TipoDeHerramienta hacha = new TipoDeHerramientaHacha(metal);
        Material materialMadera = new MaterialMadera();
        int durabilidadInicial;
        int diferenciaDeDurabilidadQueDeberiaTenerAlUsarseUnaVez;
        durabilidadInicial = hacha.durabilidad();
        hacha.usarLaHerramientaEn(materialMadera);
        diferenciaDeDurabilidadQueDeberiaTenerAlUsarseUnaVez = durabilidadInicial - hacha.durabilidad();
        assertNotEquals(0,diferenciaDeDurabilidadQueDeberiaTenerAlUsarseUnaVez);
    }
    @Test
    public void laDurabilidadDeUnHachaDeMetalSeReduceEnElMaterialPiedra(){
        MaterialDeHerramienta metal = new MaterialDeHerramientaMetal();
        TipoDeHerramienta hacha = new TipoDeHerramientaHacha(metal);
        Material materialPiedra = new MaterialPiedra();
        int durabilidadInicial;
        int diferenciaDeDurabilidadQueDeberiaTenerAlUsarseUnaVez;
        durabilidadInicial = hacha.durabilidad();
        hacha.usarLaHerramientaEn(materialPiedra);
        diferenciaDeDurabilidadQueDeberiaTenerAlUsarseUnaVez = durabilidadInicial - hacha.durabilidad();
        assertNotEquals(0,diferenciaDeDurabilidadQueDeberiaTenerAlUsarseUnaVez);
    }
    @Test
    public void laDurabilidadDeUnHachaDeMetalSeReduceEnElMaterialMetal(){
        MaterialDeHerramienta metal = new MaterialDeHerramientaMetal();
        TipoDeHerramienta hacha = new TipoDeHerramientaHacha(metal);
        Material materialMetal = new MaterialMetal();
        int durabilidadInicial;
        int diferenciaDeDurabilidadQueDeberiaTenerAlUsarseUnaVez;
        durabilidadInicial = hacha.durabilidad();
        hacha.usarLaHerramientaEn(materialMetal);
        diferenciaDeDurabilidadQueDeberiaTenerAlUsarseUnaVez = durabilidadInicial - hacha.durabilidad();
        assertNotEquals(0,diferenciaDeDurabilidadQueDeberiaTenerAlUsarseUnaVez);
    }
    @Test
    public void laDurabilidadDeUnHachaDeMetalSeReduceEnElMaterialDiamante(){
        MaterialDeHerramienta metal = new MaterialDeHerramientaMetal();
        TipoDeHerramienta hacha = new TipoDeHerramientaHacha(metal);
        Material materialDiamante = new MaterialDiamante();
        int durabilidadInicial;
        int diferenciaDeDurabilidadQueDeberiaTenerAlUsarseUnaVez;
        durabilidadInicial = hacha.durabilidad();
        hacha.usarLaHerramientaEn(materialDiamante);
        diferenciaDeDurabilidadQueDeberiaTenerAlUsarseUnaVez = durabilidadInicial - hacha.durabilidad();
        assertNotEquals(0,diferenciaDeDurabilidadQueDeberiaTenerAlUsarseUnaVez);
    }
}
