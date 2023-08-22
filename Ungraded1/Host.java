abstract class Host { 
    private final String hostID; 
    private final ImList<Term> termList;
 
    Host(String hostID) { 
        this.hostID = hostID;
        this.termList = new ImList<Term>();
    } 
    
    Host(Host h, Term t) {
        this.hostID = h.getHostID();
        this.termList = h.getTermList().add(t);
    }
   
    Host(Host h) {
        this.hostID = h.getHostID();
        this.termList = h.getTermList();
    }
       
    String getHostID() {
        return this.hostID;
    }
    
    ImList<Term> getTermList() {
        return this.termList;
    }
 
    @Override
    public boolean equals(Object o) { 
        if (this == o) {
            return true;
        } else if (o instanceof Host h) {
            return this.getHostID() == h.getHostID();
        } else {
            return false;
        }
    }
   
    public void broadcast() {
        for (Term t : this.termList) {
            t.ping();
        }
    }
  
} 
