import java.util.Scanner;
import java.util.function.Supplier;
import java.util.Random;
import java.util.stream.Stream;
import java.util.function.Function;

class Main {
    public static void main(String[] args) {
        System.out.println(Fraction.of(1, 2).add(Fraction.of(1, 4)));
        System.out.println(Fraction.of(-1, 2).add(Fraction.of(1, 4)));
        System.out.println(Fraction.of(1, 2).sub(Fraction.of(1, 4)));
        System.out.println(Fraction.of(1, 4).sub(Fraction.of(1, 2)));
        System.out.println(Fraction.of(1, 2).mul(Fraction.of(2, 1)));
        System.out.println(Num.of(1).mul(Num.of(2)));
    }
}

