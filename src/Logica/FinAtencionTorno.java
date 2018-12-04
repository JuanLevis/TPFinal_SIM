package Logica;

public class FinAtencionTorno implements Evento {
    private TCN tornoFinalizado;

    public FinAtencionTorno(TCN tornoFinalizado){
        this.tornoFinalizado = tornoFinalizado;
    }

    @Override
    public void ejecutar() {
        if(tornoFinalizado.getAlimentador().size() > 0){
            if(tornoFinalizado.verificarUltimaPiezaTCN(tornoFinalizado.getAlimentador().get(0))){
                tornoFinalizado.setPiezaActual(tornoFinalizado.getAlimentador().get(0));
                tornoFinalizado.getAlimentador().remove(0);
                if(ColaLlegadaPieza.getInstancia().getCola().size() > 0){
                    tornoFinalizado.addPiezaAlimentador(ColaLlegadaPieza.getInstancia().getCola().get(0));
                    ColaLlegadaPieza.getInstancia().getCola().remove(0);
                }
                tornoFinalizado.setEstado(EstadoTCN.Ocupado);
            }
            else {
                tornoFinalizado.setPiezaActual(null);
                tornoFinalizado.setEstado(EstadoTCN.EnReprogramacion);
            }
        }
        else {
            tornoFinalizado.setEstado(EstadoTCN.Libre);
        }

    }

    @Override
    public String getNombre() {
        return "Fin At. Torno " + tornoFinalizado.getNumero();
    }
}
