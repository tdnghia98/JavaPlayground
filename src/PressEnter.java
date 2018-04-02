import java.util.Scanner;

public class PressEnter {
    public static void main(String[] args) {
        System.out.println("Press enter to exit...");
        Scanner scanner = new Scanner(System.in);
        scanner.nextLine();
        System.out.println("Enter key was pressed!");
    }

}
