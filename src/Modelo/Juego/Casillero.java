package Modelo.Juego;

import java.util.Objects;

public class Casillero{
    private ObjetoDelTablero objeto;

    public Casillero(){
        this.objeto = null;
    }

    public String identificador(){
        if (!this.estaOcupado()){
            return "VACIO";
        }
        String identificador = this.objeto.indentificador();
        return identificador;
    }

    public boolean estaOcupado(){
        return (this.objeto != null);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Casillero casillero = (Casillero) o;
        return Objects.equals(objeto, casillero.objeto);
    }

    @Override
    public int hashCode() {
        return Objects.hash(objeto);
    }

    public boolean asignar(ObjetoDelTablero objetoAAgregar) {
        if (this.estaOcupado()){
            return false;
        }
        this.objeto = objetoAAgregar;
        return true;
    }

    public void vaciarCasillero(){
        this.objeto = null;
    }

    public ObjetoDelTablero getObjeto() {
        return this.objeto;
    }
}
