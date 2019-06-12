package Jugador;

import Herramientas.TipoDeHerramienta.Hacha;
import Herramientas.TipoDeHerramienta.MaterialDeHerramientas.MaterialDeHerramientaMadera;
import Herramientas.TipoDeHerramienta.TipoDeHerramienta;
import Juego.Mapa;
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
        String jugadorSeEncuentraEnELPrimerCasillero = mapa.obtenerCasillero(0,0).identificador();

        assertEquals("JUGADOR", jugadorSeEncuentraEnELPrimerCasillero);
    }

    @Test
    public void SeVerificiaQueElJugadorSePuedaMoverALaDerechaDesuposicionActual(){
        Mapa mapa = new Mapa(12,12);
        Jugador jugador = new Jugador();

        jugador.iniciar(mapa);
        jugador.moverALaDerecha();
        jugador.moverALaDerecha();

        String identificador = mapa.obtenerCasillero(0,2).identificador();
        assertEquals("JUGADOR", identificador);
    }

    @Test
    public void SeVerificaQueCuandoelJugadorSeMuevaALaDerechaElCasilleroQueDejoSeEncuentreDisponibleParaSerOcupado(){
        Mapa mapa = new Mapa(12,12);
        Jugador jugador = new Jugador();

        jugador.iniciar(mapa); // El jugador Comienza En La Posicion [0,0]
        jugador.moverALaDerecha();
        assertFalse(mapa.obtenerCasillero(0,0).estaOcupado());
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

        String identificador = mapa.obtenerCasillero(0,tope).identificador();
        assertEquals("JUGADOR",identificador);
    }

    @Test
    public void SeVerficaQueElJugadorSePuedaMoverHaciaAbajo(){
        Mapa mapa = new Mapa(12,12);
        Jugador jugador = new Jugador();

        jugador.iniciar(mapa); // El jugador Comienza En La Posicion [0,0]
        jugador.moverParaAbajo();
        jugador.moverParaAbajo();

        String identificador = mapa.obtenerCasillero(2,0).identificador();
        assertEquals("JUGADOR", identificador);
    }

    @Test
    public void SeVerificaQueUnaVezElJugadorEsteElTopeDelTableroYaNoSePuedaMoverParaAbajo(){
        int tope = 12;
        Mapa mapa = new Mapa(tope+1,12);
        Jugador jugador = new Jugador();
        jugador.iniciar(mapa);

        for(int i= 0; i< tope; i++){
            jugador.moverParaAbajo();
        }
        //LLEGE AL BORDE DEL MAPA
        jugador.moverParaAbajo(); //INTENTO MOVERME UNA VEZ MAS
        jugador.moverParaAbajo();
        jugador.moverParaAbajo();

        String identificador = mapa.obtenerCasillero(tope,0).identificador();
        assertEquals("JUGADOR",identificador);
    }

    @Test
    public void SeVerificaQueElJugadorSePuedaMoverParaArribaSiEsPosible(){
        Mapa mapa = new Mapa(13,13);
        Jugador jugador = new Jugador();
        jugador.iniciar(mapa);

        jugador.moverParaAriba(); //Como estoy en el Tope no me puedo mover
        String identificador = mapa.obtenerCasillero(0,0).identificador();
        assertEquals("JUGADOR",identificador); //Sigo donde comence

        jugador.moverParaAbajo();
        jugador.moverParaAbajo();
        jugador.moverParaAbajo();

        jugador.moverParaAriba();
        identificador = mapa.obtenerCasillero(2,0).identificador();
        assertEquals("JUGADOR",identificador);
    }

    @Test
    public void SeVerificaQueelJugadorSePuedaMoverHaciaLaIzquierda() {
        Mapa mapa = new Mapa(13, 13);
        Jugador jugador = new Jugador();
        jugador.iniciar(mapa);

        jugador.moverALaDerecha();
        jugador.moverALaDerecha(); //Me muevo 3 veces hacia La Derecha
        jugador.moverALaDerecha();

        jugador.moverALaIzquierda();
        jugador.moverALaIzquierda();  //Me muevo 3 veces hacia la Izquierda
        jugador.moverALaIzquierda();
        String identificador = mapa.obtenerCasillero(0, 0).identificador();
        assertEquals("JUGADOR", identificador); //Volvi Donde comenze
    }

}
