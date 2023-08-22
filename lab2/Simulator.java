class Simulator { 
    private final int numOfServers;
    private final ImList<Double> arrivalTimes;
    private final ImList<Double> serviceTimes;
    private static final int numLeave = 3;   
    private static final int numDone = 4;

    Simulator(int numOfServers,ImList<Double> arrivalTimes,ImList<Double> serviceTimes) {
        this.numOfServers = numOfServers;
        this.arrivalTimes = arrivalTimes;
        this.serviceTimes = serviceTimes;


    }

    ImList<Double> arrivalList() {
        return this.arrivalTimes;
    } 

    ImList<Double> serviceList() {
        return this.serviceTimes;
    }
    

    int getNum() {
        return this.numOfServers;
    }

    String simulate() {
        ImList<Server> serverList = new ImList<Server>();
        for (int k = 0; k < this.getNum(); k++) {
            serverList = serverList.add(new Server(0,0, k + 1));
        }

        ImList<Customer> customerList = new ImList<Customer>();
        PQ<Event> queue = new PQ<Event>(new PQComparator());
        String s = "";
        int servedCounter = 0;
        int leftCounter = 0;
        
        for (int i = 0; i < this.arrivalList().size(); i++) {
            customerList = customerList.add(new Customer(this.arrivalList().get(i),
                               this.serviceList().get(i), i + 1));
            Arrival a = new Arrival(this.arrivalList().get(i), customerList.get(i));
            queue = queue.add(a);
        }

        while (queue.isEmpty() != true) {
   
            Pair<Event, PQ<Event>> pr = queue.poll(); 
            Event out = pr.first();
            s += out.toString();

            if (out.getUniqueNum() == this.numDone) {
                servedCounter += 1;
            }
            
            if (out.getUniqueNum() == this.numLeave) {
                leftCounter += 1;
            }
            
            queue = out.getHelper(serverList, pr.second()).second();
            serverList = out.getHelper(serverList, pr.second()).first();
            
        }  
    
        s += "[" + servedCounter + " " + leftCounter + "]";
        return s;
    } 
}
