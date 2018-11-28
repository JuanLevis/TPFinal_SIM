package Logica;

public class PiezaTipo3 extends Pieza {

    public PiezaTipo3(double tiempoActual) {
        super(tiempoActual);
        calcularTiempoMecanizado();
    }

    @Override
    public double calcularTiempoMecanizado() {
        double rnd1 = Math.random();
        double rnd2 = Math.random();
        double z = Math.sqrt(-2*Math.log(rnd1)*Math.cos(2*Math.PI*rnd2));
        double tiempo = 82 + (z*1);
        return (tiempo / 60)*3600;
    }
}
