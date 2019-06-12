import Juego.Casillero;
import Juego.Mapa;
import Jugador.Jugador;
import Materiales.*;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class MapaTest {

    @Test
    public void TableroRecienIniciadoComienzaCon100Casilleros(){
        List<Material> materiales = new ArrayList<>();
        materiales.add(new MaterialMadera());
        materiales.add(new MaterialPiedra());
        materiales.add(new MaterialMetal());
        materiales.add(new MaterialMetal());

        Mapa mapa = new Mapa(materiales,10,10);
        int numeroDeCasillero = mapa.cantidadDeColumnas() * mapa.cantidadDeFilas();
        assertEquals(numeroDeCasillero , 100);
    }

    @Test
    public void TebleroRecienCreadoTiene30MaterialesDistribuidosPorEL(){
        List<Material> materiales = new ArrayList<>();
        materiales.add(new MaterialMadera());
        materiales.add(new MaterialPiedra());
        materiales.add(new MaterialMetal());
        materiales.add(new MaterialMetal());

        Mapa mapa = new Mapa(materiales,10,10);
        int cantidadDeMateriales = mapa.cantidadDeMateriales();
        assertEquals(cantidadDeMateriales,30);
    }

    @Test
    public void SeVerificaQueSePuedaOcuparUnLugarVacioEnElMapa(){
        List<Material> materiales = new ArrayList<>();
        materiales.add(new MaterialMadera());
        materiales.add(new MaterialPiedra());
        materiales.add(new MaterialMetal());
        materiales.add(new MaterialMetal());

        Mapa mapa = new Mapa(materiales,10,10);
        Casillero casillero =mapa.obtenerCasillero(1,9);
        boolean noEstaOcupado = casillero.estaOcupado();

        assertEquals(noEstaOcupado,false);
        boolean estaOcupado = casillero.asignar(new Jugador());
        assertEquals(estaOcupado,true);
    }

    @Test
    public void SeVerificaQueNoSePuedaOcuparUnCasilleroLleno(){
        List<Material> materiales = new ArrayList<>();
        materiales.add(new MaterialMadera());
        materiales.add(new MaterialPiedra());
        materiales.add(new MaterialMetal());
        materiales.add(new MaterialMetal());

        Mapa mapa = new Mapa(materiales,10,10);
        Casillero casillero = mapa.obtenerCasillero(1,9);

        boolean pudeOcupar = casillero.asignar(new Jugador());
        assertEquals(pudeOcupar,true);

        pudeOcupar = casillero.asignar(new Jugador());
        assertEquals(pudeOcupar,false);
        assertEquals(casillero.identificador(),"JUGADOR");
    }

    @Test
    public void SeVerificaQueSePuedaOcuparUnCasilleroPorUnMaterialDeMadera(){
        List<Material> materiales = new ArrayList<>();
        materiales.add(new MaterialMadera());
        materiales.add(new MaterialPiedra());
        materiales.add(new MaterialMetal());
        materiales.add(new MaterialMetal());

        Mapa mapa = new Mapa(materiales,10,10);
        Casillero casillero = mapa.obtenerCasillero(1,9);
        assertEquals(casillero.estaOcupado(),false);

        boolean pudeOcupar = casillero.asignar(new MaterialMadera());
        assertEquals(pudeOcupar,true);
        assertEquals(casillero.identificador(),"MA");
    }

    @Test
    public void SeVerificaQueSePuedaOcuparUnCasilleroPorUnMaterialDeMetal(){
        List<Material> materiales = new ArrayList<>();
        materiales.add(new MaterialMadera());
        materiales.add(new MaterialPiedra());
        materiales.add(new MaterialMetal());
        materiales.add(new MaterialMetal());

        Mapa mapa = new Mapa(materiales,10,10);
        Casillero casillero = mapa.obtenerCasillero(1,9);
        assertEquals(casillero.estaOcupado(),false);

        boolean pudeOcupar = casillero.asignar(new MaterialMetal());
        assertEquals(pudeOcupar,true);
        assertEquals(casillero.identificador(),"MET");
    }

    @Test
    public void SeVerificaQueSePuedeOcuparUnCasilleroConUnMaterialDePiedra(){
        List<Material> materiales = new ArrayList<>();
        materiales.add(new MaterialMadera());
        materiales.add(new MaterialPiedra());
        materiales.add(new MaterialMetal());
        materiales.add(new MaterialMetal());

        Mapa mapa = new Mapa(materiales,10,10);
        Casillero casillero = mapa.obtenerCasillero(1,9);
        assertEquals(casillero.estaOcupado(),false);

        boolean pudeOcupar = casillero.asignar(new MaterialPiedra());
        assertEquals(pudeOcupar,true);
    }

    @Test
    public void SeVerificaQueSePuedeOcuparUnCasilleroConUnMaterialDeDiamante(){
        List<Material> materiales = new ArrayList<>();
        materiales.add(new MaterialMadera());
        materiales.add(new MaterialPiedra());
        materiales.add(new MaterialMetal());
        materiales.add(new MaterialMetal());

        Mapa mapa = new Mapa(materiales,10,10);

        Casillero casillero = mapa.obtenerCasillero(1,9);
        assertEquals(casillero.estaOcupado(),false);

        boolean pudeOcupar = casillero.asignar(new MaterialDiamante());
        assertEquals(pudeOcupar,true);
    }




}

