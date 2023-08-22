import java.util.function.Supplier;

class Customer {
    private final double arrivalTime;
    private final Supplier<Double> serviceTime;
    private final int id;

    Customer(double arrivalTime, Supplier<Double> serviceTime, int id) {
        this.arrivalTime = arrivalTime;
        this.serviceTime = serviceTime;
        this.id = id;
    }

    double getArrival() {
        return this.arrivalTime;
    }

    double getServiceTime() {
        return this.serviceTime.get();
    }
    
    int getID() {
        return this.id;
    }
}

