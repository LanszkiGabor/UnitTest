package _1114_MásodikTesztÚjra;

public class City {

    private String townName;
    private String countryCode;
    private int cityPopulation;
    private Country country;

    public City(String townName, String countryCode, int cityPopulation, Country country) {
        this.townName = townName;
        this.countryCode = countryCode;
        this.cityPopulation = cityPopulation;
        this.country = country;
    }

    public String getTownName() {
        return townName;
    }

    public void setTownName(String townName) {
        this.townName = townName;
    }

    public String getCountryCode() {
        return countryCode;
    }

    public void setCountryCode(String countryCode) {
        this.countryCode = countryCode;
    }

    public int getCityPopulation() {
        return cityPopulation;
    }

    public void setCityPopulation(int cityPopulation) {
        this.cityPopulation = cityPopulation;
    }

    public Country getCountry() {
        return country;
    }

    public void setCountry(Country country) {
        this.country = country;
    }



}
