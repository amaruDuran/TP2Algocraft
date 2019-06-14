package Juego;

import Jugador.Jugador;
import Materiales.MaterialDiamante;
import Materiales.MaterialMadera;
import Materiales.MaterialMetal;
import Materiales.MaterialPiedra;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class CasilleroTest {
    @Test
    public void seCreaUnCasilleroYNoEstaOcupado(){
        Casillero casillero = new Casillero();
        assertEquals(false,casillero.estaOcupado());
    }
    @Test
    public void seCreaUnCasilleroYEstaVacio(){
        Casillero casillero = new Casillero();
        assertEquals("",casillero.identificador());
    }
    @Test
    public void seAsignaUnObjetoAlCasilleroAlAsignarDanTrue(){
        Casillero casilleroJugador = new Casillero();
        Casillero casilleroMaterialMadera = new Casillero();
        Casillero casilleroMaterialMetal = new Casillero();
        Casillero casilleroMaterialPiedra = new Casillero();
        Casillero casilleroMaterialDiamante = new Casillero();

        assertEquals(true,casilleroJugador.asignar(new Jugador()));
        assertEquals(true,casilleroMaterialMadera.asignar(new MaterialMadera()));
        assertEquals(true,casilleroMaterialMetal.asignar(new MaterialMetal()));
        assertEquals(true,casilleroMaterialPiedra.asignar(new MaterialPiedra()));
        assertEquals(true,casilleroMaterialDiamante.asignar(new MaterialDiamante()));
    }
    @Test
    public void seAsignaUnObjetoAlCasilleroYEsteDaOcupado(){
        Casillero casilleroJugador = new Casillero();
        Casillero casilleroMaterialMadera = new Casillero();
        Casillero casilleroMaterialMetal = new Casillero();
        Casillero casilleroMaterialPiedra = new Casillero();
        Casillero casilleroMaterialDiamante = new Casillero();

        casilleroJugador.asignar(new Jugador());
        casilleroMaterialMadera.asignar(new MaterialMadera());
        casilleroMaterialMetal.asignar(new MaterialMetal());
        casilleroMaterialPiedra.asignar(new MaterialPiedra());
        casilleroMaterialDiamante.asignar(new MaterialDiamante());

        assertEquals(true,casilleroJugador.estaOcupado());
        assertEquals(true,casilleroMaterialMadera.estaOcupado());
        assertEquals(true,casilleroMaterialMetal.estaOcupado());
        assertEquals(true,casilleroMaterialPiedra.estaOcupado());
        assertEquals(true,casilleroMaterialDiamante.estaOcupado());
    }
    @Test
    public void seAsignaUnObjetoAlCasillero(){
        Casillero casilleroJugador = new Casillero();
        Casillero casilleroMaterialMadera = new Casillero();
        Casillero casilleroMaterialMetal = new Casillero();
        Casillero casilleroMaterialPiedra = new Casillero();
        Casillero casilleroMaterialDiamante = new Casillero();

        casilleroJugador.asignar(new Jugador());
        casilleroMaterialMadera.asignar(new MaterialMadera());
        casilleroMaterialMetal.asignar(new MaterialMetal());
        casilleroMaterialPiedra.asignar(new MaterialPiedra());
        casilleroMaterialDiamante.asignar(new MaterialDiamante());

        assertEquals("JUGADOR",casilleroJugador.identificador());
        assertEquals("MA",casilleroMaterialMadera.identificador());
        assertEquals("MET",casilleroMaterialMetal.identificador());
        assertEquals("P",casilleroMaterialPiedra.identificador());
        assertEquals("D",casilleroMaterialDiamante.identificador());
    }
}