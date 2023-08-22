class BigCruise extends Cruise {
    private static final double lengthFactor = 40;
    private static final double passengerFactor = 50;

    BigCruise(String id, int arrival, double length, double  numOfPassengers) {
        super(id, arrival, (int) Math.ceil(length / lengthFactor),
             (int) Math.ceil(numOfPassengers / passengerFactor));
    }  
} 
