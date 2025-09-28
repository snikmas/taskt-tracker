import java.util.HashMap;

public class Task {

    int id;
    String name;
    String description;
    Status status;

    int parentId = -1;
    public HashMap<Integer, Task> subtasks = new HashMap<>();


}