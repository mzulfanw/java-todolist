package utils;

public class InputUtils {
    private static final java.util.Scanner scanner = new java.util.Scanner(System.in);

    public static String input(String info) {
        System.out.print(info + " : ");
        return scanner.nextLine();
    }
}
