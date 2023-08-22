class DayView implements View {
    private final int day;

    DayView(int day) {
        this.day = day;
    }
    
    @Override
    public void view(ImList<OGTask> tasks) { 
        ImList<OGTask> newtasklist = new ImList<OGTask>();
        for (OGTask t : tasks) { 
            if (t.getIdentifier() == false) {
                continue;
            } 
            if (t.getTaskList().isEmpty() == false) {
                for (OGTask rtTask : t.getTaskList()) {
                    if (rtTask.getIdentifier() == false) {
                        continue;
                    }
                    if (rtTask.getDay() == this.day) {
                        newtasklist = newtasklist.add(rtTask);
                    }
                }
                continue;
            }
            if (t.getDay() == this.day) {
                newtasklist = newtasklist.add(t);
            }
        } 
        boolean sorted = false;
        OGTask temp;
        while (!sorted) {
            sorted = true;
            for (int j = 0; j < newtasklist.size() - 1; j++) {
                if (newtasklist.get(j).getStart() > newtasklist.get(j + 1).getStart()) {
                    temp = newtasklist.get(j);
                    newtasklist = newtasklist.set(j, newtasklist.get(j + 1));
                    newtasklist = newtasklist.set(j + 1, temp);
                    sorted = false;
                }
            }
        }
        for (OGTask orderedTask : newtasklist) {
            System.out.println(orderedTask);
        }        
    }

}
