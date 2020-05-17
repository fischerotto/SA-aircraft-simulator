package avaj.launcher;

public interface Flyable {
    void updateConditions();

    void registerTower(WeatherTower weatherTower);
}