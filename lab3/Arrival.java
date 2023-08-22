class Arrival extends Event {
    private final int qmax; 

    Arrival(double eventTime, Customer customer, int numOfServers, int qmax) {
        super(eventTime, customer, numOfServers);
        this.qmax = qmax;
    }
 
    @Override 
    public String toString() {
        return String.format("%.3f %d arrives\n",this.getEventTime(), this.getCust().getID());
    }
    
    @Override 
    Pair<ImList<Server>, PQ<Event>> getUpdate(ImList<Server> serverList, PQ<Event> queue) {
        for (int j = 0; j < serverList.size(); j++) {
            Server s = serverList.get(j); 
            if (s.getQueue().isEmpty() == true) { 
                if (s.getStatus(this.getEventTime()) == false) {
                    int index = s.getAvailableIndex(this.getEventTime());
                    Server a = s.getNewServerServing(this.getCust(), this.getEventTime(), 
                        j + index + 1, false);
                    serverList = serverList.set(j, a);
                    Serve serveEvent = new Serve(this.getEventTime(),
                        this.getCust(), this.getNumServers(), a.getServerWithinList(index),
                        a.getServerWithinList(index).getBusyUntilTime());
                    queue = queue.add(serveEvent);            
                    return new Pair<ImList<Server>, PQ<Event>>(serverList, queue);        
                }
            }   
        }  
                 
        for (int i = 0; i < serverList.size(); i++) {
            Server s = serverList.get(i);
            if (s.getQueue().size() < this.qmax) {
                ImList<Customer> custQueue = s.getQueue().add(this.getCust());
                Server b = s.getNewServerUpdateQueue(custQueue, s, this.getEventTime(),
                    this.getCust());
                Wait waitEvent = new Wait(this.getEventTime(), this.getCust(), 
                    this.getNumServers(), b, true);
                serverList = serverList.set(i, b);
                queue = queue.add(waitEvent);
                return new Pair<ImList<Server>, PQ<Event>>(serverList, queue);
            } else {
                continue;
            }
        }

        Leave leaveEvent = new Leave(this.getEventTime(), this.getCust(), this.getNumServers());
        queue = queue.add(leaveEvent);
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
