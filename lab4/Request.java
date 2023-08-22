class Request { 
    private final int distance;
    private final int num;
    private final int time;

    Request(int distance, int num, int time) { 
        this.distance = distance;
        this.num = num;
        this.time = time;
    }
 
    public int computeFare(Service service) { 
        return service.computeFare(this.distance, this.num, this.time);
    }

    public int computeFare(int d, int n, int t) {
        return 0;
    }

    @Override 
    public String toString() {
        return this.distance + "km for " + this.num + "pax" + " @ " + this.time + "hrs"; 
    }

}
