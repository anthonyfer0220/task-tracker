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

    private void saveTasks() {
        try (Writer writer = new FileWriter(fileName)) {
            new Gson().toJson(tasks, writer);
        } catch (IOException e) {
            System.out.println("Error writing tasks file: " + e.getMessage());
        }
    }

    private void addTask(String description) {
        int id = tasks.isEmpty() ? 1 : tasks.get(tasks.size() - 1).getId() + 1;
        tasks.add(new Task(id, description));
        saveTasks();
        System.out.println("Task added successfully (ID: " + id + ')');
    }

    private void updateTask(int id, String description) {
        Task task = tasks.get(id);
        if (task != null) {
            task.setDescription(description);
            saveTasks();
            System.out.println("Task updated successfully");
        } else {
            System.out.println("Task not found");
        }
    }

    private void deleteTask(int id) {
        Task task = tasks.get(id);
        if (task != null) {
            tasks.remove(task);
            saveTasks();
            System.out.println("Task deleted successfully");
        } else {
            System.out.println("Task not found");
        }
    }

    private void mark(int id, String status) {
        Task task = tasks.get(id);
        if (task != null) {
            task.setStatus(status);
            saveTasks();
            System.out.println("Task marked successfully");
        } else {
            System.out.println("Task not found");
        }
    }

    private void listTasks() {
        for (Task t : tasks) {
            System.out.println(t.getDescription());
        }
    }

    private void listTasks(String status) {
        for (Task t : tasks) {
            if (t.getStatus().equals(status)) {
                System.out.println(t.getDescription());
            }
        }
    }
}
