import java.util.Optional;
import java.util.function.Supplier;

class Expr<T> { 
    //so why did we include the use of Optionals? 
    //First of an expression needs a left hand side and a right hand side(expression) and an operator. 
    //Thus, we need these 3 attributes but we notice that Expr.<Integer>of(2) takes in one input and still gives u an expression
    //As such, for the remaining two variables, they have to be a NULL value which in this case will be Optional.empty() 
    private final Supplier<T> left;
    private final Supplier<Optional<Expr<T>>> right;
    private final Optional<Operator<T>> operator;

    public static <T> Expr<T> of(T left) {
        return new Expr<T>(() -> left, () -> Optional.empty(), Optional.empty());
    }

    private Expr(Supplier<T> left, Supplier<Optional<Expr<T>>> right, Optional<Operator<T>> operator) {
        this.left = left;
        this.right = right;
        this.operator = operator;
    }

    Expr(Expr<T> expr) {
        this(expr.left, expr.right, expr.operator);
    }

    @Override 
    public String toString() {
        return "(" + this.evaluate() + ")";
    }
    
    Expr<T> op(Operator<T> operate, Expr<T> expression) {
        return op(operate, () -> Optional.of(Expr.of(expression.evaluate())));
    }

    Expr<T> op(Operator<T> operate, T input) {
        return op(operate, () -> Optional.of(Expr.of(input)));
    }

    Expr<T> op(Operator<T> operate, Supplier<Optional<Expr<T>>> input) {
        //Map returns an Optional containing type U, depends on the function it takes in, input T output U, hence does need to be 
        //of the same type as starting Optional
        return this.operator.map(x -> x.compareTo(operate) <= 0 ? 
            new Expr<T>(() -> this.evaluate(), input, Optional.of(operate)) : 
                    new Expr<T>(left, () -> right.get()
                        .map(y -> y.op(operate, input)), this.operator))
                            .orElse(new Expr<T>(left, input, Optional.of(operate)));
    }

    T evaluate() {
        return this.operator.map(x -> x.apply(left.get(), right.get().map(y -> y.evaluate()).orElseThrow()))
            .orElseGet(this.left);
    }

}
        