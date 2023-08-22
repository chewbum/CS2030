import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Consumer;
import java.lang.Runnable;
import java.util.function.Supplier;

class Main {
	public static void main(String[] args) {
		Maybe<String> ms = Maybe.<String>of("123");
		Function<String,Integer> f = x -> x.length();
		Function<String,Maybe<Integer>> g = x -> Maybe.<Integer>of(x.length());
		System.out.println(ms.map(f));
		System.out.println(ms.map(g));
		System.out.println(ms.flatMap(g));
		Maybe<Object> mo = ms.flatMap(g);
		System.out.println(mo);
}
}
