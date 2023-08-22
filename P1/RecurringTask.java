class RecurringTask extends OGTask {
    private final Task task;
    private final int freq;
    private final int numOccur;
    private final ImList<OGTask> taskList;

    RecurringTask(Task task, int freq, int numOccur) {
        this.task = task;
        this.freq = freq;
        this.numOccur = numOccur;
        ImList<OGTask> list = new ImList<OGTask>().add(this.task);
        int counter = this.task.getDay();
        for (int i = 0; i < this.numOccur - 1; i++) {
            counter += this.freq;
            list  = list.add(new Task(counter, this.task.getStart(), this.task.getEnd(),
                      this.task.getDescription())); 
        }

        this.taskList = list;        
    }

    RecurringTask(Task task, int freq, int numOccur, ImList<OGTask> taskList) {
        this.task = task;
        this.freq = freq;
        this.numOccur = numOccur;
        this.taskList = taskList;
    }
    
    @Override
    int getEnd() {
        return 0;
    }

    @Override
    int getDay() {
        return 0;
    }

    @Override 
    boolean getIdentifier() {
        return true;
    }
    
    @Override 
    int getStart() {
        return 0;
    }
    
    @Override 
    ImList<OGTask> getTaskList() {
        return this.taskList;
    }

    @Override
    public String toString() {
        String s =  "Recurring Task: " + this.task.getDay() + "," + 
            this.task.getStart() + "," + this.task.getEnd() + "," + this.task.getDescription();
        int num = 0;
        for (OGTask t: this.taskList) {
            num += 1;
            String a = "\n" + "#" + num + ":" + t.toString();
            s += a;
        }
        return s; 
    }
  
    
    CancelledRecurringTask cancel() {
        return new CancelledRecurringTask(this.task.getDay(), 
            this.task.getStart(), this.task.getEnd(), this.task.getDescription() + "[cancelled]");
    }
    
    RecurringTask cancel(int index) {
        int i = index - 1;
        OGTask t = this.taskList.get(i);
        ImList<OGTask> newlist = this.taskList.set(i, 
            new CancelledTask(t.getDay(), this.task.getStart(), 
                this.task.getEnd(), this.task.getDescription() + "[cancelled]"));
        return new RecurringTask(this.task, this.freq,this.numOccur, newlist);
    }
    
    RecurringTask edit(int newstart, int newend) {
        return new RecurringTask(new Task(this.task.getDay(), newstart,
            newend, this.task.getDescription()), this.freq,this.numOccur);
    }

    RecurringTask edit(int occur, int newday, int newstart, int newend) {
        int i = occur - 1;
        ImList<OGTask> newlist = this.taskList.set(i, new Task(newday, newstart,newend,
             this.task.getDescription()));
        boolean sorted = false;
        OGTask temp;
        while (!sorted) {
            sorted = true;
            for (int j = 0; j < newlist.size() - 1; j++) {
                if (newlist.get(j).getDay() > newlist.get(j + 1).getDay()) {
                    temp = newlist.get(j);
                    newlist = newlist.set(j, newlist.get(j + 1));
                    newlist = newlist.set(j + 1, temp);
                    sorted = false;
                }
                if (newlist.get(j).getDay() == newlist.get(j + 1).getDay()) {
                    if (newlist.get(j).getStart() > newlist.get(j + 1).getStart()) {
                        temp = newlist.get(j);
                        newlist = newlist.set(j, newlist.get(j + 1));
                        newlist = newlist.set(j + 1, temp);
                        sorted = false;
                    }
                }
                if ((newlist.get(j).getDay() == newlist.get(j + 1).getDay()) &&
                   (newlist.get(j).getStart() > newlist.get(j + 1).getStart())) {
                    if (newlist.get(j).getEnd() > newlist.get(j + 1).getEnd()) {
                        temp = newlist.get(j);
                        newlist = newlist.set(j, newlist.get(j + 1));
                        newlist = newlist.set(j + 1, temp);
                        sorted = false;
                    }
                }
            }
        }
        return new RecurringTask(this.task, this.freq,this.numOccur, newlist);
    }

}
