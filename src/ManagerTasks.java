import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class ManagerTasks {

    int id = 1;
    int userInput = -1;
    Scanner scanner = new Scanner(System.in);
    public HashMap<Integer, Task> tasks = new HashMap<>();


    public void createTask(String typeTask){

        Task task = new Task();

        if("subtask".equals(typeTask)){
            System.out.println("All Tasks:");
            getAllTasks();

            if(tasks.isEmpty()){
                System.out.println("There are no tasks!");
                return;
            }

            System.out.println("To which task you would like to add a subtack?");

            while(true){
                while(!scanner.hasNextInt()) {
                    System.out.println("Invalid input. Please try again!");
                    scanner.next();
                }

                userInput = scanner.nextInt();
                scanner.nextLine(); // buffer

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

    public void getAllTasks(){

        if(tasks.isEmpty()){
            System.out.println("No Tasks found!");
            return;
        }

        for(Map.Entry<Integer, Task> entry : tasks.entrySet()){
            int taskId = entry.getKey();
            Task task = entry.getValue();
            System.out.println(taskId + ". Task: " + task.name);
            System.out.println("Task Info:");
            System.out.println("TaskId:" + taskId);
            System.out.println("Description: " + task.description);
            System.out.println("Status: " + task.status);

            if(!task.subtasks.isEmpty()){
                System.out.println("\nSubtasks:");
                for (Map.Entry<Integer, Task> subEntry : task.subtasks.entrySet()) {
                    Task subtask = subEntry.getValue();
                    System.out.println("\tSubtask: " + subtask.name);
                    System.out.println("\tSubtaskId: " + subtask.id);
                    System.out.println("\tDescription: " + subtask.description);
                    System.out.println("\tStatus: " + subtask.status);
                }
            }
            System.out.println("\n");
        }
    }

    public void clearAllTasks(){
        if(tasks.isEmpty()){
            System.out.println("There are no tasks! Nothing to delete!");
            return;
        }
        getAllTasks();

        System.out.println("Are you sure you want to delete all tasks? [Y/N]");

        while(true){
            String input = scanner.nextLine().trim();
            while(input.isEmpty()){
                System.out.println("Invalid input. Please try again!");
            }

            char userInput = Character.toUpperCase(input.charAt(0));

            if(userInput == 'Y'){
                tasks.clear();
                System.out.println("All Tasks deleted!");
                return;
            } else if (userInput == 'N') {
                System.out.println("Deletion process was canceled, back to menu...");
                return;
            } else {
                System.out.println("Invalid input. Please try again! [Y/N]");
            }
        }
    }

    public void getTask(){
        System.out.println("Which task would you like to find? Input its id");

        while(true){
            int id = Integer.parseInt(scanner.nextLine());
            if(!tasks.containsKey(id)){
                System.out.println("Task doesn't exist! Please try again!");
            } else {
                Task task = tasks.get(id);
                System.out.println("Task: " + task.name);
                System.out.println("Task Info:");
                System.out.println("Description: " + task.description);
                System.out.println("Status: " + task.status);
                if(!task.subtasks.isEmpty()){
                    System.out.println("\nSubtasks:");
                    for (Map.Entry<Integer, Task> subEntry : task.subtasks.entrySet()) {
                        Task subtask = subEntry.getValue();
                        System.out.println("\tSubtask: " + subtask.name);
                        System.out.println("\tDescription: " + subtask.description);
                    }
                }
                System.out.println("\n");
                System.out.println("What you find another task? [Y]");
                String input = scanner.nextLine().trim();
                if(Character.toUpperCase(input.charAt(0)) != 'Y'){
                    System.out.println("Back to menu...");
                    return;
                }
            }
        }
    }

    public void upDateTask(){

        Task task = new Task();
        getAllTasks();
        System.out.println("Which task would you like to update? Input its id");

        int userInput;
        boolean flag = true;
        while(flag){

            if(!scanner.hasNextInt()){
                System.out.println("Invalid input. Please try again!");
                scanner.next();
            }

            userInput = scanner.nextInt();
            scanner.nextLine();
            if(!tasks.containsKey(userInput)){
                System.out.println("Task doesn't exist! Please try again!");
                continue;
            }

            task = tasks.get(userInput);
            flag = false;
        }

        System.out.println("What would you like to update?\n");
        System.out.println("[1] Name");
        System.out.println("[2] Description");
        System.out.println("[3] Status");
        System.out.println("[4] Subtasks");

        while(true){
            while(!scanner.hasNextInt()){
                System.out.println("Invalid input. Please try again!");
                scanner.next();
            }
            userInput = scanner.nextInt();
            scanner.nextLine();
            if(userInput < 1 || userInput > 4){
                System.out.println("Invalid input. Try again!");
                continue;
            }

            switch(userInput){
                case 1 -> update("name", task);
                case 2 -> update("description", task);
                case 3 -> update("status", task);
                case 4 -> update("subtasks", task);
            }
            System.out.println("Updated! Back to menu...");
            return;

        }
    }

    public void update(String taskField, Task task) {
        switch(taskField) {
            case "name":
                System.out.println("Task name: " + task.name);
                System.out.println("Input new name:");
                task.name = scanner.nextLine();
                break;
            case "description":
                System.out.println("Task description: " + task.description);
                System.out.println("Input new description:");
                task.description = scanner.nextLine();
                break;
            case "status":
                System.out.println("Task status: " + task.status);
                System.out.println("Input new status: NEW / IN_PROGRESS / DONE");
                String newStatus = scanner.nextLine().trim().toUpperCase();
                try {
                    task.status = Status.valueOf(newStatus);

                    if(task.parentId != -1){
                        Task parentTask = tasks.get(task.parentId);

                        // collect all subtasks of this parent
                        Collection<Task> subtasks = parentTask.subtasks.values();

                        // update parent status based on subtasks
                        if(subtasks.stream().allMatch(sub -> sub.status == Status.NEW)){
                            parentTask.status = Status.NEW;
                        } else if(subtasks.stream().allMatch(sub -> sub.status == Status.DONE)){
                            parentTask.status = Status.DONE;
                        } else {
                            parentTask.status = Status.IN_PROGRESS;
                        }
                    }

                } catch (IllegalArgumentException e) {
                    System.out.println("Invalid status! Status not changed.");
                }
                break;

            case "subtasks":
                if(task.subtasks.isEmpty()){
                    System.out.println("There are no subtasks!");
                    return;
                }

                System.out.println("Which subtask would you like to update? Input its id");
                int subtaskId;
                while(true){
                    try {
                        subtaskId = Integer.parseInt(scanner.nextLine());
                        if(!task.subtasks.containsKey(subtaskId)){
                            System.out.println("Subtask doesn't exist! Try again:");
                        } else {
                            break;
                        }
                    } catch(NumberFormatException e){
                        System.out.println("Invalid input. Enter a number:");
                    }
                }

                System.out.println("What would you like to change?");
                System.out.println("[1] Name");
                System.out.println("[2] Description");
                System.out.println("[3] Status");

                int choice;
                while(true){
                    try {
                        choice = Integer.parseInt(scanner.nextLine());
                        switch(choice){
                            case 1 -> update("name", task.subtasks.get(subtaskId));
                            case 2 -> update("description", task.subtasks.get(subtaskId));
                            case 3 -> update("status", task.subtasks.get(subtaskId));
                            default -> {
                                System.out.println("Invalid choice! Try again:");
                                continue;
                            }
                        }
                        break;
                    } catch(NumberFormatException e){
                        System.out.println("Invalid input! Enter a number:");
                    }
                }
            break;
        }
    }





    public void removeTask(){

        if (tasks.isEmpty()){
            System.out.println("There are no tasks! Nothing to delete!");
            return;
        }
        getAllTasks();

        System.out.println("Which task would you like to remove?");
        while(true){
            while(!scanner.hasNextInt()) {
                System.out.println("Invalid input. Please try again!");
                scanner.next();
            }

            userInput = scanner.nextInt();
            scanner.nextLine();

            if(!tasks.containsKey(userInput)){
                System.out.println("Task doesn't exist! Please try again!");
            } else {
                tasks.remove(userInput);
                System.out.println("Task Deleted!");
                System.out.println("Backing...");
                return;
            }
        }
    }
}
