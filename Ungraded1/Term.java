abstract class Term {
    private final String identifier; 
    
    Term(String identifier) {
        this.identifier = identifier;
    }
    
    Term(Term term) {
        this(term.getID());
    }
 
    String getID() {
        return this.identifier;
    }
   
    @Override
    public String toString() { 
        return this.identifier;
    } 
    
    @Override
    public boolean equals(Object o) {
        if (this == o) { 
            return true;
        } else if (o instanceof Term t) {
            return this.getID() == t.getID();
        } else {
            return false;
        } 
    }
    
    public void ping() {
        System.out.println(this.identifier + ":beep");;
    }
 
} 
