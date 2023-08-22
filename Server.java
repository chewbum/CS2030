class Server { 
    private final double entryTime;
    private final double timeNeeded;

    Server(double entryTime, double timeNeeded) {
        this.entryTime = entryTime;
        this.timeNeeded = timeNeeded;
    }

    double getEntryTime() { 
        return this.entryTime;
    }

    double getDuration() {
        return this.timeNeeded;
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

