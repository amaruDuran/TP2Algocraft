package Juego;

import Modelo.Jugador.Jugador;
import Modelo.Juego.Algocraft;
import Modelo.Juego.Mapa;
import Modelo.Materiales.MaterialDiamante;
import Modelo.Materiales.MaterialMadera;
import Modelo.Materiales.MaterialMetal;
import Modelo.Materiales.MaterialPiedra;
import Modelo.Juego.ObjetoDelTablero;
import org.junit.Test;

import java.awt.*;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class AlgocraftTest {
    @Test
    public void SeVerificaQueUnaVezIniciadoElJuegoElJugadorSeEncuentreEnElPrimerCasillero(){
        Algocraft miJuego = new Algocraft();
        miJuego.iniciar();
        Mapa mapaDeMiJuego = miJuego.obtenerMapaDelJuego();
        Jugador jugador = miJuego.obtenerJugador();
        ObjetoDelTablero objectoEnElPrimerCasillero  = mapaDeMiJuego.obtenerCasillero(new Point(0,0)).getObjeto();
        assertEquals(jugador,objectoEnElPrimerCasillero);
    }

    @Test
    public void SeVerificaQueUnaVezIniciadoElJuegoElMapaContengaMaterialesDeMetal(){
        Algocraft juego = new Algocraft();
        juego.iniciar();
        Mapa mapaDeMiJuego = juego.obtenerMapaDelJuego();

        ObjetoDelTablero objeto = mapaDeMiJuego.obtenerCasillero(new Point(2,1)).getObjeto();
        assertEquals(objeto.equals(new MaterialMetal()),true);
    }

    @Test
    public void SeVerificaQueUnaVezIniciadoElJuegoElMapaContengaMaterialesDeMadera(){
        Algocraft juego = new Algocraft();
        juego.iniciar();
        Mapa mapaDeMiJuego = juego.obtenerMapaDelJuego();

        ObjetoDelTablero objeto = mapaDeMiJuego.obtenerCasillero(new Point(5,1)).getObjeto();
        assertTrue(objeto.equals(new MaterialMadera()));
    }

    @Test
    public void SeVerificaQueUnaVezIniciadoElJuegoElMapaContengaMaterialesDePiedra(){
        Algocraft juego = new Algocraft();
        juego.iniciar();
        Mapa mapaDeMiJuego = juego.obtenerMapaDelJuego();

        ObjetoDelTablero objeto = mapaDeMiJuego.obtenerCasillero(new Point(8,7)).getObjeto();
        assertTrue(objeto.equals(new MaterialPiedra()));
    }

    @Test
    public void SeVerificaQueUnaVezIniciadoElJuegoElMapaContengaMaterialesDeDiamante(){
        Algocraft juego = new Algocraft();
        juego.iniciar();
        Mapa mapaDeMiJuego = juego.obtenerMapaDelJuego();

        ObjetoDelTablero objeto = mapaDeMiJuego.obtenerCasillero(new Point(2,5)).getObjeto();
        assertTrue(objeto.equals(new MaterialDiamante()));
    }


}
