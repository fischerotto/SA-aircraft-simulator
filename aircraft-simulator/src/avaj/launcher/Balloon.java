package avaj.launcher;

public class Balloon extends Aircraft implements Flyable {
    private WeatherTower weatherTower;
    private String ft = "Balloon";

    Balloon(String name, Coordinates coordinates) {
        super(name, coordinates);
    }

    public void registerTower(WeatherTower weatherTower) {
        this.weatherTower = weatherTower;
        weatherTower.register(this);
    }

    public void updateConditions() {
        String w = weatherTower.getWeather(this.coordinates);
        AvajLogger.put(String.format("%s: %s %s\n", this, Lookups.getMessage(ft, w), this.coordinates));

        int lon = this.coordinates.getLongitude() + Lookups.getLongitude(ft, w);
        int lat = this.coordinates.getLatitude() + Lookups.getLatitude(ft, w);
        int hgt = this.coordinates.getHeight() + Lookups.getHeight(ft, w);
        hgt = (hgt > 100) ? 100 : hgt;

        if (hgt <= 0) {
            AvajLogger.put(String.format("%s landing.\n", this));
            weatherTower.unregister(this);
        }

        this.coordinates.setLongitude(lon);
        this.coordinates.setLatitude(lat);
        this.coordinates.setHeight(hgt);
    }

    @Override
    public String toString() {
        return ft + "#" + name + '(' + id + ')';
    }
}