import java.util.HashMap;
import java.util.Scanner;



public class ManagerTasks {

    // global id
    int id = 0;

    Scanner scanner = new Scanner(System.in);

    HashMap<Integer, Task> tasks = new HashMap<>();



    int userInput = 0;
    public void createTask(String typeTask){
        // "task" || "susbtask"

        Task task = new Task();

        if("subtask".equals(typeTask)){
            System.out.println("All Tasks:");
            getAllTasks();
            System.out.println("To which task you would like to add a subtack?");

            userInput = scanner.nextInt();
            while(!tasks.containsKey(userInput) || userInput != -1){
                System.out.print("Incorrect name! Please try again (-1 to exit):");
                userInput = scanner.nextInt();
            }
            task.parentId = userInput;
            tasks.get(userInput).subtasks.put(id, task);
        } else if("task".equals(typeTask)){

            // just a task
            tasks.put(id, task);
        }
        id++;


        System.out.print("Task name: ");
        task.name = scanner.nextLine();
        System.out.print("Task description: ");
        task.description = scanner.nextLine();
        task.status = Status.NEW;


        System.out.println("Task Created!");
        System.out.println("Task Name: " + task.name);
        System.out.println("Task Description: " + task.description);
        System.out.println("Task Status: " + task.status);
        if(task.parentId != -1){
            System.out.println("Task Parent: " + tasks.get(task.parentId).name);
        }

        System.out.println("Back to Menu...");
    }

    public  void getAllTasks(){

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
