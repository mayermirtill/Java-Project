
package tarolas;

import modell.Iskolalo;
import modell.Lo;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.io.TempDir;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class AdatKezeloTeszt {

    @TempDir
    Path ideiglenesMappa;

    @Test
    void lovakMenteseEsBetolteseSikeres() throws IOException, ClassNotFoundException {
        String fajlnev = ideiglenesMappa.resolve("teszt_lovak.dat").toString();

        AdatKezelo adatKezelo = new AdatKezelo(fajlnev);

        List<Lo> lovak = new ArrayList<>();
        lovak.add(new Iskolalo(
                1, "Szellő", 6, "Arab telivér", 160, 3
        ));
        lovak.add(new Iskolalo(
                2, "Csillag", 10, "Lipicai", 168, 4
        ));

        adatKezelo.ment(lovak);

        List<Lo> betoltottLovak = adatKezelo.betolt();

        assertEquals(2, betoltottLovak.size());
        assertEquals("Szellő", betoltottLovak.get(0).getNev());
        assertEquals("Csillag", betoltottLovak.get(1).getNev());
        assertEquals(6, betoltottLovak.get(0).getEletkor());
        assertEquals(10, betoltottLovak.get(1).getEletkor());
    }

    @Test
    void mentettFajlValobanLetrejott() throws IOException {
        String fajlnev = ideiglenesMappa.resolve("teszt_lovak.dat").toString();

        AdatKezelo adatKezelo = new AdatKezelo(fajlnev);

        List<Lo> lovak = new ArrayList<>();
        lovak.add(new Iskolalo(
                1, "Szellő", 6, "Arab telivér", 160, 3
        ));

        adatKezelo.ment(lovak);

        File fajl = new File(fajlnev);

        assertTrue(fajl.exists());
    }

    @Test
    void nemLetezoFajlEsetenUresListatAd() throws IOException, ClassNotFoundException {
        String fajlnev = ideiglenesMappa.resolve("nem_letezik.dat").toString();

        AdatKezelo adatKezelo = new AdatKezelo(fajlnev);

        List<Lo> betoltottLovak = adatKezelo.betolt();

        assertNotNull(betoltottLovak);
        assertTrue(betoltottLovak.isEmpty());
    }

    @Test
    void uresListaMenteseEsBetolteseSikeres() throws IOException, ClassNotFoundException {
        String fajlnev = ideiglenesMappa.resolve("ures_lovak.dat").toString();

        AdatKezelo adatKezelo = new AdatKezelo(fajlnev);

        List<Lo> lovak = new ArrayList<>();

        adatKezelo.ment(lovak);

        List<Lo> betoltottLovak = adatKezelo.betolt();

        assertNotNull(betoltottLovak);
        assertTrue(betoltottLovak.isEmpty());
    }
}
