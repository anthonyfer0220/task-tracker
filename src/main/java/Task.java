public class Task {
    private int id;
    private String description;
    private String status;

    public Task(int id, String description) {
        this.id = id;
        this.description = description;
        this.status = "todo";
    }

    // Getters and Setters
    public int getId() { return id; }

    public String getDescription() { return description; }

    public void setDescription(String description) { this.description = description; }

    public String getStatus() { return status; }

    public void setStatus(String status) { this.status = status; }

    @Override
    public String toString() {
        return "Task { id=" + id + ", description=" + description +
                ", status=" + status + " }";
    }
}
