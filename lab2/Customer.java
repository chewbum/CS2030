class Customer {
    private final double arrivalTime;
    private final double serviceTime;
    private final int id;

    Customer(double arrivalTime, double serviceTime, int id) {
        this.arrivalTime = arrivalTime;
        this.serviceTime = serviceTime;
        this.id = id;
    }

    double getArrival() {
        return this.arrivalTime;
    }

    double getServiceTime() {
        return this.serviceTime;
    }
    
    int getID() {
        return this.id;
    }
}

