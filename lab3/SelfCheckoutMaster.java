import java.util.function.Supplier;

class SelfCheckoutMaster extends Server {
    private final ImList<Server> selfCheckList;
 
    SelfCheckoutMaster(double entryTime, Customer customer, int serverID,
        ImList<Customer> customerQueue, double busyUntilTime, 
        Supplier<Double> restTime, int numOfServers, ImList<Server> selfCheckList) {
        super(entryTime, customer, serverID, customerQueue, busyUntilTime, restTime, numOfServers);
        this.selfCheckList = selfCheckList;
    }
    
    SelfCheckoutMaster(double entryTime, Customer customer, int serverID,
        ImList<Customer> customerQueue, double busyUntilTime, 
        Supplier<Double> restTime, int numOfServers) {
        super(entryTime, customer, serverID, customerQueue, busyUntilTime, restTime, numOfServers);
        ImList<Server> s = new ImList<Server>();
        this.selfCheckList = s;
    }

    @Override 
    double getRestTime() {
        return 0;
    }

    @Override 
    public boolean getStatus(double currTime) {
        for (int i = 0; i < this.selfCheckList.size(); i++) {
            if (selfCheckList.get(i).getStatus(currTime) == false) {
                return false;
            }
        }
        return true;
    }

    @Override 
    ImList<Server> getSelfCheckList() {
        return this.selfCheckList;
    }

    @Override 
    int getAvailableIndex(double currTime) {
        for (int i = 0; i < this.selfCheckList.size(); i++) {
            if (selfCheckList.get(i).getStatus(currTime) == false) {
                return i;
            }
        }
        return 0;
    }
    
    @Override 
    ImList<Server> updateList(ImList<Customer> c) {
        ImList<Server> a = this.selfCheckList;
        for (int i = 0; i < this.selfCheckList.size(); i++) {
            Server s = this.selfCheckList.get(i);
            Server b = new Server(s.getEntryTime(), s.getCustomer(),
                s.getServerID(), c, s.getBusyUntilTime(), s.getRestSupplier(), 
                    this.getNumHumanServers());
            a = a.set(i,b);
        }
        return a;
    }

    @Override
    double getBusyUntilTime() {
        double min = this.selfCheckList.get(0).getBusyUntilTime();
        for (int i = 0; i < this.selfCheckList.size(); i++) {
            if (this.selfCheckList.get(i).getBusyUntilTime() < min) {
                min = this.selfCheckList.get(i).getBusyUntilTime();
            }
        }
        return min;
    }
    
    @Override
    Server getEarliestServer() {
        int minIndex = 0;
        double min = this.selfCheckList.get(0).getBusyUntilTime();
        for (int i = 0; i < this.selfCheckList.size(); i++) {
            if (this.selfCheckList.get(i).getBusyUntilTime() < min) {
                min = this.selfCheckList.get(i).getBusyUntilTime();
                minIndex = i;
            }
        }
        return this.selfCheckList.get(minIndex);
    }

    @Override
    Server getNewServerServing(Customer c, double eventTime, int serverID, boolean eventFlag) {
        double endTime = c.getServiceTime() + eventTime;
        if (eventFlag == false) {
            int index = this.getAvailableIndex(eventTime);
            Server newSelfCheck = new Server(eventTime, c, serverID, this.getQueue(), endTime, 
                this.getRestSupplier(), this.getNumHumanServers());
            SelfCheckoutMaster s = new SelfCheckoutMaster(eventTime, c, serverID - index, 
                this.getQueue(), endTime, this.getRestSupplier(), this.getNumHumanServers(),
                    this.getSelfCheckList().set(index, newSelfCheck));
            return s;
        } else {
            int index = serverID - this.getNumHumanServers() - 1;
            ImList<Customer> custQueue = this.getQueue().remove(0);
            Server newSelfCheck = new Server(eventTime, c, serverID, custQueue, endTime, 
                this.getRestSupplier(), this.getNumHumanServers());
            SelfCheckoutMaster s = new SelfCheckoutMaster(eventTime, c, 
                this.getNumHumanServers() + 1, custQueue, endTime, this.getRestSupplier(), 
                    this.getNumHumanServers(), this.updateList(custQueue)
                        .set(index, newSelfCheck));
            return s;
        }
    }

    @Override 
    Server getNewServerUpdateQueue(ImList<Customer> custQueue, Server s, double eventTime,
        Customer c) {
        SelfCheckoutMaster b = new SelfCheckoutMaster(eventTime, 
            c, s.getServerID(), custQueue,
                s.getBusyUntilTime(), s.getRestSupplier(), this.getNumHumanServers(),
                    s.updateList(custQueue));
        return b;
    }

    @Override
    Server getServerWithinList(int index) {
        return this.selfCheckList.get(index);
    }

    @Override
    Server updateRestTiming() {
        return this;
    }

}
