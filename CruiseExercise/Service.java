class Service {
    private final Loader loaderObject;
    private final Cruise cruiseObject;
    private static final int recycledCycle = 3;

    Service(Loader loaderObject, Cruise cruiseObject) {
        this.loaderObject = loaderObject;
        this.cruiseObject = cruiseObject;
    }

    Loader getLoader() {
        return this.loaderObject;
    }

    Cruise getCruise() {
        return this.cruiseObject;
    }

    int getServiceStartTime() {
        return this.getCruise().getArrivalTime();
    }

    int getServiceEndTime() {
        if (this.getLoader().getLoaderID() % recycledCycle == 0) {
            return this.getServiceStartTime() + this.getCruise().getServiceTime()
                + this.getLoader().getMaintenanceTime();
        } else { 
            return this.getServiceStartTime() + this.getCruise().getServiceTime();
        }
    } 

    @Override
    public String toString() {
        return this.getLoader() + " serving " + this.getCruise();
    }

}
