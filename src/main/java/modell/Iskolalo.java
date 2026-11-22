package modell;

public class Iskolalo extends Lo {

    private int napiOraLimit;

    public Iskolalo(int azonosito, String nev, int eletkor,
                    String fajta, double marmagassag, int napiOraLimit) {

        super(azonosito, nev, eletkor, fajta, marmagassag);

        if (napiOraLimit <= 0) {
            throw new IllegalArgumentException(
                    "A napi órák számának pozitívnak kell lennie!");
        }

        this.napiOraLimit = napiOraLimit;
    }

    public int getNapiOraLimit() {
        return napiOraLimit;
    }

    public void setNapiOraLimit(int napiOraLimit) {
        if (napiOraLimit <= 0) {
            throw new IllegalArgumentException(
                    "A napi órák számának pozitívnak kell lennie!");
        }

        this.napiOraLimit = napiOraLimit;
    }

    @Override
    public String toString() {
        return "Iskolaló: " + getNev()
                + ", azonosító: " + getAzonosito()
                + ", életkor: " + getEletkor()
                + ", fajta: " + getFajta()
                + ", marmagasság: " + getMarmagassag()
                + " cm, napi órák maximális száma: " + napiOraLimit;
    }
}