import java.util.function.BinaryOperator;

class Operator<T> implements Comparable<Operator<T>> {
    private final BinaryOperator<T> combine;
    private final int value; 

    public static <T> Operator<T> of(BinaryOperator<T> combine, int value) {
        return new Operator<T>(combine, value);
    }

    private Operator(BinaryOperator<T> combine, int value) {
        this.combine = combine;
        this.value = value;
    }

    @Override
    public String toString() {
        return String.format("Operator of precedence %d", value);
    }
    
    T apply(T inputOne, T inputTwo) {
        return combine.apply(inputOne, inputTwo);
    }
    
    @Override
    public int compareTo(Operator<T> other) {
        return this.value - other.value; 
    }

}
