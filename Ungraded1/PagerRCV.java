class PagerRCV extends Term {
    private final Host host;
     
    PagerRCV(Term t, Host h) {
        super(t); 
        this.host = h;
    }
     
    @Override 
    public String toString() { 
        return this.host + " >--rcv--> " + this.getID();
    } 
   
    TransACK ack() {
        return new TransACK(this.host, this);
    }

}
