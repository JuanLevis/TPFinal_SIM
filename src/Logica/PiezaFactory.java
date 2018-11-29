package Logica;

public class PiezaFactory implements PiezaFactoryMethod {

    @Override
    public Pieza crearPieza(double random, double tiempoActual) {
        double minInterv1 = 0;
        double maxInterv1 = 0.23999;
        double minInterv2 = 0.24;
        double maxInterv2 = 0.60999;
        double minInterv3 = 0.61;
        double maxInterv3 = 1;

        if(random > minInterv1 && random <= maxInterv1){
            return new PiezaTipo1(tiempoActual);
        }
        else if(random >= minInterv2 && random <= maxInterv2){
            return new PiezaTipo2(tiempoActual);
        }
        else{
            return new PiezaTipo3(tiempoActual);
        }

    }
}
