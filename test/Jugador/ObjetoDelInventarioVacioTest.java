package Jugador;

import Modelo.Jugador.ObjetoDelInventarioVacio;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ObjetoDelInventarioVacioTest {
    @Test
    public void siempreGeneraUnNombreVACIO(){
        ObjetoDelInventarioVacio vacio = new ObjetoDelInventarioVacio();
        assertEquals("VACIO",vacio.nombreDeElemento());
    }
}
