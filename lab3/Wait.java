class Wait extends Event {
    private final Server server; 
    private final boolean firstTime;

    Wait(double eventTime, Customer customer, int numOfServers, Server server, boolean firstTime) {
        super(eventTime, customer, numOfServers);
        this.server = server;
        this.firstTime = firstTime;
    }

    @Override
    public String toString() {
        if (this.firstTime) {
            if (this.server.getServerID() < this.getNumServers() + 1) {
                return String.format("%.3f %d waits at %d\n", this.getEventTime(), 
                    this.getCust().getID(), this.server.getServerID());
            } else {
                int waitingSelf = this.getNumServers() + 1;
                return String.format("%.3f %d waits at self-check %d\n", this.getEventTime(), 
                    this.getCust().getID(), waitingSelf);
            }
        } else { 
            return "";
        }
    }

    @Override
    Pair<ImList<Server>, PQ<Event>> getUpdate(ImList<Server> serverList, PQ<Event> queue) {
        Server s = serverList.get(this.server.getServerID() - 1);
        if (s.getBusyUntilTime() > this.getEventTime() || 
                s.getQueue().indexOf(this.getCust()) != 0) {
            Wait waitEvent = new Wait(s.getBusyUntilTime(), this.getCust(), 
                this.getNumServers(), s, false);
            queue = queue.add(waitEvent);
            return new Pair<ImList<Server>, PQ<Event>>(serverList, queue);
        } else {
            Serve serveEvent = new Serve(s.getBusyUntilTime(), this.getCust(), 
                this.getNumServers(), s.getEarliestServer(), s.getBusyUntilTime());
            queue = queue.add(serveEvent);
            return new Pair<ImList<Server>, PQ<Event>>(serverList, queue);
        } 
    }
    

    @Override
    boolean getLeaveStatus() {
        return false;
    } 
       
    double getWaitTime(ImList<Server> serverList, PQ<Event> queue) {
        Server s = serverList.get(this.server.getServerID() - 1);
        return s.getBusyUntilTime() - this.getEventTime();
    }
}  
