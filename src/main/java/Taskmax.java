import java.util.Scanner;

public class Taskmax {
    public static void main(String[] args) {
        int count = 0;  // Current count of tasks
        int limit = 100;  //Maximum number of tasks
        Mascot mascot = new Mascot();  //Taskmax's illustration
        Task[] tasks = new Task[limit]; //Task array


        String line = "-".repeat(100) + "\n";
        String tooMany = "Your list is full, get to work first!";
        String intro = "Greetings! I'm Taskmax, Your personal tasking companion.\n"
                     + "What can I schedule for you today?\n";
        System.out.println(line + intro + line + mascot + line);

        Scanner scan = new Scanner(System.in);
        String input;

        while (true) {
            input = scan.nextLine();
            if (input.equals("bye")) {   //bye input
                System.out.println(line
                        + "\nI hope that you are satisfied with your service.\n"
                        + "See you again soon!\n"
                        + line);
                break;
            } else if (input.equals("list")) {  //list input
                System.out.println(line
                        + "\nHere are the tasks in your list:\n"
                        + line);
                for (int i = 0; i < count; i++) {
                    int num = i + 1;
                    System.out.println(num + "." + tasks[i].toString());
                }
                System.out.println("\n" + line);
            } else if (input.startsWith("mark ")) {   //mark input as done
                int num = Integer.parseInt(input.substring(5)) - 1;
                    if(num >= 0 && num < count) {
                        tasks[num].markAsDone();
                        System.out.println("Nice! I've marked your task as done.\n"
                                            + "Keep up the good work!\n"
                                            + line);
                    }
            } else if (input.startsWith("unmark ")) {   //mark input as undone
                int num = Integer.parseInt(input.substring(7)) - 1;
                if(num >= 0 && num < count) {
                    tasks[num].markAsNotDone();
                    System.out.println("I've unmarked your task.\n"
                            + "Don't give up on it yet!\n"
                            + line);
                    }
                } else if (input.startsWith("todo")) {  //To do tasks
                    if(count >= limit) {
                        System.out.println(tooMany);
                        break;
                    }
                        String description = input.substring(5);
                        tasks[count] = new ToDo(description);
                        count++;
                        System.out.println(line + "\nGot it. I've added this task:\n  "
                                           + tasks[count - 1].toString()
                                           + "\nNow you have " + count + " tasks in the list.\n"
                                           + line);
            } else if (input.startsWith("deadline")) {  //Deadline tasks
                if(count >= limit) {
                    System.out.println(tooMany);
                    break;
                }
                    String[] sections = input.substring(9).split("/by");
                    if (sections.length != 2) {
                        System.out.println("Oops! You have to include a \"/by deadline\" after your task\n"
                                           + " e.g. deadline Assignment2 /by Sunday\n"
                                           + "Please reboot me and try again!");
                    }
                    tasks[count] = new Deadline(sections[0], sections[1]);
                    count++;
                    System.out.println(line + "\nGot it. I've added this task:\n  "
                            + tasks[count - 1].toString()
                            + "\nNow you have " + count + " tasks in the list.\n"
                            + line);
            } else if (input.startsWith("event")) {     //Event tasks
                if(count >= limit) {
                    System.out.println(tooMany);
                    break;
                }
                String[] sections = input.substring(6).split("/from | /to");
                if (sections.length != 3) {
                    System.out.println("Oops! You have to include a \"/from start /to end\" after your task\n"
                            + " e.g. event Concert /from Monday 3am /to Monday 4pm\n"
                            + "Please reboot me and try again!");
                }
                tasks[count] = new Event(sections[0], sections[1], sections[2]);
                count++;
                System.out.println(line + "\nGot it. I've added this task:\n  "
                        + tasks[count - 1].toString()
                        + "\nNow you have " + count + " tasks in the list.\n"
                        + line);
            } else if (count >= limit) {
                System.out.println(tooMany);
                break;
            } else {
                tasks[count] = new Task(input);
                count++;
                System.out.println(line + "\n added: " + input + "\n" + line);
            }
        }
        scan.close();
    }
}
