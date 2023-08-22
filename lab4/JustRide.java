class JustRide extends Service { 
    private static final int fareDistance = 22; 
    private static final int peakHourLower = 600;
    private static final int peakHourUpper = 900;
    private static final int surchage = 500; 
    
    JustRide() {
    }
     
    @Override
    public int computeFare(int distance, int numPassengers, int serviceTime) { 
        int fare = distance * fareDistance; 
        if (serviceTime >= peakHourLower && serviceTime <= peakHourUpper) {
            fare += surchage; 
            return fare; 
        } else {
            return fare;
        }
    }

    @Override
    public int computeFare(Service s) {
        return 0;
    }

    @Override
    public String toString() { 
        return "JustRide"; 
    }

}
