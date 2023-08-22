import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Consumer;
import java.lang.Runnable;
import java.util.function.Supplier;

abstract class Maybe<T> {

 	static <T> Maybe<T> of(T value) {
        	return new Maybe<T>() {
            private final T thing = value;

			public <R> Maybe<R> map(Function<? super T, ? extends R> mapper) {
				return Maybe.<R>of(mapper.apply(this.thing));
			}

	@Override
	public String toString() {
		return "Maybe[" + thing + "]";
	}
} ;
	}
/* 
	static <T> Maybe<T> empty() {
		return new Maybe<T>() {	
			public <R> Maybe<R> map(Function<? super T, ? extends R> mapper) {
				return this;
			}	
		
		@Override
		public String toString() {
			return "Maybe.empty";
	}
};
	}

*/
abstract <R> Maybe<R> map(Function<? super T, ? extends R> mapper);


}