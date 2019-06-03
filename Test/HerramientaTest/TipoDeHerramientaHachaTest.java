package HerramientaTest;

import Herramientas.TipoDeHerramienta.TipoDeHerramienta;
import Herramientas.TipoDeHerramienta.TipoDeHerramientaHacha;
import Herramientas.TipoDeHerramienta.MaterialDeHerramientas.MaterialDeHerramienta;
import Herramientas.TipoDeHerramienta.MaterialDeHerramientas.MaterialDeHerramientaMadera;
import Herramientas.TipoDeHerramienta.MaterialDeHerramientas.MaterialDeHerramientaMetal;
import Herramientas.TipoDeHerramienta.MaterialDeHerramientas.MaterialDeHerramientaPiedra;
import Materiales.Material;
import Materiales.MaterialMadera;
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
}
