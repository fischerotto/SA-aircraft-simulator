package avaj.launcher;

public class WeatherTower extends Tower {

    public String getWeather(Coordinates coordinates) {
        return WeatherProvider.getProvider().getCurrentWeather(coordinates);
    }

    void changeWeather() {
        super.conditionsChanged();
    }

    @Override
    public void register(Flyable f) {
        AvajLogger.put(String.format("Tower says: %s registered to weather tower.\n", f));
        super.register(f);
    }

    @Override
    public void unregister(Flyable f) {
        AvajLogger.put(String.format("Tower says: %s unregistered from weather tower.\n", f));
        super.unregister(f);
    }
}