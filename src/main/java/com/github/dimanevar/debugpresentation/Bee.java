package com.github.dimanevar.debugpresentation;

import java.util.List;
import lombok.Data;

/**
 * Class represents bee in programmatically way.
 */
@Data
public class Bee {

    /**
     * Current nectar capacity
     */
    private double nectarCapacity;

    /**
     * Maximal nectar that can take bee.
     */
    private double maxNectarCapacity = 20.0;

    public void fetchNectar(HoneyPlant honeyPlant) {
        double fetchCountPerTime = 1.0;
        while (nectarCapacity < maxNectarCapacity) {
            double retrievedNectar = honeyPlant.retrieveNectar(fetchCountPerTime);
            if (retrievedNectar == 0) {
                return;
            }
            nectarCapacity += retrievedNectar;
        }
    }

    public void fetchNectar(List<HoneyPlant> honeyPlants) {
        for (HoneyPlant honeyPlant : honeyPlants) {
            fetchNectar(honeyPlant);
        }
    }

    public double giveNectar() {
        double nectar = nectarCapacity;
        nectarCapacity = 0;
        return nectar;
    }
}
