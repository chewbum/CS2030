class Arrival extends Event {
    private static final int num = 1;

    Arrival(double eventTime, Customer customer) {
        super(eventTime, customer);
    }
 
    @Override 
    public String toString() {
        return String.format("%.3f " + this.getCust().getID() + " arrives\n",
                            this.getEventTime());
    }
    
    @Override 
    Pair<ImList<Server>, PQ<Event>> getHelper(ImList<Server> serverList, PQ<Event> queue) {
        for (int j = 0; j < serverList.size(); j++) {
            if (serverList.get(j).getStatus(this.getEventTime()) == false) {
                Server serving = new Server(this.getEventTime(),
                                  this.getCust().getServiceTime(), j + 1);
                serverList = serverList.set(j,serving);
                Serve serveEvent = new Serve(this.getEventTime(), this.getCust(), serving);
                queue = queue.add(serveEvent);
                break;
            }

            if (j == serverList.size() - 1) {
                Leave leaveEvent = new Leave(this.getEventTime(), this.getCust());
                queue = queue.add(leaveEvent);
            }
        }
        return new Pair<ImList<Server>, PQ<Event>>(serverList, queue);
    }
  
    @Override 
    int getUniqueNum() {
        return this.num;
    }  
      
}
