import java.util.Optional;
import java.util.function.Supplier;
import java.util.function.Function;
import java.util.function.Consumer;

class Log<T> { 
    private final T t;
    private final String input;

    private Log(T t) {
        this.t = t;
        this.input = "";
    }

    private Log(T t, String input) {
        this.t = t;
        this.input = input;
    }

    T getT() {
        return this.t;
    }

    String getInput() {
        return this.input;
    }

    static <U> Log<U> of(U value) {
        return Log.of(value, "");
    }

    static <U> Log<U> of(U value, String input) { 
        return new Log<U>(value, Optional.ofNullable(value).filter(x -> !(x instanceof Log<?>))
            .flatMap(y -> Optional.ofNullable(input))
            .orElseThrow(() -> new IllegalArgumentException("Invalid arguments")));
    }

    @Override
    public String toString() { 
        return "Log" + "[" + t + "]" + "\n"  + input;
    }
  
    <R> Log<R> map(Function<? super T, ? extends R> mapper) { 
        return new Log<R>(mapper.apply(this.t), this.input);
    }

    <R> Log<R> flatMap(Function<? super T, ? extends Log<? extends R>> mapper) {
        Log<? extends R> log = mapper.apply(this.t);
        String s = this.input;
        if (log.getInput() != "") {
            if (s == "") {
                s += log.getInput();
            } else {
                s += "\n" + log.getInput();
            }
        }
        Log<R> result = Log.<R>of(log.getT(), s);
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        } else if (o instanceof Log<?> other) {
            return this.t.equals(other.getT()) && this.input.equals(other.getInput());
        } else {
            return false;
        }
    }

}
 


