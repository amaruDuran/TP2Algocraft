package Herramientas.Constructor.Patron;


import Herramientas.Constructor.CeldaDeConstruccion;
import Herramientas.Constructor.TableroDeConstruccion;
import Herramientas.TipoDeHerramienta.TipoDeHerramienta;

import java.util.ArrayList;

public class PatronDeConstruccion {

    public TipoDeHerramienta construir(TableroDeConstruccion tablero){
        TipoDeHerramienta herramienta = null;
        /*
        boolean celdasSinPatronVacias = this.celdasQueNoPertenecesANingunPatronVacias(tablero);
        if (!celdasSinPatronVacias){
            return herramienta;
        }
        boolean celdasConPatronVacias = this.celdasQuePertencenATodosLosPatrones(tablero);
        if (celdasConPatronVacias){
            return herramienta;
        }
        //celdas caracteristicas de patrones
        ArrayList<CeldaDeConstruccion> ordenDeVerificacionDeCeldas = new ArrayList<CeldaDeConstruccion>();
        ordenDeVerificacionDeCeldas.add(tablero.verCelda(2,3));
        ordenDeVerificacionDeCeldas.add(tablero.verCelda(2,2));
        ordenDeVerificacionDeCeldas.add(tablero.verCelda(1,1));
        ordenDeVerificacionDeCeldas.add(tablero.verCelda(1,2));

        ordenDeVerificacionDeCeldas.add(tablero.verCelda(1,3));//pico
        ordenDeVerificacionDeCeldas.add(tablero.verCelda(2,1));//hacha/picofino
        */
        return herramienta;
    }
/*
    private boolean celdasQueNoPertenecesANingunPatronVacias(TableroDeConstruccion tablero){
        CeldaDeConstruccion celda31 = tablero.verCelda(3,1);
        boolean celda31vacia = celda31.estaVacia();
        CeldaDeConstruccion celda23 = tablero.verCelda(2,3);
        boolean celda23vacia = celda23.estaVacia();
        CeldaDeConstruccion celda33 = tablero.verCelda(3,3);
        boolean celda33vacia = celda33.estaVacia();
        boolean TodasCeldasVacias = celda31vacia && celda23vacia && celda33vacia;
        return TodasCeldasVacias;
    }

    private boolean celdasQuePertencenATodosLosPatrones(TableroDeConstruccion tablero){
        CeldaDeConstruccion celda11 = tablero.verCelda(1,1);
        boolean celda11vacia = celda11.estaVacia();
        CeldaDeConstruccion celda12 = tablero.verCelda(1,2);
        boolean celda12vacia = celda12.estaVacia();
        CeldaDeConstruccion celda22 = tablero.verCelda(1,2);
        boolean celda22vacia = celda22.estaVacia();
        CeldaDeConstruccion celda23 = tablero.verCelda(1,2);
        boolean celda23vacia = celda23.estaVacia();
        boolean NingunaCeldaVacia = celda11vacia || celda12vacia || celda22vacia || celda23vacia;
        return NingunaCeldaVacia;
    }
*/
}
