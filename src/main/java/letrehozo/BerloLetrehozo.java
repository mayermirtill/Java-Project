
package letrehozo;

import modell.Berlo;
import modell.Lo;

public class BerloLetrehozo extends LoLetrehozo {

    @Override
    public Lo letrehoz(
            int azonosito,
            String nev,
            int eletkor,
            String fajta,
            double marmagassag,
            double kulonlegesAdat
    ) {
        return new Berlo(
                azonosito,
                nev,
                eletkor,
                fajta,
                marmagassag,
                kulonlegesAdat
        );
    }
}
