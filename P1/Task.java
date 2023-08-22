class Task extends OGTask {
    private final int day;
    private final int start;
    private final int end;
    private final String description;
    private final ImList<OGTask> tasks;

    Task(int day, int start, int end, String description) {
        this.day = day;
        this.start = start;
        this.end = end;
        this.description = description;
        this.tasks = new ImList<OGTask>();
    }


    @Override 
    public String toString() {
        return "Task: " + this.day + "," + this.start + "," + this.end + "," + this.description;
    }

    Task edit(int newstart, int newend) {
        return new Task(this.day, newstart, newend, this.description);
    }

    CancelledTask cancel() {
        return new CancelledTask(this.day, this.start, this.end, this.description + "[cancelled]");
    }
    
    @Override 
    boolean getIdentifier() {
        return true;
    }
 
    @Override
    int getDay() {
        return this.day;
    }

    @Override
    int getStart() {
        return this.start;
    }
   
    @Override 
    ImList<OGTask> getTaskList() {
        return this.tasks;
    }
    
    @Override
    int getEnd() {
        return this.end;
    }

    String getDescription() {
        return this.description;
    }

}
