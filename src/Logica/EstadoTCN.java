package Logica;

public enum EstadoTCN {

    Libre("Libre"),
    EnReprogramacion("En Reprogramacion"),
    Ocupado("Ocupado");

    private final String name;

    private EstadoTCN(String name) {this.name = name;}

    public String getName() {return name;}
}
