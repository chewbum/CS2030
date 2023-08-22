class Customer {
    private final double arrivalTime;
    private final double serviceTime;

    Customer(double arrivalTime, double serviceTime) {
        this.arrivalTime = arrivalTime;
        this.serviceTime = serviceTime;
    }

    double getArrival() {
        return this.arrivalTime;
    }

    double getServiceTime() {
        return this.serviceTime;
    }
}

