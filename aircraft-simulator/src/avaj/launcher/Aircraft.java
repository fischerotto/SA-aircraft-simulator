package avaj.launcher;

abstract class Aircraft {
    private static long idCounter;
    protected long id;
    protected String name;
    protected Coordinates coordinates;

    Aircraft(String name, Coordinates coordinates) {
        this.name = name;
        this.coordinates = coordinates;
        this.id = nextId();
    }

    private long nextId() {
        idCounter += 1;
        return idCounter;
    }
}