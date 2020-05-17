package avaj.launcher;

public class WeatherProvider {
    private static WeatherProvider weatherProvider = null;
    private static String[] weather = {"SUN", "RAIN", "FOG", "SNOW"};

    private WeatherProvider() {
    }

    public static WeatherProvider getProvider() {
        if (weatherProvider == null) {
            weatherProvider = new WeatherProvider();
        }
        return weatherProvider;
    }

    public String getCurrentWeather(Coordinates coordinates) {
        int idx = coordinates.getLongitude() + coordinates.getLatitude() + coordinates.getHeight() * 2147483647;
        idx = (idx < 0) ? -idx : idx;
        return weather[idx % weather.length];
    }
}
