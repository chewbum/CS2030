class Shop { 
    private final int numOfServers;
    private final ImList<Double> arrivalTimes;
    private final ImList<Double> serviceTimes;
   

    Shop(int numOfServers,ImList<Double> arrivalTimes,ImList<Double> serviceTimes) {
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

    @Override 
    public String toString() {
        return this.helper();
    }

    String helper() {
            
        ImList<Server> serverList = new ImList<Server>();
        for (int k = 0; k < this.getNum(); k++) {
            serverList = serverList.add(new Server(0,0));
        }

        ImList<Customer> customerList = new ImList<Customer>();
        String s = "";
        int servedCounter = 0;
        int leftCounter = 0;
        for (int i = 0; i < this.arrivalList().size(); i++) {
            customerList = customerList.add(new Customer(this.arrivalList().get(i),
                            this.serviceList().get(i)));
            s += String.format("%.3f" + " customer " + (i + 1) + " arrives\n",
                           customerList.get(i).getArrival());
            for (int j = 0; j < this.getNum(); j++) {

                if (serverList.get(j).getStatus(customerList.get(i).getArrival()) == false) { 
                    serverList = serverList.set(j,
                        new Server(customerList.get(i).getArrival(),
                    customerList.get(i).getServiceTime()));
                    s += String.format("%.3f" + " customer " + (i + 1) + " served by server "
                    + (j + 1) + "\n",customerList.get(i).getArrival());
                    servedCounter += 1;
                    break; 
                }
                if (j == serverList.size() - 1) {
                    s += String.format("%.3f" + " customer " + (i + 1) + " leaves\n",
                    customerList.get(i).getArrival());
                    leftCounter += 1;
                }   
            }
        }   
    
        s += "[" + servedCounter + " " + leftCounter + "]";
        return s;
    } 

}
