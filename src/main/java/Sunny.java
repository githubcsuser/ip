import java.util.Scanner;

public class Sunny {
    public static void main(String[] args) {
        String logo = "Hello! I'm Sunny.\n"
                + "What can I do for you?\n";
        System.out.println(logo);

        Scanner scan = new Scanner(System.in);
        String input;

        while (true) {
            input = scan.nextLine();
            if (input.equals("bye")) {
                System.out.println("Bye. Hope to see you again soon!");
                break;
            } else {
                System.out.println(input);
            }
        }
        scan.close();
    }
}
