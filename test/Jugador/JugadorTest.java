package Jugador;

import Herramientas.TipoDeHerramienta.Hacha;
import Herramientas.TipoDeHerramienta.MaterialDeHerramientas.MaterialDeHerramientaMadera;
import Herramientas.TipoDeHerramienta.TipoDeHerramienta;
import Juego.Casillero;
import Juego.Mapa;
import Materiales.Material;
import Materiales.MaterialMadera;
import Materiales.MaterialMetal;
import Materiales.MaterialPiedra;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

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
        TipoDeHerramienta hachaDeMadera = new Hacha(new MaterialDeHerramientaMadera());

        TipoDeHerramienta herramienta = jugador.obtenerHerramientaEnMano();

        assertEquals(hachaDeMadera.durabilidad() , herramienta.durabilidad());
        assertEquals(hachaDeMadera.fuerza() , herramienta.fuerza());
    }

    @Test
    public void JugadorComienzaEnelPrimeroCasilleroDelTablero(){
        List<Material> materiales = new ArrayList<>();
        materiales.add(new MaterialMadera());
        materiales.add(new MaterialPiedra());
        materiales.add(new MaterialMetal());
        materiales.add(new MaterialMetal());

        Mapa mapa = new Mapa(materiales,10,10);
        Jugador jugador = new Jugador();
        jugador.iniciar(mapa);
        Casillero casillero = mapa.obtenerCasillero(1,1);
        casillero.asignar(new MaterialMadera());
        assertEquals(casillero.identificador(),"M");
    }
}
