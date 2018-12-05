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
    private FinReprogramacion finReprogramacion;
    private int dia;
    private ObservableList<Fila> data;
    private ArrayList<String> conjuntoEventos;
    private static Evento eventoActual;
    private int diasSimulacion;
    private double esperaMaximaPieza;
    private int filaActual;
    private int filaDesde;
    private int filaHasta;

    public Gestor(){
        this.conjuntoEventos = new ArrayList<String>();
        this.data = FXCollections.observableArrayList();
        this.TCN_1 = new TCN(1);
        this.TCN_2 = new TCN(2);
        this.llegadaPieza = new LlegadaPieza(TCN_1, TCN_2);
        this.dia = 1;
        this.esperaMaximaPieza = 0;
        this.filaActual = 1;
        this.filaDesde = 0;
        this.filaHasta = 0;
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

    public int getFilaDesde() {
        return filaDesde;
    }

    public void setFilaDesde(int filaDesde) {
        this.filaDesde = filaDesde;
    }

    public int getFilaHasta() {
        return filaHasta;
    }

    public void setFilaHasta(int filaHasta) {
        this.filaHasta = filaHasta;
    }

    public void inicio(){
        cargarFilaPrimeravez();
        setEventoActual(llegadaPieza);
        getConjuntoEventos().add(getEventoActual().getNombre());
        Reloj.getInstancia().setTiempoActual(llegadaPieza.getProxLlegadaPieza());
        esperaMaximaPieza = Reloj.getInstancia().getTiempoActual() - llegadaPieza.getNuevaPieza().getHoraLlegada();
        llegadaPieza.ejecutar();
        llegadaPieza.setRandomLlegada(Math.random());
        llegadaPieza.generarPieza(llegadaPieza.getRandomLlegada(), Reloj.getInstancia().getTiempoActual());
        llegadaPieza.calcularLlegadaPieza();
        llegadaPieza.calcularProxLlegadaPieza();
        if(filaActual >= filaDesde && filaActual <= filaHasta){
            cargarFila();
        } else if(filaDesde == 0 && filaHasta == 0){
            cargarFila();
        }
        filaActual++;
        iterar();
    }

    public void iterar(){
        int aux = 1;
        while ((Reloj.getInstancia().getTiempoActual()/3600) <= (diasSimulacion*24)){
            if(((Reloj.getInstancia().getTiempoActual()/3600)/24) >= aux) {
                dia++;
                aux++;//Para mostrar correctamente los dias
            }
            switch (proxEvento()){
                case "LlegadaPieza":
                    setEventoActual(llegadaPieza);
                    getConjuntoEventos().add(getEventoActual().getNombre());
                    Reloj.getInstancia().setTiempoActual(llegadaPieza.getProxLlegadaPieza());
                    llegadaPieza.ejecutar();
                    llegadaPieza.setRandomLlegada(Math.random());
                    llegadaPieza.generarPieza(llegadaPieza.getRandomLlegada(), Reloj.getInstancia().getTiempoActual());
                    llegadaPieza.calcularLlegadaPieza();
                    llegadaPieza.calcularProxLlegadaPieza();
                    if(filaActual >= filaDesde && filaActual <= filaHasta){
                        cargarFila();
                    } else if(filaDesde == 0 && filaHasta == 0){
                        cargarFila();
                    }
                    filaActual++;
                    break;
                case "FinAtTorno1":
                    FinAtencionTorno finAtTorno1 = new FinAtencionTorno(TCN_1);
                    setEventoActual(finAtTorno1);
                    getConjuntoEventos().add(getEventoActual().getNombre());
                    Reloj.getInstancia().setTiempoActual(getProxFinAtencionTorno(TCN_1));
                    finAtTorno1.ejecutar();
                    if(TCN_1.getEstado() == EstadoTCN.EnReprogramacion){
                        finReprogramacion = new FinReprogramacion(TCN_1);
                    } else if((Reloj.getInstancia().getTiempoActual() - TCN_1.getPiezaActual().getHoraLlegada()) > esperaMaximaPieza){
                        esperaMaximaPieza = Reloj.getInstancia().getTiempoActual() - TCN_1.getPiezaActual().getHoraLlegada();
                    }
                    if(filaActual >= filaDesde && filaActual <= filaHasta){
                        cargarFila();
                    } else if(filaDesde == 0 && filaHasta == 0){
                        cargarFila();
                    }
                    filaActual++;
                    break;
                case "FinAtTorno2":
                    FinAtencionTorno finAtTorno2 = new FinAtencionTorno(TCN_2);
                    setEventoActual(finAtTorno2);
                    getConjuntoEventos().add(getEventoActual().getNombre());
                    Reloj.getInstancia().setTiempoActual(getProxFinAtencionTorno(TCN_2));
                    finAtTorno2.ejecutar();
                    if (TCN_2.getEstado() == EstadoTCN.EnReprogramacion){
                        finReprogramacion = new FinReprogramacion(TCN_2);
                    } else if((Reloj.getInstancia().getTiempoActual() - TCN_2.getPiezaActual().getHoraLlegada()) > esperaMaximaPieza){
                        esperaMaximaPieza = Reloj.getInstancia().getTiempoActual() - TCN_2.getPiezaActual().getHoraLlegada();
                    }
                    if(filaActual >= filaDesde && filaActual <= filaHasta){
                        cargarFila();
                    } else if(filaDesde == 0 && filaHasta == 0){
                        cargarFila();
                    }
                    filaActual++;
                    break;
                case "FinReprogramacion":
                    setEventoActual(finReprogramacion);
                    getConjuntoEventos().add(getEventoActual().getNombre());
                    Reloj.getInstancia().setTiempoActual(finReprogramacion.getProxFinReprogramacion());
                    finReprogramacion.ejecutar();
                    if((Reloj.getInstancia().getTiempoActual() - finReprogramacion.getTornoFinalizado().getPiezaActual().getHoraLlegada()) > esperaMaximaPieza){
                        esperaMaximaPieza = Reloj.getInstancia().getTiempoActual() - finReprogramacion.getTornoFinalizado().getPiezaActual().getHoraLlegada();
                    }
                    finReprogramacion.setProxFinReprogramacion(0);
                    if(filaActual >= filaDesde && filaActual <= filaHasta){
                        cargarFila();
                    } else if(filaDesde == 0 && filaHasta == 0){
                        cargarFila();
                    }
                    filaActual++;
                    break;
            }
        }

    }

    public double getProxFinAtencionTorno(TCN torno){
        if(torno.getPiezaActual() != null){
            return torno.getPiezaActual().proxFinMecanizado;
        }
        else{
            return 0;
        }

    }

    public double tiempoMinimo(){
        double minTiempo = 2592000;

        if(llegadaPieza.getProxLlegadaPieza() != 0 && llegadaPieza.getProxLlegadaPieza() < minTiempo){
            minTiempo = llegadaPieza.getProxLlegadaPieza();
        }
        if(getProxFinAtencionTorno(TCN_1) != 0 && getProxFinAtencionTorno(TCN_1) < minTiempo){
            minTiempo = getProxFinAtencionTorno(TCN_1);
        }
        if(getProxFinAtencionTorno(TCN_2) != 0 && getProxFinAtencionTorno(TCN_2) < minTiempo){
            minTiempo = getProxFinAtencionTorno(TCN_2);
        }
        if(finReprogramacion != null && finReprogramacion.getProxFinReprogramacion() != 0 && finReprogramacion.getProxFinReprogramacion() < minTiempo){
            minTiempo = finReprogramacion.getProxFinReprogramacion();
        }

        return minTiempo;
    }

    public String proxEvento(){
        double tiempo = tiempoMinimo();

        if(tiempo == llegadaPieza.getProxLlegadaPieza()){
            return "LlegadaPieza";
        } else if(tiempo == getProxFinAtencionTorno(TCN_1)){
            return "FinAtTorno1";
        } else if(finReprogramacion != null && tiempo == finReprogramacion.getProxFinReprogramacion()){
            return "FinReprogramacion";
        } else {
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
            String tiempoMecanizadoTorno2Content = "00:00:00";
            String proxFinAtencionTorno2Content = "00:00:00";

            data.add(new Fila(diaContent, relojContent, eventContent, piezaContent, rnd1Content, tiempoEntreLlegadasContent, proxFinAtencionContent, colaLlegadaPiezasContent, estadoTorno1Content, alimentadorTorno1_1Content, alimentadorTorno1_2Content, alimentadorTorno1_3Content, rndTorno1Content, tiempoMecanizadoTorno1Content, proxFinAtencionTorno1Content, estadoTorno2Content, alimentadorTorno2_1Content, alimentadorTorno2_2Content, alimentadorTorno2_3Content, tiempoMecanizadoTorno2Content, proxFinAtencionTorno2Content));
    }

    public void cargarFila(){
        String diaContent = String.valueOf(getDia());
        String relojContent = Reloj.tiempoString();
        String eventContent = eventoActual.getNombre();
        String piezaContent = (llegadaPieza.getNuevaPieza() != null) ? String.valueOf(llegadaPieza.getNuevaPieza().getNumeroPieza()) : "-";
        String rnd1Content = String.valueOf(llegadaPieza.getRandomLlegada());
        String tiempoEntreLlegadasContent = Reloj.tiempoString(llegadaPieza.getTiempoLlegada());
        String proxFinAtencionContent = Reloj.tiempoString(llegadaPieza.getProxLlegadaPieza());
        String colaLlegadaPiezasContent = String.valueOf(ColaLlegadaPieza.getInstancia().getCola().size());
        String estadoTorno1Content = TCN_1.getEstado().getName();
        String alimentadorTorno1_1Content = (TCN_1.getAlimentador().size() > 0) ? String.valueOf(TCN_1.getAlimentador().get(0).getNumeroPieza()) : "-";
        String alimentadorTorno1_2Content = (TCN_1.getAlimentador().size() > 1) ? String.valueOf(TCN_1.getAlimentador().get(1).getNumeroPieza()) : "-";
        String alimentadorTorno1_3Content = (TCN_1.getAlimentador().size() > 2) ? String.valueOf(TCN_1.getAlimentador().get(2).getNumeroPieza()) : "-";
        String rndTorno1Content = "-";
        String tiempoMecanizadoTorno1Content = (TCN_1.getPiezaActual() != null) ? Reloj.tiempoString(TCN_1.getPiezaActual().tiempoMecanizado) : "-";
        String proxFinAtencionTorno1Content = (TCN_1.getPiezaActual() != null) ? Reloj.tiempoString(getProxFinAtencionTorno(TCN_1)) : "-";
        String estadoTorno2Content = TCN_2.getEstado().getName();
        String alimentadorTorno2_1Content = (TCN_2.getAlimentador().size() > 0) ? String.valueOf(TCN_2.getAlimentador().get(0).getNumeroPieza()) : "-";
        String alimentadorTorno2_2Content = (TCN_2.getAlimentador().size() > 1) ? String.valueOf(TCN_2.getAlimentador().get(1).getNumeroPieza()) : "-";
        String alimentadorTorno2_3Content = (TCN_2.getAlimentador().size() > 2) ? String.valueOf(TCN_2.getAlimentador().get(2).getNumeroPieza()) : "-";
        String tiempoMecanizadoTorno2Content = (TCN_2.getPiezaActual() != null) ? Reloj.tiempoString(TCN_2.getPiezaActual().tiempoMecanizado) : "-";
        String proxFinAtencionTorno2Content = (TCN_2.getPiezaActual() != null) ? Reloj.tiempoString(getProxFinAtencionTorno(TCN_2)) : "-";

        data.add(new Fila(diaContent, relojContent, eventContent, piezaContent, rnd1Content, tiempoEntreLlegadasContent, proxFinAtencionContent, colaLlegadaPiezasContent, estadoTorno1Content, alimentadorTorno1_1Content, alimentadorTorno1_2Content, alimentadorTorno1_3Content, rndTorno1Content, tiempoMecanizadoTorno1Content, proxFinAtencionTorno1Content, estadoTorno2Content, alimentadorTorno2_1Content, alimentadorTorno2_2Content, alimentadorTorno2_3Content, tiempoMecanizadoTorno2Content, proxFinAtencionTorno2Content));
    }

    public String setTiempoOcioso1() {return String.valueOf(""); }
    public String setTiempoOcioso2() {return String.valueOf(""); }
    public String setEsperaMaxima() {return Reloj.tiempoString(esperaMaximaPieza); }
}
