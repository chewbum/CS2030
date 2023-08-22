class PrivateCar extends Driver { 
    private static final double convert = 100;

    PrivateCar(String plateNum, int waitTime) {
        super(plateNum,waitTime);
    }
    
    @Override 
    public String toString() {
        return this.getPlateNum() + " (" + this.getWaitTime() + " mins away) PrivateCar";
    }
    
    @Override
    Pair<Double, String> computeCheapest(Request request, boolean tracker) {
        double amountJustRide = request.computeFare(new JustRide()) / convert;
        double amountShareARide = request.computeFare(new ShareARide()) / convert;
        if (tracker == true) {
            if (amountJustRide > amountShareARide) {
                return new Pair<Double, String>(amountJustRide, "JustRide");
            } else {
                return new Pair<Double, String>(amountShareARide, "ShareARide");
            }
        } else {
            if (amountJustRide > amountShareARide) {
                return new Pair<Double, String>(amountShareARide, "ShareARide");
            } else {
                return new Pair<Double, String>(amountJustRide, "JustRide");
            }
        }
    }
    
}
