package Logica;

public class Reloj {
    private static Reloj instancia;
    private static double tiempoActual;

    public static Reloj getInstancia(){
        if(instancia == null){
            instancia = new Reloj();
        }
        return instancia;
    }

    public Reloj(){
        setTiempoActual(0);
    }

    public double getTiempoActual() {
        return tiempoActual;
    }

    public void setTiempoActual(double tiempoActual) {
        this.tiempoActual = tiempoActual;
    }

    public static String tiempoString(){

        tiempoActual=(long)tiempoActual;
        long horas = (long)tiempoActual/3600 ;
        long minutos = (long)(tiempoActual - horas*3600) / 60;
        long segundos = (long) (tiempoActual - (horas*3600 + minutos*60));
        String ceroH = "", ceroM = "", ceroS = "";
        if( horas < 10 ) ceroH = "0";
        if( minutos < 10 ) ceroM = "0";
        if( segundos < 10 ) ceroS = "0";
        horas = horas % 24;

        return ceroH + horas + ":"  + ceroM + minutos + ":" + ceroS + segundos;
    }

    public static String tiempoString(double tiempo) {

        tiempo = (long) tiempo;
        long horas = (long) tiempo / 3600;
        long minutos = (long) (tiempo - horas * 3600) / 60;
        long segundos = (long) (tiempo - (horas * 3600 + minutos * 60));
        String ceroH = "", ceroM = "", ceroS = "";
        if (horas < 10) ceroH = "0";
        if (minutos < 10) ceroM = "0";
        if (segundos < 10) ceroS = "0";
        horas = horas % 24;

        return ceroH + String.valueOf(horas) + ":" + ceroM + String.valueOf(minutos) + ":" + ceroS + String.valueOf(segundos);
    }

    public static void resetearReloj()
    {
        instancia = null;
    }
}
