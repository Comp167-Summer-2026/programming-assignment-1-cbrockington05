import java.util.Scanner;

public class TemperatureConverter {

    /* hint

    public static double convertTemperature(double temperature, String unit) {
        // TODO: students implement this
        return 0.0;
    }

     */

    /**
     * Converts a temperature value from one unit to the other.
     * @param temperature the numeric temperature to convert
     * @param unit "C" for Celsius to Fahrenheit, "F" for Fahrenheit to Celsius
     * @return the converted temperature as a double
     */
    public static double convertTemperature(double temperature, String unit) {
        double result = 0.0;
        if (unit.equalsIgnoreCase("C")) {
            // Celsius to Fahrenheit: F = (C * 9/5) + 32
            result = (temperature * 9.0 / 5.0) + 32.0;
        } else {
            // Fahrenheit to Celsius: C = (F - 32) * 5/9
            result = (temperature - 32.0) * 5.0 / 9.0;
        }
        return result;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean running = true;

        while (running) {

            // Prompt for temperature or "stop"
            System.out.print("Enter temperature (or 'stop' to quit): ");
            String tempInput = scanner.nextLine().trim();

            if (tempInput.equalsIgnoreCase("stop")) {
                running = false;
            } else {
                // Validate the input is a number without try/catch
                Scanner tempCheck = new Scanner(tempInput);
                boolean validTemp = tempCheck.hasNextDouble();
                tempCheck.close();

                if (!validTemp) {
                    System.out.println("Error: \"" + tempInput
                            + "\" is not a valid number. Please enter a numeric temperature.");
                } else {
                    double temperature = Double.parseDouble(tempInput);

                    // Loop on unit prompt until a valid unit is entered
                    boolean validUnit = false;
                    while (!validUnit) {
                        System.out.print("Enter unit (C or F): ");
                        String unit = scanner.nextLine().trim().toUpperCase();

                        if (!unit.equals("C") && !unit.equals("F")) {
                            System.out.println("Error: \"" + unit
                                    + "\" is not a valid unit. Please enter C or F.");
                        } else {
                            double converted = convertTemperature(temperature, unit);

                            if (unit.equals("C")) {
                                System.out.printf("%.2f\u00b0C is equal to %.2f\u00b0F%n",
                                        temperature, converted);
                            } else {
                                System.out.printf("%.2f\u00b0F is equal to %.2f\u00b0C%n",
                                        temperature, converted);
                            }
                            validUnit = true;
                        }
                    }
                }
            }
        }

        System.out.println("Goodbye!");
        scanner.close();
    }

}
