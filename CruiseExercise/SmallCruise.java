class SmallCruise extends Cruise {
    private static final int serviceTime = 30;
    private static final int numOfLoaders = 1;

    SmallCruise(String id, int arrival) {
        super(id, arrival, numOfLoaders, serviceTime);
    }
    
}

