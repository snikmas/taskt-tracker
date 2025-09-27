import java.util.ArrayList;
import java.util.HashMap;

public class Task {

    int id;
    String name;
    String description;
    Status status;

    int parentId = -1;
    HashMap<Integer, Task> subtasks = new HashMap<>();

//    public Task() {
//        this.id = id;
//        this.name = name;
//        this.description = description;
//        this.status = status;
//    }


}