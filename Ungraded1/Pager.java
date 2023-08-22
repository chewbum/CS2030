class Pager extends TermImp {

    Pager(String identifier) {
        super(identifier);
    }  
    
    @Override
    public String toString() {
        return this.getID();
    }    

}
