package Logica;

import java.util.ArrayList;

public class TCN {
    private int numero;
    private EstadoTCN estado;
    private ArrayList<Pieza> alimentador; //Tendra maximo 3 elementos
    private Pieza piezaActual;


    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public EstadoTCN getEstado() {
        return estado;
    }

    public void setEstado(EstadoTCN estado) {
        this.estado = estado;
    }

    public ArrayList<Pieza> getAlimentador() {
        return alimentador;
    }

    public void setAlimentador(ArrayList<Pieza> alimentador) {
        this.alimentador = alimentador;
    }

    public Pieza getPiezaActual() {
        return piezaActual;
    }

    public void setPiezaActual(Pieza piezaActual) {
        this.piezaActual = piezaActual;
        if(piezaActual != null){
            if(piezaActual.proxFinMecanizado == 0){
                piezaActual.proxFinMecanizado = piezaActual.tiempoMecanizado + Reloj.getInstancia().getTiempoActual();
            }
        }

    }

    public TCN(int numero) {
        this.numero = numero;
        setEstado(EstadoTCN.Libre);
        alimentador = new ArrayList<Pieza>();
    }

    /**
     * Determina si el ultimo elemento en el array es del mismo tipo que el que quiero insertar
     * */
    public boolean verificarUltimaPiezaAlimentador(Pieza pieza) {
        if(alimentador.size() > 0) {
            if (alimentador.get(alimentador.size() - 1).getClass().equals(pieza.getClass())) {
                return true;
            } else {
                return false;
            }
        } else {
            return false;
        }
    }

    /**Añade la pieza al final del array. Si no hay piezas procesandose, se asigna como pieza actual*/
    public void addPiezaAlimentador(Pieza pieza){
        alimentador.add(pieza);
        if(this.estado == EstadoTCN.Libre){
            piezaActual = alimentador.get(0);
            alimentador.remove(0);
            piezaActual.proxFinMecanizado = Reloj.getInstancia().getTiempoActual() + piezaActual.tiempoMecanizado;
            setEstado(EstadoTCN.Ocupado);
        }
    }

    /**Determina si el alimentador esta lleno*/
    public boolean estaAlimentadorLleno(){
        return (alimentador.size() == 3) ? true : false;
    }

    /**Verifica si la pieza que va a ingresar al TCN es del mismo tipo que la que termina*/
    public boolean verificarUltimaPiezaTCN(Pieza pieza){
        return (piezaActual.getClass().equals(pieza.getClass())) ? true : false;
    }
}
