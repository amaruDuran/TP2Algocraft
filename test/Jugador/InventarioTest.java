package Jugador;

import Herramientas.TipoDeHerramienta.Hacha;
import Herramientas.TipoDeHerramienta.MaterialDeHerramientas.MaterialDeHerramientaMadera;
import Herramientas.TipoDeHerramienta.MaterialDeHerramientas.MaterialDeHerramientaMetal;
import Herramientas.TipoDeHerramienta.MaterialDeHerramientas.MaterialDeHerramientaMetalPiedra;
import Herramientas.TipoDeHerramienta.MaterialDeHerramientas.MaterialDeHerramientaPiedra;
import Herramientas.TipoDeHerramienta.Pico;
import Herramientas.TipoDeHerramienta.PicoFino;
import Herramientas.TipoDeHerramienta.TipoDeHerramienta;
import Materiales.UnidadElemental.*;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class InventarioTest {
    //test inicio de inventario
    @Test
    public void seCreaUnInventarioVacio(){
        Inventario inventario = new Inventario();
        int cant = inventario.cantidadDeElementos();
        assertEquals(0,cant);
    }
    //test de agregar elementos
    @Test
    public void seCreaUnInventarioYSeAgregaUnaHerramienta(){
        Inventario inventario = new Inventario();
        TipoDeHerramienta hacha = new Hacha(new MaterialDeHerramientaMetal());
        inventario.agregarObjetosAlInventario(hacha);
        int cant = inventario.cantidadDeElementos();
        assertEquals(1,cant);
    }
    @Test
    public void seCreaUnInventarioYSeAgreganVariasHerramientasDistintas(){
        Inventario inventario = new Inventario();
        TipoDeHerramienta hachaMadera = new Hacha(new MaterialDeHerramientaMadera());
        TipoDeHerramienta hachaMetal = new Hacha(new MaterialDeHerramientaMetal());
        TipoDeHerramienta hachaPiedra = new Hacha(new MaterialDeHerramientaPiedra());
        TipoDeHerramienta picoMadera = new Pico(new MaterialDeHerramientaMadera());
        TipoDeHerramienta picoMetal = new Pico(new MaterialDeHerramientaMetal());
        TipoDeHerramienta picoPiedra = new Pico(new MaterialDeHerramientaPiedra());
        TipoDeHerramienta picoFino = new PicoFino(new MaterialDeHerramientaMetalPiedra());

        inventario.agregarObjetosAlInventario(hachaMadera);
        inventario.agregarObjetosAlInventario(hachaMetal);
        inventario.agregarObjetosAlInventario(hachaPiedra);
        inventario.agregarObjetosAlInventario(picoMadera);
        inventario.agregarObjetosAlInventario(picoMetal);
        inventario.agregarObjetosAlInventario(picoPiedra);
        inventario.agregarObjetosAlInventario(picoFino);
        int cant = inventario.cantidadDeElementos();

        assertEquals(7,cant);
    }
    @Test
    public void seCreaUnInventarioYSeAgregaUnElemento(){
        Inventario inventario = new Inventario();
        UnidadElemental metal = new UnidadElementalMetal();

        inventario.agregarObjetosAlInventario(metal);
        int cant = inventario.cantidadDeElementos();

        assertEquals(1,cant);
    }
    @Test
    public void seCreaUnInventarioYSeAgreganMuchosElementosDistintos(){
        Inventario inventario = new Inventario();
        UnidadElemental madera = new UnidadElementalMadera();
        UnidadElemental metal = new UnidadElementalMetal();
        UnidadElemental piedra = new UnidadElementalPiedra();
        UnidadElemental diamante = new UnidadElementalDiamante();

        inventario.agregarObjetosAlInventario(metal);
        inventario.agregarObjetosAlInventario(madera);
        inventario.agregarObjetosAlInventario(piedra);
        inventario.agregarObjetosAlInventario(diamante);
        int cant = inventario.cantidadDeElementos();

        assertEquals(4,cant);
    }
    @Test
    public void seCreaUnInventarioYSeAgreganMuchosElementosYMuchasHerramientasDistintas(){
        Inventario inventario = new Inventario();
        UnidadElemental madera = new UnidadElementalMadera();
        UnidadElemental metal = new UnidadElementalMetal();
        UnidadElemental piedra = new UnidadElementalPiedra();
        UnidadElemental diamante = new UnidadElementalDiamante();
        TipoDeHerramienta hachaMadera = new Hacha(new MaterialDeHerramientaMadera());
        TipoDeHerramienta hachaMetal = new Hacha(new MaterialDeHerramientaMetal());
        TipoDeHerramienta hachaPiedra = new Hacha(new MaterialDeHerramientaPiedra());
        TipoDeHerramienta picoMadera = new Pico(new MaterialDeHerramientaMadera());
        TipoDeHerramienta picoMetal = new Pico(new MaterialDeHerramientaMetal());
        TipoDeHerramienta picoPiedra = new Pico(new MaterialDeHerramientaPiedra());
        TipoDeHerramienta picoFino = new PicoFino(new MaterialDeHerramientaMetalPiedra());


        inventario.agregarObjetosAlInventario(metal);
        inventario.agregarObjetosAlInventario(madera);
        inventario.agregarObjetosAlInventario(piedra);
        inventario.agregarObjetosAlInventario(diamante);

        inventario.agregarObjetosAlInventario(hachaMadera);
        inventario.agregarObjetosAlInventario(hachaMetal);
        inventario.agregarObjetosAlInventario(hachaPiedra);
        inventario.agregarObjetosAlInventario(picoMadera);
        inventario.agregarObjetosAlInventario(picoMetal);
        inventario.agregarObjetosAlInventario(picoPiedra);
        inventario.agregarObjetosAlInventario(picoFino);
        int cant = inventario.cantidadDeElementos();


        assertEquals(11,cant);
    }
    @Test
    public void seCreaUnInventarioYSeAgreganMuchosElementosYMuchasHerramientasPeroAlIntentarAgregarlasPorSegundaVezNoSeAgregan(){
        Inventario inventario = new Inventario();
        UnidadElemental madera1 = new UnidadElementalMadera();
        UnidadElemental metal1 = new UnidadElementalMetal();
        UnidadElemental piedra1 = new UnidadElementalPiedra();
        UnidadElemental diamante1 = new UnidadElementalDiamante();
        TipoDeHerramienta hachaMadera1 = new Hacha(new MaterialDeHerramientaMadera());
        TipoDeHerramienta hachaMetal1 = new Hacha(new MaterialDeHerramientaMetal());
        TipoDeHerramienta hachaPiedra1 = new Hacha(new MaterialDeHerramientaPiedra());
        TipoDeHerramienta picoMadera1 = new Pico(new MaterialDeHerramientaMadera());
        TipoDeHerramienta picoMetal1 = new Pico(new MaterialDeHerramientaMetal());
        TipoDeHerramienta picoPiedra1 = new Pico(new MaterialDeHerramientaPiedra());
        TipoDeHerramienta picoFino1 = new PicoFino(new MaterialDeHerramientaMetalPiedra());

        inventario.agregarObjetosAlInventario(metal1);
        inventario.agregarObjetosAlInventario(madera1);
        inventario.agregarObjetosAlInventario(piedra1);
        inventario.agregarObjetosAlInventario(diamante1);
        inventario.agregarObjetosAlInventario(hachaMadera1);
        inventario.agregarObjetosAlInventario(hachaMetal1);
        inventario.agregarObjetosAlInventario(hachaPiedra1);
        inventario.agregarObjetosAlInventario(picoMadera1);
        inventario.agregarObjetosAlInventario(picoMetal1);
        inventario.agregarObjetosAlInventario(picoPiedra1);
        inventario.agregarObjetosAlInventario(picoFino1);
        inventario.agregarObjetosAlInventario(metal1);
        inventario.agregarObjetosAlInventario(madera1);
        inventario.agregarObjetosAlInventario(piedra1);
        inventario.agregarObjetosAlInventario(diamante1);
        inventario.agregarObjetosAlInventario(hachaMadera1);
        inventario.agregarObjetosAlInventario(hachaMetal1);
        inventario.agregarObjetosAlInventario(hachaPiedra1);
        inventario.agregarObjetosAlInventario(picoMadera1);
        inventario.agregarObjetosAlInventario(picoMetal1);
        inventario.agregarObjetosAlInventario(picoPiedra1);
        inventario.agregarObjetosAlInventario(picoFino1);
        int cant = inventario.cantidadDeElementos();

        assertEquals(11,cant);
    }
    @Test
    public void seCreaUnInventarioYSeAgreganMuchosElementosYMuchasHerramientasDuplicadasPeroDiferentes(){
        Inventario inventario = new Inventario();
        UnidadElemental madera1 = new UnidadElementalMadera();
        UnidadElemental metal1 = new UnidadElementalMetal();
        UnidadElemental piedra1 = new UnidadElementalPiedra();
        UnidadElemental diamante1 = new UnidadElementalDiamante();
        TipoDeHerramienta hachaMadera1 = new Hacha(new MaterialDeHerramientaMadera());
        TipoDeHerramienta hachaMetal1 = new Hacha(new MaterialDeHerramientaMetal());
        TipoDeHerramienta hachaPiedra1 = new Hacha(new MaterialDeHerramientaPiedra());
        TipoDeHerramienta picoMadera1 = new Pico(new MaterialDeHerramientaMadera());
        TipoDeHerramienta picoMetal1 = new Pico(new MaterialDeHerramientaMetal());
        TipoDeHerramienta picoPiedra1 = new Pico(new MaterialDeHerramientaPiedra());
        TipoDeHerramienta picoFino1 = new PicoFino(new MaterialDeHerramientaMetalPiedra());

        UnidadElemental madera2 = new UnidadElementalMadera();
        UnidadElemental metal2 = new UnidadElementalMetal();
        UnidadElemental piedra2 = new UnidadElementalPiedra();
        UnidadElemental diamante2 = new UnidadElementalDiamante();
        TipoDeHerramienta hachaMadera2 = new Hacha(new MaterialDeHerramientaMadera());
        TipoDeHerramienta hachaMetal2 = new Hacha(new MaterialDeHerramientaMetal());
        TipoDeHerramienta hachaPiedra2 = new Hacha(new MaterialDeHerramientaPiedra());
        TipoDeHerramienta picoMadera2 = new Pico(new MaterialDeHerramientaMadera());
        TipoDeHerramienta picoMetal2 = new Pico(new MaterialDeHerramientaMetal());
        TipoDeHerramienta picoPiedra2 = new Pico(new MaterialDeHerramientaPiedra());
        TipoDeHerramienta picoFino2 = new PicoFino(new MaterialDeHerramientaMetalPiedra());


        inventario.agregarObjetosAlInventario(metal1);
        inventario.agregarObjetosAlInventario(madera1);
        inventario.agregarObjetosAlInventario(piedra1);
        inventario.agregarObjetosAlInventario(diamante1);
        inventario.agregarObjetosAlInventario(hachaMadera1);
        inventario.agregarObjetosAlInventario(hachaMetal1);
        inventario.agregarObjetosAlInventario(hachaPiedra1);
        inventario.agregarObjetosAlInventario(picoMadera1);
        inventario.agregarObjetosAlInventario(picoMetal1);
        inventario.agregarObjetosAlInventario(picoPiedra1);
        inventario.agregarObjetosAlInventario(picoFino1);
        inventario.agregarObjetosAlInventario(metal2);
        inventario.agregarObjetosAlInventario(madera2);
        inventario.agregarObjetosAlInventario(piedra2);
        inventario.agregarObjetosAlInventario(diamante2);
        inventario.agregarObjetosAlInventario(hachaMadera2);
        inventario.agregarObjetosAlInventario(hachaMetal2);
        inventario.agregarObjetosAlInventario(hachaPiedra2);
        inventario.agregarObjetosAlInventario(picoMadera2);
        inventario.agregarObjetosAlInventario(picoMetal2);
        inventario.agregarObjetosAlInventario(picoPiedra2);
        inventario.agregarObjetosAlInventario(picoFino2);
        int cant = inventario.cantidadDeElementos();


        assertEquals(22,cant);
    }
    //test de quitar elementos
    @Test
    public void seCreaUnInventarioSeAgregaUnaHerramientaYSeLaQuitaDevolviendoLaMisma(){
        Inventario inventario = new Inventario();
        TipoDeHerramienta hacha = new Hacha(new MaterialDeHerramientaMetal());
        inventario.agregarObjetosAlInventario(hacha);
        ObjeosDelInventario herramienta = inventario.quitarObjetoDelInventario(0);
        int cant = inventario.cantidadDeElementos();
        assertEquals(0,cant);
        assertEquals(hacha,herramienta);
    }
    @Test
    public void seCreaUnInventarioSeAgreganVariasHerramientaYSeLasQuitaDevolviendoLasMismas(){
        Inventario inventario = new Inventario();
        TipoDeHerramienta hachaMadera = new Hacha(new MaterialDeHerramientaMadera());
        TipoDeHerramienta hachaMetal = new Hacha(new MaterialDeHerramientaMetal());
        TipoDeHerramienta hachaPiedra = new Hacha(new MaterialDeHerramientaPiedra());
        TipoDeHerramienta picoMadera = new Pico(new MaterialDeHerramientaMadera());
        TipoDeHerramienta picoMetal = new Pico(new MaterialDeHerramientaMetal());
        TipoDeHerramienta picoPiedra = new Pico(new MaterialDeHerramientaPiedra());
        TipoDeHerramienta picoFino = new PicoFino(new MaterialDeHerramientaMetalPiedra());
        inventario.agregarObjetosAlInventario(hachaMadera);
        inventario.agregarObjetosAlInventario(hachaMetal);
        inventario.agregarObjetosAlInventario(hachaPiedra);
        inventario.agregarObjetosAlInventario(picoMadera);
        inventario.agregarObjetosAlInventario(picoMetal);
        inventario.agregarObjetosAlInventario(picoPiedra);
        inventario.agregarObjetosAlInventario(picoFino);
        ObjeosDelInventario objeto7 = inventario.quitarObjetoDelInventario(6);
        ObjeosDelInventario objeto6 = inventario.quitarObjetoDelInventario(5);
        ObjeosDelInventario objeto1 = inventario.quitarObjetoDelInventario(0);
        ObjeosDelInventario objeto2 = inventario.quitarObjetoDelInventario(0);
        ObjeosDelInventario objeto3 = inventario.quitarObjetoDelInventario(0);
        ObjeosDelInventario objeto4 = inventario.quitarObjetoDelInventario(0);
        ObjeosDelInventario objeto5 = inventario.quitarObjetoDelInventario(0);

        int cant = inventario.cantidadDeElementos();
        assertEquals(0,cant);
        assertEquals(hachaMadera,objeto1);
        assertEquals(hachaMetal,objeto2);
        assertEquals(hachaPiedra,objeto3);
        assertEquals(picoMadera,objeto4);
        assertEquals(picoMetal,objeto5);
        assertEquals(picoPiedra,objeto6);
        assertEquals(picoFino,objeto7);
    }
    @Test
    public void seCreaUnInventarioSeAgregaUnElementoYSeLaQuitaDevolviendoElMismo(){
        Inventario inventario = new Inventario();
        UnidadElemental metal = new UnidadElementalMetal();
        inventario.agregarObjetosAlInventario(metal);
        ObjeosDelInventario elemento = inventario.quitarObjetoDelInventario(0);
        int cant = inventario.cantidadDeElementos();
        assertEquals(0,cant);
        assertEquals(metal,elemento);
    }
    @Test
    public void seCreaUnInventarioSeAgreganVariosElementosYSeLosQuitanDevolviendoLosMismos(){
        Inventario inventario = new Inventario();
        UnidadElemental madera = new UnidadElementalMadera();
        UnidadElemental metal = new UnidadElementalMetal();
        UnidadElemental piedra = new UnidadElementalPiedra();
        UnidadElemental diamante = new UnidadElementalDiamante();
        inventario.agregarObjetosAlInventario(madera);
        inventario.agregarObjetosAlInventario(metal);
        inventario.agregarObjetosAlInventario(piedra);
        inventario.agregarObjetosAlInventario(diamante);
        ObjeosDelInventario objeto4 = inventario.quitarObjetoDelInventario(3);
        ObjeosDelInventario objeto1 = inventario.quitarObjetoDelInventario(0);
        ObjeosDelInventario objeto2 = inventario.quitarObjetoDelInventario(0);
        ObjeosDelInventario objeto3 = inventario.quitarObjetoDelInventario(0);
        int cant = inventario.cantidadDeElementos();
        assertEquals(0,cant);
        assertEquals(madera,objeto1);
        assertEquals(metal,objeto2);
        assertEquals(piedra,objeto3);
        assertEquals(diamante,objeto4);
    }
    @Test
    public void seCreaUnInventarioYSeAgreganMuchosElementosYMuchasHerramientasYSeDevuelvenTodas(){
        Inventario inventario = new Inventario();
        UnidadElemental madera = new UnidadElementalMadera();
        UnidadElemental metal = new UnidadElementalMetal();
        UnidadElemental piedra = new UnidadElementalPiedra();
        UnidadElemental diamante = new UnidadElementalDiamante();
        TipoDeHerramienta hachaMadera = new Hacha(new MaterialDeHerramientaMadera());
        TipoDeHerramienta hachaMetal = new Hacha(new MaterialDeHerramientaMetal());
        TipoDeHerramienta hachaPiedra = new Hacha(new MaterialDeHerramientaPiedra());
        TipoDeHerramienta picoMadera = new Pico(new MaterialDeHerramientaMadera());
        TipoDeHerramienta picoMetal = new Pico(new MaterialDeHerramientaMetal());
        TipoDeHerramienta picoPiedra = new Pico(new MaterialDeHerramientaPiedra());
        TipoDeHerramienta picoFino = new PicoFino(new MaterialDeHerramientaMetalPiedra());

        inventario.agregarObjetosAlInventario(madera);
        inventario.agregarObjetosAlInventario(metal);
        inventario.agregarObjetosAlInventario(piedra);
        inventario.agregarObjetosAlInventario(diamante);
        inventario.agregarObjetosAlInventario(hachaMadera);
        inventario.agregarObjetosAlInventario(hachaMetal);
        inventario.agregarObjetosAlInventario(hachaPiedra);
        inventario.agregarObjetosAlInventario(picoMadera);
        inventario.agregarObjetosAlInventario(picoMetal);
        inventario.agregarObjetosAlInventario(picoPiedra);
        inventario.agregarObjetosAlInventario(picoFino);
        ObjeosDelInventario objeto11 = inventario.quitarObjetoDelInventario(10);
        ObjeosDelInventario objeto1 = inventario.quitarObjetoDelInventario(0);
        ObjeosDelInventario objeto2 = inventario.quitarObjetoDelInventario(0);
        ObjeosDelInventario objeto3 = inventario.quitarObjetoDelInventario(0);
        ObjeosDelInventario objeto8 = inventario.quitarObjetoDelInventario(4);
        ObjeosDelInventario objeto4 = inventario.quitarObjetoDelInventario(0);
        ObjeosDelInventario objeto5 = inventario.quitarObjetoDelInventario(0);
        ObjeosDelInventario objeto6 = inventario.quitarObjetoDelInventario(0);
        ObjeosDelInventario objeto7 = inventario.quitarObjetoDelInventario(0);
        ObjeosDelInventario objeto9 = inventario.quitarObjetoDelInventario(0);
        ObjeosDelInventario objeto10 = inventario.quitarObjetoDelInventario(0);
        int cant = inventario.cantidadDeElementos();

        assertEquals(0,cant);
        assertEquals(madera,objeto1);
        assertEquals(metal,objeto2);
        assertEquals(piedra,objeto3);
        assertEquals(diamante,objeto4);
        assertEquals(hachaMadera,objeto5);
        assertEquals(hachaMetal,objeto6);
        assertEquals(hachaPiedra,objeto7);
        assertEquals(picoMadera,objeto8);
        assertEquals(picoMetal,objeto9);
        assertEquals(picoPiedra,objeto10);
        assertEquals(picoFino,objeto11);
    }
    @Test
    public void seCreaUnInventarioYSeAgreganMuchosElementosYMuchasHerramientasYSeDevuelvenCasiTodas(){
        Inventario inventario = new Inventario();
        UnidadElemental madera = new UnidadElementalMadera();
        UnidadElemental metal = new UnidadElementalMetal();
        UnidadElemental piedra = new UnidadElementalPiedra();
        UnidadElemental diamante = new UnidadElementalDiamante();
        TipoDeHerramienta hachaMadera = new Hacha(new MaterialDeHerramientaMadera());
        TipoDeHerramienta hachaMetal = new Hacha(new MaterialDeHerramientaMetal());
        TipoDeHerramienta hachaPiedra = new Hacha(new MaterialDeHerramientaPiedra());
        TipoDeHerramienta picoMadera = new Pico(new MaterialDeHerramientaMadera());
        TipoDeHerramienta picoMetal = new Pico(new MaterialDeHerramientaMetal());
        TipoDeHerramienta picoPiedra = new Pico(new MaterialDeHerramientaPiedra());
        TipoDeHerramienta picoFino = new PicoFino(new MaterialDeHerramientaMetalPiedra());
        UnidadElemental madera2 = new UnidadElementalMadera();
        UnidadElemental metal2 = new UnidadElementalMetal();
        UnidadElemental piedra2 = new UnidadElementalPiedra();
        UnidadElemental diamante2 = new UnidadElementalDiamante();
        TipoDeHerramienta hachaMadera2 = new Hacha(new MaterialDeHerramientaMadera());
        TipoDeHerramienta hachaMetal2 = new Hacha(new MaterialDeHerramientaMetal());
        TipoDeHerramienta hachaPiedra2 = new Hacha(new MaterialDeHerramientaPiedra());
        TipoDeHerramienta picoMadera2 = new Pico(new MaterialDeHerramientaMadera());
        TipoDeHerramienta picoMetal2 = new Pico(new MaterialDeHerramientaMetal());
        TipoDeHerramienta picoPiedra2 = new Pico(new MaterialDeHerramientaPiedra());
        TipoDeHerramienta picoFino2 = new PicoFino(new MaterialDeHerramientaMetalPiedra());
        inventario.agregarObjetosAlInventario(madera);
        inventario.agregarObjetosAlInventario(metal);
        inventario.agregarObjetosAlInventario(piedra);
        inventario.agregarObjetosAlInventario(diamante);
        inventario.agregarObjetosAlInventario(hachaMadera);
        inventario.agregarObjetosAlInventario(hachaMetal);
        inventario.agregarObjetosAlInventario(hachaPiedra);
        inventario.agregarObjetosAlInventario(picoMadera);
        inventario.agregarObjetosAlInventario(picoMetal);
        inventario.agregarObjetosAlInventario(picoPiedra);
        inventario.agregarObjetosAlInventario(picoFino);
        inventario.agregarObjetosAlInventario(metal2);
        inventario.agregarObjetosAlInventario(madera2);
        inventario.agregarObjetosAlInventario(piedra2);
        inventario.agregarObjetosAlInventario(diamante2);
        inventario.agregarObjetosAlInventario(hachaMadera2);
        inventario.agregarObjetosAlInventario(hachaMetal2);
        inventario.agregarObjetosAlInventario(hachaPiedra2);
        inventario.agregarObjetosAlInventario(picoMadera2);
        inventario.agregarObjetosAlInventario(picoMetal2);
        inventario.agregarObjetosAlInventario(picoPiedra2);
        inventario.agregarObjetosAlInventario(picoFino2);
        ObjeosDelInventario objeto11 = inventario.quitarObjetoDelInventario(10);
        ObjeosDelInventario objeto1 = inventario.quitarObjetoDelInventario(0);
        ObjeosDelInventario objeto2 = inventario.quitarObjetoDelInventario(0);
        ObjeosDelInventario objeto3 = inventario.quitarObjetoDelInventario(0);
        ObjeosDelInventario objeto8 = inventario.quitarObjetoDelInventario(4);
        ObjeosDelInventario objeto4 = inventario.quitarObjetoDelInventario(0);
        ObjeosDelInventario objeto5 = inventario.quitarObjetoDelInventario(0);
        ObjeosDelInventario objeto6 = inventario.quitarObjetoDelInventario(0);
        ObjeosDelInventario objeto7 = inventario.quitarObjetoDelInventario(0);
        ObjeosDelInventario objeto9 = inventario.quitarObjetoDelInventario(0);
        ObjeosDelInventario objeto10 = inventario.quitarObjetoDelInventario(0);

        int cant = inventario.cantidadDeElementos();
        assertEquals(11,cant);
        assertEquals(madera,objeto1);
        assertEquals(metal,objeto2);
        assertEquals(piedra,objeto3);
        assertEquals(diamante,objeto4);
        assertEquals(hachaMadera,objeto5);
        assertEquals(hachaMetal,objeto6);
        assertEquals(hachaPiedra,objeto7);
        assertEquals(picoMadera,objeto8);
        assertEquals(picoMetal,objeto9);
        assertEquals(picoPiedra,objeto10);
        assertEquals(picoFino,objeto11);
    }
    //Test de tope maximo
    @Test
    public void seCreaUnInventarioYSeAgreganMuchosElementosYMuchasHerramientasHastaLlegarA30(){
        Inventario inventario = new Inventario();
        UnidadElemental madera = new UnidadElementalMadera();
        UnidadElemental metal = new UnidadElementalMetal();
        UnidadElemental piedra = new UnidadElementalPiedra();
        UnidadElemental diamante = new UnidadElementalDiamante();
        TipoDeHerramienta hachaMadera = new Hacha(new MaterialDeHerramientaMadera());
        TipoDeHerramienta hachaMetal = new Hacha(new MaterialDeHerramientaMetal());
        TipoDeHerramienta hachaPiedra = new Hacha(new MaterialDeHerramientaPiedra());
        TipoDeHerramienta picoMadera = new Pico(new MaterialDeHerramientaMadera());
        TipoDeHerramienta picoMetal = new Pico(new MaterialDeHerramientaMetal());
        TipoDeHerramienta picoPiedra = new Pico(new MaterialDeHerramientaPiedra());
        TipoDeHerramienta picoFino = new PicoFino(new MaterialDeHerramientaMetalPiedra());
        UnidadElemental madera2 = new UnidadElementalMadera();
        UnidadElemental metal2 = new UnidadElementalMetal();
        UnidadElemental piedra2 = new UnidadElementalPiedra();
        UnidadElemental diamante2 = new UnidadElementalDiamante();
        TipoDeHerramienta hachaMadera2 = new Hacha(new MaterialDeHerramientaMadera());
        TipoDeHerramienta hachaMetal2 = new Hacha(new MaterialDeHerramientaMetal());
        TipoDeHerramienta hachaPiedra2 = new Hacha(new MaterialDeHerramientaPiedra());
        TipoDeHerramienta picoMadera2 = new Pico(new MaterialDeHerramientaMadera());
        TipoDeHerramienta picoMetal2 = new Pico(new MaterialDeHerramientaMetal());
        TipoDeHerramienta picoPiedra2 = new Pico(new MaterialDeHerramientaPiedra());
        TipoDeHerramienta picoFino2 = new PicoFino(new MaterialDeHerramientaMetalPiedra());
        UnidadElemental madera3 = new UnidadElementalMadera();
        UnidadElemental metal3 = new UnidadElementalMetal();
        UnidadElemental piedra3 = new UnidadElementalPiedra();
        UnidadElemental diamante3 = new UnidadElementalDiamante();
        UnidadElemental madera4 = new UnidadElementalMadera();
        UnidadElemental metal4 = new UnidadElementalMetal();
        UnidadElemental piedra4 = new UnidadElementalPiedra();
        UnidadElemental diamante4 = new UnidadElementalDiamante();
        inventario.agregarObjetosAlInventario(madera);
        inventario.agregarObjetosAlInventario(metal);
        inventario.agregarObjetosAlInventario(piedra);
        inventario.agregarObjetosAlInventario(diamante);
        inventario.agregarObjetosAlInventario(hachaMadera);
        inventario.agregarObjetosAlInventario(hachaMetal);
        inventario.agregarObjetosAlInventario(hachaPiedra);
        inventario.agregarObjetosAlInventario(picoMadera);
        inventario.agregarObjetosAlInventario(picoMetal);
        inventario.agregarObjetosAlInventario(picoPiedra);
        inventario.agregarObjetosAlInventario(picoFino);
        inventario.agregarObjetosAlInventario(metal2);
        inventario.agregarObjetosAlInventario(madera2);
        inventario.agregarObjetosAlInventario(piedra2);
        inventario.agregarObjetosAlInventario(diamante2);
        inventario.agregarObjetosAlInventario(hachaMadera2);
        inventario.agregarObjetosAlInventario(hachaMetal2);
        inventario.agregarObjetosAlInventario(hachaPiedra2);
        inventario.agregarObjetosAlInventario(picoMadera2);
        inventario.agregarObjetosAlInventario(picoMetal2);
        inventario.agregarObjetosAlInventario(picoPiedra2);
        inventario.agregarObjetosAlInventario(picoFino2);
        inventario.agregarObjetosAlInventario(metal3);
        inventario.agregarObjetosAlInventario(madera3);
        inventario.agregarObjetosAlInventario(piedra3);
        inventario.agregarObjetosAlInventario(diamante3);
        inventario.agregarObjetosAlInventario(metal4);
        inventario.agregarObjetosAlInventario(madera4);
        inventario.agregarObjetosAlInventario(piedra4);
        inventario.agregarObjetosAlInventario(diamante4);
        int cant = inventario.cantidadDeElementos();
        assertEquals(30,cant);
    }
    @Test
    public void seCreaUnInventarioYSeAgreganMuchosElementosYMuchasHerramientasMasDe30PeroElInventarioSeLlenaYNoAgregaNadaMas(){
        Inventario inventario = new Inventario();
        UnidadElemental madera = new UnidadElementalMadera();
        UnidadElemental metal = new UnidadElementalMetal();
        UnidadElemental piedra = new UnidadElementalPiedra();
        UnidadElemental diamante = new UnidadElementalDiamante();
        TipoDeHerramienta hachaMadera = new Hacha(new MaterialDeHerramientaMadera());
        TipoDeHerramienta hachaMetal = new Hacha(new MaterialDeHerramientaMetal());
        TipoDeHerramienta hachaPiedra = new Hacha(new MaterialDeHerramientaPiedra());
        TipoDeHerramienta picoMadera = new Pico(new MaterialDeHerramientaMadera());
        TipoDeHerramienta picoMetal = new Pico(new MaterialDeHerramientaMetal());
        TipoDeHerramienta picoPiedra = new Pico(new MaterialDeHerramientaPiedra());
        TipoDeHerramienta picoFino = new PicoFino(new MaterialDeHerramientaMetalPiedra());
        UnidadElemental madera2 = new UnidadElementalMadera();
        UnidadElemental metal2 = new UnidadElementalMetal();
        UnidadElemental piedra2 = new UnidadElementalPiedra();
        UnidadElemental diamante2 = new UnidadElementalDiamante();
        TipoDeHerramienta hachaMadera2 = new Hacha(new MaterialDeHerramientaMadera());
        TipoDeHerramienta hachaMetal2 = new Hacha(new MaterialDeHerramientaMetal());
        TipoDeHerramienta hachaPiedra2 = new Hacha(new MaterialDeHerramientaPiedra());
        TipoDeHerramienta picoMadera2 = new Pico(new MaterialDeHerramientaMadera());
        TipoDeHerramienta picoMetal2 = new Pico(new MaterialDeHerramientaMetal());
        TipoDeHerramienta picoPiedra2 = new Pico(new MaterialDeHerramientaPiedra());
        TipoDeHerramienta picoFino2 = new PicoFino(new MaterialDeHerramientaMetalPiedra());
        UnidadElemental madera3 = new UnidadElementalMadera();
        UnidadElemental metal3 = new UnidadElementalMetal();
        UnidadElemental piedra3 = new UnidadElementalPiedra();
        UnidadElemental diamante3 = new UnidadElementalDiamante();
        UnidadElemental madera4 = new UnidadElementalMadera();
        UnidadElemental metal4 = new UnidadElementalMetal();
        UnidadElemental piedra4 = new UnidadElementalPiedra();
        UnidadElemental diamante4 = new UnidadElementalDiamante();
        TipoDeHerramienta hachaMadera3 = new Hacha(new MaterialDeHerramientaMadera());
        TipoDeHerramienta hachaMetal3 = new Hacha(new MaterialDeHerramientaMetal());
        TipoDeHerramienta hachaPiedra3 = new Hacha(new MaterialDeHerramientaPiedra());
        TipoDeHerramienta picoMadera3 = new Pico(new MaterialDeHerramientaMadera());
        TipoDeHerramienta picoMetal3 = new Pico(new MaterialDeHerramientaMetal());
        TipoDeHerramienta picoPiedra3 = new Pico(new MaterialDeHerramientaPiedra());
        TipoDeHerramienta picoFino3 = new PicoFino(new MaterialDeHerramientaMetalPiedra());

        inventario.agregarObjetosAlInventario(madera);
        inventario.agregarObjetosAlInventario(metal);
        inventario.agregarObjetosAlInventario(piedra);
        inventario.agregarObjetosAlInventario(diamante);
        inventario.agregarObjetosAlInventario(hachaMadera);
        inventario.agregarObjetosAlInventario(hachaMetal);
        inventario.agregarObjetosAlInventario(hachaPiedra);
        inventario.agregarObjetosAlInventario(picoMadera);
        inventario.agregarObjetosAlInventario(picoMetal);
        inventario.agregarObjetosAlInventario(picoPiedra);
        inventario.agregarObjetosAlInventario(picoFino);
        inventario.agregarObjetosAlInventario(metal2);
        inventario.agregarObjetosAlInventario(madera2);
        inventario.agregarObjetosAlInventario(piedra2);
        inventario.agregarObjetosAlInventario(diamante2);
        inventario.agregarObjetosAlInventario(hachaMadera2);
        inventario.agregarObjetosAlInventario(hachaMetal2);
        inventario.agregarObjetosAlInventario(hachaPiedra2);
        inventario.agregarObjetosAlInventario(picoMadera2);
        inventario.agregarObjetosAlInventario(picoMetal2);
        inventario.agregarObjetosAlInventario(picoPiedra2);
        inventario.agregarObjetosAlInventario(picoFino2);
        inventario.agregarObjetosAlInventario(metal3);
        inventario.agregarObjetosAlInventario(madera3);
        inventario.agregarObjetosAlInventario(piedra3);
        inventario.agregarObjetosAlInventario(diamante3);
        inventario.agregarObjetosAlInventario(metal4);
        inventario.agregarObjetosAlInventario(madera4);
        inventario.agregarObjetosAlInventario(piedra4);
        inventario.agregarObjetosAlInventario(diamante4);
        inventario.agregarObjetosAlInventario(hachaMadera3);
        inventario.agregarObjetosAlInventario(hachaMetal3);
        inventario.agregarObjetosAlInventario(hachaPiedra3);
        inventario.agregarObjetosAlInventario(picoMadera3);
        inventario.agregarObjetosAlInventario(picoMetal3);
        inventario.agregarObjetosAlInventario(picoPiedra3);
        inventario.agregarObjetosAlInventario(picoFino3);
        int cant = inventario.cantidadDeElementos();

        assertEquals(30,cant);
    }
}
