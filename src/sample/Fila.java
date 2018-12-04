package sample;

import javafx.beans.property.SimpleStringProperty;

public class Fila {
    private final SimpleStringProperty dia;
    private final SimpleStringProperty reloj;
    private final SimpleStringProperty event;
    private final SimpleStringProperty pieza;
    private final SimpleStringProperty rnd1;
    private final SimpleStringProperty tiempoEntreLlegadas;
    private final SimpleStringProperty proxFinAtencion;
    private final SimpleStringProperty colaLlegadaPiezas;
    private final SimpleStringProperty estadoTorno1;
    private final SimpleStringProperty alimentadorTorno1_1;
    private final SimpleStringProperty alimentadorTorno1_2;
    private final SimpleStringProperty alimentadorTorno1_3;
    private final SimpleStringProperty rndTorno1;
    private final SimpleStringProperty tiempoMecanizadoTorno1;
    private final SimpleStringProperty proxFinAtencionTorno1;
    private final SimpleStringProperty estadoTorno2;
    private final SimpleStringProperty alimentadorTorno2_1;
    private final SimpleStringProperty alimentadorTorno2_2;
    private final SimpleStringProperty alimentadorTorno2_3;
    private final SimpleStringProperty tiempoMecanizadoTorno2;
    private final SimpleStringProperty proxFinAtencionTorno2;

    public Fila(String dia, String reloj, String event, String pieza, String rnd1, String tiempoEntreLlegadas, String proxFinAtencion, String colaLlegadaPiezas, String estadoTorno1, String alimentadorTorno1_1, String alimentadorTorno1_2, String alimentadorTorno1_3, String rndTorno1, String tiempoMecanizadoTorno1, String proxFinAtencionTorno1, String estadoTorno2, String alimentadorTorno2_1, String alimentadorTorno2_2, String alimentadorTorno2_3, String tiempoMecanizadoTorno2, String proxFinAtencionTorno2) {
        this.dia = new SimpleStringProperty(dia);
        this.reloj = new SimpleStringProperty(reloj);
        this.event = new SimpleStringProperty(event);
        this.pieza = new SimpleStringProperty(pieza);
        this.rnd1 = new SimpleStringProperty(rnd1);
        this.tiempoEntreLlegadas = new SimpleStringProperty(tiempoEntreLlegadas);
        this.proxFinAtencion = new SimpleStringProperty(proxFinAtencion);
        this.colaLlegadaPiezas = new SimpleStringProperty(colaLlegadaPiezas);
        this.estadoTorno1 = new SimpleStringProperty(estadoTorno1);
        this.alimentadorTorno1_1 = new SimpleStringProperty(alimentadorTorno1_1);
        this.alimentadorTorno1_2 = new SimpleStringProperty(alimentadorTorno1_2);
        this.alimentadorTorno1_3 = new SimpleStringProperty(alimentadorTorno1_3);
        this.rndTorno1 = new SimpleStringProperty(rndTorno1);
        this.tiempoMecanizadoTorno1 = new SimpleStringProperty(tiempoMecanizadoTorno1);
        this.proxFinAtencionTorno1 = new SimpleStringProperty(proxFinAtencionTorno1);
        this.estadoTorno2 = new SimpleStringProperty(estadoTorno2);
        this.alimentadorTorno2_1 = new SimpleStringProperty(alimentadorTorno2_1);
        this.alimentadorTorno2_2 = new SimpleStringProperty(alimentadorTorno2_2);
        this.alimentadorTorno2_3 = new SimpleStringProperty(alimentadorTorno2_3);
        this.tiempoMecanizadoTorno2 = new SimpleStringProperty(tiempoMecanizadoTorno2);
        this.proxFinAtencionTorno2 = new SimpleStringProperty(proxFinAtencionTorno2);
    }

    public String getDia() {
        return dia.get();
    }

    public SimpleStringProperty diaProperty() {
        return dia;
    }

    public void setDia(String dia) {
        this.dia.set(dia);
    }

    public String getReloj() {
        return reloj.get();
    }

    public SimpleStringProperty relojProperty() {
        return reloj;
    }

    public void setReloj(String reloj) {
        this.reloj.set(reloj);
    }

    public String getEvent() {
        return event.get();
    }

    public SimpleStringProperty eventProperty() {
        return event;
    }

    public void setEvent(String event) {
        this.event.set(event);
    }

    public String getPieza() {
        return pieza.get();
    }

    public SimpleStringProperty piezaProperty() {
        return pieza;
    }

    public void setPieza(String pieza) {
        this.pieza.set(pieza);
    }

    public String getRnd1() {
        return rnd1.get();
    }

    public SimpleStringProperty rnd1Property() {
        return rnd1;
    }

    public void setRnd1(String rnd1) {
        this.rnd1.set(rnd1);
    }

    public String getTiempoEntreLlegadas() {
        return tiempoEntreLlegadas.get();
    }

    public SimpleStringProperty tiempoEntreLlegadasProperty() {
        return tiempoEntreLlegadas;
    }

    public void setTiempoEntreLlegadas(String tiempoEntreLlegadas) {
        this.tiempoEntreLlegadas.set(tiempoEntreLlegadas);
    }

    public String getProxFinAtencion() {
        return proxFinAtencion.get();
    }

    public SimpleStringProperty proxFinAtencionProperty() {
        return proxFinAtencion;
    }

    public void setProxFinAtencion(String proxFinAtencion) {
        this.proxFinAtencion.set(proxFinAtencion);
    }

    public String getColaLlegadaPiezas() {
        return colaLlegadaPiezas.get();
    }

    public SimpleStringProperty colaLlegadaPiezasProperty() {
        return colaLlegadaPiezas;
    }

    public void setColaLlegadaPiezas(String colaLlegadaPiezas) {
        this.colaLlegadaPiezas.set(colaLlegadaPiezas);
    }

    public String getEstadoTorno1() {
        return estadoTorno1.get();
    }

    public SimpleStringProperty estadoTorno1Property() {
        return estadoTorno1;
    }

    public void setEstadoTorno1(String estadoTorno1) {
        this.estadoTorno1.set(estadoTorno1);
    }

    public String getAlimentadorTorno1_1() {
        return alimentadorTorno1_1.get();
    }

    public SimpleStringProperty alimentadorTorno1_1Property() {
        return alimentadorTorno1_1;
    }

    public void setAlimentadorTorno1_1(String alimentadorTorno1_1) {
        this.alimentadorTorno1_1.set(alimentadorTorno1_1);
    }

    public String getAlimentadorTorno1_2() {
        return alimentadorTorno1_2.get();
    }

    public SimpleStringProperty alimentadorTorno1_2Property() {
        return alimentadorTorno1_2;
    }

    public void setAlimentadorTorno1_2(String alimentadorTorno1_2) {
        this.alimentadorTorno1_2.set(alimentadorTorno1_2);
    }

    public String getAlimentadorTorno1_3() {
        return alimentadorTorno1_3.get();
    }

    public SimpleStringProperty alimentadorTorno1_3Property() {
        return alimentadorTorno1_3;
    }

    public void setAlimentadorTorno1_3(String alimentadorTorno1_3) {
        this.alimentadorTorno1_3.set(alimentadorTorno1_3);
    }

    public String getRndTorno1() {
        return rndTorno1.get();
    }

    public SimpleStringProperty rndTorno1Property() {
        return rndTorno1;
    }

    public void setRndTorno1(String rndTorno1) {
        this.rndTorno1.set(rndTorno1);
    }

    public String getTiempoMecanizadoTorno1() {
        return tiempoMecanizadoTorno1.get();
    }

    public SimpleStringProperty tiempoMecanizadoTorno1Property() {
        return tiempoMecanizadoTorno1;
    }

    public void setTiempoMecanizadoTorno1(String tiempoMecanizadoTorno1) {
        this.tiempoMecanizadoTorno1.set(tiempoMecanizadoTorno1);
    }

    public String getProxFinAtencionTorno1() {
        return proxFinAtencionTorno1.get();
    }

    public SimpleStringProperty proxFinAtencionTorno1Property() {
        return proxFinAtencionTorno1;
    }

    public void setProxFinAtencionTorno1(String proxFinAtencionTorno1) {
        this.proxFinAtencionTorno1.set(proxFinAtencionTorno1);
    }

    public String getEstadoTorno2() {
        return estadoTorno2.get();
    }

    public SimpleStringProperty estadoTorno2Property() {
        return estadoTorno2;
    }

    public void setEstadoTorno2(String estadoTorno2) {
        this.estadoTorno2.set(estadoTorno2);
    }

    public String getAlimentadorTorno2_1() {
        return alimentadorTorno2_1.get();
    }

    public SimpleStringProperty alimentadorTorno2_1Property() {
        return alimentadorTorno2_1;
    }

    public void setAlimentadorTorno2_1(String alimentadorTorno2_1) {
        this.alimentadorTorno2_1.set(alimentadorTorno2_1);
    }

    public String getAlimentadorTorno2_2() {
        return alimentadorTorno2_2.get();
    }

    public SimpleStringProperty alimentadorTorno2_2Property() {
        return alimentadorTorno2_2;
    }

    public void setAlimentadorTorno2_2(String alimentadorTorno2_2) {
        this.alimentadorTorno2_2.set(alimentadorTorno2_2);
    }

    public String getAlimentadorTorno2_3() {
        return alimentadorTorno2_3.get();
    }

    public SimpleStringProperty alimentadorTorno2_3Property() {
        return alimentadorTorno2_3;
    }

    public void setAlimentadorTorno2_3(String alimentadorTorno2_3) {
        this.alimentadorTorno2_3.set(alimentadorTorno2_3);
    }

    public String getTiempoMecanizadoTorno2() {
        return tiempoMecanizadoTorno2.get();
    }

    public SimpleStringProperty tiempoMecanizadoTorno2Property() {
        return tiempoMecanizadoTorno2;
    }

    public void setTiempoMecanizadoTorno2(String tiempoMecanizadoTorno2) {
        this.tiempoMecanizadoTorno2.set(tiempoMecanizadoTorno2);
    }

    public String getProxFinAtencionTorno2() {
        return proxFinAtencionTorno2.get();
    }

    public SimpleStringProperty proxFinAtencionTorno2Property() {
        return proxFinAtencionTorno2;
    }

    public void setProxFinAtencionTorno2(String proxFinAtencionTorno2) {
        this.proxFinAtencionTorno2.set(proxFinAtencionTorno2);
    }
}
