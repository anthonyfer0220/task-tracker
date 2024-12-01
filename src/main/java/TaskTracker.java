public class TaskTracker {
    public static void main(String[] args) {
        TaskManager taskManager = new TaskManager();

        if (args.length == 0) {
            System.out.println("Usage: java TaskTracker <task name>");
            return;
        }

        String taskName = args[0];
        try {
            switch (taskName) {
                case "add":
                    String taskDescription = args[1];
                    taskManager.addTask(taskDescription);
            }
        }
    }
}
