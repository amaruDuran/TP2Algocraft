package Juego;

public class Casillero{
    private ObjetoDelTablero objeto;

    public Casillero(){
        this.objeto = null;
    }

    public String identificador(){
        if (!this.estaOcupado()){
            return "";
        }
        String identificador = this.objeto.indentificador();
        return identificador;
    }

    public boolean estaOcupado(){
        return (this.objeto != null);
    }

    public boolean asignar(ObjetoDelTablero objetoAAgragar) {
        if (this.estaOcupado()){
            return false;
        }
        this.objeto = objetoAAgragar;
        return true;
    }

    public void eliminar(){
        this.objeto = null;
    }

}
