package _1114_MásodikTesztÚjra;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class CountryTest {
    WorldStatistics worldStatistics = new WorldStatistics();

    @Before
    public void setUp() throws Exception {
        worldStatistics.readFile("Files/orszagok.txt","Files/varosok.txt");
    }

//    A Country osztályba írj egy
//    public double getPopulationDensity()
//    metódust, ami visszaadja az adott ország népsűrűségét fő/km2-ben! Ha az ország területe vagy népessége nincs megadva, akkor metódusod -1-gyel térjen vissza!

    @Test
    public void getPopulationDensityInDouble() {
        Assert.assertEquals(533.6787564766839, worldStatistics.countryHashMap.get("ABW").getPopulationDensity(), 0.00002);
        Assert.assertEquals(107.95657314844674, worldStatistics.countryHashMap.get("HUN").getPopulationDensity(), 0.0000004);
        Assert.assertEquals(96.49292264396189, worldStatistics.countryHashMap.get("AUT").getPopulationDensity(), 0.00001);
        Assert.assertEquals(29.862548847493454, worldStatistics.countryHashMap.get("ZWE").getPopulationDensity(), 0.00000002);
        //TODO float típusú az areaSize-od, ezért pontatlan a double-lal visszatérő metódus =>
        // célszerű lett volna az areaSize-ot double-ként deklarálni, mert az azt használó metódus double-lal tér vissza (más okból egyébként nem feltétlenül, bár ennél a
        // feladatnál jól látszik, hogy a double már ebben az esetben is mennyivel pontosabb (vagy a float pontatlanabb)...
    }

//    A Country osztályba írj egy
//    public double getRuralPopulation()
//    metódust, ami visszaadja, hogy az adott országban hány fő él a felsorolt városokon kívül!

    @Test
    public void getRuralPopulation() {
        Assert.assertEquals(8938580.0, worldStatistics.countryHashMap.get("ZWE").getRuralPopulation(), 0);
        Assert.assertEquals(73966.0, worldStatistics.countryHashMap.get("ABW").getRuralPopulation(), 0);
        Assert.assertEquals(2.03879E7, worldStatistics.countryHashMap.get("AFG").getRuralPopulation(), 0);
    }
}