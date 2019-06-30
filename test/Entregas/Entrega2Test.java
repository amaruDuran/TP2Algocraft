package Entregas;

import Modelo.Herramientas.Constructor.TableroDeConstruccion;
import Modelo.Herramientas.TipoDeHerramienta.Hacha;
import Modelo.Herramientas.TipoDeHerramienta.MaterialDeHerramientas.MaterialDeHerramientaMadera;
import Modelo.Herramientas.TipoDeHerramienta.TipoDeHerramienta;
import Modelo.Juego.*;
import Modelo.Jugador.Jugador;
import Modelo.Materiales.MaterialDiamante;
import Modelo.Materiales.MaterialMadera;
import Modelo.Materiales.MaterialMetal;
import Modelo.Materiales.MaterialPiedra;
import Modelo.Materiales.UnidadElemental.UnidadElemental;
import Modelo.Materiales.UnidadElemental.UnidadElementalMadera;
import Modelo.Materiales.UnidadElemental.UnidadElementalMetal;
import Modelo.Materiales.UnidadElemental.UnidadElementalPiedra;
import org.junit.Test;

import java.awt.*;

import static org.junit.Assert.*;
import static org.junit.Assert.assertTrue;

public class Entrega2Test {
    //Construcción de herramienta:
    //Se verifica la correcta construcción de cada herramienta con su correspondiente forma de creación y materiales.


    @Test
    public void ContruccionDeHachaDeMaderaConSuFuerzaYDurabilidadInicial() {
        //UnidadesElementales de Material Que se utilizan para su construcción.
        UnidadElemental madera1 = new UnidadElementalMadera();
        UnidadElemental madera2 = new UnidadElementalMadera();
        UnidadElemental madera3 = new UnidadElementalMadera();
        UnidadElemental madera4 = new UnidadElementalMadera();
        UnidadElemental madera5 = new UnidadElementalMadera();

        TableroDeConstruccion tablero = new TableroDeConstruccion();

        tablero.agregarElementoEnCelda(1, 1, madera1);
        tablero.agregarElementoEnCelda(1, 2, madera2);
        tablero.agregarElementoEnCelda(2, 1, madera3);
        tablero.agregarElementoEnCelda(2, 2, madera4);
        tablero.agregarElementoEnCelda(3, 2, madera5);

        TipoDeHerramienta hachaDeMadera = tablero.construir();

        assertEquals(2, hachaDeMadera.fuerza());
        assertEquals(100, hachaDeMadera.durabilidad());
    }


    @Test
    public void ContruccionDeHachaDePiedraConSuFuerzaYDurabilidadInicial() {
        //UnidadesElementales de Material Que se utilizan para su construcción.
        UnidadElemental madera1 = new UnidadElementalMadera();
        UnidadElemental madera2 = new UnidadElementalMadera();
        UnidadElemental piedra1 = new UnidadElementalPiedra();
        UnidadElemental piedra2 = new UnidadElementalPiedra();
        UnidadElemental piedra3 = new UnidadElementalPiedra();
        TableroDeConstruccion tablero = new TableroDeConstruccion();

        tablero.agregarElementoEnCelda(1, 1, piedra1);
        tablero.agregarElementoEnCelda(1, 2, piedra2);
        tablero.agregarElementoEnCelda(2, 1, piedra3);
        tablero.agregarElementoEnCelda(2, 2, madera1);
        tablero.agregarElementoEnCelda(3, 2, madera2);

        TipoDeHerramienta hachaDePiedra = tablero.construir();

        assertEquals(200, hachaDePiedra.durabilidad());
        assertEquals(5, hachaDePiedra.fuerza());

    }


    @Test
    public void ContruccionDeHachaDeMetalConSuFuerzaYDurabilidadInicial() {
        //UnidadesElementales de Material Que se utilizan para su construcción.
        UnidadElemental madera1 = new UnidadElementalMadera();
        UnidadElemental madera2 = new UnidadElementalMadera();
        UnidadElemental metal1 = new UnidadElementalMetal();
        UnidadElemental metal2 = new UnidadElementalMetal();
        UnidadElemental metal3 = new UnidadElementalMetal();

        TableroDeConstruccion tablero = new TableroDeConstruccion();

        tablero.agregarElementoEnCelda(1, 1, metal1);
        tablero.agregarElementoEnCelda(1, 2, metal2);
        tablero.agregarElementoEnCelda(2, 1, metal3);
        tablero.agregarElementoEnCelda(2, 2, madera1);
        tablero.agregarElementoEnCelda(3, 2, madera2);

        TipoDeHerramienta hachaDeMetal = tablero.construir();

        assertEquals(400, hachaDeMetal.durabilidad());
        assertEquals(10, hachaDeMetal.fuerza());

    }


    @Test
    public void ContruccionDePicoDeMaderaConSuFuerzaYDurabilidadInicial() {
        //UnidadesElementales de Material Que se utilizan para su construcción.
        UnidadElemental madera1 = new UnidadElementalMadera();
        UnidadElemental madera2 = new UnidadElementalMadera();
        UnidadElemental madera3 = new UnidadElementalMadera();
        UnidadElemental madera4 = new UnidadElementalMadera();
        UnidadElemental madera5 = new UnidadElementalMadera();

        TableroDeConstruccion tablero = new TableroDeConstruccion();

        tablero.agregarElementoEnCelda(1, 1, madera1);
        tablero.agregarElementoEnCelda(1, 2, madera2);
        tablero.agregarElementoEnCelda(1, 3, madera3);
        tablero.agregarElementoEnCelda(2, 2, madera4);
        tablero.agregarElementoEnCelda(3, 2, madera5);

        TipoDeHerramienta picoDeMadera = tablero.construir();

        assertEquals(2, picoDeMadera.fuerza());
        assertEquals(100, picoDeMadera.durabilidad());
    }

    @Test
    public void ContruccionDePicoDePiedraConSuFuerzaYDurabilidadInicial() {
        //UnidadesElementales de Material Que se utilizan para su construcción.
        UnidadElemental madera1 = new UnidadElementalMadera();
        UnidadElemental madera2 = new UnidadElementalMadera();
        UnidadElemental piedra1 = new UnidadElementalPiedra();
        UnidadElemental piedra2 = new UnidadElementalPiedra();
        UnidadElemental piedra3 = new UnidadElementalPiedra();
        TableroDeConstruccion tablero = new TableroDeConstruccion();

        tablero.agregarElementoEnCelda(1, 1, piedra1);
        tablero.agregarElementoEnCelda(1, 2, piedra2);
        tablero.agregarElementoEnCelda(1, 3, piedra3);
        tablero.agregarElementoEnCelda(2, 2, madera1);
        tablero.agregarElementoEnCelda(3, 2, madera2);

        TipoDeHerramienta picoDePiedra = tablero.construir();

        assertEquals(4, picoDePiedra.fuerza());
        assertEquals(200, picoDePiedra.durabilidad());
    }

    @Test
    public void ContruccionDePicoDeMetalConSuFuerzaYDurabilidadInicial() {
        //UnidadesElementales de Material Que se utilizan para su construcción.
        UnidadElemental madera1 = new UnidadElementalMadera();
        UnidadElemental madera2 = new UnidadElementalMadera();
        UnidadElemental metal1 = new UnidadElementalMetal();
        UnidadElemental metal2 = new UnidadElementalMetal();
        UnidadElemental metal3 = new UnidadElementalMetal();

        TableroDeConstruccion tablero = new TableroDeConstruccion();

        tablero.agregarElementoEnCelda(1, 1, metal1);
        tablero.agregarElementoEnCelda(1, 2, metal2);
        tablero.agregarElementoEnCelda(1, 3, metal3);
        tablero.agregarElementoEnCelda(2, 2, madera1);
        tablero.agregarElementoEnCelda(3, 2, madera2);

        TipoDeHerramienta picoDeMetal = tablero.construir();

        assertEquals(12, picoDeMetal.fuerza());
        assertEquals(400, picoDeMetal.durabilidad());
    }

    @Test
    public void ContruccionDePicoFinoConSuFuerzaYDurabilidadInicial() {
        //UnidadesElementales de Material Que se utilizan para su construcción.
        UnidadElemental madera1 = new UnidadElementalMadera();
        UnidadElemental madera2 = new UnidadElementalMadera();
        UnidadElemental metal1 = new UnidadElementalMetal();
        UnidadElemental metal2 = new UnidadElementalMetal();
        UnidadElemental metal3 = new UnidadElementalMetal();
        UnidadElemental piedra = new UnidadElementalPiedra();

        TableroDeConstruccion tablero = new TableroDeConstruccion();

        tablero.agregarElementoEnCelda(1, 1, metal1);
        tablero.agregarElementoEnCelda(1, 2, metal2);
        tablero.agregarElementoEnCelda(1, 3, metal3);
        tablero.agregarElementoEnCelda(2, 1, piedra);
        tablero.agregarElementoEnCelda(2, 2, madera1);
        tablero.agregarElementoEnCelda(3, 2, madera2);

        TipoDeHerramienta picoFino = tablero.construir();

        assertEquals(20, picoFino.fuerza());
        assertEquals(1000, picoFino.durabilidad());
    }


    //Jugador:
    //Se verifica la correcta inicialización del jugador en el mapa.
    //Se verifica que puede moverse para todas las direcciones vacías.



    @Test
    public void JugadorRecienCreadoComienzaConInventarioVacio(){
        Jugador jugador = new Jugador();

        int cant = jugador.cantidadDeElementosDelInventario();

        assertEquals(0,cant);
    }

    @Test
    public void JugadorRecienCreadoComienzaConHachaDeMaderaEnManoYVerificoQueTengaAtributosDeHachaDeMadera(){
        Jugador jugador = new Jugador();
        TipoDeHerramienta hachaDeMadera = new Hacha(new MaterialDeHerramientaMadera());

        TipoDeHerramienta herramienta = jugador.obtenerHerramientaEnMano();

        assertEquals(hachaDeMadera.durabilidad() , herramienta.durabilidad());
        assertEquals(hachaDeMadera.fuerza() , herramienta.fuerza());
    }


    @Test
    public void SeVerificaQueEljugadorComienzaEnElPrimerCasilleroDelMapa(){
        Mapa mapa = new Mapa(12,12);
        Jugador jugador = new Jugador();

        jugador.iniciar(mapa);
        ObjetoDelTablero objeto = mapa.obtenerCasillero(new Point(0,0)).getObjeto();

        assertEquals(objeto.equals(new Jugador()),true);
    }

    @Test
    public void SeVerificaQueElJugadorSePuedaMoverParaAbajo(){
        Mapa mapa = new Mapa(13,13);
        Jugador jugador = new Jugador();
        jugador.iniciar(mapa);

        jugador.moverParaAbajo();
        jugador.moverParaAbajo();
        ObjetoDelTablero objetoDelCasillero = mapa.obtenerCasillero(new Point(0,2)).getObjeto();
        assertEquals(jugador, objetoDelCasillero);
    }

    @Test
    public void SeVerificiaQueElJugadorSePuedaMoverALaDerechaDesuposicionActual(){
        Mapa mapa = new Mapa(12,12);
        Jugador jugador = new Jugador();

        jugador.iniciar(mapa);
        jugador.moverALaDerecha();
        jugador.moverALaDerecha();

        ObjetoDelTablero objetoEnCasillero = mapa.obtenerCasillero(new Point(2,0)).getObjeto();
        assertTrue(objetoEnCasillero.equals(new Jugador()));
    }

    @Test
    public void SeVerificaQueCuandoelJugadorSeMuevaSeEncuentreEnElCasilleroDeSuUltimaPosicion(){
        Mapa mapa = new Mapa(12,12);
        Jugador jugador = new Jugador();

        jugador.iniciar(mapa); // El jugador Comienza En La Posicion [0,0]
        jugador.moverALaDerecha();
        jugador.moverParaAbajo();
        jugador.moverParaAbajo();
        jugador.moverALaDerecha();
        jugador.moverALaIzquierda();
        assertTrue(mapa.obtenerCasillero(new Point(2,1)).estaOcupado());
    }

    @Test
    public void SeVerificaQueElJugadorSePuedaMoverHaciaLaIzquierda() {
        Mapa mapa = new Mapa(13, 13);
        Jugador jugador = new Jugador();
        jugador.iniciar(mapa);

        jugador.moverALaDerecha();
        jugador.moverALaDerecha(); //Me muevo 3 veces hacia La Derecha
        jugador.moverALaDerecha();

        jugador.moverALaIzquierda();
        jugador.moverALaIzquierda();  //Me muevo 3 veces hacia la Izquierda
        jugador.moverALaIzquierda();
        ObjetoDelTablero objeto = mapa.obtenerCasillero(new Point(0,0)).getObjeto();
        assertEquals(jugador, objeto);
    }

    @Test
    public void SeVerificaQueUnaVezElJugadorEsteEnElTopeDelTableroYaNoSePuedaMoverMasALaDerecha(){
        int tope = 12;
        Mapa mapa = new Mapa(12, 12);
        Jugador jugador = new Jugador();

        jugador.iniciar(mapa); // El jugador Comienza En La Posicion [0,0]

        //LLEGE AL BORDE DEL MAPA
        for (int i = 0; i < tope; i++){
            jugador.moverALaDerecha();
        }

        jugador.moverALaDerecha(); //INTENTO MOVERME UNA VEZ MAS
        jugador.moverALaDerecha(); //INTENTO MOVERME UNA VEZ MAS


        ObjetoDelTablero objetoDelTablero = mapa.obtenerCasillero(new Point(tope - 1, 0)).getObjeto();
        assertEquals(jugador, objetoDelTablero);
    }

    @Test
    public void SeVerficaQueElJugadorNoSePuedaMoverHaciaArriba(){
        Mapa mapa = new Mapa(12,12);
        Jugador jugador = new Jugador();

        jugador.iniciar(mapa); // El jugador Comienza En La Posicion [0,0]
        jugador.moverParaArriba();
        jugador.moverParaArriba();

        ObjetoDelTablero objetoDelCasillero = mapa.obtenerCasillero(new Point(0,0)).getObjeto();
        assertEquals(jugador, objetoDelCasillero);
    }

    @Test
    public void SeVerificaQueUnaVezElJugadorEsteElTopeDelTableroYaNoSePuedaMoverParaAbajo(){
        Mapa mapa = new Mapa(12,12);
        Jugador jugador = new Jugador();
        jugador.iniciar(mapa);

        for(int i = 0; i < 12; i++){
            jugador.moverParaAbajo();
        }
        // ME ENCUENTRO EN EL BORDE DEL TABLERO
        jugador.moverParaAbajo();
        jugador.moverParaAbajo();

        ObjetoDelTablero objetoDelCasillero = mapa.obtenerCasillero(new Point(0,11)).getObjeto();
        assertEquals(jugador, objetoDelCasillero);
    }

    //Mapa:
    //Se verifica que se puede ocupar un casillero vacío del terreno.
    //Se verifica que no se puede ocupar un casillero ocupado.
    //Se verifica que un casillero puede ser ocupado por un material o personaje.


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
        Casillero casillero = mapa.obtenerCasillero(new Point(5,9));
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
    public void SeVerificaQueAlAgregarUnMaterialMaderaElCasilleroContengaElMaterialExactoQueAgregamos(){
        Mapa mapa = new Mapa(10,10);

        Casillero casillero = mapa.obtenerCasillero(new Point(1,9));
        assertEquals(casillero.estaOcupado(),false);

        casillero.asignar(new MaterialMadera());
        ObjetoDelTablero objetoDelCasillero = casillero.getObjeto();

        assertTrue(objetoDelCasillero.equals(new MaterialMadera()));
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
    public void SeVerificaQueAlAgregarUnMaterialMetalElCasilleroContengaElMaterialExactoQueAgregamos(){
        Mapa mapa = new Mapa(10,10);

        Casillero casillero = mapa.obtenerCasillero(new Point(5,9));
        assertEquals(casillero.estaOcupado(),false);

        casillero.asignar(new MaterialMetal());
        ObjetoDelTablero objetoDelCasillero = casillero.getObjeto();
        assertTrue(objetoDelCasillero.equals(new MaterialMetal()));
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
    public void SeVerificaQueAlAgregarUnMaterialPiedraElCasilleroContengaElMaterialExactoQueAgregamos(){
        Mapa mapa = new Mapa(10,10);

        Casillero casillero = mapa.obtenerCasillero(new Point(1,9));
        assertEquals(casillero.estaOcupado(),false);

        casillero.asignar(new MaterialPiedra());
        ObjetoDelTablero objetoDelCasillero = casillero.getObjeto();
        assertTrue(objetoDelCasillero.equals(new MaterialPiedra()));
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
    public void SeVerificaQueAlAgregarUnMaterialDediamanteElCasilleroContengaElMaterialExactoQueAgregamos(){
        Mapa mapa = new Mapa(10,10);

        Casillero casillero = mapa.obtenerCasillero(new Point(1,9));
        assertEquals(casillero.estaOcupado(),false);

        casillero.asignar(new MaterialDiamante());
        ObjetoDelTablero objetoDelCasillero = casillero.getObjeto();
        assertTrue(objetoDelCasillero.equals(new MaterialDiamante()));
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


    //Algocraft:
    //Se verifica que se inicia el juego con el terreno inicializado (materiales distribuidos en el mapa), el jugador inicializado.

    @Test
    public void SeVerificaQueUnaVezIniciadoElJuegoElJugadorSeEncuentreEnElPrimerCasillero(){
        Algocraft miJuego = new Algocraft();
        miJuego.iniciar();
        Mapa mapaDeMiJuego = miJuego.obtenerMapaDelJuego();
        Jugador jugador = miJuego.obtenerJugador();
        ObjetoDelTablero objectoEnElPrimerCasillero  = mapaDeMiJuego.obtenerCasillero(new Point(0,0)).getObjeto();
        assertEquals(jugador,objectoEnElPrimerCasillero);
    }

    @Test
    public void SeVerificaQueUnaVezIniciadoElJuegoElMapaContengaMaterialesDeMetal(){
        Algocraft juego = new Algocraft();
        juego.iniciar();
        Mapa mapaDeMiJuego = juego.obtenerMapaDelJuego();

        ObjetoDelTablero objeto = mapaDeMiJuego.obtenerCasillero(new Point(2,1)).getObjeto();
        assertEquals(objeto.equals(new MaterialMetal()),true);
    }

    @Test
    public void SeVerificaQueUnaVezIniciadoElJuegoElMapaContengaMaterialesDeMadera(){
        Algocraft juego = new Algocraft();
        juego.iniciar();
        Mapa mapaDeMiJuego = juego.obtenerMapaDelJuego();

        ObjetoDelTablero objeto = mapaDeMiJuego.obtenerCasillero(new Point(5,1)).getObjeto();
        assertTrue(objeto.equals(new MaterialMadera()));
    }

    @Test
    public void SeVerificaQueUnaVezIniciadoElJuegoElMapaContengaMaterialesDePiedra(){
        Algocraft juego = new Algocraft();
        juego.iniciar();
        Mapa mapaDeMiJuego = juego.obtenerMapaDelJuego();

        ObjetoDelTablero objeto = mapaDeMiJuego.obtenerCasillero(new Point(8,7)).getObjeto();
        assertTrue(objeto.equals(new MaterialPiedra()));
    }

    @Test
    public void SeVerificaQueUnaVezIniciadoElJuegoElMapaContengaMaterialesDeDiamante(){
        Algocraft juego = new Algocraft();
        juego.iniciar();
        Mapa mapaDeMiJuego = juego.obtenerMapaDelJuego();

        ObjetoDelTablero objeto = mapaDeMiJuego.obtenerCasillero(new Point(2,5)).getObjeto();
        assertTrue(objeto.equals(new MaterialDiamante()));
    }




}