package Logica;

public abstract class Pieza {
    private double horaLlegada;
    private int numeroPieza = 0;

    public Pieza(){
        this.numeroPieza++;
    }

    public abstract double calcularTiempoMecanizado();


}
