class TransACK extends CompletedHost {
    private final Term term;

    TransACK(Host h, Term term) {
        super(h,term);
        this.term = term;
    }

    @Override
    public String toString() {
        return term + " >--ack--> " + this.getHostID(); 
    }

}
