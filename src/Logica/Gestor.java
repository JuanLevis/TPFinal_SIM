package Logica;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import sample.Fila;

import java.util.ArrayList;

public class Gestor {
    private double tiempoOcioso; //Tiempo ocioso de los Tornos
    private TCN TCN_1;
    private TCN TCN_2;
    private LlegadaPieza llegadaPieza;
    private int dia;
    private ObservableList<Fila> data;
    private ArrayList<String> conjuntoEventos;
    private static Evento eventoActual;
    private int diasSimulacion;

    public Gestor(){
        this.conjuntoEventos = new ArrayList<String>();
        this.data = FXCollections.observableArrayList();
        this.TCN_1 = new TCN(1);
        this.TCN_2 = new TCN(2);
        this.llegadaPieza = new LlegadaPieza(TCN_1, TCN_2);
        this.dia = 1;
    }

    public double getTiempoOcioso() {
        return tiempoOcioso;
    }

    public void setTiempoOcioso(double tiempoOcioso) {
        this.tiempoOcioso = tiempoOcioso;
    }

    public TCN getTCN_1() {
        return TCN_1;
    }

    public void setTCN_1(TCN TCN_1) {
        this.TCN_1 = TCN_1;
    }

    public TCN getTCN_2() {
        return TCN_2;
    }

    public void setTCN_2(TCN TCN_2) {
        this.TCN_2 = TCN_2;
    }

    public int getDia() {
        return dia;
    }

    public void setDia(int dia) {
        this.dia = dia;
    }

    public ObservableList<Fila> getData() {
        return data;
    }

    public void setData(ObservableList<Fila> data) {
        this.data = data;
    }

    public ArrayList<String> getConjuntoEventos() {
        return conjuntoEventos;
    }

    public void setConjuntoEventos(ArrayList<String> conjuntoEventos) {
        this.conjuntoEventos = conjuntoEventos;
    }

    public static Evento getEventoActual() {
        return eventoActual;
    }

    public static void setEventoActual(Evento eventoActual) {
        Gestor.eventoActual = eventoActual;
    }

    public int getDiasSimulacion() {
        return diasSimulacion;
    }

    public void setDiasSimulacion(int diasSimulacion) {
        this.diasSimulacion = diasSimulacion;
    }

    public void inicio(){
        cargarFilaPrimeravez();
        setEventoActual(llegadaPieza);
        getConjuntoEventos().add(getEventoActual().getNombre());
        Reloj.getInstancia().setTiempoActual(llegadaPieza.getProxLlegadaPieza());
        iterar();
    }

    //TODO: Terminar los distintos eventos
    public void iterar(){
        while ((Reloj.getInstancia().getTiempoActual()/3600) <= (diasSimulacion*24)){
            switch (proxEvento()){
                case "LlegadaPieza":
                    break;
                case "FinAtTorno1":
                    break;
                case "FinAtTorno2":
                    break;
            }
        }

    }

    public double calcularProxFinAtencionTorno(TCN torno){
        return torno.getPiezaActual().tiempoMecanizado + Reloj.getInstancia().getTiempoActual();
    }

    public double tiempoMinimo(){
        double minTiempo = 2592000;

        if(llegadaPieza.getProxLlegadaPieza() != 0 && llegadaPieza.getProxLlegadaPieza() < minTiempo){
            minTiempo = llegadaPieza.getProxLlegadaPieza();
        }
        if(calcularProxFinAtencionTorno(TCN_1) != 0 && calcularProxFinAtencionTorno(TCN_1) < minTiempo){
            minTiempo = calcularProxFinAtencionTorno(TCN_1);
        }
        if(calcularProxFinAtencionTorno(TCN_2) != 0 && calcularProxFinAtencionTorno(TCN_2) < minTiempo){
            minTiempo = calcularProxFinAtencionTorno(TCN_2);
        }

        return minTiempo;
    }

    public String proxEvento(){
        double tiempo = tiempoMinimo();

        if(tiempo == llegadaPieza.getProxLlegadaPieza()){
            return "LlegadaPieza";
        } else if(tiempo == calcularProxFinAtencionTorno(TCN_1)){
            return "FinAtTorno1";
        } else{
            return "FinAtTorno2";
        }
    }

    public void cargarFilaPrimeravez() {

            String diaContent = String.valueOf(getDia());
            String relojContent = "00:00:00";
            String eventContent = "Inicio de la simulacion";
            String piezaContent = "-";
            String rnd1Content = "-";
            String tiempoEntreLlegadasContent = "00:00:00";
            String proxFinAtencionContent = "00:00:00";
            String colaLlegadaPiezasContent = "0";
            String estadoTorno1Content = "Libre";
            String alimentadorTorno1_1Content = "-";
            String alimentadorTorno1_2Content = "-";
            String alimentadorTorno1_3Content = "-";
            String rndTorno1Content = "-";
            String tiempoMecanizadoTorno1Content = "00:00:00";
            String proxFinAtencionTorno1Content = "00:00:00";
            String estadoTorno2Content = "Libre";
            String alimentadorTorno2_1Content = "-";
            String alimentadorTorno2_2Content = "-";
            String alimentadorTorno2_3Content = "-";
            String rndTorno2Content = "-";
            String tiempoMecanizadoTorno2Content = "00:00:00";
            String proxFinAtencionTorno2Content = "00:00:00";

            data.add(new Fila(diaContent, relojContent, eventContent, piezaContent, rnd1Content, tiempoEntreLlegadasContent, proxFinAtencionContent, colaLlegadaPiezasContent, estadoTorno1Content, alimentadorTorno1_1Content, alimentadorTorno1_2Content, alimentadorTorno1_3Content, rndTorno1Content, tiempoMecanizadoTorno1Content, proxFinAtencionTorno1Content, estadoTorno2Content, alimentadorTorno2_1Content, alimentadorTorno2_2Content, alimentadorTorno2_3Content, rndTorno2Content, tiempoMecanizadoTorno2Content, proxFinAtencionTorno2Content));
    }
}
