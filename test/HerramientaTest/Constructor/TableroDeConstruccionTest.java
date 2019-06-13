package HerramientaTest.Constructor;

import Herramientas.Constructor.TableroDeConstruccion;
import Jugador.Inventario;
import Materiales.UnidadElemental.*;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

public class TableroDeConstruccionTest {
    //faltaTest de construir
    @Test
    public void TableroDeConstruccionSeCreaCon9CeldasInicialmenteVacias(){
        TableroDeConstruccion tablero = new TableroDeConstruccion();

        //Respeta el Encapsulamiento. No interesa si se implementó con celdas o Lo que sea.
        assertEquals (true , tablero.posicionEstaVacia(1,1));
        assertEquals (true , tablero.posicionEstaVacia(1,2));
        assertEquals (true , tablero.posicionEstaVacia(1,3));
        assertEquals (true , tablero.posicionEstaVacia(2,1));
        assertEquals (true , tablero.posicionEstaVacia(2,2));
        assertEquals (true , tablero.posicionEstaVacia(2,3));
        assertEquals (true , tablero.posicionEstaVacia(3,1));
        assertEquals (true , tablero.posicionEstaVacia(3,2));
        assertEquals (true , tablero.posicionEstaVacia(3,3));
    }

    @Test
    public void TableroDeConstruccionAgregarElementosEnPosicionesVacias(){
        TableroDeConstruccion tablero = new TableroDeConstruccion();
        UnidadElementalDiamante diamante = new UnidadElementalDiamante();
        UnidadElementalMadera madera = new UnidadElementalMadera();
        UnidadElementalPiedra piedra = new UnidadElementalPiedra();
        UnidadElementalMetal metal = new UnidadElementalMetal();

        assertEquals(true, tablero.agregarElementoEnCelda(1,3,diamante));
        assertEquals(true, tablero.agregarElementoEnCelda(2,3,madera));
        assertEquals(true, tablero.agregarElementoEnCelda(3,3,piedra));
        assertEquals(true, tablero.agregarElementoEnCelda(1,1,metal));
    }

    @Test
    public void TableroDeConstruccionObtieneElementosEnlaPosicionAdecuadaUnaVezAgregados(){
        TableroDeConstruccion tablero = new TableroDeConstruccion();
        UnidadElementalDiamante diamante = new UnidadElementalDiamante();
        UnidadElementalMadera madera = new UnidadElementalMadera();
        UnidadElementalPiedra piedra = new UnidadElementalPiedra();
        UnidadElementalMetal metal = new UnidadElementalMetal();

        tablero.agregarElementoEnCelda(1, 3,diamante);
        tablero.agregarElementoEnCelda(2, 3,madera);
        tablero.agregarElementoEnCelda(3, 3,piedra);
        tablero.agregarElementoEnCelda(1, 1,metal);

        assertEquals(diamante, tablero.obtenerElementoDe(1,3));
        assertEquals(madera, tablero.obtenerElementoDe(2,3));
        assertEquals(piedra, tablero.obtenerElementoDe(3,3));
        assertEquals(metal, tablero.obtenerElementoDe(1,1));
    }
    @Test
    public void TableroDeConstruccionAgregarElementosEnPosicionesOcupadasPreservaElElementoOcupado(){
        TableroDeConstruccion tablero = new TableroDeConstruccion();
        UnidadElementalDiamante diamante = new UnidadElementalDiamante();
        UnidadElementalMadera madera = new UnidadElementalMadera();
        UnidadElementalPiedra piedra = new UnidadElementalPiedra();
        UnidadElementalMetal metal = new UnidadElementalMetal();
        UnidadElementalDiamante diamante2 = new UnidadElementalDiamante();
        UnidadElementalMadera madera2 = new UnidadElementalMadera();
        UnidadElementalPiedra piedra2 = new UnidadElementalPiedra();
        UnidadElementalMetal metal2 = new UnidadElementalMetal();

        tablero.agregarElementoEnCelda(1, 3, diamante);
        tablero.agregarElementoEnCelda(2, 3, madera);
        tablero.agregarElementoEnCelda(3, 3, piedra);
        tablero.agregarElementoEnCelda(1, 1, metal);
        tablero.agregarElementoEnCelda(1, 3, piedra2);
        tablero.agregarElementoEnCelda(2, 3, metal2);
        tablero.agregarElementoEnCelda(3, 3, madera2);
        tablero.agregarElementoEnCelda(1, 1, diamante2);

        assertEquals(diamante, tablero.obtenerElementoDe(1, 3));
        assertEquals(madera, tablero.obtenerElementoDe(2, 3));
        assertEquals(piedra, tablero.obtenerElementoDe(3, 3));
        assertEquals(metal, tablero.obtenerElementoDe(1, 1));
    }

    @Test
    public void TableroConElementosIdentificaCeldasVacias(){
        UnidadElemental madera1 = new UnidadElementalMadera();
        UnidadElemental madera2 = new UnidadElementalMadera();
        UnidadElemental madera3 = new UnidadElementalMadera();
        UnidadElemental madera4 = new UnidadElementalMadera();
        UnidadElemental madera5 = new UnidadElementalMadera();

        TableroDeConstruccion tablero = new TableroDeConstruccion();

        tablero.agregarElementoEnCelda(1,1, madera1);
        tablero.agregarElementoEnCelda(1,2, madera2);
        tablero.agregarElementoEnCelda(2,1, madera3);
        tablero.agregarElementoEnCelda(2,2, madera4);
        tablero.agregarElementoEnCelda(3,2, madera5);

        assertEquals(null, tablero.obtenerElementoDe(1,3));
        assertEquals(null, tablero.obtenerElementoDe(2,3));
        assertEquals(null, tablero.obtenerElementoDe(3,1));
        assertEquals(null, tablero.obtenerElementoDe(3,3));
    }

    @Test
    public void seVaciaUnaCeldaYSuContenidoVaAPararAUnInventarioDejandoLaCeldaVacia(){
        TableroDeConstruccion tablero = new TableroDeConstruccion();
        Inventario inventario = new Inventario();
        UnidadElementalDiamante diamante = new UnidadElementalDiamante();
        tablero.agregarElementoEnCelda(1, 3, diamante);
        tablero.quitarElementoEnCelda(1, 3, inventario);

        assertEquals(1, inventario.cantidadDeElementos());
        assertNull(tablero.obtenerElementoDe(1,3));
    }
    @Test
    public void seConsumeElElementoDeUnaCeldaYSuContenidoDesapareceDejandoLaCeldaVacia(){
        TableroDeConstruccion tablero = new TableroDeConstruccion();
        UnidadElementalDiamante diamante = new UnidadElementalDiamante();
        tablero.agregarElementoEnCelda(1,3,diamante);
        tablero.consumirElemento(1,3);
        assertNull(tablero.obtenerElementoDe(1,3));
    }


}
