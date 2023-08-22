class Transmitter extends CompletedHost {
 
    Transmitter(String hostID) {
        super(hostID); 
    }

    @Override public String toString() {
        return this.getHostID();
    }

}
