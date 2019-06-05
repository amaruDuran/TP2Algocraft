package Jugador;

import Herramientas.TipoDeHerramienta.TipoDeHerramienta;
import Materiales.UnidadElemental.UnidadElemental;

import java.util.ArrayList;
import java.util.List;

public class Inventario {
    private List<UnidadElemental> unidadesDeMaterial;
    private List<TipoDeHerramienta> herramientas;

    public Inventario(){
        this.unidadesDeMaterial = new ArrayList();
        this.herramientas = new ArrayList();
    }

    public int cantidadDeElementos() {
        return (this.herramientas.size() + this.unidadesDeMaterial.size());
    }
}
