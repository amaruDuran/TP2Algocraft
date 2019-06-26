package Modelo.Jugador;

import Modelo.Herramientas.TipoDeHerramienta.Hacha;
import Modelo.Herramientas.TipoDeHerramienta.MaterialDeHerramientas.MaterialDeHerramienta;
import Modelo.Herramientas.TipoDeHerramienta.MaterialDeHerramientas.MaterialDeHerramientaMadera;
import Modelo.Herramientas.TipoDeHerramienta.TipoDeHerramienta;
import Modelo.Juego.Casillero;
import Modelo.Juego.Mapa;
import Modelo.Juego.ObjetoDelTablero;
import Modelo.Materiales.Material;
import Vista.Aplicacion;

import java.awt.*;
import java.util.List;
import java.util.Objects;

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
        this.identificador = "jugadorMirandoDerecha";
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

    public List<ObjeosDelInventario> listadoDeInventario(){
        return inventario.listadoDeInventario();
    }

    public void iniciar(Mapa mapa) {
        this.mapa = mapa;
        this.movimiento.iniciar(mapa,this);
    }

    public void moverALaDerecha() {
         this.movimiento.moverHaciaLaDerecha(this.mapa,this);
         this.identificador = "jugadorMirandoDerecha";
    }

    public void moverParaAbajo(){
        this.movimiento.moverHaciaAbajo(this.mapa,this);
        this.identificador = "jugadorMirandoAbajo";
    }

    public void moverParaArriba() {
        this.movimiento.moverHaciaArriba(this.mapa,this);
        this.identificador = "jugadorMirandoArriba";
    }

    public void moverALaIzquierda() {
        this.movimiento.moverHaciaLaIzquierda(this.mapa,this);
        this.identificador = "jugadorMirandoIzquierda";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Jugador jugador = (Jugador) o;
        return Objects.equals(identificador, jugador.identificador);
    }

    @Override
    public int hashCode() {
        return Objects.hash(herramientaEnMano, inventario, identificador, mapa, movimiento);
    }

    public void romperADerecha() {
        int posX = this.movimiento.getPosicionHorizontal();
        int posY = this.movimiento.getPosicionVertical();

        Casillero casilleroARomper = this.mapa.obtenerCasillero(new Point(posX+1, posY));
        if (casilleroARomper.estaOcupado()){
            Material material = (Material) casilleroARomper.getObjeto();
            this.herramientaEnMano.usarEn(material);
            if (material.durabilidadActualDelMaterial() == 0){
                casilleroARomper.vaciarCasillero();
                this.inventario.agregarObjetosAlInventario(material.getUnidadElemental());
            }

        }
    }

    public void agregarAlInventario(Material material){
        this.inventario.agregarObjetosAlInventario(material.getUnidadElemental());
    }
}
