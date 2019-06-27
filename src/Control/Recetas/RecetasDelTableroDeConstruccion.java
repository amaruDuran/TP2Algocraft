package Control.Recetas;

import Control.TableroDeConstruccionControl;
import Modelo.Herramientas.Constructor.Patron.PatronMaterialTipoHerramienta;
import Modelo.Herramientas.TipoDeHerramienta.MaterialDeHerramientas.MaterialDeHerramienta;
import Modelo.Herramientas.TipoDeHerramienta.MaterialDeHerramientas.MaterialDeHerramientaMadera;
import Modelo.Herramientas.TipoDeHerramienta.MaterialDeHerramientas.MaterialDeHerramientaMetal;
import Modelo.Herramientas.TipoDeHerramienta.MaterialDeHerramientas.MaterialDeHerramientaPiedra;

import java.util.ArrayList;
import java.util.HashMap;

public abstract class RecetasDelTableroDeConstruccion{
        protected HashMap<MaterialDeHerramienta, Integer> cantidadDeElementosNesesarios;
        protected ArrayList<MaterialDeHerramienta> materialesPosibles;
        protected Integer cantidadDeMaderaNesesaria;
        protected Integer cantidadDePiedraNesesaria;
        protected Integer cantidadDeMetalNesesaria;
        protected PatronMaterialTipoHerramienta patronCorrespondiente;

        protected void elementosNesesarios(){
            materialesPosibles = new ArrayList<>();
            cantidadDeElementosNesesarios = new HashMap<>();
            MaterialDeHerramienta madera = new MaterialDeHerramientaMadera();
            MaterialDeHerramienta metal = new MaterialDeHerramientaMetal();
            MaterialDeHerramienta piedra = new MaterialDeHerramientaPiedra();

            cantidadDeElementosNesesarios.put(madera, cantidadDeMaderaNesesaria);
            cantidadDeElementosNesesarios.put(metal, cantidadDeMetalNesesaria);
            cantidadDeElementosNesesarios.put(piedra, cantidadDePiedraNesesaria);

            materialesPosibles.add(0,madera);
            materialesPosibles.add(1,metal);
            materialesPosibles.add(2,piedra);
        }

        private boolean esSuficienteMaterial(int nesesario, int disponible){
            return disponible >= nesesario;
        }
        public boolean tieneMaterialesNesesarios(HashMap<MaterialDeHerramienta, Integer> elementosQuePosee){
            boolean tieneTodosLosElementosNesesarios = true;
            for (int i = 0; i < materialesPosibles.size(); i++){
                MaterialDeHerramienta material = materialesPosibles.get(i);
                tieneTodosLosElementosNesesarios = tieneTodosLosElementosNesesarios && esSuficienteMaterial(cantidadDeElementosNesesarios.get(material),elementosQuePosee.get(material));
            }
            return tieneTodosLosElementosNesesarios;
        }
        public String nombreDeReceta(){
            return "";
        }
        public String urlDeImagenDeReceta(){
            return "";
        }
        public void acomodar(TableroDeConstruccionControl tablero){
            tablero.vaciar();
            tablero.acomodar(patronCorrespondiente.cargarPatron(),this);
        }
        public ArrayList<MaterialDeHerramienta> getPosiblesMateriales(){
            return materialesPosibles;
        }
}
