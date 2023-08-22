class TermImp extends Term { 
   
    TermImp(String id) {
        super(id);
    }
  
    public TransSND snd(CompletedHost h) {
        return new TransSND(h, this);
    }

}
