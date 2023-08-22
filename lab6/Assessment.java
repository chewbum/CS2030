class Assessment implements Keyable {
    private final String test;
    private final String result;

    Assessment(String test, String result) {
        this.test = test;
        this.result = result;
    }

    @Override 
    public String toString() {
        return "{" + this.test + ": " + this.result + "}";
    }

    @Override
    public String getKey() {
        return this.test;
    }

    String getGrade() {
        return this.result;
    }

}

