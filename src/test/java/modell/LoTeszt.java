
package modell;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LoTeszt {

    @Test
    void iskolaloLetrehozasaSikeres() {
        Iskolalo lo = new Iskolalo(
                1, "Szellő", 6, "Arab telivér", 160, 3
        );

        assertEquals(1, lo.getAzonosito());
        assertEquals("Szellő", lo.getNev());
        assertEquals(6, lo.getEletkor());
        assertEquals("Arab telivér", lo.getFajta());
        assertEquals(160, lo.getMarmagassag());
        assertEquals(3, lo.getNapiOraLimit());
        assertEquals(LoAllapot.AKTIV, lo.getAllapot());
    }

    @Test
    void berloLetrehozasaSikeres() {
        Berlo lo = new Berlo(
                2, "Csillag", 10, "Lipicai", 168, 5000
        );

        assertEquals(2, lo.getAzonosito());
        assertEquals("Csillag", lo.getNev());
        assertEquals(10, lo.getEletkor());
        assertEquals("Lipicai", lo.getFajta());
        assertEquals(168, lo.getMarmagassag());
        assertEquals(5000, lo.getOradij());
        assertEquals(LoAllapot.AKTIV, lo.getAllapot());
    }

    @Test
    void negativAzonositoNemEngedelyezett() {
        assertThrows(IllegalArgumentException.class, () ->
                new Iskolalo(
                        -1, "Szellő", 6, "Arab telivér", 160, 3
                )
        );
    }

    @Test
    void uresNevNemEngedelyezett() {
        assertThrows(IllegalArgumentException.class, () ->
                new Iskolalo(
                        1, "", 6, "Arab telivér", 160, 3
                )
        );
    }

    @Test
    void nullaNapiOraLimitNemEngedelyezett() {
        assertThrows(IllegalArgumentException.class, () ->
                new Iskolalo(
                        1, "Szellő", 6, "Arab telivér", 160, 0
                )
        );
    }

    @Test
    void nullaOradijNemEngedelyezett() {
        assertThrows(IllegalArgumentException.class, () ->
                new Berlo(
                        2, "Csillag", 10, "Lipicai", 168, 0
                )
        );
    }

    @Test
    void nevModositasaMukodik() {
        Iskolalo lo = new Iskolalo(
                1, "Szellő", 6, "Arab telivér", 160, 3
        );

        lo.setNev("Villám");

        assertEquals("Villám", lo.getNev());
    }

    @Test
    void allapotModositasaMukodik() {
        Iskolalo lo = new Iskolalo(
                1, "Szellő", 6, "Arab telivér", 160, 3
        );

        lo.setAllapot(LoAllapot.PIHENO);

        assertEquals(LoAllapot.PIHENO, lo.getAllapot());
    }
}
