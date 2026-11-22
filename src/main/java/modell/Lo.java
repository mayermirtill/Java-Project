
package modell;

import java.io.Serializable;

public abstract class Lo implements Serializable {

    private static final long serialVersionUID = 1L;

    private int azonosito;
    private String nev;
    private int eletkor;
    private String fajta;
    private double marmagassag;
    private LoAllapot allapot;

    public Lo(int azonosito, String nev, int eletkor,
              String fajta, double marmagassag) {

        if (azonosito <= 0) {
            throw new IllegalArgumentException("Az azonosito csak pozitiv szam lehet!");
        }

        if (nev == null || nev.isBlank()) {
            throw new IllegalArgumentException("A lo neve nem lehet ures!");
        }

        if (eletkor < 0) {
            throw new IllegalArgumentException("Az eletkor nem lehet negativ!");
        }

        if (fajta == null || fajta.isBlank()) {
            throw new IllegalArgumentException("A fajta nem lehet ures!");
        }

        if (marmagassag <= 0) {
            throw new IllegalArgumentException("A marmagassagnak pozitivnak kell lennie!");
        }

        this.azonosito = azonosito;
        this.nev = nev;
        this.eletkor = eletkor;
        this.fajta = fajta;
        this.marmagassag = marmagassag;
        this.allapot = LoAllapot.AKTIV;
    }

    public int getAzonosito() {
        return azonosito;
    }

    public String getNev() {
        return nev;
    }

    public void setNev(String nev) {
        if (nev == null || nev.isBlank()) {
            throw new IllegalArgumentException("A nev nem lehet ures!");
        }
        this.nev = nev;
    }

    public int getEletkor() {
        return eletkor;
    }

    public void setEletkor(int eletkor) {
        if (eletkor < 0) {
            throw new IllegalArgumentException("Az eletkor nem lehet negativ!");
        }
        this.eletkor = eletkor;
    }

    public String getFajta() {
        return fajta;
    }

    public void setFajta(String fajta) {
        if (fajta == null || fajta.isBlank()) {
            throw new IllegalArgumentException("A fajta nem lehet ures!");
        }
        this.fajta = fajta;
    }

    public double getMarmagassag() {
        return marmagassag;
    }

    public void setMarmagassag(double marmagassag) {
        if (marmagassag <= 0) {
            throw new IllegalArgumentException("A marmagassagnak pozitivnak kell lennie!");
        }
        this.marmagassag = marmagassag;
    }

    public LoAllapot getAllapot() {
        return allapot;
    }

    public void setAllapot(LoAllapot allapot) {
        if (allapot == null) {
            throw new IllegalArgumentException("Az allapot nem lehet ures!");
        }
        this.allapot = allapot;
    }
}
