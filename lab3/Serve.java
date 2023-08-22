class Serve extends Event {
    private final Server server;
    private final double endTime;

    Serve(double eventTime, Customer customer, int numOfServers, Server server, double endTime) {
        super(eventTime, customer, numOfServers);
        this.server = server;
        this.endTime = endTime;
    }
  
    @Override
    public String toString() {
        return String.format("%.3f %d serves by %s%d\n", this.getEventTime(), 
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

        int index = this.server.getServerID() - 1 - this.getNumServers();

        if (this.getCust().getID() == s.getServerWithinList(index).getCustomer().getID()) {
            Done doneEvent = new Done(this.endTime, this.getCust(), this.getNumServers(), 
                s.getServerWithinList(index));
            queue = queue.add(doneEvent);
            return new Pair<ImList<Server>, PQ<Event>>(serverList, queue);
        } else { 
            Server b = s.getNewServerServing(this.getCust(), this.getEventTime(), 
                this.server.getServerID(), true);
            serverList = serverList.set(b.getServerID() - 1, b);
            Done doneEvent = new Done(b.getServerWithinList(index).getBusyUntilTime(), 
                this.getCust(), this.getNumServers(), b.getServerWithinList(index));
            queue = queue.add(doneEvent);
            return new Pair<ImList<Server>, PQ<Event>>(serverList, queue);
        }  
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
    
