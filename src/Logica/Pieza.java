package Logica;

public abstract class Pieza {
    private double horaLlegada;
    private int numeroPieza = 0;

    public Pieza(double tiempoActual){
        this.numeroPieza++;
        this.horaLlegada = tiempoActual;
    }

    public abstract double calcularTiempoMecanizado();


}
