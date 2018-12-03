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
                tornoFinalizado.setEstado(EstadoTCN.Ocupado);
            }
            else {
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
