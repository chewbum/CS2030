import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Consumer;
import java.lang.Runnable;
import java.util.function.Supplier;

interface Maybe<T> {
    static <T> Maybe<T> of(T value) {
        return new Maybe<T>() {
            private final T v = value;

            private T get() {
                return this.v;
            }

            private boolean isEmpty() {
                return this.v == null;
            }

            private boolean isPresent() {
                return !this.isEmpty();
            }

            public <R> Maybe<R> map(Function<? super T, ? extends R> mapper) {
                if (this.isEmpty()) {
                    return Maybe.<R>empty();
                } else {
                    return Maybe.<R>of(mapper.apply(this.v));
                }
            }

            @Override
            public String toString() {
                if (this.v == null) {
                    return "Maybe.empty";
                } else {
                    return "Maybe[" + this.v + "]";
                }
            }

            @Override
            public boolean equals(Object m) {
                if (this == m) {
                    return true;
                } else if (m instanceof Maybe<?> other) {
                    if (this.isEmpty()) {
                        if (other.orElse(null) == null) {
                            return true;
                        } else {
                            return false;
                        }
                    } else {
                        return other.orElse(null) != null && this.get().equals(other.orElse(null));
                    }
                } else {
                    return false;
                }
            }


            public Maybe<T> filter(Predicate<? super T> predicate) {
                return this.isEmpty() ? this : predicate.test(this.get()) ? this : Maybe.<T>empty();
            }

            public void ifPresent(Consumer<? super T> action) {
                if (this.isPresent()) {
                    action.accept(this.v);
                }
            }

            public void ifPresentOrElse(Consumer<? super T> consumer, Runnable action) {
                if (this.isPresent()) {
                    consumer.accept(this.v);
                } else {
                    action.run();
                }
            }

            public T orElse(T input) {
                if (this.isPresent()) {
                    return this.get();
                } else {
                    return input;
                }
            }

            public T orElseGet(Supplier<? extends T> supply) {
                if (this.isPresent()) {
                    return this.get();
                } else {
                    return supply.get();
                }
            }

            public Maybe<T> or(Supplier<? extends Maybe<? extends T>> supply) {
                if (this.isPresent()) {
                    return this;
                } else {
                    Maybe<? extends T> m = supply.get();
                    Maybe<T> result = Maybe.<T>of(m.orElse(null));
                    return result;
                }
            }

            public <R> Maybe<R> flatMap(Function<? super T, ? extends Maybe<? extends R>> mapper) {
                if (this.isEmpty()) {
                    return Maybe.<R>empty();
                } else {
                    Maybe<? extends R> m = mapper.apply(this.v);
                    Maybe<R> result = Maybe.<R>of(m.orElse(null));
                    return result;
                }
            }
        };
    }

    static <T> Maybe<T> empty() {
        return Maybe.<T>of(null);
    }
   
    <R> Maybe<R> map(Function<? super T, ? extends R> mapper);

    <R> Maybe<R> flatMap(Function<? super T, ? extends Maybe<? extends R>> mapper);

    Maybe<T> or(Supplier<? extends Maybe<? extends T>> supply);

    T orElseGet(Supplier<? extends T> supply);

    T orElse(T input);

    void ifPresentOrElse(Consumer<? super T> consumer, Runnable action);

    void ifPresent(Consumer<? super T> action);

    Maybe<T> filter(Predicate<? super T> predicate);

    boolean equals(Object m);
}
