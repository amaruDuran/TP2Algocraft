package Modelo.Jugador;

import Modelo.Herramientas.TipoDeHerramienta.Hacha;
import Modelo.Herramientas.TipoDeHerramienta.MaterialDeHerramientas.MaterialDeHerramienta;
import Modelo.Herramientas.TipoDeHerramienta.MaterialDeHerramientas.MaterialDeHerramientaMadera;
import Modelo.Herramientas.TipoDeHerramienta.TipoDeHerramienta;
import Modelo.Juego.Mapa;
import Modelo.Juego.ObjetoDelTablero;
import Modelo.Materiales.Material;

import java.awt.*;
import java.util.List;
import java.util.Objects;

public class Jugador implements ObjetoDelTablero {
    private TipoDeHerramienta herramientaEnMano;
    private Inventario inventario;
    private String identificador;
    private Mapa mapa;
    private Movimiento movimiento;
    private Ruptura romper;

    public Jugador(){
        this.inventario = new Inventario();
        MaterialDeHerramienta madera = new MaterialDeHerramientaMadera();
        this.herramientaEnMano = new Hacha(madera);
        this.identificador = "jugadorMirandoDerecha";
        this.movimiento = new Movimiento();
    }

    public int cantidadDeElementosDelInventario() {
        return this.inventario.cantidadDeElementos();
    }

    public TipoDeHerramienta obtenerHerramientaEnMano() {
        return this.herramientaEnMano;
    }

    public void equipar(TipoDeHerramienta herramienta){
        this.desequipar();
        herramientaEnMano = herramienta;
    }
    public void desequipar(){
        if (herramientaEnMano != null){
            inventario.agregarObjetosAlInventario(herramientaEnMano);
        }
        herramientaEnMano = null;
    }
    public void destruirHerramienta(){
        /*if (herramientaEnMano == null){
            return;
        }*/
        herramientaEnMano = null;
    }

    @Override
    public String indentificador() {
        return this.identificador;
    }

    public List<ObjeosDelInventario> listadoDeInventario(){
        return inventario.listadoDeInventario();
    }

    public void iniciar(Mapa mapa) {
        this.romper = new Ruptura(movimiento,mapa,this);
        this.mapa = mapa;
        this.movimiento.iniciar(mapa,this);
        this.romper = new Ruptura(this.movimiento,this.mapa,this);
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

    public Point posicion() {
        int posx = this.movimiento.getPosicionHorizontal();
        int posy = this.movimiento.getPosicionVertical();
        return new Point(posx, posy);
    }

    public void agregarAlInventario(Material material){
        this.inventario.agregarObjetosAlInventario(material.getUnidadElemental());
    }

    public void agregarAlInventario(ObjeosDelInventario objeto){
        this.inventario.agregarObjetosAlInventario(objeto);
    }

    public ObjeosDelInventario quitarObjetoDelInventario(int posicion){
        return this.inventario.quitarObjetoDelInventario(posicion);
    }

    public void intentarRomperADerecha(){
        this.romper.aDerecha();
    }

    public void intentarRomperAIzquierda(){
        this.romper.aIzquierda();
    }

    public void intentarRomperArriba(){
        this.romper.Arriba();
    }

    public void intentarRomperAbajo(){
        this.romper.Abajo();
    }
}
