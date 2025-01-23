public class Task {
    protected String description;
    protected boolean isDone;

    public Task(String description) {
        this.description = description;
        this.isDone = false;
    }

    public String getStatusIcon() {   //Marks a checkbox
        return (isDone ? "X" : " ");
    }

    public void markAsDone() {  //marks isDone as true
        isDone = true;
    }

    public void markAsNotDone() { //marks isDone as false
        isDone = false;
    }

    @Override
    public String toString() {  //default task string
        return "[" + getStatusIcon() + "] " + description;
    }
}
