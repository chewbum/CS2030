class Loader {
    private final int loaderID;
    private static final int maintenanceTime = 0;
 
    Loader(int loaderID) {
        this.loaderID = loaderID;
    }

    int getLoaderID() {
        return this.loaderID;
    }

    int getMaintenanceTime() { 
        return maintenanceTime; 
    }

    @Override
    public String toString() {
        return "Loader " + "#" + this.loaderID;
    }

}
