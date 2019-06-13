package Juego;

public class Casillero{
    private  boolean ocupado;
    private ObjetoDelTablero objeto;

    public Casillero(){
        this.ocupado = false;
    }

    public String identificador(){
        String identificador = this.objeto.indentificador();
        return identificador;
    }

    public boolean estaOcupado(){
        return this.ocupado;
    }

    public boolean asignar(ObjetoDelTablero objeto) {
        boolean devolver = false;
        if (this.ocupado == false){
            this.objeto = objeto;
            this.ocupado = true;
            devolver = true;
        }
        return devolver;
    }

    public void eliminar(){
        this.ocupado = false;
        this.objeto = null;
    }

}
