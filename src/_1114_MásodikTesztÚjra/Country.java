package _1114_MásodikTesztÚjra;

import java.util.ArrayList;

public class Country {

    private String countryCode;
    private String countryName;
    private String continent;
    private String region;
    private float areaSize;
    private int independenceYear;
    private int population;
    private String minister;
    private ArrayList<City> cityArrayList = new ArrayList<>();

    public Country(String countryCode, String countryName, String continent, String region, float areaSize, int independenceYear, int population) {
        this.countryCode = countryCode;
        this.countryName = countryName;
        this.continent = continent;
        this.region = region;
        this.areaSize = areaSize;
        this.independenceYear = independenceYear;
        this.population = population;
    }

    public Country(String countryCode, String countryName, String continent, String region, float areaSize, int independenceYear, int population, String minister) {
        this.countryCode = countryCode;
        this.countryName = countryName;
        this.continent = continent;
        this.region = region;
        this.areaSize = areaSize;
        this.independenceYear = independenceYear;
        this.population = population;
        this.minister = minister;
    }

    public Country() {
    }

    public void addNewCity(City city) {
        this.cityArrayList.add(city);
    }

    public String getCountryCode() {
        return countryCode;
    }

    public void setCountryCode(String countryCode) {
        this.countryCode = countryCode;
    }

    public String getCountryName() {
        return countryName;
    }

    public void setCountryName(String countryName) {
        this.countryName = countryName;
    }

    public String getContinent() {
        return continent;
    }

    public void setContinent(String continent) {
        this.continent = continent;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public float getAreaSize() {
        return areaSize;
    }

    public void setAreaSize(float areaSize) {
        this.areaSize = areaSize;
    }

    public int getIndependenceYear() {
        return independenceYear;
    }

    public void setIndependenceYear(int independenceYear) {
        this.independenceYear = independenceYear;
    }

    public int getPopulation() {
        return population;
    }

    public void setPopulation(int population) {
        this.population = population;
    }

    public String getMinister() {
        return minister;
    }

    public void setMinister(String minister) {
        this.minister = minister;
    }

    public ArrayList<City> getCityArrayList() {
        return cityArrayList;
    }

    @Override
    public String toString() {
        return "Country{" +
                "countryCode='" + countryCode + '\'' +
                ", countryName='" + countryName + '\'' +
                ", continent='" + continent + '\'' +
                ", region='" + region + '\'' +
                ", areaSize=" + areaSize +
                ", independenceYear='" + independenceYear + '\'' +
                ", population=" + population +
                ", minister='" + minister + '\'' +
                '}';
    }

    // népsűrűség km2-ben

    public double getPopulationDensity() {
        if (getPopulation() == 0 || getAreaSize() == 0) {
            return -1;
        } else {
            return getPopulation() / getAreaSize();
        }
    }


    //az adott országban hány fő él a felsorolt városokon kívül!

    public double getRuralPopulation() {
        int sum = 0;
        for (City city : cityArrayList) {
            sum += city.getCityPopulation();
        }
        return getPopulation() - sum;
    }



}
