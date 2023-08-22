abstract class Driver { 
    private final String plateNum;
    private final int waitTime; 

    Driver(String plateNum, int waitTime) {
        this.plateNum = plateNum;
        this.waitTime = waitTime;
    } 
    
    String getPlateNum() { 
        return this.plateNum;
    }
    
    int getWaitTime() {
        return this.waitTime;
    }
    
    abstract Pair<Double, String> computeCheapest(Request request, boolean tracker);
    
}  
    
