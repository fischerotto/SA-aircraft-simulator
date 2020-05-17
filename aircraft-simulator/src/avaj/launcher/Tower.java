package avaj.launcher;

import java.util.ArrayList;

abstract class Tower {
    private ArrayList<Flyable> observers = new ArrayList<Flyable>();

    public void register(Flyable f) {
        observers.add(f);
    }

    public void unregister(Flyable f) {
        observers.remove(f);
    }

    protected void conditionsChanged() {

        for (int i = 0; i < observers.size(); i++) {
            Flyable f = observers.get(i);
            f.updateConditions();
        }
    }
}