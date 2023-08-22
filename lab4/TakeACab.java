class TakeACab extends Service { 
    private static final int distanceFare = 33; 
    private static final int bookingFee = 200; 
    
    TakeACab() { 
    } 

    @Override 
    public int computeFare(int distance, int num, int time) {
        return distance * distanceFare + bookingFee; 
    }

    @Override
    public int computeFare(Service s) { 
        return 0;
    }

    @Override 
    public String toString() {
        return "TakeACab";
    }

}
