package Logica;

import java.util.ArrayList;

public class ColaLlegadaPieza{
    private static ColaLlegadaPieza instancia;
    private static ArrayList<Pieza> cola;

    public static ColaLlegadaPieza getInstancia(){
        if(instancia == null){
            instancia = new ColaLlegadaPieza();
        }
        return instancia;
    }

    public ArrayList<Pieza> getCola() {
        return cola;
    }

    public void setCola(ArrayList<Pieza> cola) {
        ColaLlegadaPieza.cola = cola;
    }
}
