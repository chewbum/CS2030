abstract class Test { 
    private final String result = result;

    Test(String result) {
        this.result = result;
    }
    
    String getResult() {
        return this.result;
    }

    abstract boolean isValid();
    
    abstract boolean isPositive();

}
