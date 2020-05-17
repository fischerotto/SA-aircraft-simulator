package avaj.launcher;

public class Lookups {
    private static String[] flyables = {"Jetplane", "Helicopter", "Balloon"};
    private static String[] weather = {"SUN", "RAIN", "FOG", "SNOW"};
    private static String[][] msg = {
            {
                    "Riding on a jet plane Sunny, higher than a bird",
                    "It's raining. Better watch out for lightnings.",
                    "The fog is killing me. Request permission to land.",
                    "OMG! Winter is coming!"
            },
            {
                    "This is why, this is why i'm hot.",
                    "Helicopter in the rain, velociraptor on a train",
                    "Foggy misty cloudy choppy chopper chop chop",
                    "My rotor is going to freeze!"
            },
            {
                    "Let's enjoy the good weather and take some pics.",
                    "Rainy with a chance of pancakes!",
                    "Zero visibility up there, Mr Fredricksen",
                    "It's snowing. We're gonna crash."
            }
    };

    private static int[][][] coords = {
            {
                    {0, 10, 2},
                    {0, 5, 0},
                    {0, 1, 0},
                    {0, 0, -7}
            },
            {
                    {10, 0, 2},
                    {5, 0, 0},
                    {1, 0, 0},
                    {0, 0, -12}
            },
            {
                    {2, 0, 4},
                    {0, 0, -5},
                    {0, 0, -3},
                    {0, 0, -15}
            }
    };

    private static int indexOf(String[] arr, String e) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i].equals(e)) {
                return i;
            }
        }
        return -1;
    }

    public static int getLongitude(String f, String w) {
        int i = indexOf(flyables, f);
        int j = indexOf(weather, w);
        return coords[i][j][0];
    }

    public static int getLatitude(String f, String w) {
        int i = indexOf(flyables, f);
        int j = indexOf(weather, w);
        return coords[i][j][1];
    }

    public static int getHeight(String f, String w) {
        int i = indexOf(flyables, f);
        int j = indexOf(weather, w);
        return coords[i][j][2];
    }

    public static String getMessage(String f, String w) {
        int i = indexOf(flyables, f);
        int j = indexOf(weather, w);
        return msg[i][j];
    }
}