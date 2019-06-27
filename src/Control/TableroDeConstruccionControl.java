package Control;

import Control.Recetas.RecetasDelTableroDeConstruccion;
import Modelo.Herramientas.Constructor.Patron.PatronMaterialTipoHerramienta;
import Modelo.Herramientas.Constructor.TableroDeConstruccion;
import Modelo.Herramientas.TipoDeHerramienta.MaterialDeHerramientas.MaterialDeHerramienta;
import Modelo.Herramientas.TipoDeHerramienta.MaterialDeHerramientas.MaterialDeHerramientaMadera;
import Modelo.Herramientas.TipoDeHerramienta.MaterialDeHerramientas.MaterialDeHerramientaMetal;
import Modelo.Herramientas.TipoDeHerramienta.MaterialDeHerramientas.MaterialDeHerramientaPiedra;
import Modelo.Jugador.Inventario;
import Modelo.Jugador.ObjeosDelInventario;
import Modelo.Materiales.UnidadElemental.UnidadElemental;
import Vista.Aplicacion;
import Vista.TableroDeConstruccionVista;
import jdk.nashorn.internal.runtime.ListAdapter;

import java.awt.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class TableroDeConstruccionControl {
    private TableroDeConstruccion tablero;
    private Inventario deposito;
    private TableroDeConstruccionVista vista;

    public TableroDeConstruccionControl(Inventario inventario, TableroDeConstruccionVista tableroDeConstruccionVista){
        tablero = new TableroDeConstruccion();
        deposito = inventario;
        vista = tableroDeConstruccionVista;
    }

    public void vaciar(){
        for (int i = 0; i < 9; i++){
            Point posicion = this.posicionDeLaCelda(i);
            int fila = posicion.y;
            int columna = posicion.x;
            if (tablero.posicionEstaVacia(fila,columna)){
                continue;
            }
            tablero.quitarElementoEnCelda(fila,columna,deposito);
        }
    }

    public void acomodar(ArrayList<UnidadElemental> patron, RecetasDelTableroDeConstruccion receta){
        if (!receta.tieneMaterialesNesesarios(this.elementosQuePoseeElInventario(receta))){
            return;
        }
        for (int i = 0; i < patron.size(); i++){
            Point ubicacion = this.posicionDeLaCelda(i);
            int fila = ubicacion.y;
            int columna = ubicacion.x;
            //////////////////////////////////
            //aca tiene que estar el quitar del inventario
            ///////////////////////////
            tablero.agregarElementoEnCelda(fila,columna,patron.get(i));
        }
        //Aplicacion.tableroDeConstruccionVista.dibujar();
        vista.dibujar();
    }

    private Point posicionDeLaCelda(int pos){
        int y = (pos / 3) + 1;
        pos = pos + 1;
        int x = pos % 3;
        return new Point(x,y);
    }

    private HashMap<MaterialDeHerramienta, Integer> elementosQuePoseeElInventario(RecetasDelTableroDeConstruccion receta){
        List<UnidadElemental> unidadesDepositadas = deposito.listadoDeUnidadesElementalesDelInventario();
        ArrayList<MaterialDeHerramienta> lista = receta.getPosiblesMateriales();
        HashMap<MaterialDeHerramienta, Integer> objetosQuePoseo = new HashMap<MaterialDeHerramienta, Integer>();
        for (int material = 0; material < lista.size(); material++){
            objetosQuePoseo.put(lista.get(material),0);
        }
        for (int i = 0; i < unidadesDepositadas.size(); i++){
            UnidadElemental unidad = unidadesDepositadas.get(i);
            MaterialDeHerramienta material = unidad.materialDeConstruccion();
            int cantidad = objetosQuePoseo.get(material) + 1;
            objetosQuePoseo.put(material,cantidad);
        }
        return objetosQuePoseo;
    }

    public void crear(){
        deposito.agregarObjetosAlInventario(tablero.construir());
        Aplicacion.inventarioVista.dibujar();
    }
}
