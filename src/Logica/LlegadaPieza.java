package Logica;

public class LlegadaPieza implements Evento{
    private Pieza nuevaPieza;
    private TCN tornoControl1;
    private TCN tornoControl2;

    public LlegadaPieza(TCN torno1, TCN torno2){
        PiezaFactoryMethod factory = new PiezaFactory();
        nuevaPieza = factory.crearPieza(Math.random(), Reloj.getInstancia().getTiempoActual());
        tornoControl1 = torno1;
        tornoControl2 = torno2;
    }

    @Override
    public void ejecutar() {
        if(tornoControl1.estaAlimentadorLleno() && tornoControl2.estaAlimentadorLleno()){
            ColaLlegadaPieza.getInstancia().getCola().add(nuevaPieza);
        } else if(tornoControl1.estaAlimentadorLleno()){
            tornoControl2.addPiezaAlimentador(nuevaPieza);
        } else if(tornoControl2.estaAlimentadorLleno()){
            tornoControl1.addPiezaAlimentador(nuevaPieza);
        } else if(tornoControl1.verificarUltimaPiezaAlimentador(nuevaPieza)){
            tornoControl1.addPiezaAlimentador(nuevaPieza);
        } else {
            tornoControl2.addPiezaAlimentador(nuevaPieza);
        }
    }
}
