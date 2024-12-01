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
                    break;
                case "update":
                    int taskId = Integer.parseInt(args[1]);
                    String taskDesc = args[2];
                    taskManager.updateTask(taskId, taskDesc);
                    break;
                case "delete":
                    break;
                case "mark-in-progress":
                    break;
                case "mark-done":
                    break;
                case "list":
                    break;
                default:
                    System.out.println("Task " + taskName + " not found");
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
