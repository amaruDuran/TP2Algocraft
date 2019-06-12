package Entregas;

import Herramientas.Constructor.TableroDeConstruccion;
import Herramientas.Herramienta;
import Herramientas.TipoDeHerramienta.TipoDeHerramienta;
import Materiales.UnidadElemental.UnidadElemental;
import Materiales.UnidadElemental.UnidadElementalMadera;
import Materiales.UnidadElemental.UnidadElementalMetal;
import Materiales.UnidadElemental.UnidadElementalPiedra;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class Entrega2Test {
    //Construcción de herramienta:
    //Se verifica la correcta construcción de cada herramienta con su correspondiente forma de creación y materiales.

    /*
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
        assertEquals(100,hachaDeMadera.durabilidad());
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
        UnidadElemental madera3 = new UnidadElementalMetal();
        UnidadElemental madera4 = new UnidadElementalMetal();
        UnidadElemental madera5 = new UnidadElementalMetal();

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

        assertEquals(10, picoDeMetal.fuerza());
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
    */





    //Jugador:
    //Se verifica la correcta inicialización del jugador en el mapa.
    //Se verifica que puede moverse para todas las direcciones vacías.

    //Mapa:
    //Se verifica que se puede ocupar un casillero vacío del terreno.
    //Se verifica que no se puede ocupar un casillero ocupado.
    //Se verifica que un casillero puede ser ocupado por un material o personaje.

    //Algocraft:
    //Se verifica que se inicia el juego con el terreno inicializado (materiales distribuidos en el mapa), el jugador inicializado.
}
