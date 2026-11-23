
package tarolas;

import kivetel.MarLetezoLoKivetel;
import modell.Lo;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class LoTarolo {

    private final List<Lo> lovak;

    public LoTarolo() {
        lovak = new ArrayList<>();
    }

    // Új ló hozzáadása
    public void hozzaad(Lo lo) throws MarLetezoLoKivetel {
        if (lo == null) {
            throw new IllegalArgumentException("A ló nem lehet null!");
        }

        if (keres(lo.getAzonosito()) != null) {
            throw new MarLetezoLoKivetel(
                    "Már létezik ló ezzel az azonosítóval!");
        }

        lovak.add(lo);
    }

    // Ló keresése azonosító alapján
    public Lo keres(int azonosito) {
        for (Lo lo : lovak) {
            if (lo.getAzonosito() == azonosito) {
                return lo;
            }
        }

        return null;
    }

    // Ló keresése név alapján
    public List<Lo> keresNevAlapjan(String nev) {
        List<Lo> talalatok = new ArrayList<>();

        if (nev == null || nev.isBlank()) {
            return talalatok;
        }

        for (Lo lo : lovak) {
            if (lo.getNev().equalsIgnoreCase(nev.trim())) {
                talalatok.add(lo);
            }
        }

        return talalatok;
    }

    // Ló adatainak módosítása
    public boolean modosit(Lo modositottLo) {
        if (modositottLo == null) {
            throw new IllegalArgumentException("A ló nem lehet null!");
        }

        for (int i = 0; i < lovak.size(); i++) {
            Lo regiLo = lovak.get(i);

            if (regiLo.getAzonosito() == modositottLo.getAzonosito()) {
                lovak.set(i, modositottLo);
                return true;
            }
        }

        return false;
    }

    // Ló törlése azonosító alapján
    public boolean torol(int azonosito) {
        Lo lo = keres(azonosito);

        if (lo == null) {
            return false;
        }

        lovak.remove(lo);
        return true;
    }

    // Az összes ló lekérdezése
    public List<Lo> getLovak() {
        return new ArrayList<>(lovak);
    }

    // Lovak rendezése név szerint
    public void rendezNevSzerint() {
        lovak.sort(Comparator.comparing(
                Lo::getNev,
                String.CASE_INSENSITIVE_ORDER
        ));
    }

    // Lovak rendezése életkor szerint
    public void rendezEletkorSzerint() {
        lovak.sort(Comparator.comparingInt(Lo::getEletkor));
    }

    // Nyilvántartott lovak száma
    public int getLovakSzama() {
        return lovak.size();
    }
}