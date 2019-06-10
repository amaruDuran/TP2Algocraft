package Juego;

import Materiales.*;
import java.util.ArrayList;
import java.util.List;

public class Algocraft {
    private Mapa mapa;
    private List<Material> materiales = new ArrayList<>();

    public Algocraft() {
        this.cargarMateriales();
        this.mapa = new Mapa(this.materiales);
    }

    private void cargarMateriales() {
        this.materiales.add(new MaterialMadera());
        this.materiales.add(new MaterialPiedra());
        this.materiales.add(new MaterialMetal());
        this.materiales.add(new MaterialMetal());
    }
}