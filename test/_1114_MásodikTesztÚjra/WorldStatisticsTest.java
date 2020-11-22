package _1114_MásodikTesztÚjra;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

import static org.junit.Assert.*;

public class WorldStatisticsTest {
    WorldStatistics worldStatistics = new WorldStatistics();
    HashSet<String> cities = new HashSet<>();

    @Before
    public void setUp() throws Exception {
        readFile();
    }

    @After
    public void tearDown() throws Exception {
    }

//    A WorldStatistics osztályba készíts egy
//    public void readFile(String countriesFile, String citiesFile) throws FileNotFoundException
//    metódust, amiben beolvasod az adatokat a fájlokból, és eltárolod el egy megfelelő adatszerkezetben!
//    Javasoljuk, hogy hozz létre egy main metódust is ebben az osztályban, hogy kipróbálhasd a megoldásaidat (bár az ellenőrzésnél mi nem fogjuk használni a main metódusodat)!
//            3 pont (Az országok listáját és a városok listáját külön tárolva nem jár pont.)

    @Test
    public void readFile() throws FileNotFoundException {
        worldStatistics.readFile("Files/orszagok.txt", "Files/varosok.txt");
    }

//    Írj egy olyan metódust, ami országkód alapján visszaadja egy ország összes adatát! A metódus szignatúrája az alábbi legyen:
//    public Country findCountryByISoCode(String isoCode)

    @Test
    public void findCountryByISoCode() {
        Assert.assertEquals(worldStatistics.countryHashMap.get("ABW"), worldStatistics.findCountryByISoCode("ABW"));
        Assert.assertEquals(worldStatistics.countryHashMap.get("HUN"), worldStatistics.findCountryByISoCode("HUN"));
        Assert.assertEquals(worldStatistics.countryHashMap.get("ZWE"), worldStatistics.findCountryByISoCode("ZWE"));
    }

//    Írj egy olyan metódust, amely visszaadja egy paraméterül kapott kontinens országainak az országkódjait! A metódus szignatúrája az alábbi legyen:
//    public ArrayList<String> getCountriesOfContinent(String continentName)

    @Test
    public void getCountriesOfContinent() {
        Assert.assertEquals(getCountriesOfContinent("Europe"), worldStatistics.getCountriesOfContinent("Europe"));
        Assert.assertEquals(getCountriesOfContinent("Africa"), worldStatistics.getCountriesOfContinent("Africa"));
    }

    public ArrayList<String> getCountriesOfContinent(String continentName) {
        ArrayList<String> countries = new ArrayList<>();
        for (Country value : worldStatistics.countryHashMap.values()) {
            if (value.getContinent().equals(continentName)) {
                countries.add(value.getCountryCode());
            }
        }
        return countries;
    }

//    Írj egy olyan metódust, amely visszaadja egy paraméterül kapott ország városainak a neveit (az országot országkóddal adjuk meg)! A metódus szignatúrája az alábbi legyen:
//    public HashSet<String> getCitiesOfCountry(String countryCode)

    @Test
    public void getCitiesOfCountry() {
        Assert.assertEquals(getCitiesOfCountry("HUN"), worldStatistics.getCitiesOfCountry("HUN"));
        Assert.assertEquals(getCitiesOfCountry("ABW"), worldStatistics.getCitiesOfCountry("ABW"));
        Assert.assertEquals(getCitiesOfCountry("ZWE"), worldStatistics.getCitiesOfCountry("ZWE"));
    }

    public HashSet<String> getCitiesOfCountry(String countryCode) {
        HashSet<String> cities = new HashSet<>();
        for (City city : worldStatistics.countryHashMap.get(countryCode).getCityArrayList()) {
            cities.add(city.getTownName());
        }
        return cities;
    }

//    Hány országnak az államfőjének nevében szerepel “Hamad” vagy “Ahmad” vagy “Ahmed”? A metódus szignatúrája az alábbi legyen:
//    public int getAhmedCount()
//    Egy String objektumban a .indexOf() metódussal tudod megvizsgálni, hogy tartalmaz-e egy adott karaktersorozatot.

    @Test
    public void getAhmedCount() {
        Assert.assertEquals(7, worldStatistics.getAhmedCount());
        Assert.assertEquals(getAhmedCountForReference(), worldStatistics.getAhmedCount());
    }

    public int getAhmedCountForReference() {
        int counter = 0;
        for (Country value : worldStatistics.countryHashMap.values()) {
            if (value.getMinister() != null && (value.getMinister().contains("Hamad") || value.getMinister().contains("Ahmed") || value.getMinister().contains("Ahmad"))) {
                counter++;
            }
        }
        return counter;
    }

//    Melyik betűvel kezdődik a legtöbb országkód? A visszatérési érték egy egybetűs String, a metódus szignatúrája pedig az alábbi legyen:
//    public String getPopularFirstLetter()
//    Egy hosszabb String első betűjének visszakapására a .substring() metódus használatos.

    @Test
    public void getPopularFirstLetterAsString() {
        Assert.assertEquals("M", worldStatistics.getPopularFirstLetter());
    }

//    Melyik ország nyerte el legkésőbb (a nyilvántartás szerint) a függetlenségét? Add vissza a megfelelő országkódot, a metódus szignatúrája az alábbi legyen:
//    public String lastIndependentCountry()

    @Test
    public void getlastIndependentCountryCode() {
        Assert.assertEquals("PLW", worldStatistics.lastIndependentCountry());
    }
}