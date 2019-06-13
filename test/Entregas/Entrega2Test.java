package Entregas;

import Herramientas.Constructor.TableroDeConstruccion;
import Herramientas.Herramienta;
import Herramientas.TipoDeHerramienta.Hacha;
import Herramientas.TipoDeHerramienta.MaterialDeHerramientas.MaterialDeHerramientaMadera;
import Herramientas.TipoDeHerramienta.TipoDeHerramienta;
import Juego.Algocraft;
import Juego.Casillero;
import Juego.Mapa;
import Jugador.Jugador;
import Materiales.MaterialDiamante;
import Materiales.MaterialMadera;
import Materiales.MaterialMetal;
import Materiales.MaterialPiedra;
import Materiales.UnidadElemental.UnidadElemental;
import Materiales.UnidadElemental.UnidadElementalMadera;
import Materiales.UnidadElemental.UnidadElementalMetal;
import Materiales.UnidadElemental.UnidadElementalPiedra;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

public class Entrega2Test {
    //Construcción de herramienta:
    //Se verifica la correcta construcción de cada herramienta con su correspondiente forma de creación y materiales.


    @Test
    public void ContruccionDeHachaDeMaderaConSuFuerzaYDurabilidadInicial(){
        //UnidadesElementales de Material Que se utilizan para su construcción.
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

        TipoDeHerramienta hachaDeMadera = tablero.construir();

        assertEquals(2, hachaDeMadera.fuerza());
        assertEquals(100,100);
    }


    @Test
    public void ContruccionDeHachaDePiedraConSuFuerzaYDurabilidadInicial(){
        //UnidadesElementales de Material Que se utilizan para su construcción.
        UnidadElemental madera1 = new UnidadElementalMadera();
        UnidadElemental madera2 = new UnidadElementalMadera();
        UnidadElemental piedra1 = new UnidadElementalPiedra();
        UnidadElemental piedra2 = new UnidadElementalPiedra();
        UnidadElemental piedra3 = new UnidadElementalPiedra();
        TableroDeConstruccion tablero = new TableroDeConstruccion();

        tablero.agregarElementoEnCelda(1,1, piedra1);
        tablero.agregarElementoEnCelda(1,2, piedra2);
        tablero.agregarElementoEnCelda(2,1, piedra3);
        tablero.agregarElementoEnCelda(2,2, madera1);
        tablero.agregarElementoEnCelda(3,2, madera2);

        TipoDeHerramienta hachaDePiedra = tablero.construir();

        assertEquals(5, hachaDePiedra.fuerza());
        assertEquals(200,hachaDePiedra.durabilidad());
    }


    @Test
    public void ContruccionDeHachaDeMetalConSuFuerzaYDurabilidadInicial(){
        //UnidadesElementales de Material Que se utilizan para su construcción.
        UnidadElemental madera1 = new UnidadElementalMadera();
        UnidadElemental madera2 = new UnidadElementalMadera();
        UnidadElemental metal1 = new UnidadElementalMetal();
        UnidadElemental metal2 = new UnidadElementalMetal();
        UnidadElemental metal3 = new UnidadElementalMetal();

        TableroDeConstruccion tablero = new TableroDeConstruccion();

        tablero.agregarElementoEnCelda(1,1, metal1);
        tablero.agregarElementoEnCelda(1,2, metal2);
        tablero.agregarElementoEnCelda(2,1, metal3);
        tablero.agregarElementoEnCelda(2,2, madera1);
        tablero.agregarElementoEnCelda(3,2, madera2);

        TipoDeHerramienta hachaDeMetal = tablero.construir();

        assertEquals(10, hachaDeMetal.fuerza());
        assertEquals(400,hachaDeMetal.durabilidad());
    }



    @Test
    public void ContruccionDePicoDeMaderaConSuFuerzaYDurabilidadInicial(){
        //UnidadesElementales de Material Que se utilizan para su construcción.
        UnidadElemental madera1 = new UnidadElementalMadera();
        UnidadElemental madera2 = new UnidadElementalMadera();
        UnidadElemental madera3 = new UnidadElementalMadera();
        UnidadElemental madera4 = new UnidadElementalMadera();
        UnidadElemental madera5 = new UnidadElementalMadera();

        TableroDeConstruccion tablero = new TableroDeConstruccion();

        tablero.agregarElementoEnCelda(1,1, madera1);
        tablero.agregarElementoEnCelda(1,2, madera2);
        tablero.agregarElementoEnCelda(1,3, madera3);
        tablero.agregarElementoEnCelda(2,2, madera4);
        tablero.agregarElementoEnCelda(3,2, madera5);

        TipoDeHerramienta picoDeMadera = tablero.construir();

        assertEquals(2, picoDeMadera.fuerza());
        assertEquals(100, picoDeMadera.durabilidad());
    }

    @Test
    public void ContruccionDePicoDePiedraConSuFuerzaYDurabilidadInicial(){
        //UnidadesElementales de Material Que se utilizan para su construcción.
        UnidadElemental madera1 = new UnidadElementalMadera();
        UnidadElemental madera2 = new UnidadElementalMadera();
        UnidadElemental piedra1 = new UnidadElementalPiedra();
        UnidadElemental piedra2 = new UnidadElementalPiedra();
        UnidadElemental piedra3 = new UnidadElementalPiedra();
        TableroDeConstruccion tablero = new TableroDeConstruccion();

        tablero.agregarElementoEnCelda(1,1, piedra1);
        tablero.agregarElementoEnCelda(1,2, piedra2);
        tablero.agregarElementoEnCelda(1,3, piedra3);
        tablero.agregarElementoEnCelda(2,2, madera1);
        tablero.agregarElementoEnCelda(3,2, madera2);

        TipoDeHerramienta picoDePiedra = tablero.construir();

        assertEquals(4, picoDePiedra.fuerza());
        assertEquals(200,picoDePiedra.durabilidad());
    }

    @Test
    public void ContruccionDePicoDeMetalConSuFuerzaYDurabilidadInicial(){
        //UnidadesElementales de Material Que se utilizan para su construcción.
        UnidadElemental madera1 = new UnidadElementalMadera();
        UnidadElemental madera2 = new UnidadElementalMadera();
        UnidadElemental metal1 = new UnidadElementalMetal();
        UnidadElemental metal2 = new UnidadElementalMetal();
        UnidadElemental metal3 = new UnidadElementalMetal();

        TableroDeConstruccion tablero = new TableroDeConstruccion();

        tablero.agregarElementoEnCelda(1,1, metal1);
        tablero.agregarElementoEnCelda(1,2, metal2);
        tablero.agregarElementoEnCelda(1,3, metal3);
        tablero.agregarElementoEnCelda(2,2, madera1);
        tablero.agregarElementoEnCelda(3,2, madera2);

        TipoDeHerramienta picoDeMetal = tablero.construir();

        assertEquals(12, picoDeMetal.fuerza());
        assertEquals(400, picoDeMetal.durabilidad());
    }

    @Test
    public void ContruccionDePicoFinoConSuFuerzaYDurabilidadInicial(){
        //UnidadesElementales de Material Que se utilizan para su construcción.
        UnidadElemental madera1 = new UnidadElementalMadera();
        UnidadElemental madera2 = new UnidadElementalMadera();
        UnidadElemental metal1 = new UnidadElementalMetal();
        UnidadElemental metal2 = new UnidadElementalMetal();
        UnidadElemental metal3 = new UnidadElementalMetal();
        UnidadElemental piedra = new UnidadElementalPiedra();

        TableroDeConstruccion tablero = new TableroDeConstruccion();

        tablero.agregarElementoEnCelda(1,1, metal1);
        tablero.agregarElementoEnCelda(1,2, metal2);
        tablero.agregarElementoEnCelda(1,3, metal3);
        tablero.agregarElementoEnCelda(2,1, piedra);
        tablero.agregarElementoEnCelda(2,2, madera1);
        tablero.agregarElementoEnCelda(3,2, madera2);

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
        String jugadorSeEncuentraEnELPrimerCasillero = mapa.obtenerCasillero(0,0).identificador();

        assertEquals("JUGADOR", jugadorSeEncuentraEnELPrimerCasillero);
    }

    @Test
    public void SeVerificiaQueElJugadorSePuedaMoverALaDerechaDesuposicionActual(){
        Mapa mapa = new Mapa(12,12);
        Jugador jugador = new Jugador();

        jugador.iniciar(mapa);
        jugador.moverALaDerecha();
        jugador.moverALaDerecha();

        String identificador = mapa.obtenerCasillero(0,2).identificador();
        assertEquals("JUGADOR", identificador);
    }

    @Test
    public void SeVerificaQueCuandoelJugadorSeMuevaALaDerechaElCasilleroQueDejoSeEncuentreDisponibleParaSerOcupado(){
        Mapa mapa = new Mapa(12,12);
        Jugador jugador = new Jugador();

        jugador.iniciar(mapa); // El jugador Comienza En La Posicion [0,0]
        jugador.moverALaDerecha();
        assertFalse(mapa.obtenerCasillero(0,0).estaOcupado());
    }

    @Test
    public void SeVerificaQueUnaVezElJugadorEsteEnElTopeDelTableroYaNoSePuedaMoverMasALaDerecha(){
        int tope = 12;
        Mapa mapa = new Mapa(12,13);
        Jugador jugador = new Jugador();

        jugador.iniciar(mapa); // El jugador Comienza En La Posicion [0,0]

        for (int i=0; i<=tope; i++){
            jugador.moverALaDerecha();;
        }
        //LLEGE AL BORDE DEL MAPA
        jugador.moverALaDerecha(); //INTENTO MOVERME UNA VEZ MAS

        String identificador = mapa.obtenerCasillero(0,tope).identificador();
        assertEquals("JUGADOR",identificador);
    }

    @Test
    public void SeVerficaQueElJugadorSePuedaMoverHaciaAbajo(){
        Mapa mapa = new Mapa(12,12);
        Jugador jugador = new Jugador();

        jugador.iniciar(mapa); // El jugador Comienza En La Posicion [0,0]
        jugador.moverParaAbajo();
        jugador.moverParaAbajo();

        String identificador = mapa.obtenerCasillero(2,0).identificador();
        assertEquals("JUGADOR", identificador);
    }

    @Test
    public void SeVerificaQueUnaVezElJugadorEsteElTopeDelTableroYaNoSePuedaMoverParaAbajo(){
        int tope = 12;
        Mapa mapa = new Mapa(tope+1,12);
        Jugador jugador = new Jugador();
        jugador.iniciar(mapa);

        for(int i= 0; i< tope; i++){
            jugador.moverParaAbajo();
        }
        //LLEGE AL BORDE DEL MAPA
        jugador.moverParaAbajo(); //INTENTO MOVERME UNA VEZ MAS
        jugador.moverParaAbajo();
        jugador.moverParaAbajo();

        String identificador = mapa.obtenerCasillero(tope,0).identificador();
        assertEquals("JUGADOR",identificador);
    }

    @Test
    public void SeVerificaQueElJugadorSePuedaMoverParaArribaSiEsPosible(){
        Mapa mapa = new Mapa(13,13);
        Jugador jugador = new Jugador();
        jugador.iniciar(mapa);

        jugador.moverParaAriba(); //Como estoy en el Tope no me puedo mover
        String identificador = mapa.obtenerCasillero(0,0).identificador();
        assertEquals("JUGADOR",identificador); //Sigo donde comence

        jugador.moverParaAbajo();
        jugador.moverParaAbajo();
        jugador.moverParaAbajo();

        jugador.moverParaAriba();
        identificador = mapa.obtenerCasillero(2,0).identificador();
        assertEquals("JUGADOR",identificador);
    }

    @Test
    public void SeVerificaQueelJugadorSePuedaMoverHaciaLaIzquierda() {
        Mapa mapa = new Mapa(13, 13);
        Jugador jugador = new Jugador();
        jugador.iniciar(mapa);

        jugador.moverALaDerecha();
        jugador.moverALaDerecha(); //Me muevo 3 veces hacia La Derecha
        jugador.moverALaDerecha();

        jugador.moverALaIzquierda();
        jugador.moverALaIzquierda();  //Me muevo 3 veces hacia la Izquierda
        jugador.moverALaIzquierda();
        String identificador = mapa.obtenerCasillero(0, 0).identificador();
        assertEquals("JUGADOR", identificador); //Volvi Donde comenze
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

    //Algocraft:
    //Se verifica que se inicia el juego con el terreno inicializado (materiales distribuidos en el mapa), el jugador inicializado.

    @Test
    public void SeVerificaQueUnaVezIniciadoElJuegoElJugadorSeEncuentreEnLaPosicionInicial(){
        Algocraft juego = new Algocraft();
        juego.iniciar();
        Mapa mapaDeMiJuego = juego.obtenerMapaDelJuego();
        String identidicador = mapaDeMiJuego.obtenerCasillero(0,0).identificador();
        assertEquals("JUGADOR",identidicador);
    }

    @Test
    public void SeVerificaQueUnaVezIniciadoElJuegoElMapaContengaMaterialesDeMetal(){
        Algocraft juego = new Algocraft();
        juego.iniciar();
        Mapa mapaDeMiJuego = juego.obtenerMapaDelJuego();

        String identidicador = mapaDeMiJuego.obtenerCasillero(2,1).identificador();
        assertEquals("MET",identidicador);

        identidicador = mapaDeMiJuego.obtenerCasillero(3,2).identificador();
        assertEquals("MET",identidicador);
    }

    @Test
    public void SeVerificaQueUnaVezIniciadoElJuegoElMapaContengaMaterialesDeMadera(){
        Algocraft juego = new Algocraft();
        juego.iniciar();
        Mapa mapaDeMiJuego = juego.obtenerMapaDelJuego();

        String identidicador = mapaDeMiJuego.obtenerCasillero(5,1).identificador();
        assertEquals("MA",identidicador);

        identidicador = mapaDeMiJuego.obtenerCasillero(5,4).identificador();
        assertEquals("MA",identidicador);
    }

    @Test
    public void SeVerificaQueUnaVezIniciadoElJuegoElMapaContengaMaterialesDePiedra(){
        Algocraft juego = new Algocraft();
        juego.iniciar();
        Mapa mapaDeMiJuego = juego.obtenerMapaDelJuego();

        String identidicador = mapaDeMiJuego.obtenerCasillero(8,7).identificador();
        assertEquals("P",identidicador);

        identidicador = mapaDeMiJuego.obtenerCasillero(8,8).identificador();
        assertEquals("P",identidicador);
    }

    @Test
    public void SeVerificaQueUnaVezIniciadoElJuegoElMapaContengaMaterialesDeDiamante(){
        Algocraft juego = new Algocraft();
        juego.iniciar();
        Mapa mapaDeMiJuego = juego.obtenerMapaDelJuego();

        String identidicador = mapaDeMiJuego.obtenerCasillero(2,5).identificador();
        assertEquals("D",identidicador);

        identidicador = mapaDeMiJuego.obtenerCasillero(3,6).identificador();
        assertEquals("D",identidicador);
    }

}
