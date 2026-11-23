
package letrehozo;

import modell.Berlo;
import modell.Iskolalo;
import modell.Lo;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LoLetrehozoTeszt {

    @Test
    void iskolaloLetrehozasaSikeres() {
        IskolaloLetrehozo letrehozo = new IskolaloLetrehozo();

        Lo lo = letrehozo.letrehoz(
                1, "Szellő", 6, "Arab telivér", 160, 3
        );

        assertInstanceOf(Iskolalo.class, lo);

        Iskolalo iskolalo = (Iskolalo) lo;

        assertEquals(1, iskolalo.getAzonosito());
        assertEquals("Szellő", iskolalo.getNev());
        assertEquals(6, iskolalo.getEletkor());
        assertEquals("Arab telivér", iskolalo.getFajta());
        assertEquals(160, iskolalo.getMarmagassag());
        assertEquals(3, iskolalo.getNapiOraLimit());
    }

    @Test
    void berloLetrehozasaSikeres() {
        BerloLetrehozo letrehozo = new BerloLetrehozo();

        Lo lo = letrehozo.letrehoz(
                2, "Csillag", 10, "Lipicai", 168, 5000
        );

        assertInstanceOf(Berlo.class, lo);

        Berlo berlo = (Berlo) lo;

        assertEquals(2, berlo.getAzonosito());
        assertEquals("Csillag", berlo.getNev());
        assertEquals(10, berlo.getEletkor());
        assertEquals("Lipicai", berlo.getFajta());
        assertEquals(168, berlo.getMarmagassag());
        assertEquals(5000, berlo.getOradij());
    }

    @Test
    void iskolaloNemEgeszNapiOraLimitjeNemEngedelyezett() {
        IskolaloLetrehozo letrehozo = new IskolaloLetrehozo();

        assertThrows(IllegalArgumentException.class, () ->
                letrehozo.letrehoz(
                        1, "Szellő", 6, "Arab telivér", 160, 2.5
                )
        );
    }

    @Test
    void negativNapiOraLimitNemEngedelyezett() {
        IskolaloLetrehozo letrehozo = new IskolaloLetrehozo();

        assertThrows(IllegalArgumentException.class, () ->
                letrehozo.letrehoz(
                        1, "Szellő", 6, "Arab telivér", 160, -1
                )
        );
    }
}
