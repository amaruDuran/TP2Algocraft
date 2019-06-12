package Juego;
import Jugador.Jugador;
import Materiales.*;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class MapaTest {

    @Test
    public void TableroRecienCreadoDe12FilasY12ColumasTiene144Casilleros(){
        Mapa mapa = new Mapa(12,12);
        int numeroDeCasillero = mapa.cantidadDeColumnas() * mapa.cantidadDeFilas();
        assertEquals(numeroDeCasillero , 144);
    }

    @Test
    public void SeVerificaQueSePuedaOcuparUnLugarVacioEnElMapa(){
        Mapa mapa = new Mapa(10,10);
        Casillero casillero =mapa.obtenerCasillero(4,9);
        boolean noEstaOcupado = casillero.estaOcupado();

        assertEquals(noEstaOcupado,false);
        boolean estaOcupado = casillero.asignar(new Jugador());
        assertEquals(estaOcupado,true);
    }

    @Test
    public void SeVerificaQueNoSePuedaAgregarUnCasilleroLleno(){

        Mapa mapa = new Mapa(10,10);
        Casillero casillero = mapa.obtenerCasillero(1,9);

        boolean puedoAgregar = casillero.asignar(new Jugador());
        assertEquals(puedoAgregar,true);

        puedoAgregar = casillero.asignar(new Jugador());
        assertEquals(puedoAgregar,false);
        assertEquals(casillero.identificador(),"JUGADOR");
    }

    @Test
    public void SeVerificaQueSePuedaAgregarUnCasilleroPorUnMaterialDeMadera() {

        Mapa mapa = new Mapa(10, 10);
        Casillero casillero = mapa.obtenerCasillero(1, 9);
        assertEquals(casillero.estaOcupado(), false);

        boolean agrege = casillero.asignar(new MaterialMadera());
        assertEquals(agrege, true);
    }
    @Test
    public void SeVerificaQueAlAgregarUnMaterialMaderaPuedoObtenerSusAtributos(){
        Mapa mapa = new Mapa(10,10);

        Casillero casillero = mapa.obtenerCasillero(1,9);
        assertEquals(casillero.estaOcupado(),false);

        casillero.asignar(new MaterialMadera());
        assertEquals(casillero.identificador(),"MA");
    }

    @Test
    public void SeVerificaQueSePuedaAgregarCasilleroPorUnMaterialDeMetal(){
        Mapa mapa = new Mapa(10,10);
        Casillero casillero = mapa.obtenerCasillero(1,9);
        assertEquals(casillero.estaOcupado(),false);

        boolean agrege = casillero.asignar(new MaterialMetal());
        assertEquals(agrege,true);
    }

    @Test
    public void SeVerificaQueAlAgregarUnMaterialMetalPuedaObtenerSusAtributos(){
        Mapa mapa = new Mapa(10,10);

        Casillero casillero = mapa.obtenerCasillero(5,9);
        assertEquals(casillero.estaOcupado(),false);

        casillero.asignar(new MaterialMetal());
        assertEquals(casillero.identificador(),"MET");
    }

    @Test
    public void SeVerificaQueSePuedeAgregarUnCasilleroConUnMaterialDePiedra(){
        Mapa mapa = new Mapa(10,10);
        Casillero casillero = mapa.obtenerCasillero(1,9);
        assertEquals(casillero.estaOcupado(),false);

        boolean agrege = casillero.asignar(new MaterialPiedra());
        assertEquals(agrege,true);
    }

    @Test
    public void SeVerificaQueAlAgregarUnMaterialPiedraYPuedaObtenerSusAtributos(){
        Mapa mapa = new Mapa(10,10);

        Casillero casillero = mapa.obtenerCasillero(1,9);
        assertEquals(casillero.estaOcupado(),false);

        casillero.asignar(new MaterialPiedra());
        assertEquals(casillero.identificador(),"P");
    }

    @Test
    public void SeVerificaQueSePuedeAgregarUnCasilleroConUnMaterialDeDiamante(){
        Mapa mapa = new Mapa(10,10);

        Casillero casillero = mapa.obtenerCasillero(1,9);
        assertEquals(casillero.estaOcupado(),false);

        boolean agrege = casillero.asignar(new MaterialDiamante());
        assertEquals(agrege,true);
    }

    @Test
    public void SeVerificaQueAlAgregarUnMaterialDediamantePuedaObtenerSusAtributos(){
        Mapa mapa = new Mapa(10,10);

        Casillero casillero = mapa.obtenerCasillero(1,9);
        assertEquals(casillero.estaOcupado(),false);

        casillero.asignar(new MaterialDiamante());
        assertEquals(casillero.identificador(),"D");
    }
}

