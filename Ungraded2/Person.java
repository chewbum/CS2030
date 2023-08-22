class Person { 
    private final String ID;
    private final int score;
    private final String status;
    private static final int highScore = 8;
    private static final int len = 2;
    private final boolean vaccinated;

    Person(Stirng ID, String status, int score) {
        this.ID = ID;
        this.status = status;
        this.score = score;
        if (this.status.length() >= len) {
            this.vaccinated = true;
        } else { 
            this.vaccinated = false;
        }
    }
 
    boolean isVaccinated() { 
        if (this.vaccinated == true) {
            return true;
        } else {
            return false;
        }
    }

    boolean isHighRisk() {
        if (this.score >= highScore) {
            return true;
        } 
        return false;
    }

    @Override 
    public String toString() {
        if (this.isHighRisk() == true) {
            return this.ID + "/" + "HIGH";
        } else { 
            return this.ID + "/" + "LOW";
    }

}    
