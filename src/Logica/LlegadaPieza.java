package Logica;

public class LlegadaPieza implements Evento{
    private Pieza nuevaPieza;
    private TCN tornoControl1;
    private TCN tornoControl2;
    private double randomLlegada;
    private double tiempoLlegada;
    private double proxLlegadaPieza;

    public LlegadaPieza(TCN torno1, TCN torno2){
        tornoControl1 = torno1;
        tornoControl2 = torno2;
        randomLlegada = Math.random();
        nuevaPieza = generarPieza(randomLlegada, Reloj.getInstancia().getTiempoActual());
        calcularLlegadaPieza();
        calcularProxLlegadaPieza();
    }

    public Pieza generarPieza(double random, double tiempoActual){
        if(ColaLlegadaPieza.getInstancia().getCola().size() > 0){
            return ColaLlegadaPieza.getInstancia().getCola().get(0);
        }
        PiezaFactoryMethod factory = new PiezaFactory();
        return factory.crearPieza(random, tiempoActual);
    }

    public void calcularLlegadaPieza(){
        double demora = -((1/200)*Math.log((1-randomLlegada))*3600);
        tiempoLlegada = demora;
    }

    public void calcularProxLlegadaPieza(){
        proxLlegadaPieza = tiempoLlegada + Reloj.getInstancia().getTiempoActual();
    }


    @Override
    public void ejecutar() {
        if(tornoControl1.estaAlimentadorLleno() && tornoControl2.estaAlimentadorLleno()){
            ColaLlegadaPieza.getInstancia().getCola().add(nuevaPieza);
            this.nuevaPieza = null;
        } else if(tornoControl1.estaAlimentadorLleno()){
            tornoControl2.addPiezaAlimentador(nuevaPieza);
            this.nuevaPieza = null;
        } else if(tornoControl2.estaAlimentadorLleno()){
            tornoControl1.addPiezaAlimentador(nuevaPieza);
            this.nuevaPieza = null;
        } else if(tornoControl1.verificarUltimaPiezaAlimentador(nuevaPieza)){
            tornoControl1.addPiezaAlimentador(nuevaPieza);
            this.nuevaPieza = null;
        } else {
            tornoControl2.addPiezaAlimentador(nuevaPieza);
            this.nuevaPieza = null;
        }
    }
}
