class ART extends Test {
    
    ART(String result) { 
        super(result);
    }
   
    boolean isValid() {
        if (this.getResult() == "C" || this.getResult() == "CT") {
            return true;
        } else { 
            return false;
        }
    }

    boolean isPositive() {
        if (this.getResult() == "CT") {
            return true; 
        } else {
            return false;
        } 
    
    @Override
    public String toString() {
        if (this.isPositive() == true) { 
             return "A" + "+";
        } else if (this.isValid() == false) {
             return "AX";
        } else {
             return "A" + "-";
        }
    }

}
 
