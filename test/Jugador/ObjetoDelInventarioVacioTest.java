package Jugador;

import Modelo.Jugador.ObjetoDelInventarioVacio;
import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ObjetoDelInventarioVacioTest {
    @Test
    public void siempreGeneraUnNombreVACIO(){
        ObjetoDelInventarioVacio vacio = new ObjetoDelInventarioVacio();
        assertEquals("VACIO",vacio.nombreDeElemento());
    }
    @Test
    public void elObjetoVacioNoEsEquipable(){
        ObjetoDelInventarioVacio vacio = new ObjetoDelInventarioVacio();
        Assert.assertFalse(vacio.equipable());
    }
}
