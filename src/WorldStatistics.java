package _1114_MásodikTesztÚjra;


import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class WorldStatistics {

    HashMap<String, Country> countryHashMap = new HashMap<>();
    HashMap<String, City> cityHashMap = new HashMap<>();


    public void readFile(String countriesFile, String citiesFile) throws FileNotFoundException {

        Scanner scanner = new Scanner(new File(countriesFile));
        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            String[] parts = line.split(",");


            Country newCountry = null;

            int x = 0;
            if (parts[5].equals("NULL")) {
                x = 0;
            } else {
                x = Integer.parseInt(parts[5]);
            }

            if (parts.length == 7) {
                newCountry = new Country(parts[0], parts[1], parts[2], parts[3], Float.parseFloat(parts[4]), x, Integer.parseInt(parts[6]));
            } else {
                newCountry = new Country(parts[0], parts[1], parts[2], parts[3], Float.parseFloat(parts[4]), x, Integer.parseInt(parts[6]), parts[7]);
            }
            countryHashMap.put(parts[0], newCountry);
        }

        scanner = new Scanner(new File(citiesFile));
        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            String[] parts = line.split(",");
            String countryID = parts[1];
            Country country = countryHashMap.get(countryID);
            City city = new City(parts[0], countryID, Integer.parseInt(parts[2]), country);
            cityHashMap.put(parts[0], city);
            country.addNewCity(city);
        }
    }

    public void printCountryPopulationDensity(String countryID) {
        Country country = countryHashMap.get(countryID);
        System.out.println("Density: " + country.getPopulationDensity());
    }

    public void printRuralPopulation(String countryID) {
        Country country = countryHashMap.get(countryID);
        System.out.println("Rural population: " + country.getRuralPopulation());
    }

    // országkód alapján visszaadja egy ország összes adatát!

    public Country findCountryByISoCode(String isoCode) {
        return countryHashMap.get(isoCode);
    }

    // visszaadja egy paraméterül kapott kontinens országainak az országkódjait

    public ArrayList<String> getCountriesOfContinent(String continentName) {
        ArrayList<String> countryCodesOfTheContinent = new ArrayList<>();
        for (Country country : countryHashMap.values()) {
            if (country.getContinent().equals(continentName)) {
                countryCodesOfTheContinent.add(country.getCountryCode());
            }
        }
        return countryCodesOfTheContinent;
    }

    // visszaadja egy paraméterül kapott ország városainak a neveit (az országot országkóddal adjuk meg)!

    public HashSet<String> getCitiesOfCountry(String countryCode) {
        HashSet<String> citiesOfTheCountry = new HashSet<>();
        for (City city : countryHashMap.get(countryCode).getCityArrayList()) {
            citiesOfTheCountry.add(city.getTownName());
        }
        return citiesOfTheCountry;
    }


    //Hány országnak az államfőjének nevében szerepel “Hamad” vagy “Ahmad” vagy “Ahmed”?

    public int getAhmedCount() {
        int counter = 0;
        for (Country country : countryHashMap.values()) {
            String minister = country.getMinister();
            if (minister != null && (minister.contains("Ahmad") || minister.contains("Hamad") || minister.contains("Ahmed"))) {
                counter++;
            }
        }
        return counter;
    }

    // Melyik betűvel kezdődik a legtöbb országkód? A visszatérési érték egy egybetűs String, a metódus szignatúrája pedig az alábbi legyen

    public String getPopularFirstLetter() {
        HashMap<String, Integer> firstLetterMap = new HashMap<>();
        for (String countryCode : countryHashMap.keySet()) {
            String firstLetter = countryCode.substring(0, 1);
            firstLetterMap.put(firstLetter, firstLetterMap.getOrDefault(firstLetter, 0) + 1);
        }
        Map.Entry<String, Integer> max = null;
        for (Map.Entry<String, Integer> entry : firstLetterMap.entrySet()) {
            if (max == null || max.getValue() < entry.getValue()) {
                max = entry;
            }
        }
        return max.getKey();
    }

    // Melyik ország nyerte el legkésőbb (a nyilvántartás szerint) a függetlenségét? Add vissza a megfelelő országkódot

    public String lastIndependentCountry() {
        int max = 0;
        String code = "";
        for (Country country : countryHashMap.values()) {
            if (country.getIndependenceYear() > max) {
                max = country.getIndependenceYear();
                code = country.getCountryCode();
            }
        }
        return code;
    }
}




