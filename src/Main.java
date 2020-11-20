package _1114_MásodikTesztÚjra;

import java.io.FileNotFoundException;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {

        Country country = new Country();
        WorldStatistics worldStatistics = new WorldStatistics();
        worldStatistics.readFile("Files/orszagok.txt","Files/varosok.txt");


       // worldStatistics.printCountryPopulationDensity("ATG");
        //worldStatistics.printRuralPopulation("NZL");
        //System.out.println(worldStatistics.findCountryByISoCode("NZL"));
       // System.out.println(worldStatistics.getCountriesOfContinent("Europe"));
       // System.out.println(worldStatistics.getAhmedCount());
       //System.out.println(worldStatistics.getPopularFirstLetter());
        //System.out.println(worldStatistics.lastIndependentCountry());
    }
}
