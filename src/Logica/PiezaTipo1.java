package Logica;

public class PiezaTipo1 extends Pieza {

    public PiezaTipo1(double tiempoActual){
        super(tiempoActual);
        this.tiempoMecanizado = calcularTiempoMecanizado();
    }

    @Override
    public double calcularTiempoMecanizado() {
        double rnd1 = Math.random();
        double rnd2 = Math.random();
        double z = Math.sqrt(-2*Math.log(rnd1))*Math.cos(2*Math.PI*rnd2);
        double tiempo = 150 + (z*2);
        return (tiempo / 60)*3600;
    }


}
