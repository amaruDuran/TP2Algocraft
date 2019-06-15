package Juego;
import Jugador.Jugador;
import Materiales.*;
import org.junit.Test;

import java.awt.*;

import static org.junit.Assert.assertEquals;

public class MapaTest {

    @Test
    public void TableroRecienCreadoDe12FilasY12ColumasTiene144Casilleros(){
        Mapa mapa = new Mapa(12,12);
        int numeroDeCasillero = mapa.cantidadDeColumnas() * mapa.cantidadDeFilas();
        assertEquals(numeroDeCasillero , 144);
    }

    @Test
    public void TableroRecienCreadoDe20FilasY10ColumasTiene200Casilleros(){
        Mapa mapa = new Mapa(20,10);
        int numeroDeCasillero = mapa.cantidadDeColumnas() * mapa.cantidadDeFilas();
        assertEquals(200 , numeroDeCasillero);
    }

    @Test
    public void TableroRecienCreadoDe7FilasY9ColumasLanzaErroPorSerDeTamanioInvalido(){
        boolean thrown = false;

        try {
            Mapa mapa = new Mapa(7,9);
        } catch (ErrorDeCreacionDelMapaTamanioInvalido e) {
            thrown = true;
        }
        assert(thrown);
    }
    @Test
    public void TableroRecienCreadoDe9FilasY7ColumasLanzaErroPorSerDeTamanioInvalido(){
        boolean thrown = false;

        try {
            Mapa mapa = new Mapa(9,7);
        } catch (ErrorDeCreacionDelMapaTamanioInvalido e) {
            thrown = true;
        }
        assert(thrown);
    }
    @Test
    public void TableroRecienCreadoDe7FilasY7ColumasLanzaErroPorSerDeTamanioInvalido(){
        boolean thrown = false;

        try {
            Mapa mapa = new Mapa(7,7);
        } catch (ErrorDeCreacionDelMapaTamanioInvalido e) {
            thrown = true;
        }
        assert(thrown);
    }

    @Test
    public void SeVerificaQueSePuedaOcuparUnLugarVacioEnElMapa(){
        Mapa mapa = new Mapa(10,10);
        Casillero casillero = mapa.obtenerCasillero(new Point(4,9));
        boolean noEstaOcupado = casillero.estaOcupado();

        assertEquals(noEstaOcupado,false);
        boolean estaOcupado = casillero.asignar(new Jugador());
        assertEquals(estaOcupado,true);
    }

    @Test
    public void SeVerificaQueNoSePuedaAgregarUnCasilleroLleno(){

        Mapa mapa = new Mapa(10,10);
        Casillero casillero = mapa.obtenerCasillero(new Point(1,9));

        boolean puedoAgregar = casillero.asignar(new Jugador());
        assertEquals(puedoAgregar,true);

        puedoAgregar = casillero.asignar(new Jugador());
        assertEquals(puedoAgregar,false);
        assertEquals(casillero.identificador(),"JUGADOR");
    }

    @Test
    public void SeVerificaQueSePuedaAgregarUnCasilleroPorUnMaterialDeMadera() {

        Mapa mapa = new Mapa(10, 10);
        Casillero casillero = mapa.obtenerCasillero(new Point(1,9));
        assertEquals(casillero.estaOcupado(), false);

        boolean agrege = casillero.asignar(new MaterialMadera());
        assertEquals(agrege, true);
    }
    @Test
    public void SeVerificaQueAlAgregarUnMaterialMaderaPuedoObtenerSusAtributos(){
        Mapa mapa = new Mapa(10,10);

        Casillero casillero = mapa.obtenerCasillero(new Point(1,9));
        assertEquals(casillero.estaOcupado(),false);

        casillero.asignar(new MaterialMadera());
        assertEquals(casillero.identificador(),"MA");
    }

    @Test
    public void SeVerificaQueSePuedaAgregarCasilleroPorUnMaterialDeMetal(){
        Mapa mapa = new Mapa(10,10);
        Casillero casillero = mapa.obtenerCasillero(new Point(1,9));
        assertEquals(casillero.estaOcupado(),false);

        boolean agrege = casillero.asignar(new MaterialMetal());
        assertEquals(agrege,true);
    }

    @Test
    public void SeVerificaQueAlAgregarUnMaterialMetalPuedaObtenerSusAtributos(){
        Mapa mapa = new Mapa(10,10);

        Casillero casillero = mapa.obtenerCasillero(new Point(5,9));
        assertEquals(casillero.estaOcupado(),false);

        casillero.asignar(new MaterialMetal());
        assertEquals(casillero.identificador(),"MET");
    }

    @Test
    public void SeVerificaQueSePuedeAgregarUnCasilleroConUnMaterialDePiedra(){
        Mapa mapa = new Mapa(10,10);
        Casillero casillero = mapa.obtenerCasillero(new Point(1,9));
        assertEquals(casillero.estaOcupado(),false);

        boolean agrege = casillero.asignar(new MaterialPiedra());
        assertEquals(agrege,true);
    }

    @Test
    public void SeVerificaQueAlAgregarUnMaterialPiedraYPuedaObtenerSusAtributos(){
        Mapa mapa = new Mapa(10,10);

        Casillero casillero = mapa.obtenerCasillero(new Point(1,9));
        assertEquals(casillero.estaOcupado(),false);

        casillero.asignar(new MaterialPiedra());
        assertEquals(casillero.identificador(),"P");
    }

    @Test
    public void SeVerificaQueSePuedeAgregarUnCasilleroConUnMaterialDeDiamante(){
        Mapa mapa = new Mapa(10,10);

        Casillero casillero = mapa.obtenerCasillero(new Point(1,9));
        assertEquals(casillero.estaOcupado(),false);

        boolean agrege = casillero.asignar(new MaterialDiamante());
        assertEquals(agrege,true);
    }

    @Test
    public void SeVerificaQueAlAgregarUnMaterialDediamantePuedaObtenerSusAtributos(){
        Mapa mapa = new Mapa(10,10);

        Casillero casillero = mapa.obtenerCasillero(new Point(1,9));
        assertEquals(casillero.estaOcupado(),false);

        casillero.asignar(new MaterialDiamante());
        assertEquals(casillero.identificador(),"D");
    }

    @Test
    public void SeVerificaQueUnMapaDe10Por10NoPoseaCasillerosFueraDeEl(){
        Mapa mapa = new Mapa(10,10);
        assertEquals(false, mapa.existeUbicacion(new Point(-1,5)));
        assertEquals(false, mapa.existeUbicacion(new Point(5,-1)));
        assertEquals(false, mapa.existeUbicacion(new Point(-1,-1)));
        assertEquals(false, mapa.existeUbicacion(new Point(-1,10)));
        assertEquals(false, mapa.existeUbicacion(new Point(10,-1)));
        assertEquals(false, mapa.existeUbicacion(new Point(10,5)));
        assertEquals(false, mapa.existeUbicacion(new Point(5,10)));
        assertEquals(false, mapa.existeUbicacion(new Point(10,10)));
    }

    @Test
    public void SeVerificaQueUnMapaDe10Por10PoseaCasillerosDentroDeEl(){
        Mapa mapa = new Mapa(10,10);
        assertEquals(true, mapa.existeUbicacion(new Point(0,5)));
        assertEquals(true, mapa.existeUbicacion(new Point(5,0)));
        assertEquals(true, mapa.existeUbicacion(new Point(0,0)));
        assertEquals(true, mapa.existeUbicacion(new Point(0,9)));
        assertEquals(true, mapa.existeUbicacion(new Point(9,0)));
        assertEquals(true, mapa.existeUbicacion(new Point(9,5)));
        assertEquals(true, mapa.existeUbicacion(new Point(5,9)));
        assertEquals(true, mapa.existeUbicacion(new Point(9,9)));
    }
}

