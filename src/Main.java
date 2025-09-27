import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        // process:

        // task - the simplest
        // name
        // descrioption
        // id
        // status 4.1 (new, no one has touched it) 4.2 in progress; 4.3 done
        //
        // epic - task with subtasks (big task)
        // subtask

        // task: 1) common task 2) epic 3) subtask
        // requirements:
        // podtask knows to which epic it belongs
        // epic knows all their subtasks
        //
         // hints:
        // abstract class
        // class for object-manager: runs when the program starts
        // 1) able to save all kind of tasks
        // 2) methods for every type of task
        // 2) 1) get all tasks
        // 2) 2) delete all tasks
        // 2) 3) get by id
        // 2) 4) creating
        // 2) 5) update
        // 2) 5) delete by id
        // 3) other methods:
        // 4) 1) status managing: : manager doesn't handle the status of the task, it will get it when task's managing
        // 4) epics:
        // 4) 2) if an epic doesnt have subtask / they all have status "new" -> epic is a new
        // 4) 2) if all epic's subtasks done -> epic is also done
        // otherwise: in progress

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

            userInput = scanner.nextInt();

            switch(userInput) {
                case 1 -> {
                    System.out.println("What kind of task do you want?");
                    System.out.println("[1] Create a new task");
                    System.out.println("[2] Add a subtask to an existing task");
                    taskOption = scanner.nextInt();
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