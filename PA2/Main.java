import java.util.Optional;
import java.util.function.Predicate;
import java.util.function.Function;
import java.util.function.BinaryOperator;
import java.util.function.Supplier;
import java.util.function.Consumer;

class Main {
    public static void main(String[] args) {

        Pair<Integer,Integer> pairOf(int a, int b) {
            Pair<Integer,Integer> pair = Pair.of(a, b);
           System.out.println(pair + " evaluated");
           return pair; 
        }
        Predicate<Pair<Integer, Integer>> pred = pair -> pair.first() == pair.second();
        Function<Pair<Integer, Integer>, Integer> f = pair -> pair.first() * pair.first();
        DnC<Pair<Integer,Integer>, Integer> dnc = DnC.of(pairOf(5, 7), pred, f, 
          pair -> {
          int a = pair.first();
          int b = pair.second();
          int mid = (a + b) / 2;
          return Pair.of(Pair.of(a, mid), Pair.of(mid + 1, b));
        });
        BinaryOperator<Integer> bop = (x,y) -> x + y;
        dnc.solve();
        dnc.solve(bop);
        dnc.left().solve(bop);
        dnc.left().left().solve(bop);

        dnc = DnC.<Pair<Integer,Integer>,Integer>of(() -> pairOf(5, 7), pred, f, 
            pair -> {
           int a = pair.first();
         int b = pair.second();
           int mid = (a + b) / 2;
          return Pair.of(() -> pairOf(a, mid), () -> pairOf(mid + 1, b));
      })
    }
}