package HerramientaTest.Constructor;

import Herramientas.Constructor.TableroDeConstruccion;
import Jugador.Inventario;
import Materiales.UnidadElemental.UnidadElementalDiamante;
import Materiales.UnidadElemental.UnidadElementalMadera;
import Materiales.UnidadElemental.UnidadElementalMetal;
import Materiales.UnidadElemental.UnidadElementalPiedra;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

public class TableroDeConstruccionTest {
    //faltaTest de construir
    @Test
    public void seCreaUnTableroDeConstruccionCon9CeldasTodasVacias(){
        TableroDeConstruccion tablero = new TableroDeConstruccion();
        assertEquals (true ,tablero.verCelda(1,1).estaVacia());
        assertEquals (true ,tablero.verCelda(1,2).estaVacia());
        assertEquals (true ,tablero.verCelda(1,3).estaVacia());
        assertEquals (true ,tablero.verCelda(2,1).estaVacia());
        assertEquals (true ,tablero.verCelda(2,2).estaVacia());
        assertEquals (true ,tablero.verCelda(2,3).estaVacia());
        assertEquals (true ,tablero.verCelda(3,1).estaVacia());
        assertEquals (true ,tablero.verCelda(3,2).estaVacia());
        assertEquals (true ,tablero.verCelda(3,3).estaVacia());
    }
    @Test
    public void seCreaUnTableroDeConstruccionYSeAgreganElementosEnSusCeldas(){
        TableroDeConstruccion tablero = new TableroDeConstruccion();
        UnidadElementalDiamante diamante = new UnidadElementalDiamante();
        UnidadElementalMadera madera = new UnidadElementalMadera();
        UnidadElementalPiedra piedra = new UnidadElementalPiedra();
        UnidadElementalMetal metal = new UnidadElementalMetal();
        tablero.agregarElementoEnCelda(1,3,diamante);
        tablero.agregarElementoEnCelda(2,3,madera);
        tablero.agregarElementoEnCelda(3,3,piedra);
        tablero.agregarElementoEnCelda(1,1,metal);
        assertEquals(diamante,tablero.verCelda(1,3).verElemento());
        assertEquals(madera,tablero.verCelda(2,3).verElemento());
        assertEquals(piedra,tablero.verCelda(3,3).verElemento());
        assertEquals(metal,tablero.verCelda(1,1).verElemento());
    }
    @Test
    public void seCreaUnTableroDeConstruccionSeAgreganElementosEnSusCeldasYAlIntentarAgregarOtroElementoEnUnaCeldaOcupadaNoLoAgregaDejandoLosElementosQueYaEstaban(){
        TableroDeConstruccion tablero = new TableroDeConstruccion();
        UnidadElementalDiamante diamante = new UnidadElementalDiamante();
        UnidadElementalMadera madera = new UnidadElementalMadera();
        UnidadElementalPiedra piedra = new UnidadElementalPiedra();
        UnidadElementalMetal metal = new UnidadElementalMetal();
        UnidadElementalDiamante diamante2 = new UnidadElementalDiamante();
        UnidadElementalMadera madera2 = new UnidadElementalMadera();
        UnidadElementalPiedra piedra2 = new UnidadElementalPiedra();
        UnidadElementalMetal metal2 = new UnidadElementalMetal();
        tablero.agregarElementoEnCelda(1,3,diamante);
        tablero.agregarElementoEnCelda(2,3,madera);
        tablero.agregarElementoEnCelda(3,3,piedra);
        tablero.agregarElementoEnCelda(1,1,metal);
        tablero.agregarElementoEnCelda(1,3,piedra2);
        tablero.agregarElementoEnCelda(2,3,metal2);
        tablero.agregarElementoEnCelda(3,3,madera2);
        tablero.agregarElementoEnCelda(1,1,diamante2);
        assertEquals(diamante,tablero.verCelda(1,3).verElemento());
        assertEquals(madera,tablero.verCelda(2,3).verElemento());
        assertEquals(piedra,tablero.verCelda(3,3).verElemento());
        assertEquals(metal,tablero.verCelda(1,1).verElemento());
    }
    @Test
    public void seVaciaUnaCeldaYSuContenidoVaAPararAUnInventarioDejandoLaCeldaVacia(){
        TableroDeConstruccion tablero = new TableroDeConstruccion();
        Inventario inventario = new Inventario();
        UnidadElementalDiamante diamante = new UnidadElementalDiamante();
        tablero.agregarElementoEnCelda(1,3,diamante);
        tablero.quitarElementoEnCelda(1,3,inventario);
        assertEquals(1,inventario.cantidadDeElementos());
        assertNull(tablero.verCelda(1,3).verElemento());
    }
    @Test
    public void seConsumeElElementoDeUnaCeldaYSuContenidoDesapareceDejandoLaCeldaVacia(){
        TableroDeConstruccion tablero = new TableroDeConstruccion();
        UnidadElementalDiamante diamante = new UnidadElementalDiamante();
        tablero.agregarElementoEnCelda(1,3,diamante);
        tablero.consumirElemento(1,3);
        assertNull(tablero.verCelda(1,3).verElemento());
    }
}
