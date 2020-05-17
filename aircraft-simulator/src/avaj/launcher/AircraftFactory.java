package avaj.launcher;

class InvalidAircraftTypeException extends Exception {
    public InvalidAircraftTypeException() {
    }

    public InvalidAircraftTypeException(String e) {
        super(e);
    }
}

public abstract class AircraftFactory {
    public static Flyable newAircraft(String type, String name, int longitude, int latitude, int height)
            throws InvalidAircraftTypeException {
        Coordinates coords = new Coordinates(longitude, latitude, height);
        if (type.equalsIgnoreCase("helicopter")) {
            return new Helicopter(name, coords);
        } else if (type.equalsIgnoreCase("jetplane")) {
            return new Jetplane(name, coords);
        } else if (type.equalsIgnoreCase("balloon")) {
            return new Balloon(name, coords);
        } else if (type.equalsIgnoreCase("baloon")) {
            return new Balloon(name, coords);
        } else {
            throw new InvalidAircraftTypeException("invalid aircraft type");
        }
    }
}