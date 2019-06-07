package Jugador;

import HerramientaTest.MaterialDeHerramientaTest.MaterialDeTipoDeHerramientaMaderaTest;
import Herramientas.TipoDeHerramienta.Hacha;
import Herramientas.TipoDeHerramienta.MaterialDeHerramientas.MaterialDeHerramientaMadera;
import Herramientas.TipoDeHerramienta.TipoDeHerramienta;
import org.junit.Test;
import static org.junit.Assert.*;

public class JugadorTest {
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
}
