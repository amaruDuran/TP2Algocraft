package Juego;

import org.junit.Test;

import java.awt.*;

import static org.junit.Assert.assertEquals;

public class AlgocraftTest {
    @Test
    public void SeVerificaQueUnaVezIniciadoElJuegoElJugadorSeEncuentreEnLaPosicionInicial(){
        Algocraft juego = new Algocraft();
        juego.iniciar();
        Mapa mapaDeMiJuego = juego.obtenerMapaDelJuego();
        Point posicionInicial = new Point(0,0);
        String identidicador = mapaDeMiJuego.obtenerCasillero(posicionInicial).identificador();
        assertEquals("JUGADOR",identidicador);
    }

    @Test
    public void SeVerificaQueUnaVezIniciadoElJuegoElMapaContengaMaterialesDeMetal(){
        Algocraft juego = new Algocraft();
        juego.iniciar();
        Mapa mapaDeMiJuego = juego.obtenerMapaDelJuego();

        String identidicador = mapaDeMiJuego.obtenerCasillero(new Point(2,1)).identificador();
        assertEquals("MET",identidicador);

        identidicador = mapaDeMiJuego.obtenerCasillero(new Point(3,2)).identificador();
        assertEquals("MET",identidicador);
    }

    @Test
    public void SeVerificaQueUnaVezIniciadoElJuegoElMapaContengaMaterialesDeMadera(){
        Algocraft juego = new Algocraft();
        juego.iniciar();
        Mapa mapaDeMiJuego = juego.obtenerMapaDelJuego();

        String identidicador = mapaDeMiJuego.obtenerCasillero(new Point(5,1)).identificador();
        assertEquals("MA",identidicador);

        identidicador = mapaDeMiJuego.obtenerCasillero(new Point(5,4)).identificador();
        assertEquals("MA",identidicador);
    }

    @Test
    public void SeVerificaQueUnaVezIniciadoElJuegoElMapaContengaMaterialesDePiedra(){
        Algocraft juego = new Algocraft();
        juego.iniciar();
        Mapa mapaDeMiJuego = juego.obtenerMapaDelJuego();

        String identidicador = mapaDeMiJuego.obtenerCasillero(new Point(8,7)).identificador();
        assertEquals("P",identidicador);

        identidicador = mapaDeMiJuego.obtenerCasillero(new Point(8,8)).identificador();
        assertEquals("P",identidicador);
    }

    @Test
    public void SeVerificaQueUnaVezIniciadoElJuegoElMapaContengaMaterialesDeDiamante(){
        Algocraft juego = new Algocraft();
        juego.iniciar();
        Mapa mapaDeMiJuego = juego.obtenerMapaDelJuego();

        String identidicador = mapaDeMiJuego.obtenerCasillero(new Point(2,5)).identificador();
        assertEquals("D",identidicador);

        identidicador = mapaDeMiJuego.obtenerCasillero(new Point(3,6)).identificador();
        assertEquals("D",identidicador);
    }


}
