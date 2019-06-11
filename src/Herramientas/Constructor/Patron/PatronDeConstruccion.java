package Herramientas.Constructor.Patron;


import Herramientas.Constructor.CeldaDeConstruccion;
import Herramientas.Constructor.TableroDeConstruccion;
import Herramientas.TipoDeHerramienta.MaterialDeHerramientas.MaterialDeHerramienta;
import Herramientas.TipoDeHerramienta.TipoDeHerramienta;
import Materiales.UnidadElemental.UnidadElemental;

import java.util.ArrayList;
import java.util.List;

public class PatronDeConstruccion {

    public TipoDeHerramienta construir(List<CeldaDeConstruccion> listaDeCeldas){
        TipoDeHerramienta herramienta = null;

        return herramienta;
    }

    private List<String> conversorACadena(List<CeldaDeConstruccion> listaDeCeldas){
        List<String> cadenas = new ArrayList<String>();
        int tamanio = listaDeCeldas.size();
        for (int i = 0; i < tamanio; i++){
            CeldaDeConstruccion celda = listaDeCeldas.get(i + 1);
            UnidadElemental unidadElemental = celda.verElemento();
            String nombre = unidadElemental.generarNombre();
            cadenas.add(nombre);
        }
        return cadenas;
    }
}
