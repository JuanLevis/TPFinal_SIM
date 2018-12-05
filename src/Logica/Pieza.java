package Logica;

public abstract class Pieza {
    private double horaLlegada;
    protected double tiempoMecanizado;
    protected double proxFinMecanizado;
    private int numeroPieza = 0;

    public Pieza(double tiempoActual){
        this.horaLlegada = tiempoActual;
    }

    public abstract double calcularTiempoMecanizado();

    public int getNumeroPieza() {
        return numeroPieza;
    }

    public void setNumeroPieza(int numeroPieza) {
        this.numeroPieza = numeroPieza;
    }

    public double getHoraLlegada() {
        return horaLlegada;
    }
}
