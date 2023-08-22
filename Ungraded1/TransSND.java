class TransSND extends Host { 
    private final Term term;

    TransSND(Host h, Term t) {
        super(h);
        this.term = t;
    } 

    @Override 
    public String toString() {
        return this.term.getID() + " >--snd--> " + this.getHostID();
    }
    
    PagerRCV rcv() {
        return new PagerRCV(this.term, this);
    }

}
