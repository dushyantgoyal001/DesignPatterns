package AdapterDesignPattern;

public class LegacyWeatherService {
    public String fetchWeatherData() {
        // Simulate fetching weather data in XML format
        return "<weather><temperature>25</temperature><humidity>60</humidity></weather>";
    }
}
