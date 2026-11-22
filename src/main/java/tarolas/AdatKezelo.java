package tarolas;

import modell.Lo;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class AdatKezelo {

    private static final String FAJLNEV = "adatok/lovak.dat";

    // Lovak mentése fájlba
    public void ment(List<Lo> lovak) throws IOException {
        File fajl = new File(FAJLNEV);
        File mappa = fajl.getParentFile();

        if (!mappa.exists()) {
            mappa.mkdirs();
        }

        try (ObjectOutputStream kimenet =
                     new ObjectOutputStream(new FileOutputStream(fajl))) {
            kimenet.writeObject(lovak);
        }
    }

    // Lovak betöltése fájlból
    @SuppressWarnings("unchecked")
    public List<Lo> betolt() throws IOException, ClassNotFoundException {
        File fajl = new File(FAJLNEV);

        if (!fajl.exists()) {
            return new ArrayList<>();
        }

        try (ObjectInputStream bemenet =
                     new ObjectInputStream(new FileInputStream(fajl))) {
            return (List<Lo>) bemenet.readObject();
        }
    }
}