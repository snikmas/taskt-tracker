import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        System.out.println("Welcome! This is Your Personal Task Tracker App.\n");
        int userInput = -1;
        int taskOption;
        Scanner scanner = new Scanner(System.in);
        ManagerTasks manager = new ManagerTasks();

        while(userInput != 0) {
            System.out.println("Menu:\n" + "[1] Create A Task");
            System.out.println("[2] Get All Tasks");
            System.out.println("[3] Clear All Tasks");
            System.out.println("[4] Get Task By ID / Name");
            System.out.println("[5] Update a Task");
            System.out.println("[6] Remove a Task");
            System.out.println("[0] Exit");

            while (true) {
                while (!scanner.hasNextInt()) {
                    System.out.println("Invalid input! Please enter a number.");
                    scanner.next();
                }

                userInput = scanner.nextInt();
                if(userInput < 0 || userInput > 6 ) {
                    System.out.println("Invalid input! Please enter a valid number.");
                } else {
                    break;
                }
            }

            switch(userInput) {
                case 1 -> {
                    System.out.println("What kind of task do you want?");
                    System.out.println("[1] Create a new task");
                    System.out.println("[2] Add a subtask to an existing task");

                    while (true) {
                        while (!scanner.hasNextInt()) {
                            System.out.println("Invalid input! Please enter a number.");
                            scanner.next();
                        }

                        taskOption = scanner.nextInt();
                        if(taskOption < 1 || taskOption > 2 ) {
                            System.out.println("Invalid input! Please enter a valid number.");
                        } else {
                            break;
                        }
                    }

                    switch (taskOption) {
                        case 1 -> manager.createTask("task");
                        case 2 -> manager.createTask("subtask");
                    }
                }

                case 2 -> manager.getAllTasks();
                case 3 -> manager.clearAllTasks();
                case 4 -> manager.getTask();
                case 5 -> manager.upDateTask();
                case 6 -> manager.removeTask();
                case 0 -> System.out.println("Bye!");

            }
        }
    }
}