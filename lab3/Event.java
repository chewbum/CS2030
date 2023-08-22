abstract class Event {
    private final double eventTime;
    private final Customer customer;
    private final int numOfServers;

    Event(double eventTime, Customer customer, int numOfServers) {
        this.eventTime = eventTime;
        this.customer = customer;
        this.numOfServers = numOfServers;
    }
   
    public double getEventTime() {
        return this.eventTime;
    }

    public Customer getCust() {
        return this.customer;
    }
   
    public int getNumServers() {
        return this.numOfServers;
    }

    abstract Pair<ImList<Server>, PQ<Event>> getUpdate(ImList<Server> serverList, PQ<Event> queue);

    abstract boolean getLeaveStatus();
    
    abstract double getWaitTime(ImList<Server> serverList, PQ<Event> queue);
     
}
