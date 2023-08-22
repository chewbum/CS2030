class CancelledTask extends OGTask {
    private final int day;
    private final int start;
    private final int end;
    private final String description;
     
    CancelledTask(int day, int start, int end, String description) {
        this.day = day;
        this.start = start;
        this.end = end;
        this.description = description;
    }


    @Override 
    public String toString() {
        return "Task: " + this.day + "," + this.start + "," + this.end + "," + this.description;
    }
   
    @Override
    int getDay() {
        return this.day;
    }
    
    @Override 
    boolean getIdentifier() {
        return false;
    }
    
    @Override
    int getStart() {
        return this.start;
    }
  
    @Override 
    ImList<OGTask> getTaskList() {
        return new ImList<OGTask>();
    }

    String getCancelledDescription() {
        return this.description;
    }
    
    @Override
    int getEnd() {
        return this.end;
    }

}
