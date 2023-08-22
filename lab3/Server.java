import java.util.function.Supplier;

class Server { 
    private final double entryTime;
    private final Customer customer;
    private final int serverID;
    private final ImList<Customer> customerQueue;
    private final double busyUntilTime;
    private final Supplier<Double> restTime;
    private final int numOfServers;

    Server(double entryTime, Customer customer, int serverID, 
        ImList<Customer> customerQueue, double busyUntilTime, 
        Supplier<Double> restTime, int numOfServers) {
        this.entryTime = entryTime;
        this.customer = customer;
        this.serverID = serverID; 
        this.customerQueue = customerQueue;      
        this.busyUntilTime = busyUntilTime;
        this.restTime = restTime;
        this.numOfServers = numOfServers;
    }

    double getEntryTime() { 
        return this.entryTime;
    }

    Customer getCustomer() {
        return this.customer;
    }

    Supplier<Double> getRestSupplier() {
        return this.restTime;
    }

    int getServerID() {
        return this.serverID;
    }

    ImList<Customer> getQueue() {
        return this.customerQueue; 
    }
    
    double getBusyUntilTime() {
        return this.busyUntilTime;
    }
    
    boolean getStatus(double currTime) {
        if (this.busyUntilTime <= currTime) {
            return false; 
        } else {
            return true;
        }
    }
    
    int getNumHumanServers() {
        return this.numOfServers;
    }

    double getRestTime() {
        return this.getRestSupplier().get();
    }

    ImList<Server> getSelfCheckList() {
        return new ImList<Server>();
    }

    int getAvailableIndex(double currTime) {
        return 0;
    }

    ImList<Server> updateList(ImList<Customer> c) {
        return new ImList<Server>();
    }
    
    Server getEarliestServer() {
        return this;
    }

    @Override
    public String toString() {
        if (this.serverID > this.numOfServers) {
            return "self-check ";
        } else {
            return "";
        }
    }

    Server getServerWithinList(int index) {
        return this;
    }

    Server getNewServerServing(Customer c, double eventTime, int serverID, boolean eventFlag) {
        double endTime = c.getServiceTime() + eventTime;
        if (eventFlag == false) {
            Server serving = new Server(eventTime, c, serverID, this.getQueue(), endTime, 
                this.getRestSupplier(), this.numOfServers);
            return serving;
        } else {
            Server serving = new Server(eventTime, c, serverID, this.getQueue().remove(0), 
                endTime, this.getRestSupplier(), this.numOfServers);
            return serving;
        }
    }

    Server getNewServerUpdateQueue(ImList<Customer> custQueue, Server s, double eventTime,
        Customer c) {
        Server b = new Server(s.getEntryTime(), s.getCustomer(), s.getServerID(), custQueue, 
            s.getBusyUntilTime(), s.getRestSupplier(), this.numOfServers);
        return b;
    }

    Server updateRestTiming() {
        Server newS = new Server(this.getEntryTime(), this.getCustomer(),
            this.getServerID(), this.getQueue(), this.getBusyUntilTime() + this.getRestTime(),
                this.getRestSupplier(), this.getNumHumanServers());
        return newS;
    }

}

