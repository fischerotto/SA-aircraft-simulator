package avaj.launcher;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class InvalidNumSimulationsException extends Exception {

    public InvalidNumSimulationsException() {
    }

    public InvalidNumSimulationsException(String e) {
        super(e);
    }
}

public class Simulator {

    public static void main(String[] args) {
        Scanner in = null;
        int numSimulations = -1;
        boolean isValid = false;
        String s;
        String[] split;
        WeatherTower wt;
        List<Flyable> fleet = new ArrayList<>();

        if (args.length != 1) {
            System.out.println("usage: program <scenario_file.txt>");
            System.exit(1);
        }

        try {
            in = new Scanner(new File(args[0]));
        } catch (IOException e) {
            System.out.println("error: could not read file");
            System.exit(0);
        }

        if (in.hasNext()) {
            s = in.nextLine();
            if (s.matches("^\\d+$")) {
                try {
                    numSimulations = Integer.parseInt(s);
                    if (numSimulations <= 0) {
                        throw new InvalidNumSimulationsException("number of simulations must be greater than 0");
                    } else {
                        isValid = true;
                    }
                } catch (InvalidNumSimulationsException e) {
                    System.out.println(e);
                } catch (NumberFormatException e) {
                    System.out.println("error: invalid number of simulations - int out of range");
                }
            } else {
                System.out.println("error: first line of input should be number of simulations");
            }
        }

        while (isValid && in.hasNext()) {
            s = in.nextLine();
            if (s.matches("^\\w+\\s+\\w+\\s+\\d+\\s+\\d+\\s+\\d+$")) {
                split = s.split("\\s+");
                try {
                    fleet.add(
                            AircraftFactory.newAircraft(
                                    split[0],
                                    split[1],
                                    Integer.parseInt(split[2]),
                                    Integer.parseInt(split[3]),
                                    Integer.parseInt(split[4])
                            )
                    );
                } catch (InvalidAircraftTypeException e) {
                    System.out.println("line: " + s);
                    System.out.println("error: " + e);
                    isValid = false;
                    break;
                } catch (NumberFormatException e) {
                    System.out.println("number format exception: " + s);
                    isValid = false;
                    break;
                }
            } else {
                System.out.println("parse error: " + s);
                isValid = false;
                break;
            }
        }

        in.close();
        if (!isValid) {
            System.exit(0);
        }

        wt = new WeatherTower();
        for (Flyable f : fleet) {
            f.registerTower(wt);
        }

        for (int i = 0; i < numSimulations; i++) {
            wt.changeWeather();
        }

    }
}