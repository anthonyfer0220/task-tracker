import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.*;
import java.util.*;

public class TaskManager {
    private final String fileName = "tasks.json";
    private List<Task> tasks = new ArrayList<>();

    public TaskManager() {
        loadTasks();
    }

    private void loadTasks() {
        File file = new File(fileName);
        if (file.exists()) {
            try (Reader reader = new FileReader(file)) {
                tasks = new Gson().fromJson(reader, new TypeToken<List<Task>>() {}.getType());
            } catch (IOException e) {
                System.out.println("Error reading tasks file: " + e.getMessage());
            }
        }
    }
}
