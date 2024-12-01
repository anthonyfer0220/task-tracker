public class TaskTracker {
    public static void main(String[] args) {
        TaskManager taskManager = new TaskManager();

        if (args.length == 0) {
            System.out.println("Usage: java TaskTracker <task name>");
            return;
        }

        int taskId;

        String taskName = args[0];
        try {
            switch (taskName) {
                case "add" -> {
                    String taskDescription = args[1];
                    taskManager.addTask(taskDescription);
                }
                case "update" -> {
                    taskId = Integer.parseInt(args[1]);
                    String taskDesc = args[2];
                    taskManager.updateTask(taskId, taskDesc);
                }
                case "delete" -> {
                    taskId = Integer.parseInt(args[1]);
                    taskManager.deleteTask(taskId);
                }
                case "mark-in-progress" -> {
                    taskId = Integer.parseInt(args[1]);
                    taskManager.mark(taskId, "in-progress");
                }
                case "mark-done" -> {
                    taskId = Integer.parseInt(args[1]);
                    taskManager.mark(taskId, "done");
                }
                case "list" -> {
                    if (args[1] == null) {
                        taskManager.listTasks();
                    } else {
                        String status = args[1];
                        taskManager.listTasks(status);
                    }
                }
                default -> System.out.println("Task " + taskName + " not found");
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
