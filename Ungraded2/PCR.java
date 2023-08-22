class PCR extends Test { 
     
     PCR(String result) {
         super(result);
     }
  
     boolean isValid() {
         return true;
     }

     boolean isPositive() {
         if (this.getResult() == "alpha" || this.getResult() == "beta"
             || this.getResult() == "delta" || this.getResult() == "omicron") { 
            return true;
         } else {
            return false;
          }
     }
 
    @Override 
    public String toString() { 
        if (this.isPositive()) { 
            return "P" + "+";
        } else {
            return "P" + "-";
        }
    }

}
