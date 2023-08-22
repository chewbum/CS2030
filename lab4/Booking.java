class Booking implements Comparable<Booking> {
    private final Driver driver; 
    private final Request request;
    private final boolean tracker; 
 
    Booking(Driver driver, Request request) {
        this.driver = driver;
        this.request = request;
        this.tracker = false;
    }

    Booking(Driver driver, Request request, boolean tracker) { 
        this.driver = driver; 
        this.request = request; 
        this.tracker = tracker;
    }
    
    Driver getDriver() {
        return this.driver;
    }
    
    Request getRequest() {
        return this.request;
    }
    
    boolean getTracker() {
        return this.tracker;
    }
    
    @Override
    public String toString() {
        Pair<Double, String> pair = this.driver.computeCheapest(this.request,this.tracker);
        return String.format("$%.2f using ", pair.first()) +
             this.driver.toString() + " (" + pair.second() + ")";
    }
       
    @Override
    public int compareTo(Booking other) {
        if (this.driver.computeCheapest(this.request, this.tracker).first() < 
            other.getDriver().computeCheapest(other.getRequest(), other.getTracker()).first()) {
            return -1; 
        } 
        
        if (this.driver.computeCheapest(this.request,this.tracker).first() >
              other.getDriver().computeCheapest(other.getRequest(), other.getTracker()).first()) {
            return 1;
        }
        
        if (this.driver.getWaitTime() == other.getDriver().getWaitTime()) {
            return 0; 
        } else { 
            if (this.driver.getWaitTime() < other.getDriver().getWaitTime()) {
                return -1;
            } 
            return 1;
        }
    }
   
}
