package Jugador;

import Herramientas.TipoDeHerramienta.Hacha;
import Herramientas.TipoDeHerramienta.MaterialDeHerramientas.MaterialDeHerramienta;
import Herramientas.TipoDeHerramienta.MaterialDeHerramientas.MaterialDeHerramientaMadera;
import Herramientas.TipoDeHerramienta.TipoDeHerramienta;
import Juego.ObjetoDelTablero;

public class Jugador implements ObjetoDelTablero {
    private TipoDeHerramienta herramientaEnMano;
    private Inventario inventario;
    private String identificador;
    //private TableroDeConstruccion constructor;

    public Jugador(){
        this.inventario = new Inventario();
        MaterialDeHerramienta madera = new MaterialDeHerramientaMadera();
        this.herramientaEnMano = new Hacha(madera);
        this.identificador = "JUGADOR";
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
}
