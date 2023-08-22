class Serve extends Event {
    private final Server server;
    private static final int num = 2; 


    Serve(double eventTime, Customer customer, Server server) {
        super(eventTime, customer);
        this.server = server;
    }
  
    @Override
    public String toString() {
        return String.format("%.3f " + this.getCust().getID() + " serves by "
                      + server.getServerID() + "\n", this.getEventTime());
    }
    
    @Override
    Pair<ImList<Server>, PQ<Event>> getHelper(ImList<Server> serverList, PQ<Event> queue) {
        Done doneEvent = new Done(this.server.busyUntilTime(), this.getCust(), this.server);
        queue = queue.add(doneEvent);
        return new Pair<ImList<Server>, PQ<Event>>(serverList, queue);
    }

    @Override
    int getUniqueNum() {
        return this.num;
    }
 
}
    
