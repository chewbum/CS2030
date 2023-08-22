import java.util.stream.Stream;
import java.util.stream.IntStream;
import java.util.List;
import java.util.function.UnaryOperator;
import java.util.function.Function;
import java.util.stream.Collectors;

class Main {

    static IntStream twinPrimes(int n) {
        return IntStream.rangeClosed(2,n)
            .filter(x -> isPrime(x) && (isPrime(x - 2) || isPrime(x + 2)));
    }

    static boolean isPrime(int num) {
        return num > 1 && IntStream.range(2, num).noneMatch(x -> num % x == 0);
    }

    static String reverse(String str) {
        return Stream.<String>of(str.split("")).reduce("", (x,y) -> y + x);
    }
    
    static long countRepeats(List<Integer> list) {
        return IntStream.range(0, list.size() - 1).filter(x -> x > 0 ? list.get(x)
            .equals(list.get(x + 1)) && !list.get(x).equals(list.get(x - 1)) : list.get(x)
                .equals(list.get(x + 1))).count();
    }

    static UnaryOperator<List<Integer>> generateRule() {
        return x -> IntStream.rangeClosed(0, x.size() - 1).map(y -> {
            if (y == 0) {
                if (x.get(y) == 1) {
                    return 0;
                } else {
                    if (x.get(y + 1) == 1) {
                        return 1;
                    } else {
                        return 0;
                    }
                }
            } else if (y == x.size() - 1) {
                if (x.get(y) == 1) {
                    return 0;
                } else {
                    if (x.get(y - 1) == 1) {
                        return 1;
                    } else {
                        return 0;
                    }
                }
            } else {
                if (x.get(y) == 1 || (x.get(y - 1) == 1 && x.get(y + 1) == 1)) {
                    return 0;
                } else if (x.get(y - 1) == 1 || x.get(y + 1) == 1) {
                    return 1;
                } else {
                    return 0;
                }
            }
        }).boxed().toList();
    }

    static Stream<String> gameOfLife(List<Integer> list, UnaryOperator<List<Integer>> rule, int n) {
        return Stream.iterate(list, rule).limit(n).map(intList -> intList.stream()
            .map(x -> x.equals(0) ? "." : "x").collect(Collectors.joining()));
    }
    
}