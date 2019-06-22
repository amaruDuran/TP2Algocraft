package HerramientaTest.Constructor;

import Modelo.Herramientas.Constructor.CeldaDeConstruccion;
import Modelo.Jugador.Inventario;
import Modelo.Materiales.UnidadElemental.UnidadElemental;
import Modelo.Materiales.UnidadElemental.UnidadElementalMadera;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

public class CeldaDeConstruccionTest {
    @Test
    public void seCreaUnaCeldaNuevaEstaVacia(){
        CeldaDeConstruccion celdaDeConstruccion = new CeldaDeConstruccion();
        assertEquals(true,celdaDeConstruccion.estaVacia());
    }
    @Test
    public void seCreaUnaCeldaVaciaConSuElementoNulo(){
        CeldaDeConstruccion celdaDeConstruccion = new CeldaDeConstruccion();

        assertNull(celdaDeConstruccion.verElemento());
    }
    @Test
    public void seCreaUnaCeldaYSeLeAgregaUnElemento(){
        CeldaDeConstruccion celdaDeConstruccion = new CeldaDeConstruccion();
        UnidadElemental madera = new UnidadElementalMadera();

        celdaDeConstruccion.agregarElemento(madera);

        assertEquals(madera, celdaDeConstruccion.verElemento());
    }
    @Test
    public void seCreaUnaCeldaYSeLeAsignaUnElementoYaNoEstaVacia(){
        CeldaDeConstruccion celdaDeConstruccion = new CeldaDeConstruccion();
        UnidadElemental elemento = new UnidadElementalMadera();
        celdaDeConstruccion.agregarElemento(elemento);
        assertEquals(false, celdaDeConstruccion.estaVacia());
    }
    @Test
    public void seCreaUnaCeldaSeLeAsignaUnElementoYSeLoQuitaDeVolviendoloAlInventarioQuedandoseSinElemento(){
        CeldaDeConstruccion celdaDeConstruccion = new CeldaDeConstruccion();
        Inventario inventario = new Inventario();
        UnidadElemental elemento = new UnidadElementalMadera();

        celdaDeConstruccion.agregarElemento(elemento);
        celdaDeConstruccion.quitarElemento(inventario);

        assertNull(celdaDeConstruccion.verElemento());
        assertEquals(1, inventario.cantidadDeElementos());

    }
}
