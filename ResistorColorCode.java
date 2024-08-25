import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class ResistorColorCode {

    // Map to store color codes and their corresponding values
    private static final Map<String, Integer> colorToDigit = new HashMap<>();
    private static final Map<String, Double> colorToMultiplier = new HashMap<>();

    static {
        // Initialize color to digit map
        colorToDigit.put("black", 0);
        colorToDigit.put("brown", 1);
        colorToDigit.put("red", 2);
        colorToDigit.put("orange", 3);
        colorToDigit.put("yellow", 4);
        colorToDigit.put("green", 5);
        colorToDigit.put("blue", 6);
        colorToDigit.put("violet", 7);
        colorToDigit.put("gray", 8);
        colorToDigit.put("white", 9);

        // Initialize color to multiplier map
        colorToMultiplier.put("black", 1.0);
        colorToMultiplier.put("brown", 10.0);
        colorToMultiplier.put("red", 100.0);
        colorToMultiplier.put("orange", 1000.0);
        colorToMultiplier.put("yellow", 10000.0);
        colorToMultiplier.put("green", 100000.0);
        colorToMultiplier.put("blue", 1000000.0);
        colorToMultiplier.put("violet", 10000000.0);
        colorToMultiplier.put("gray", 100000000.0);
        colorToMultiplier.put("white", 1000000000.0);
        colorToMultiplier.put("gold", 0.1);
        colorToMultiplier.put("silver", 0.01);
    }

    public static double calculateResistance(String band1, String band2, String multiplierBand) {
        if (!colorToDigit.containsKey(band1) || !colorToDigit.containsKey(band2) || !colorToMultiplier.containsKey(multiplierBand)) {
            throw new IllegalArgumentException("Invalid color band. Please use valid resistor colors.");
        }

        int firstDigit = colorToDigit.get(band1);
        int secondDigit = colorToDigit.get(band2);
        double multiplier = colorToMultiplier.get(multiplierBand);

        return (firstDigit * 10 + secondDigit) * multiplier;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Resistor Color Code Calculator");
        System.out.println("Enter the color of the bands:");

        try {
            System.out.print("First band: ");
            String band1 = scanner.nextLine().toLowerCase();

            System.out.print("Second band: ");
            String band2 = scanner.nextLine().toLowerCase();

            System.out.print("Multiplier band: ");
            String multiplierBand = scanner.nextLine().toLowerCase();

            double resistance = calculateResistance(band1, band2, multiplierBand);
            System.out.printf("The resistance value is: %.2f ohms%n", resistance);
        } catch (IllegalArgumentException e) {
            System.err.println("Error: " + e.getMessage());
        } finally {
            scanner.close();
        }
    }
}
