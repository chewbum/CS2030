class ShareARide extends Service { 
    private static final int fareDistance = 50; 
    private static final int surcharge = 500;
    private static final int lowerHour = 600; 
    private static final int upperHour = 900;
    
    ShareARide() {
    }  
    
    @Override 
    public int computeFare(int distance, int numPassengers, int serviceTime) {
        int fare = distance * fareDistance; 
        if (serviceTime >= lowerHour  && serviceTime <= upperHour) {
            fare += surcharge;
        } 
        return fare / numPassengers;
    }
    
    @Override
    public int computeFare(Service s) {
        return 0;
    }
 
    @Override
    public String toString() {
        return "ShareARide";
    }

}
