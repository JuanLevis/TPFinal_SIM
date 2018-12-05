package Logica;

public class FinReprogramacion implements Evento {
    private TCN tornoFinalizado;
    private double proxFinReprogramacion;

    public FinReprogramacion(TCN torno){
        tornoFinalizado = torno;
        proxFinReprogramacion = Reloj.getInstancia().getTiempoActual() + 2; //Añado 2 segundos de reprogramacion
    }

    public double getProxFinReprogramacion() {
        return proxFinReprogramacion;
    }

    public void setProxFinReprogramacion(double proxFinReprogramacion) {
        this.proxFinReprogramacion = proxFinReprogramacion;
    }

    public TCN getTornoFinalizado() {
        return tornoFinalizado;
    }

    public void setTornoFinalizado(TCN tornoFinalizado) {
        this.tornoFinalizado = tornoFinalizado;
    }

    @Override
    public void ejecutar() {
        tornoFinalizado.setPiezaActual(tornoFinalizado.getAlimentador().get(0));
        tornoFinalizado.getAlimentador().remove(0);
        if(ColaLlegadaPieza.getInstancia().getCola().size() > 0){
            tornoFinalizado.addPiezaAlimentador(ColaLlegadaPieza.getInstancia().getCola().get(0));
            ColaLlegadaPieza.getInstancia().getCola().remove(0);
        }
        tornoFinalizado.setEstado(EstadoTCN.Ocupado);
    }

    @Override
    public String getNombre() {
        return "Fin Reprog. Torno " + tornoFinalizado.getNumero();
    }
}
