import Jugador.Jugador;
import Materiales.MaterialDiamante;
import Materiales.MaterialMadera;
import Materiales.MaterialMetal;
import Materiales.MaterialPiedra;
import org.junit.Test;

import static org.junit.Assert.*;

/*public class TableroTest {
    @Test
    public void TablerRecienCreadoTiene144Celdas(){
        Tablero tablero = new Tablero();
        int nCeldas =  tablero.numeroDeCeldas();
        assertEquals(144,nCeldas);
    }

    @Test
    public void TableroRecienCreadoTiene17MaterialesEnElTablero(){
        Tablero tablero = new Tablero();
        int nMateriales = tablero.numeroDeMateriales();
        assertEquals(17, nMateriales);
    }

    @Test
    public void SeVerificaQueSePuedaOcuparUnLugarVacioEnElTablero(){
        Tablero tablero = new Tablero();

        boolean sePudoOcuparEnElTablero = tablero.agregar(1,11,new Jugador());
        assertTrue(sePudoOcuparEnElTablero);
    }

    @Test
    public void SeVerificaQueAlOcuparUnLugarEnELTableroYQueSePuedaObtenerAtributosDelObjetoQueSeEncuentreEnDichaPosicion(){
        Tablero tablero = new Tablero();

        boolean sePudoOcuparEnElTablero = tablero.agregar(1,5,new Jugador());
        assertTrue(sePudoOcuparEnElTablero);

        String identificador = tablero.obtener(1,5).identificador();
        assertEquals("JUGADOR",identificador);
    }

    @Test
    public void SeVerificaQueNoSePuedaOcuparUnCeldaLLena(){
        Tablero tablero = new Tablero();

        boolean sePudoOcuparEnElTablero = tablero.agregar(1,11,new Jugador());
        assertTrue(sePudoOcuparEnElTablero);

        sePudoOcuparEnElTablero = tablero.agregar(1,11,new Jugador());
        assertFalse(sePudoOcuparEnElTablero);
    }

    @Test
    public void SeVerificaQueSePuedeAgregarUnMaterialDeMaderaAlTablero(){
        Tablero tablero = new Tablero();

        boolean sePudoAgregarAlTablero = tablero.agregar(0,1,new MaterialMadera());
        assertTrue(sePudoAgregarAlTablero);
    }

    @Test
    public void SeVerificaQueUnaVezAgregadoUnMaterialMaderaYSePuedaObtenerAlgunAtributo(){
        Tablero tablero = new Tablero();

        tablero.agregar(0,1,new MaterialMadera());
        String identificador = tablero.obtener(0,1).identificador();

        assertEquals("MA",identificador);
    }

    @Test
    public void SeVerifcaQueSePuedaAgregarUnMaterialDePiedraALTablero(){
        Tablero tablero = new Tablero();

        boolean sePudoAgregarAlTablero = tablero.agregar(0,1,new MaterialPiedra());

        assertTrue(sePudoAgregarAlTablero);
    }

    @Test
    public void SeVerificaQueUnaVezAgregadoUnMaterialDePiedraSePuedaObtenerAlgunAtributo(){
        Tablero tablero = new Tablero();

        tablero.agregar(1,1,new MaterialPiedra());
        String identificador = tablero.obtener(1,1).identificador();

        assertEquals("P",identificador);
    }

    @Test
    public void SeVerificaQueSePuedaAlgregarUnMaterialDeMetalAlTablero(){
        Tablero tablero = new Tablero();

        boolean sePudoAgregarAlTablero = tablero.agregar(1,0,new MaterialMetal());

        assertTrue(sePudoAgregarAlTablero);
    }

    @Test
    public void SeVerificaQueUnaVezAgregadoUnMaterialDeMetalSePuedaObtenerAlgunAtributo(){
        Tablero tablero = new Tablero();

        tablero.agregar(1,0,new MaterialMetal());
        String identificador = tablero.obtener(1,0).identificador();

        assertEquals("MET",identificador);
    }

    @Test
    public void VerificaQueSePuedaAgregarUnMaterialDeDiamanteAlTablero(){
        Tablero tablero = new Tablero();

        boolean sePudoAgregarAlTablero = tablero.agregar(1,2,new MaterialDiamante());

        assertTrue(sePudoAgregarAlTablero);
    }

    @Test
    public  void SeVerificaQueUnaVezAgregadoUnMaterialDeDiamanteSePuedaObtenerAlgunAtributo(){
        Tablero tablero = new Tablero();

        tablero.agregar(8,12,new MaterialDiamante());
        String identificador = tablero.obtener(8,12).identificador();

        assertEquals("D",identificador);
    }

}

 */
