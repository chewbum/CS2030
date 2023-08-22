class Server { 
    private final double entryTime;
    private final double timeNeeded;
    private final int serverID;

    Server(double entryTime, double timeNeeded, int serverID) {
        this.entryTime = entryTime;
        this.timeNeeded = timeNeeded;
        this.serverID = serverID; 
    }

    double getEntryTime() { 
        return this.entryTime;
    }

    double getDuration() {
        return this.timeNeeded;
    }

    int getServerID() {
        return this.serverID;
    }

    double busyUntilTime() {
        double end = this.getDuration() + this.getEntryTime();
        return end;
    }

    boolean getStatus(double currTime) {
        if (this.busyUntilTime() <= currTime) {
            return false; 
        } else {
            return true;
        }
    }
}

