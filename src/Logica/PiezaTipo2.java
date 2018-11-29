package Logica;

public class PiezaTipo2 extends Pieza {

    public PiezaTipo2(double tiempoActual){
        super(tiempoActual);
        this.tiempoMecanizado = calcularTiempoMecanizado();
    }

    @Override
    public double calcularTiempoMecanizado() {
        double rnd1 = Math.random();
        double rnd2 = Math.random();
        double z = Math.sqrt(-2*Math.log(rnd1)*Math.cos(2*Math.PI*rnd2));
        double tiempo = 80 + (z*3);
        return (tiempo / 60)*3600;
    }


}
