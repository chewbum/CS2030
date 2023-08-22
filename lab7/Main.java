import java.util.Scanner;
import java.util.function.Supplier;
import java.util.Random;
import java.util.stream.Stream;
import java.util.function.Function;

class Main {
    public static void main(String[] args) {
        Function<Integer, Log<Integer>> f = x -> Log.<Integer>of(x + 1, "add 1");
        Function<Integer,Boolean> idleft = x -> Log.<Integer>of(x).flatMap(f).equals(f.apply(x));
        System.out.println(idleft.apply(5));
        Function<Integer, Log<Integer>> g = x -> Log.<Integer>of(x, "mul 2").map(y -> y * 2);
        Function<Integer,Boolean> assoc = x -> Log.<Integer>of(x).flatMap(f).flatMap(g).equals(f.apply(x).flatMap(g));
        System.out.println(assoc.apply(5));
        

    }
}
