abstract class Event {
    protected final double eventTime;
    protected final Customer customer;

    Event(double eventTime, Customer customer) {
        this.eventTime = eventTime;
        this.customer = customer;
    }
   
    public double getEventTime() {
        return this.eventTime;
    }

    public Customer getCust() {
        return this.customer;
    }
   
    abstract Pair<ImList<Server>, PQ<Event>> getHelper(ImList<Server> serverList, PQ<Event> queue);

    abstract int getUniqueNum();

}
