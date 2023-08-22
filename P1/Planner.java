class Planner { 
    private final ImList<OGTask> taskList;

    Planner() {
        this.taskList = new ImList<OGTask>();
    }
    
    Planner(OGTask t, ImList<OGTask> list) {
        this.taskList = list.add(t);
    }

    @Override 
    public String toString() {
        String s = "\n";
        int listsize = this.taskList.size() - 1;
        for (OGTask t : this.taskList) {
            if (this.taskList.indexOf(t) == listsize) {
                s += String.format("%s", t);
                continue;
            }
            s += String.format("%s\n", t); 
        }
        return s;
    }

    Planner add(OGTask t) {
        return new Planner(t, this.taskList);
    }
    
    void view(View day) {
        day.view(this.taskList);
    }

}
