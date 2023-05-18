package models;

import java.util.ArrayList;

public class reserva {

    private int cod_reserva;
    private ArrayList<String> juegos = new ArrayList<>();


    public reserva()
    {
        cod_reserva = 1;
        juegos.add("Red Dead Redemption 2");
        juegos.add("Elden Ring");
        juegos.add("Call of Duty Modern Warfare 2");
    }

    public reserva(int cod_reserva, ArrayList<String> juegos) {
        this.cod_reserva = cod_reserva;
        this.juegos = juegos;
    }

    public int getCod_reserva() {
        return cod_reserva;
    }

    public void setCod_reserva(int cod_reserva) {
        this.cod_reserva = cod_reserva;
    }

    public ArrayList<String> getJuegos() {
        return juegos;
    }

    public void setJuegos(ArrayList<String> juegos) {
        this.juegos = juegos;
    }
}