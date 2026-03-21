package AdapterDesignPattern;

public class TravelApp {
    public static void main(String[] args) {
        LegacyWeatherService legacyWeatherService = new LegacyWeatherService();
        WeatherTarget weatherAdapter = new WeatherAdapter(legacyWeatherService);
        System.out.println("Weather data in JSON format: " + weatherAdapter.getWeatherDataInJson());
    }
}
