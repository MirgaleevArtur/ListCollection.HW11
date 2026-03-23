import java.util.Scanner;

public class UserInputReader {

    private static final Scanner SCANNER = new Scanner(System.in);

    public static int readIntValueFromConsole() {
        while (true) {
            if (SCANNER.hasNextInt()) {
                int result = SCANNER.nextInt();
                SCANNER.nextLine();
                return result;
            } else {
                System.out.println("Ошибка! Пожалуйста, введите целое число.");
                SCANNER.nextLine();
            }
        }
    }

    public static String readStringValueFromConsole() {
        return SCANNER.nextLine().trim();
    }
}
