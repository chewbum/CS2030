class NormalCab extends Driver { 
    private static final double convert = 100;

    NormalCab(String plateNum, int waitTime) {
        super(plateNum, waitTime);
    }

    @Override 
    public String toString() {
        return this.getPlateNum() + " (" + this.getWaitTime() + " mins away) NormalCab";
    } 
    
    @Override
    Pair<Double, String> computeCheapest(Request request, boolean tracker) { 
        double amountJustRide = request.computeFare(new JustRide()) / convert;
        double amountTakeACab = request.computeFare(new TakeACab()) / convert;
        if (tracker == true) { 
            if (amountJustRide > amountTakeACab) {
                return new Pair<Double, String>(amountJustRide, "JustRide");
            } else {
                return new Pair<Double, String>(amountTakeACab, "TakeACab");
            }
        } else {
            if (amountJustRide > amountTakeACab) {
                return new Pair<Double, String>(amountTakeACab, "TakeACab");
            } else {
                return new Pair<Double, String>(amountJustRide, "JustRide");
            } 
        }
    }
   
}
