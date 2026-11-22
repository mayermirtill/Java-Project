
package modell;

public class Berlo extends Lo {

    private double oradij;

    public Berlo(int azonosito, String nev, int eletkor,
                 String fajta, double marmagassag, double oradij) {

        super(azonosito, nev, eletkor, fajta, marmagassag);

        if (oradij <= 0) {
            throw new IllegalArgumentException(
                    "Az óradíjnak pozitívnak kell lennie!");
        }

        this.oradij = oradij;
    }

    public double getOradij() {
        return oradij;
    }

    public void setOradij(double oradij) {
        if (oradij <= 0) {
            throw new IllegalArgumentException(
                    "Az óradíjnak pozitívnak kell lennie!");
        }

        this.oradij = oradij;
    }

    @Override
    public String toString() {
        return "Bérlőló: " + getNev()
                + ", azonosító: " + getAzonosito()
                + ", életkor: " + getEletkor()
                + ", fajta: " + getFajta()
                + ", marmagasság: " + getMarmagassag()
                + " cm, óradíj: " + oradij + " Ft";
    }
}
