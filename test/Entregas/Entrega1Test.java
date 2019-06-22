package Entregas;

import Modelo.Herramientas.TipoDeHerramienta.Hacha;
import Modelo.Herramientas.TipoDeHerramienta.MaterialDeHerramientas.*;
import Modelo.Herramientas.TipoDeHerramienta.Pico;
import Modelo.Herramientas.TipoDeHerramienta.PicoFino;
import Modelo.Herramientas.TipoDeHerramienta.TipoDeHerramienta;
import Modelo.Jugador.Jugador;
import Modelo.Materiales.Material;
import Modelo.Materiales.MaterialMadera;
import Modelo.Materiales.MaterialMetal;
import Modelo.Materiales.MaterialPiedra;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class Entrega1Test {

    //Se crea hacha de madera con con su durabilidad y fuerza correspondiente
    @Test
    public void seVerificaQueUnHachaDeMaderaNuevaTengaDurabilidad100YFuerza2(){
        MaterialDeHerramienta madera = new MaterialDeHerramientaMadera();
        TipoDeHerramienta hacha = new Hacha(madera);
        assertEquals(100,hacha.durabilidad());
        assertEquals(2,hacha.fuerza());
    }
    //Se crea pico de madera con con su durabilidad y fuerza correspondiente
    @Test
    public void seVerificaQueUnPicoDeMaderaNuevaTengaDurabilidad100YFuerza2(){
        MaterialDeHerramienta madera = new MaterialDeHerramientaMadera();
        TipoDeHerramienta pico = new Pico(madera);
        assertEquals(100,pico.durabilidad());
        assertEquals(2,pico.fuerza());
    }
    //Se crea hacha de metal con con su durabilidad y fuerza correspondiente
    @Test
    public void seVerificaQueUnHachaDeMetalNuevaTengaDurabilidad400YFuerza10(){
        MaterialDeHerramienta metal = new MaterialDeHerramientaMetal();
        TipoDeHerramienta hacha = new Hacha(metal);
        assertEquals(400,hacha.durabilidad());
        assertEquals(10,hacha.fuerza());
    }
    //Se crea Pico de metal con con su durabilidad y fuerza correspondiente
    @Test
    public void seVerificaQueUnPicoDeMetalNuevaTengaDurabilidad400YFuerza12(){
        MaterialDeHerramienta metal = new MaterialDeHerramientaMetal();
        TipoDeHerramienta pico = new Pico(metal);
        assertEquals(400,pico.durabilidad());
        assertEquals(12,pico.fuerza());
    }
    //Se crea Pico Fino con con su durabilidad y fuerza correspondiente
    @Test
    public void seVerificaQueUnPicoDeMaderaNuevaTengaDurabilidad1000YFuerza20(){
        MaterialDeHerramienta metalPiedra = new MaterialDeHerramientaMetalPiedra();
        TipoDeHerramienta picoFino = new PicoFino(metalPiedra);
        assertEquals(1000,picoFino.durabilidad());
        assertEquals(20,picoFino.fuerza());
    }
    //Hacha se usa contra cada uno de los materiales y se reduce su durabilidad correspondiente al material del Hacha(echa en HachaTest)
    //Pico se usa contra cada uno de los materiales y se reduce su durabilidad correspondiente al material del Pico(echa en PicoTest)
    //Pico Fino se usa contra Diamante y se reduce su durabilidad correspondiente(echa en PicoFinoTest)
    //Pico Fino se usa contra los demás materiales y no se reduce su durabilidad(echa en PicoFinoTest)

    //Correcta creación e inicialización del jugador
    @Test
    public void JugadorRecienCreadoComienzaConInventarioVacio(){
        Jugador jugador = new Jugador();
        int cant = jugador.cantidadDeElementosDelInventario();
        assertEquals(0,cant);
    }

    @Test
    public void JugadorRecienCreadoComienzaConHachaDeMaderaEnManoYVerificoQueTengaAtributosDeHachaDeMadera(){
        Jugador jugador = new Jugador();
        TipoDeHerramienta herramienta = jugador.obtenerHerramientaEnMano();
        TipoDeHerramienta hachaDeMadera = new Hacha(new MaterialDeHerramientaMadera());
        assertEquals(hachaDeMadera.durabilidad() , herramienta.durabilidad());
        assertEquals(hachaDeMadera.fuerza() , herramienta.fuerza());
    }
    //Madera se golpea con un Hacha de Madera y se verifica que se reduce la durabilidad del material.
    @Test
    public void seIntentaRecolesctarMaderaConHachaDeMaderaYDisminuyeSuDurabilidadLaFuerzaDeLaHerramienta(){
        Hacha hachaDeMadera = new Hacha(new MaterialDeHerramientaMadera());
        Material madera = new MaterialMadera();
        int durabilidadInicial = madera.durabilidadActualDelMaterial();
        int durabilidadQueDeberiaTenerElMaterial = (durabilidadInicial - hachaDeMadera.fuerza());
        madera.recolectadoPor(hachaDeMadera);
        assertEquals(durabilidadQueDeberiaTenerElMaterial, madera.durabilidadActualDelMaterial());
    }
    @Test
    public void seIntentaRecolesctarMaderaConHachaDePiedraYDisminuyeSuDurabilidadLaFuerzaDeLaHerramienta(){
        Hacha hachaDePiedra = new Hacha(new MaterialDeHerramientaPiedra());
        Material madera = new MaterialMadera();
        int durabilidadInicial = madera.durabilidadActualDelMaterial();
        int durabilidadQueDeberiaTenerElMaterial = (durabilidadInicial - hachaDePiedra.fuerza());
        madera.recolectadoPor(hachaDePiedra);
        assertEquals(durabilidadQueDeberiaTenerElMaterial, madera.durabilidadActualDelMaterial());
    }
    @Test
    public void seIntentaRecolesctarMaderaConHachaDeMetalYDisminuyeSuDurabilidadLaFuerzaDeLaHerramienta(){
        Hacha hachaDeMetal = new Hacha(new MaterialDeHerramientaMetal());
        Material madera = new MaterialMadera();
        int durabilidadInicial = madera.durabilidadActualDelMaterial();
        int durabilidadQueDeberiaTenerElMaterial = (durabilidadInicial - hachaDeMetal.fuerza());
        madera.recolectadoPor(hachaDeMetal);
        assertEquals(durabilidadQueDeberiaTenerElMaterial, madera.durabilidadActualDelMaterial());
    }
    //Piedra se golpea con un Hacha y se verifica que no se reduce la durabilidad del material.
    @Test
    public void seIntentaRecolesctarPiedraElProcesoFallaConTodoTipoDeHachaYNoDisminuyeSuDurabilidad(){
        Hacha hachaDeMadera = new Hacha(new MaterialDeHerramientaMadera());
        Hacha hachaDePiedra = new Hacha(new MaterialDeHerramientaPiedra());
        Hacha hachaDeMetal = new Hacha(new MaterialDeHerramientaMetal());
        Material Piedra = new MaterialPiedra();
        int durabilidadInicial = Piedra.durabilidadActualDelMaterial();
        Piedra.recolectadoPor(hachaDeMadera);
        Piedra.recolectadoPor(hachaDePiedra);
        Piedra.recolectadoPor(hachaDeMetal);
        assertEquals(durabilidadInicial, Piedra.durabilidadActualDelMaterial());
    }
    //Metal se golpea con un Pico de madera y se verifica que no se reduce la durabilidad del material.
    @Test
    public void seIntentaRecolesctarMetalElProcesoFallaConPicoDeMaderaNoDisminuyeSuDurabilidad(){
        Pico picoDeMadera = new Pico(new MaterialDeHerramientaMadera());
        Material metal = new MaterialMetal();
        int durabilidadInicial = metal.durabilidadActualDelMaterial();
        metal.recolectadoPor(picoDeMadera);
        assertEquals(durabilidadInicial, metal.durabilidadActualDelMaterial());
    }
}
