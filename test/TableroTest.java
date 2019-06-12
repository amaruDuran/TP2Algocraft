import Juego.Celda;
import Juego.Tablero;
import Jugador.Jugador;
import org.junit.Test;

import static org.junit.Assert.*;

public class TableroTest {
    @Test
    public void TablerRecienCreadoTiene117Celdas(){
        Tablero tablero = new Tablero();
        int nCeldas =  tablero.numeroDeCeldas();
        assertEquals(117,nCeldas);
    }

    @Test
    public void TableroRecienCreadoTiene17MaterialesEnElTablero(){
        Tablero tablero = new Tablero();
        int nMateriales = tablero.numeroDeMateriales();
        assertEquals(16, nMateriales);
    }

    @Test
    public void SeVerificaQueSePuedaOcuparUnLugarVacioEnElTablero(){
        Tablero tablero = new Tablero();

        boolean sePudoOcuparEnElTablero = tablero.agregar(0,0,new Jugador());
        assertTrue(sePudoOcuparEnElTablero);
    }

    @Test
    public void SeVerificaQueAlOcuparUnLugarEnELTableroYQueSePuedaObtenerAtributosDelObjetoQueSeEncuentreEnDichaPosicion(){
        Tablero tablero = new Tablero();

        boolean sePudoOcuparEnElTablero = tablero.agregar(0,0,new Jugador());
        assertTrue(sePudoOcuparEnElTablero);

        String identificador = tablero.obtener(0,0).identificador();
        assertEquals("JUGADOR",identificador);
    }

    @Test
    public void SeVerificaQueNoSePuedaOcuparUnCeldaLLena(){
        Tablero tablero = new Tablero();

        boolean sePudoOcuparEnElTablero = tablero.agregar(0,0,new Jugador());
        assertTrue(sePudoOcuparEnElTablero);

        sePudoOcuparEnElTablero = tablero.agregar(0,0,new Jugador());
        assertFalse(sePudoOcuparEnElTablero);
    }

    @Test
    public void SeVerificaQu
}
