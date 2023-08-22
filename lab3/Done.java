class Done extends Event {
    private final Server server;

    Done(double eventTime, Customer customer, int numOfServers, Server server) {
        super(eventTime, customer, numOfServers);
        this.server = server;
    }

    @Override
    public String toString() {
        return String.format("%.3f %d done serving by %s%d\n", this.getEventTime(), 
            this.getCust().getID(), this.server.toString(), this.server.getServerID());
    }
 
    @Override
    Pair<ImList<Server>, PQ<Event>> getUpdate(ImList<Server> serverList, PQ<Event> queue) {
        Server s;
        if (this.server.getServerID() <= this.getNumServers()) {
            s = serverList.get(this.server.getServerID() - 1);
        } else {
            s = serverList.get(this.getNumServers());
        }
        Server newS = s.updateRestTiming();
        serverList = serverList.set(this.server.getServerID() - 1, newS);
        return new Pair<ImList<Server>, PQ<Event>>(serverList, queue);
    }

    @Override
    boolean getLeaveStatus() {
        return false;
    } 
    
    @Override
    double getWaitTime(ImList<Server> serverList, PQ<Event> queue) {
        return 0.0;
    }
}
