package Jugador;

import Modelo.Herramientas.TipoDeHerramienta.Hacha;
import Modelo.Herramientas.TipoDeHerramienta.MaterialDeHerramientas.MaterialDeHerramientaMadera;
import Modelo.Herramientas.TipoDeHerramienta.MaterialDeHerramientas.MaterialDeHerramientaMetalPiedra;
import Modelo.Herramientas.TipoDeHerramienta.PicoFino;
import Modelo.Herramientas.TipoDeHerramienta.TipoDeHerramienta;
import Modelo.Jugador.Jugador;
import Modelo.Juego.Mapa;
import Modelo.Juego.ObjetoDelTablero;
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
        ObjetoDelTablero objeto = mapa.obtenerCasillero(new Point(0,0)).getObjeto();

        assertEquals(objeto.equals(new Jugador()),true);
    }

    @Test
    public void SeVerificaQueElJugadorSePuedaMoverParaAbajo(){
        Mapa mapa = new Mapa(13,13);
        Jugador jugador = new Jugador();
        jugador.iniciar(mapa);

        jugador.moverParaAbajo();
        jugador.moverParaAbajo();
        ObjetoDelTablero objetoDelCasillero = mapa.obtenerCasillero(new Point(0,2)).getObjeto();
        assertEquals(jugador, objetoDelCasillero);
    }

    @Test
    public void SeVerificiaQueElJugadorSePuedaMoverALaDerechaDesuposicionActual(){
        Mapa mapa = new Mapa(12,12);
        Jugador jugador = new Jugador();

        jugador.iniciar(mapa);
        jugador.moverALaDerecha();
        jugador.moverALaDerecha();

        ObjetoDelTablero objetoEnCasillero = mapa.obtenerCasillero(new Point(2,0)).getObjeto();
        assertTrue(objetoEnCasillero.equals(new Jugador()));
    }

    @Test
    public void SeVerificaQueCuandoelJugadorSeMuevaSeEncuentreEnElCasilleroDeSuUltimaPosicion(){
        Mapa mapa = new Mapa(12,12);
        Jugador jugador = new Jugador();

        jugador.iniciar(mapa); // El jugador Comienza En La Posicion [0,0]
        jugador.moverALaDerecha();
        jugador.moverParaAbajo();
        jugador.moverParaAbajo();
        jugador.moverALaDerecha();
        jugador.moverALaIzquierda();
        assertTrue(mapa.obtenerCasillero(new Point(2,1)).estaOcupado());
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
        ObjetoDelTablero objeto = mapa.obtenerCasillero(new Point(0,0)).getObjeto();
        assertEquals(jugador, objeto);
    }

    @Test
    public void SeVerificaQueUnaVezElJugadorEsteEnElTopeDelTableroYaNoSePuedaMoverMasALaDerecha(){
        Mapa mapa = new Mapa(12,12);
        Jugador jugador = new Jugador();

        jugador.iniciar(mapa); // El jugador Comienza En La Posicion [0,0]

        for (int i=0; i < 12; i++){
            jugador.moverALaDerecha();
        }
        //LLEGE AL BORDE DEL MAPA
        jugador.moverALaDerecha(); //INTENTO MOVERME UNA VEZ MAS
        jugador.moverALaDerecha(); //INTENTO MOVERME UNA VEZ MAS


        ObjetoDelTablero objetoDelTablero = mapa.obtenerCasillero(new Point(11,0)).getObjeto();
        assertTrue(objetoDelTablero.equals(new Jugador()));
    }

    @Test
    public void SeVerficaQueElJugadorNoSePuedaMoverHaciaArriba(){
        Mapa mapa = new Mapa(12,12);
        Jugador jugador = new Jugador();

        jugador.iniciar(mapa); // El jugador Comienza En La Posicion [0,0]
        jugador.moverParaArriba();
        jugador.moverParaArriba();

        ObjetoDelTablero objetoDelCasillero = mapa.obtenerCasillero(new Point(0,0)).getObjeto();
        assertEquals(jugador, objetoDelCasillero);
    }

    @Test
    public void SeVerificaQueUnaVezElJugadorEsteElTopeDelTableroYaNoSePuedaMoverParaAbajo(){
        Mapa mapa = new Mapa(12,12);
        Jugador jugador = new Jugador();
        jugador.iniciar(mapa);

        for(int i = 0; i < 12; i++){
            jugador.moverParaAbajo();
        }
        // ME ENCUENTRO EN EL BORDE DEL TABLERO
        jugador.moverParaAbajo();
        jugador.moverParaAbajo();

        ObjetoDelTablero objetoDelCasillero = mapa.obtenerCasillero(new Point(0,11)).getObjeto();
        assertEquals(jugador, objetoDelCasillero);
    }

    @Test
    public void elJugadorIniciaConUnaHerramientaEnManoYSeLaDesEquipaQuedandoseSinHerramientaEnMano(){
        Jugador jugador = new Jugador();
        jugador.desequipar();
        assertNull(jugador.obtenerHerramientaEnMano());
    }
    @Test
    public void elJugadorIniciaConUnaHerramientaEnManoYSeLaDesEquipaColocandoseEnSuInventario(){
        Jugador jugador = new Jugador();
        TipoDeHerramienta herramienta = jugador.obtenerHerramientaEnMano();
        jugador.desequipar();
        assertNull(jugador.obtenerHerramientaEnMano());
        assertEquals(herramienta,jugador.quitarObjetoDelInventario(0));
    }
    @Test
    public void elJugadorDesequipaSuHerramientaYNoPuedeDesequiparOtraVez(){
        Jugador jugador = new Jugador();
        TipoDeHerramienta herramienta = jugador.obtenerHerramientaEnMano();
        jugador.desequipar();
        jugador.desequipar();
        assertEquals(1,jugador.cantidadDeElementosDelInventario());
        assertNull(jugador.obtenerHerramientaEnMano());
    }
    @Test
    public void elJugadorIniciaConUnaHerramientaEnManoSeAgregaOtraAlInventarioYSeLaEquipaColocandolaEnsuManoYGuardandoLaAnterior(){
        Jugador jugador = new Jugador();
        TipoDeHerramienta pico = new PicoFino(new MaterialDeHerramientaMetalPiedra());
        jugador.equipar(pico);
        assertEquals(pico,jugador.obtenerHerramientaEnMano());
        assertEquals(1,jugador.cantidadDeElementosDelInventario());
    }
}
