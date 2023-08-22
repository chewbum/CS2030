import java.util.Optional;
import java.util.function.Predicate;
import java.util.function.Function;
import java.util.function.BinaryOperator;
import java.util.function.Supplier;
import java.util.function.Consumer;

class IfElse<T,R> {
		
	private final Predicate<T> condition;
	private final Function<T,R> positive;
	private final Function<T,R> negative;

	static <T,R> IfElse<T,R> of(Predicate<T> condition, Function<T,R> positive, Function<T,R> negative) {
		return new IfElse(condition, positive, negative);
	} 
	
	IfElse(Predicate<T> condition, Function<T,R> positive, Function<T,R> negative) {
		this.condition = condition;	
		this.positive = positive;
		this.negative = negative;
	}

    Predicate<T> getPred() {
        return this.condition;
    }

	R apply(T testInput) { 
		return this.condition.test(testInput) ? positive.apply(testInput) : negative.apply(test);	
		//return Optional.of(testInput).filter(this.condition).map(this.positive).equals(Optional.of(testInput).map(this.negative));
	}

	IfElse<T,R> mapIf(IfElse<T,R> other) {
		return new IfELse<T,R>(this.condition.and(other.getPred()), other.positive,
			x -> new IfElse<T,R>(this.condition, other.negative, this.negative).apply(x));
	}

	IfElse<T,R> mapElse(IfElse<T,R> other) {
		return new IfELse<T,R>(this.condition.or(other.getPred()),
			x -> new IfElse<T,R>(this.condition, this.positive, other.positive)
				,other.negative);
    }

    <U> IfElse<T,U> map(Function<? super R, ? extends U> mapper) {
		return new IfElse<T,U>(this.condition, this.postive.andThen(mapper),
			this.negative.andThen(mapper));
	}
	
	<U> IfElse<T,U> flatMap(Function<? super R, ? extends IfELse<R, ? extends U>> mapper) {
		/* return new IfElse<T,U>(this.condition, 
			x -> mapper.apply(this.positive.apply(x)).apply(left.apply(x)),
				x -> mapper.apply(this.negative.apply(x)).apply(this.negative.apply(x)));
		*/
		Function<T,U> f = x -> mapper.apply(this.apply(x)).apply(this.apply(x));
		return new IfElse<T,U>(this.condition, f, f);
	}


}