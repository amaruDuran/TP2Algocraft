package Juego;


public class Celda {
    private boolean ocupado;
    private int posicion;
    private ObjetoDelTablero objeto;
    private Celda celdaSiguiente;

    public Celda(int posicion){
        this.posicion = posicion;
        this.ocupado = false;
        this.objeto = null;
    }


    public void agregar(ObjetoDelTablero objeto) {
        this.objeto = objeto;
        this.ocupado = true;
    }

    public String identificador(){
        String identificador = this.objeto.indentificador();
        return identificador;
    }

    public void quitarElemento(){
        this.objeto = null;
    }

    public boolean estaOcupado(){
        return this.ocupado;
    }


}
