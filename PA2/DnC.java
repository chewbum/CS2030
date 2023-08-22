import java.util.Optional;
import java.util.function.Predicate;
import java.util.function.Function;
import java.util.function.BinaryOperator;
import java.util.function.Supplier;
import java.util.function.Consumer;

class DnC<T,R> {
    
    private final Supplier<T> problem;
    private final Predicate<T> atomicCheck;
    private final Function<T,R> trans;
    private final Optional<Function<T,Pair<Supplier<T>, Supplier<T>>>> pairTrans;
    
    static <T,R> DnC<T,R> of(T problem, Predicate<T> atomicCheck, Function<T,R> trans) {
        return new DnC<T,R>(() -> problem, atomicCheck, trans, Optional.empty());
    }
    
    static <T,R> DnC<T,R> of(T problem, Predicate<T> atomicCheck, Function<T,R> trans, 
        Function<T,Pair<T,T>> pairTrans) {

            Function<Pair<T,T>, Pair<Supplier<T>, Supplier<T>>> f = 
                pair -> Pair.of(() -> pair.first(), () -> pair.second());

            return new DnC<T,R>(() -> problem, atomicCheck, trans, Optional
                .of(pairTrans.andThen(f)));
    }
     
    static <T,R> DnC<T,R> of(Supplier<T> problem, Predicate<T> atomicCheck, Function<T,R> trans, 
        Function<T,Pair<Supplier<T>, Supplier<T>>> pairTrans) {
            return new DnC<T,R>(problem, atomicCheck, trans, Optional.of(pairTrans));
    }


    DnC(Supplier<T> problem, Predicate<T> atomicCheck, Function<T,R> trans, 
        Optional<Function<T,Pair<Supplier<T>, Supplier<T>>>> pairTrans) {
        this.problem = problem;
        this.atomicCheck = atomicCheck;
        this.trans = trans;
        this.pairTrans = pairTrans;
    }

    void peek(Consumer<T> action) {
       action.accept(this.problem.get());
    }

    Optional<R> solve() {
        return this.solve(this.problem.get());
    }

    Optional<R> solve(T problemGet) {
        return Optional.of(problemGet).filter(x -> this.atomicCheck
            .test(x)).map(y -> trans.apply(y));
    }

    DnC<T,R> left() {
        return this.left(this.problem.get());
    }

    DnC<T,R> right() {
        return this.right(this.problem.get());
    }
    
    DnC<T,R> left(T problemGet) {
        return pairTrans.filter(x -> !this.atomicCheck.test(problemGet))    
            .map(y -> y.apply(problemGet)
                .first()).map(z -> new DnC<T,R>(z, atomicCheck, trans, pairTrans))
                    .orElse(this);
    }

    DnC<T,R> right(T problemGet) {
        return pairTrans.filter(x -> !this.atomicCheck.test(problemGet))
            .map(y -> y.apply(problemGet)
                .second()).map(z -> new DnC<T,R>(z, atomicCheck, trans, pairTrans))
                    .orElse(this);
    }

    Optional<R> solve(BinaryOperator<R> combiner) {
        return this.solve(this.problem.get(), combiner);
    }
   
    Optional<R> solve(T problemGet, BinaryOperator<R> combiner) {
       return this.solve(problemGet).or(() -> left(problemGet).solve(combiner)
            .flatMap(leftS -> right(problemGet).solve(combiner)
                .map(rightS -> combiner.apply(leftS,rightS))));
   }

}

