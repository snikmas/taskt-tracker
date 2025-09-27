import java.util.HashMap;
import java.util.Scanner;



public class ManagerTasks {

    // global id
    int id = 1;

    Scanner scanner = new Scanner(System.in);

    HashMap<Integer, Task> tasks = new HashMap<>();



    int userInput = -1;
    public void createTask(String typeTask){
        // "task" || "susbtask"

        Task task = new Task();

        if("subtask".equals(typeTask)){
            System.out.println("All Tasks:");
            getAllTasks();

            System.out.println("To which task you would like to add a subtack?");

            while(true){
                while(!scanner.hasNextInt()) {
                    System.out.println("Invalid input. Please try again!");
                    scanner.next();
                }

                userInput = scanner.nextInt();
                if(!tasks.containsKey(userInput)){
                    System.out.println("Task doesn't exist! Please try again!");
                } else {
                    break;
                }
            }


            task.parentId = userInput;

        }


        System.out.print("Task name: ");
        task.name = scanner.nextLine();
        System.out.print("Task description: ");
        task.description = scanner.nextLine();
        task.status = Status.NEW;

        if(task.parentId != -1){
            tasks.get(userInput).subtasks.put(id, task);
        } else {
            tasks.put(id, task);
        }

        id++;


        System.out.println("Task Created!");
        System.out.println("Task Name: " + task.name);
        System.out.println("Task Description: " + task.description);
        System.out.println("Task Status: " + task.status);
        if(task.parentId != -1){
            System.out.println("Task Parent: " + tasks.get(task.parentId).name);
        }

    }

    public  void getAllTasks(){


        // check for a size!
        if(tasks.isEmpty()){
            System.out.println("No Tasks found!");
            return;
        }

        for(int i = 0; i < tasks.size(); i++){
            Task task = tasks.get(i);
            System.out.println("1. Task: " + task.name);
            System.out.println("Task Info:");
            System.out.println("Description: " + task.description);
            System.out.println("Status: " + task.status);

            if(!task.subtasks.isEmpty()){
                System.out.println("Subtasks:");
                for(int ii = 0; ii < task.subtasks.size(); ii++){
                    Task subtask = task.subtasks.get(ii);
                    System.out.println("Subtask: " + subtask.name);
                    System.out.println("Description: " + subtask.description);
                    System.out.println("Status: " + subtask.status);
                }
            }

            System.out.println("\n");
        }

        System.out.println("Back to Menu...");
    }

    public void clearAllTasks(){


    }

    public void getTask(){

    }

    public void upDateTask(){

    }





    public void removeTask(){

    }






}
