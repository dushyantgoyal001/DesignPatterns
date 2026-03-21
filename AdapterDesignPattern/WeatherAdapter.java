package AdapterDesignPattern;

public class WeatherAdapter implements WeatherTarget{
    private LegacyWeatherService legacyWeatherService;
    public WeatherAdapter(LegacyWeatherService legacyWeatherService) {
        this.legacyWeatherService = legacyWeatherService;
    }
    @Override
    public String getWeatherDataInJson() {
        String xmlData = legacyWeatherService.fetchWeatherData();
        // Simulate converting XML to JSON
        String jsonData = convertXmlToJson(xmlData);
        return jsonData;
    }

    private String convertXmlToJson(String xmlData) {
        return "{\"weather\":{\"temperature\":25,\"humidity\":60}}";
    }
}
