package Jugador;

import Herramientas.TipoDeHerramienta.Hacha;
import Herramientas.TipoDeHerramienta.MaterialDeHerramientas.MaterialDeHerramienta;
import Herramientas.TipoDeHerramienta.MaterialDeHerramientas.MaterialDeHerramientaMadera;
import Herramientas.TipoDeHerramienta.TipoDeHerramienta;
import Juego.*;

public class Jugador implements ObjetoDelTablero {
    private TipoDeHerramienta herramientaEnMano;
    private Inventario inventario;
    private String identificador;
    private Mapa mapa;
    private Movimiento movimiento;
    //private TableroDeConstruccion constructor;

    public Jugador(){
        this.inventario = new Inventario();
        MaterialDeHerramienta madera = new MaterialDeHerramientaMadera();
        this.herramientaEnMano = new Hacha(madera);
        this.identificador = "JUGADOR";
        this.movimiento = new Movimiento();
        //this.constructor = new TableroDeConstruccion();
    }

    public int cantidadDeElementosDelInventario() {
        return this.inventario.cantidadDeElementos();
    }

    public TipoDeHerramienta obtenerHerramientaEnMano() {
        return this.herramientaEnMano;
    }

    @Override
    public String indentificador() {
        return this.identificador;
    }


    public void iniciar(Mapa mapa) {
        this.mapa = mapa;
        this.movimiento.iniciar(mapa,this);
    }

    public void moverALaDerecha() {
         this.movimiento.moverHaciaLaDerecha(this.mapa,this);
    }

    public void moverParaAbajo(){
        this.movimiento.moverHaciaAbajo(this.mapa,this);
    }

    public void moverParaArriba() {
        this.movimiento.moverHaciaArriba(this.mapa,this);
    }

    public void moverALaIzquierda() {
        this.movimiento.moverHaciaLaIzquierda(this.mapa,this);
    }
}
