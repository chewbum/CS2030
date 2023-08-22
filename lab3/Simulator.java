import java.util.function.Supplier;

class Simulator { 
    private final int numOfServers;
    private final int numOfSelfChecks;
    private final int qmax;
    private final ImList<Double> arrivalTimes;
    private final Supplier<Double> serviceTime;
    private final Supplier<Double> restTime;

    Simulator(int numOfServers, int numOfSelfChecks, int qmax, ImList<Double> arrivalTimes,
        Supplier<Double> serviceTime, Supplier<Double> restTime) {
        this.numOfServers = numOfServers;
        this.numOfSelfChecks = numOfSelfChecks;
        this.qmax = qmax;
        this.arrivalTimes = arrivalTimes;
        this.serviceTime = serviceTime;
        this.restTime = restTime;

    }

    ImList<Double> arrivalList() {
        return this.arrivalTimes;
    } 
   
    int getNum() {
        return this.numOfServers;
    }

    int getQueueLimit() {
        return this.qmax;
    }

    String simulate() {
        ImList<Server> serverList = new ImList<Server>();
        if (this.numOfSelfChecks == 0) {
            for (int k = 0; k < this.getNum(); k++) {
                serverList = serverList.add(new Server(0, new Customer(0, this.serviceTime, 0),
                    k + 1, new ImList<Customer>(), 0, this.restTime, this.getNum()));
            }
        } else {
            for (int k = 0; k < this.getNum() + 1; k++) {
                if (k < this.getNum()) {
                    serverList = serverList.add(new Server(0, new Customer(0, 
                        this.serviceTime, 0),
                        k + 1, new ImList<Customer>(), 0, this.restTime, this.getNum()));
                } else {
                    ImList<Server> s = new ImList<Server>();
                    for (int i = 0; i < this.numOfSelfChecks; i++) {
                        s = s.add(new Server(0, new Customer(0, this.serviceTime, 0),
                            k + i, new ImList<Customer>(), 0, this.restTime, this.getNum()));
                    }
                    serverList = serverList.add(new SelfCheckoutMaster(0, 
                        new Customer(0, this.serviceTime, 0),
                            k + 1, new ImList<Customer>(), 0, this.restTime, this.getNum(), s));
                }
            }
        }

        ImList<Customer> customerList = new ImList<Customer>();
        PQ<Event> queue = new PQ<Event>(new PQComparator());
        String s = "";
        int servedCounter = 0;
        int leftCounter = 0;
        double waitTime = 0.0;

        for (int i = 0; i < this.arrivalList().size(); i++) {
            customerList = customerList.add(new Customer(this.arrivalList().get(i),
                               this.serviceTime, i + 1));
            Arrival a = new Arrival(this.arrivalList().get(i), customerList.get(i),
                this.numOfServers, this.getQueueLimit());
            queue = queue.add(a);
        }

        while (queue.isEmpty() != true) {
            
            Pair<Event, PQ<Event>> pr = queue.poll(); 
            Event out = pr.first();
            s += out.toString();

            if (out.getLeaveStatus() == true) {
                leftCounter += 1;
            }
            waitTime += out.getWaitTime(serverList, pr.second());
            Pair<ImList<Server>,PQ<Event>> eventPair = out.getUpdate(serverList, pr.second());
            queue = eventPair.second();
            serverList = eventPair.first();
        }  
        
        servedCounter = customerList.size() - leftCounter;
        if (servedCounter == 0) {
            waitTime = 0;
        } else {
            waitTime = waitTime / servedCounter; 
        }

        s += String.format("[%.3f %d %d]", waitTime, servedCounter, leftCounter);
        return s;
    } 
}
