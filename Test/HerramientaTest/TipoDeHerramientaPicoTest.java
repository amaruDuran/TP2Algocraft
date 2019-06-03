package HerramientaTest;

import Herramientas.TipoDeHerramienta.MaterialDeHerramientas.MaterialDeHerramienta;
import Herramientas.TipoDeHerramienta.TipoDeHerramienta;
import Herramientas.TipoDeHerramienta.TipoDeHerramientaPico;
import Herramientas.TipoDeHerramienta.MaterialDeHerramientas.MaterialDeHerramientaMadera;
import Herramientas.TipoDeHerramienta.MaterialDeHerramientas.MaterialDeHerramientaMetal;
import Herramientas.TipoDeHerramienta.MaterialDeHerramientas.MaterialDeHerramientaPiedra;
import Materiales.Material;
import Materiales.MaterialMadera;
import Materiales.MaterialPiedra;
import org.junit.Test;
import static org.junit.Assert.*;

public class TipoDeHerramientaPicoTest {
    //test de atributo de herramienta
    @Test
    public void seVerificaQueUnPicoDeMaderaNuevaTengaDurabilidad100YFuerza2(){
        MaterialDeHerramienta madera = new MaterialDeHerramientaMadera();
        TipoDeHerramienta pico = new TipoDeHerramientaPico(madera);
        assertEquals(100,pico.durabilidad());
        assertEquals(2,pico.fuerza());
    }
    @Test
    public void seVerificaQueUnPicoDePiedraNuevaTengaDurabilidad200YFuerza4(){
        MaterialDeHerramienta piedra = new MaterialDeHerramientaPiedra();
        TipoDeHerramienta pico = new TipoDeHerramientaPico(piedra);
        assertEquals(200,pico.durabilidad());
        assertEquals(4,pico.fuerza());
    }
    @Test
    public void seVerificaQueUnPicoDeMetalNuevaTengaDurabilidad400YFuerza12(){
        MaterialDeHerramienta metal = new MaterialDeHerramientaMetal();
        TipoDeHerramienta pico = new TipoDeHerramientaPico(metal);
        assertEquals(400,pico.durabilidad());
        assertEquals(12,pico.fuerza());
    }

    //test de desgaste
    //hacha de madera
    @Test
    public void laDurabilidadDeUnPicoDeMaderaSeGastaReduciendoseEnSuFuerzaConElUso(){
        MaterialDeHerramienta madera = new MaterialDeHerramientaMadera();
        TipoDeHerramienta pico = new TipoDeHerramientaPico(madera);
        Material material = new MaterialPiedra();
        int durabilidadInicial = pico.durabilidad();
        int durabilidadQueDeberiaTenerAlUsarseUnaVez = durabilidadInicial - pico.fuerza();
        pico.usarLaHerramientaEn(material);
        assertEquals(durabilidadQueDeberiaTenerAlUsarseUnaVez,pico.durabilidad());
    }
    @Test
    public void laDurabilidadDeUnPicoDeMaderaSeGastaReduciendoseEnSuFuerzaConCadaUso(){
        MaterialDeHerramienta madera = new MaterialDeHerramientaMadera();
        TipoDeHerramienta pico = new TipoDeHerramientaPico(madera);
        Material material = new MaterialPiedra();
        int durabilidadInicial = pico.durabilidad();
        int vecesUsada = 8;
        int durabilidadQueDeberiaTenerAlUsarseUnaVez = durabilidadInicial - (pico.fuerza() * vecesUsada);
        for (int i = 0; i < vecesUsada; i++){
            pico.usarLaHerramientaEn(material);
        }
        assertEquals(durabilidadQueDeberiaTenerAlUsarseUnaVez,pico.durabilidad());
    }
    //hacha de piedra
    @Test
    public void laDurabilidadDeUnPicoDePiedraSeGastaReduciendoseEnDosTerciosDeSuFuerzaConElUso(){
        MaterialDeHerramienta piedra = new MaterialDeHerramientaPiedra();
        TipoDeHerramienta pico = new TipoDeHerramientaPico(piedra);
        Material material = new MaterialPiedra();
        int durabilidadInicial = pico.durabilidad();
        int durabilidadQueDeberiaTenerAlUsarseUnaVez = durabilidadInicial - ((pico.fuerza() * 2) / 3);
        pico.usarLaHerramientaEn(material);
        assertEquals(durabilidadQueDeberiaTenerAlUsarseUnaVez,pico.durabilidad());
    }
    @Test
    public void laDurabilidadDeUnPicoDePiedraSeGastaReduciendoseEnDosTerciosDeSuFuerzaConCadaUso(){
        MaterialDeHerramienta piedra = new MaterialDeHerramientaPiedra();
        TipoDeHerramienta pico = new TipoDeHerramientaPico(piedra);
        Material material = new MaterialPiedra();
        int durabilidadInicial = pico.durabilidad();
        int vecesUsada = 8;
        int durabilidadQueDeberiaTenerAlUsarseUnaVez = durabilidadInicial - (((pico.fuerza() * 2) / 3) * vecesUsada);
        for (int i = 0; i < vecesUsada; i++){
            pico.usarLaHerramientaEn(material);
        }
        assertEquals(durabilidadQueDeberiaTenerAlUsarseUnaVez,pico.durabilidad());
    }
    //hacha de metal
    @Test
    public void laDurabilidadDeUnPicoDeMetalNoSeGastaConElUso(){
        MaterialDeHerramienta metal = new MaterialDeHerramientaMetal();
        TipoDeHerramienta pico = new TipoDeHerramientaPico(metal);
        Material material = new MaterialPiedra();
        int durabilidadInicial = pico.durabilidad();
        pico.usarLaHerramientaEn(material);
        assertEquals(durabilidadInicial,pico.durabilidad());
    }
    @Test
    public void laDurabilidadDeUnPicoDeMetalNoSeGastaConAlMenos9Usos(){
        MaterialDeHerramienta metal = new MaterialDeHerramientaMetal();
        TipoDeHerramienta pico = new TipoDeHerramientaPico(metal);
        Material material = new MaterialPiedra();
        int durabilidadInicial = pico.durabilidad();
        int vecesUsada = 9;
        for (int i = 0; i < vecesUsada; i++){
            pico.usarLaHerramientaEn(material);
        }
        assertEquals(durabilidadInicial,pico.durabilidad());
    }
    @Test
    public void laDurabilidadDeUnPicoDeMetalEs0Tras10Usos(){
        MaterialDeHerramienta metal = new MaterialDeHerramientaMetal();
        TipoDeHerramienta pico = new TipoDeHerramientaPico(metal);
        Material material = new MaterialPiedra();
        int vecesUsada = 10;
        for (int i = 0; i < vecesUsada; i++){
            pico.usarLaHerramientaEn(material);
        }
        assertEquals(0,pico.durabilidad());
    }
}
