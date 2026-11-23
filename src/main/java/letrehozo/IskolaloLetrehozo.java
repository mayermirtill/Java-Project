
package letrehozo;

import modell.Iskolalo;
import modell.Lo;

public class IskolaloLetrehozo extends LoLetrehozo {

    @Override
    public Lo letrehoz(
            int azonosito,
            String nev,
            int eletkor,
            String fajta,
            double marmagassag,
            double kulonlegesAdat
    ) {
        if (!Double.isFinite(kulonlegesAdat)
                || kulonlegesAdat != Math.floor(kulonlegesAdat)
                || kulonlegesAdat > Integer.MAX_VALUE) {
            throw new IllegalArgumentException(
                    "A napi óraszámkorlát egész szám legyen!"
            );
        }

        return new Iskolalo(
                azonosito,
                nev,
                eletkor,
                fajta,
                marmagassag,
                (int) kulonlegesAdat
        );
    }
}
