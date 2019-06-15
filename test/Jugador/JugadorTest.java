package Jugador;

import Herramientas.TipoDeHerramienta.Hacha;
import Herramientas.TipoDeHerramienta.MaterialDeHerramientas.MaterialDeHerramientaMadera;
import Herramientas.TipoDeHerramienta.TipoDeHerramienta;
import Juego.Mapa;
import org.junit.Test;

import java.awt.*;

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
    public void SeVerificaQueEljugadorComienzaEnElPrimerCasilleroDelMapa(){
        Mapa mapa = new Mapa(12,12);
        Jugador jugador = new Jugador();

        jugador.iniciar(mapa);
        String jugadorSeEncuentraEnELPrimerCasillero = mapa.obtenerCasillero(new Point(0,0)).identificador();

        assertEquals("JUGADOR", jugadorSeEncuentraEnELPrimerCasillero);
    }

    @Test
    public void SeVerificiaQueElJugadorSePuedaMoverALaDerechaDesuposicionActual(){
        Mapa mapa = new Mapa(12,12);
        Jugador jugador = new Jugador();

        jugador.iniciar(mapa);
        jugador.moverALaDerecha();
        jugador.moverALaDerecha();

        String identificador = mapa.obtenerCasillero(new Point(0,2)).identificador();
        assertEquals("JUGADOR", identificador);
    }

    @Test
    public void SeVerificaQueCuandoelJugadorSeMuevaALaDerechaElCasilleroQueDejoSeEncuentreDisponibleParaSerOcupado(){
        Mapa mapa = new Mapa(12,12);
        Jugador jugador = new Jugador();

        jugador.iniciar(mapa); // El jugador Comienza En La Posicion [0,0]
        jugador.moverALaDerecha();
        assertFalse(mapa.obtenerCasillero(new Point(0,0)).estaOcupado());
    }

    @Test
    public void SeVerificaQueUnaVezElJugadorEsteEnElTopeDelTableroYaNoSePuedaMoverMasALaDerecha(){
        int tope = 12;
        Mapa mapa = new Mapa(12,13);
        Jugador jugador = new Jugador();

        jugador.iniciar(mapa); // El jugador Comienza En La Posicion [0,0]

        for (int i=0; i<=tope; i++){
            jugador.moverALaDerecha();;
        }
        //LLEGE AL BORDE DEL MAPA
        jugador.moverALaDerecha(); //INTENTO MOVERME UNA VEZ MAS

        String identificador = mapa.obtenerCasillero(new Point(0,tope)).identificador();
        assertEquals("JUGADOR",identificador);
    }

    @Test
    public void SeVerficaQueElJugadorSePuedaMoverHaciaArriba(){
        Mapa mapa = new Mapa(12,12);
        Jugador jugador = new Jugador();

        jugador.iniciar(mapa); // El jugador Comienza En La Posicion [0,0]
        jugador.moverParaArriba();
        jugador.moverParaArriba();

        String identificador = mapa.obtenerCasillero(new Point(2,0)).identificador();
        assertEquals("JUGADOR", identificador);
    }

    @Test
    public void SeVerificaQueUnaVezElJugadorEsteElTopeDelTableroYaNoSePuedaMoverParaAbajo(){
        Mapa mapa = new Mapa(12,12);
        Jugador jugador = new Jugador();
        jugador.iniciar(mapa);

        //LLEGE AL BORDE DEL MAPA
        jugador.moverParaAbajo(); //INTENTO MOVERME UNA VEZ MAS
        jugador.moverParaAbajo();
        jugador.moverParaAbajo();

        String identificador = mapa.obtenerCasillero(new Point(0,0)).identificador();
        assertEquals("JUGADOR",identificador);
    }

    @Test
    public void SeVerificaQueElJugadorSePuedaMoverParaAbajoSiEsPosible(){
        Mapa mapa = new Mapa(13,13);
        Jugador jugador = new Jugador();
        jugador.iniciar(mapa);

        jugador.moverParaAbajo();
        jugador.moverParaAbajo();
        String identificador = mapa.obtenerCasillero(new Point(0,0)).identificador();
        assertEquals("JUGADOR",identificador);
    }

    @Test
    public void SeVerificaQueElJugadorSePuedaMoverHaciaLaIzquierda() {
        Mapa mapa = new Mapa(13, 13);
        Jugador jugador = new Jugador();
        jugador.iniciar(mapa);

        jugador.moverALaDerecha();
        jugador.moverALaDerecha(); //Me muevo 3 veces hacia La Derecha
        jugador.moverALaDerecha();

        jugador.moverALaIzquierda();
        jugador.moverALaIzquierda();  //Me muevo 3 veces hacia la Izquierda
        jugador.moverALaIzquierda();
        String identificador = mapa.obtenerCasillero(new Point(0,0)).identificador();
        assertEquals("JUGADOR", identificador); //Volvi Donde comenze
    }

}
