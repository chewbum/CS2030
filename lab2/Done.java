class Done extends Event {
    private static final int num = 4;
    private final Server server;

    Done(double eventTime, Customer customer, Server server) {
        super(eventTime, customer);
        this.server = server;
    }

    @Override
    public String toString() {
        return String.format("%.3f " +  this.getCust().getID() + " done serving by "
                        + server.getServerID() + "\n", this.getEventTime());
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
