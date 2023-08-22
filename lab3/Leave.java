class Leave extends Event {
   
    Leave(double eventTime, Customer customer, int numOfServers) {
        super(eventTime,customer, numOfServers);
    }
   
    @Override
    public String toString() {
        return String.format("%.3f %d leaves\n", this.getEventTime(), this.getCust().getID());
    } 

    @Override
    Pair<ImList<Server>, PQ<Event>> getUpdate(ImList<Server> serverList, PQ<Event> queue) {
        return new Pair<ImList<Server>, PQ<Event>>(serverList, queue);
    }
   
    @Override
    boolean getLeaveStatus() {
        return true;
    } 
    
    @Override
    double getWaitTime(ImList<Server> serverList, PQ<Event> queue) {
        return 0.0;
    }

}
