
package megjelenites;

import kivetel.MarLetezoLoKivetel;
import modell.Berlo;
import modell.Iskolalo;
import modell.Lo;
import modell.LoAllapot;
import tarolas.AdatKezelo;
import tarolas.LoTarolo;

import java.io.IOException;
import java.util.List;
import java.util.Scanner;

public class KonzolMenu {

    private final Scanner scanner;
    private LoTarolo tarolo;
    private final AdatKezelo adatKezelo;

    public KonzolMenu() {
        scanner = new Scanner(System.in);
        tarolo = new LoTarolo();
        adatKezelo = new AdatKezelo();

        betoltes();
    }

    public void indit() {
        int valasztas;

        do {
            System.out.println("\n========== LOVARDA NYILVÁNTARTÓ RENDSZER ==========");
            System.out.println("1. Új ló felvétele");
            System.out.println("2. Lovak listázása");
            System.out.println("3. Ló keresése azonosító alapján");
            System.out.println("4. Ló keresése név alapján");
            System.out.println("5. Ló adatainak módosítása");
            System.out.println("6. Ló törlése");
            System.out.println("7. Lovak rendezése név szerint");
            System.out.println("8. Lovak rendezése életkor szerint");
            System.out.println("9. Ló állapotának módosítása");
            System.out.println("10. Statisztikák");
            System.out.println("0. Kilépés");
            System.out.println("====================================================");

            valasztas = bekerSzam("Választás: ");

            switch (valasztas) {
                case 1 -> ujLoFelvetele();
                case 2 -> lovakListazasa();
                case 3 -> loKereseseAzonositoAlapjan();
                case 4 -> loKereseseNevAlapjan();
                case 5 -> loModositasa();
                case 6 -> loTorlese();
                case 7 -> nevSzerintiRendezes();
                case 8 -> eletkorSzerintiRendezes();
                case 9 -> allapotModositasa();
                case 10 -> statisztikak();
                case 0 -> kilepes();
                default -> System.out.println("Érvénytelen menüpont!");
            }

        } while (valasztas != 0);
    }

    private void ujLoFelvetele() {
        System.out.println("\n--- Új ló felvétele ---");

        int azonosito = bekerSzam("Azonosító: ");
        String nev = bekerSzoveg("Név: ");
        int eletkor = bekerSzam("Életkor: ");
        String fajta = bekerSzoveg("Fajta: ");
        double marmagassag = bekerTizedes("Marmagasság (cm): ");

        System.out.println("Ló típusa:");
        System.out.println("1. Iskolaló");
        System.out.println("2. Bérlő ló");

        int tipus = bekerSzam("Választás: ");

        try {
            Lo lo;

            if (tipus == 1) {
                int napiOraLimit = bekerSzam("Napi óraszámkorlát: ");

                lo = new Iskolalo(
                        azonosito, nev, eletkor,
                        fajta, marmagassag, napiOraLimit
                );

            } else if (tipus == 2) {
                int oradij = bekerSzam("Óradíj: ");

                lo = new Berlo(
                        azonosito, nev, eletkor,
                        fajta, marmagassag, oradij
                );

            } else {
                System.out.println("Érvénytelen típus!");
                return;
            }

            tarolo.hozzaad(lo);
            System.out.println("A ló sikeresen felvéve!");

        } catch (MarLetezoLoKivetel | IllegalArgumentException e) {
            System.out.println("Hiba: " + e.getMessage());
        }
    }

    private void lovakListazasa() {
        System.out.println("\n--- Nyilvántartott lovak ---");

        List<Lo> lovak = tarolo.getLovak();

        if (lovak.isEmpty()) {
            System.out.println("Nincs nyilvántartott ló.");
            return;
        }

        for (Lo lo : lovak) {
            System.out.println(lo);
        }
    }

    private void loKereseseAzonositoAlapjan() {
        int azonosito = bekerSzam("Keresett azonosító: ");

        Lo lo = tarolo.keres(azonosito);

        if (lo == null) {
            System.out.println("Nem található ilyen ló.");
        } else {
            System.out.println(lo);
        }
    }

    private void loKereseseNevAlapjan() {
        String nev = bekerSzoveg("Keresett név: ");

        List<Lo> talalatok = tarolo.keresNevAlapjan(nev);

        if (talalatok.isEmpty()) {
            System.out.println("Nem található ilyen ló.");
            return;
        }

        for (Lo lo : talalatok) {
            System.out.println(lo);
        }
    }

    private void loModositasa() {
        int azonosito = bekerSzam("A módosítandó ló azonosítója: ");

        Lo lo = tarolo.keres(azonosito);

        if (lo == null) {
            System.out.println("Nem található ilyen ló.");
            return;
        }

        System.out.println("Jelenlegi adatok:");
        System.out.println(lo);

        System.out.println("Új adatok megadása:");

        try {
            lo.setNev(bekerSzoveg("Új név: "));
            lo.setEletkor(bekerSzam("Új életkor: "));
            lo.setFajta(bekerSzoveg("Új fajta: "));
            lo.setMarmagassag(bekerTizedes("Új marmagasság (cm): "));

            System.out.println("A ló adatai sikeresen módosultak!");

        } catch (IllegalArgumentException e) {
            System.out.println("Hiba: " + e.getMessage());
        }
    }

    private void loTorlese() {
        int azonosito = bekerSzam("A törlendő ló azonosítója: ");

        if (tarolo.torol(azonosito)) {
            System.out.println("A ló sikeresen törölve.");
        } else {
            System.out.println("Nem található ilyen ló.");
        }
    }

    private void nevSzerintiRendezes() {
        tarolo.rendezNevSzerint();
        System.out.println("A lovak név szerint rendezve:");
        lovakListazasa();
    }

    private void eletkorSzerintiRendezes() {
        tarolo.rendezEletkorSzerint();
        System.out.println("A lovak életkor szerint rendezve:");
        lovakListazasa();
    }

    private void allapotModositasa() {
        int azonosito = bekerSzam("A ló azonosítója: ");

        Lo lo = tarolo.keres(azonosito);

        if (lo == null) {
            System.out.println("Nem található ilyen ló.");
            return;
        }

        System.out.println("Lehetséges állapotok:");
        System.out.println("1. AKTIV");
        System.out.println("2. PIHENO");
        System.out.println("3. BETEG");

        int valasztas = bekerSzam("Új állapot: ");

        try {
            switch (valasztas) {
                case 1 -> lo.setAllapot(LoAllapot.AKTIV);
                case 2 -> lo.setAllapot(LoAllapot.PIHENO);
                case 3 -> lo.setAllapot(LoAllapot.BETEG);
                default -> {
                    System.out.println("Érvénytelen választás!");
                    return;
                }
            }

            System.out.println("A ló állapota módosult!");

        } catch (IllegalArgumentException e) {
            System.out.println("Hiba: " + e.getMessage());
        }
    }

    private void statisztikak() {
        List<Lo> lovak = tarolo.getLovak();

        int iskolalovak = 0;
        int berlolovak = 0;
        int aktiv = 0;
        int piheno = 0;
        int beteg = 0;

        for (Lo lo : lovak) {
            if (lo instanceof Iskolalo) {
                iskolalovak++;
            } else if (lo instanceof Berlo) {
                berlolovak++;
            }

            switch (lo.getAllapot()) {
                case AKTIV -> aktiv++;
                case PIHENO -> piheno++;
                case BETEG -> beteg++;
            }
        }

        System.out.println("\n--- Statisztikák ---");
        System.out.println("Összes ló: " + tarolo.getLovakSzama());
        System.out.println("Iskolalovak: " + iskolalovak);
        System.out.println("Bérlő lovak: " + berlolovak);
        System.out.println("Aktív lovak: " + aktiv);
        System.out.println("Pihenő lovak: " + piheno);
        System.out.println("Beteg lovak: " + beteg);
    }

    private void betoltes() {
        try {
            List<Lo> betoltottLovak = adatKezelo.betolt();

            for (Lo lo : betoltottLovak) {
                tarolo.hozzaad(lo);
            }

            System.out.println("Az adatok betöltése sikeres.");

        } catch (IOException | ClassNotFoundException | MarLetezoLoKivetel e) {
            System.out.println("Az adatok betöltése nem sikerült: " + e.getMessage());
        }
    }

    private void mentes() {
        try {
            adatKezelo.ment(tarolo.getLovak());
            System.out.println("Az adatok mentése sikeres.");

        } catch (IOException e) {
            System.out.println("Mentési hiba: " + e.getMessage());
        }
    }

    private void kilepes() {
        mentes();
        System.out.println("A program bezárult.");
        scanner.close();
    }

    private int bekerSzam(String uzenet) {
        while (true) {
            System.out.print(uzenet);

            try {
                return Integer.parseInt(scanner.nextLine().trim());
            } catch (NumberFormatException e) {
                System.out.println("Kérlek, egész számot adj meg!");
            }
        }
    }

    private double bekerTizedes(String uzenet) {
        while (true) {
            System.out.print(uzenet);

            try {
                return Double.parseDouble(
                        scanner.nextLine().trim().replace(',', '.')
                );
            } catch (NumberFormatException e) {
                System.out.println("Kérlek, érvényes számot adj meg!");
            }
        }
    }

    private String bekerSzoveg(String uzenet) {
        while (true) {
            System.out.print(uzenet);

            String szoveg = scanner.nextLine().trim();

            if (!szoveg.isEmpty()) {
                return szoveg;
            }

            System.out.println("A mező nem lehet üres!");
        }
    }
}
