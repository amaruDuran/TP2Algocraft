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

        Mapa mapa = new Mapa(materiales);
        int numeroDeCasillero = mapa.cantidadDeColumnas() * mapa.cantidadDeFilas();
        assertEquals(numeroDeCasillero , 100);
    }

    @Test
    public void TableroRecienCreadoComienzaConAlMenosUnMaterial(){
        List<Material> materiales = new ArrayList<>();
        materiales.add(new MaterialMadera());
        materiales.add(new MaterialPiedra());
        materiales.add(new MaterialMetal());
        materiales.add(new MaterialMetal());

        Mapa mapa = new Mapa(materiales);
        boolean hayMaterial = mapa.existeMaterialEnMapa();
        assertEquals(hayMaterial,true);
    }

    @Test
    public void TebleroRecienCreadoTiene30MaterialesDistribuidosPorEL(){
        List<Material> materiales = new ArrayList<>();
        materiales.add(new MaterialMadera());
        materiales.add(new MaterialPiedra());
        materiales.add(new MaterialMetal());
        materiales.add(new MaterialMetal());

        Mapa mapa = new Mapa(materiales);
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

        Mapa mapa = new Mapa(materiales);
        Casillero[][] tablero = mapa.indicar();
        Casillero casillero = tablero[1][9];
        assertEquals(casillero.estaOcupado(),false);
    }




}

