
package tarolas;

import kivetel.MarLetezoLoKivetel;
import modell.Iskolalo;
import modell.Lo;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class LoTaroloTeszt {

    private Iskolalo ujLo(int azonosito, String nev, int eletkor) {
        return new Iskolalo(
                azonosito,
                nev,
                eletkor,
                "Arab telivér",
                160,
                3
        );
    }

    @Test
    void loHozzaadasaSikeres() throws MarLetezoLoKivetel {
        LoTarolo tarolo = new LoTarolo();
        Iskolalo lo = ujLo(1, "Szellő", 6);

        tarolo.hozzaad(lo);

        assertEquals(1, tarolo.getLovakSzama());
        assertEquals(lo, tarolo.keres(1));
    }

    @Test
    void azonositoAlapjanKeresesMukodik() throws MarLetezoLoKivetel {
        LoTarolo tarolo = new LoTarolo();
        Iskolalo lo = ujLo(1, "Szellő", 6);

        tarolo.hozzaad(lo);

        assertEquals("Szellő", tarolo.keres(1).getNev());
    }

    @Test
    void nemLetezoAzonositoEsetenNullErteketAd() {
        LoTarolo tarolo = new LoTarolo();

        assertNull(tarolo.keres(99));
    }

    @Test
    void nevAlapjanKeresesMukodik() throws MarLetezoLoKivetel {
        LoTarolo tarolo = new LoTarolo();
        tarolo.hozzaad(ujLo(1, "Szellő", 6));
        tarolo.hozzaad(ujLo(2, "Csillag", 10));

        List<Lo> talalatok = tarolo.keresNevAlapjan("Szellő");

        assertEquals(1, talalatok.size());
        assertEquals("Szellő", talalatok.get(0).getNev());
    }

    @Test
    void torlesMukodik() throws MarLetezoLoKivetel {
        LoTarolo tarolo = new LoTarolo();
        tarolo.hozzaad(ujLo(1, "Szellő", 6));

        boolean sikeres = tarolo.torol(1);

        assertTrue(sikeres);
        assertEquals(0, tarolo.getLovakSzama());
    }

    @Test
    void nemLetezoLoTorleseSikertelen() {
        LoTarolo tarolo = new LoTarolo();

        assertFalse(tarolo.torol(99));
    }

    @Test
    void lovakRendezeseEletkorSzerint() throws MarLetezoLoKivetel {
        LoTarolo tarolo = new LoTarolo();
        tarolo.hozzaad(ujLo(1, "Szellő", 6));
        tarolo.hozzaad(ujLo(2, "Csillag", 10));
        tarolo.hozzaad(ujLo(3, "Villám", 4));

        tarolo.rendezEletkorSzerint();

        List<Lo> lovak = tarolo.getLovak();

        assertEquals("Villám", lovak.get(0).getNev());
        assertEquals("Szellő", lovak.get(1).getNev());
        assertEquals("Csillag", lovak.get(2).getNev());
    }

    @Test
    void lovakRendezeseNevSzerint() throws MarLetezoLoKivetel {
        LoTarolo tarolo = new LoTarolo();
        tarolo.hozzaad(ujLo(1, "Szellő", 6));
        tarolo.hozzaad(ujLo(2, "Csillag", 10));
        tarolo.hozzaad(ujLo(3, "Villám", 4));

        tarolo.rendezNevSzerint();

        List<Lo> lovak = tarolo.getLovak();

        assertEquals("Csillag", lovak.get(0).getNev());
        assertEquals("Szellő", lovak.get(1).getNev());
        assertEquals("Villám", lovak.get(2).getNev());
    }

    @Test
    void duplikaltAzonositoNemEngedelyezett() throws MarLetezoLoKivetel {
        LoTarolo tarolo = new LoTarolo();
        tarolo.hozzaad(ujLo(1, "Szellő", 6));

        assertThrows(
                MarLetezoLoKivetel.class,
                () -> tarolo.hozzaad(ujLo(1, "Csillag", 10))
        );
    }

    @Test
    void nullLoHozzaadasaNemEngedelyezett() {
        LoTarolo tarolo = new LoTarolo();

        assertThrows(
                IllegalArgumentException.class,
                () -> tarolo.hozzaad(null)
        );
    }
}
