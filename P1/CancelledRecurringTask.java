class CancelledRecurringTask extends CancelledTask { 

    CancelledRecurringTask(int day, int start, int end, String description) {
        super(day,start,end,description);
    }

    @Override 
    public String toString() {
        return "Recurring Task: " + this.getDay() + "," + this.getStart() + "," +
         this.getEnd() + "," + this.getCancelledDescription();
    }

}
    
