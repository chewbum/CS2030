class Leave extends Event {
    private static final int num = 3;

    Leave(double eventTime, Customer customer) {
        super(eventTime,customer);
    }
   
    @Override
    public String toString() {
        return String.format("%.3f " +  this.getCust().getID() + " leaves\n", this.getEventTime());
    } 

    @Override
    Pair<ImList<Server>, PQ<Event>> getHelper(ImList<Server> serverList, PQ<Event> queue) {
        return new Pair<ImList<Server>, PQ<Event>>(serverList, queue);
    }
   
    @Override 
    int getUniqueNum() {
        return this.num;
    }

}
