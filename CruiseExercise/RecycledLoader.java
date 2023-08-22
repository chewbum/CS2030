class RecycledLoader extends Loader {
    private static final int maintenanceTime = 60;

    RecycledLoader(int loaderID) {
        super(loaderID);
    }

    int getMaintenanceTime() {
        return maintenanceTime;
    }
   
    @Override
    public String toString() {
        return "Recycled Loader " + "#" + this.getLoaderID();
    }

}
