import java.util.Optional;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Stream;

final class Fraction extends AbstractNum<Frac> {

    static Fraction of(int numerator, int denominator) {
        Num n = Num.of(numerator);
        Num d = Num.of(denominator);
        if (valid.test(numerator) && valid.test(denominator)) {
            if (d.equals(Num.zero())) {
                return new Fraction(Optional.<Frac>empty());
            } else {
                Frac f = Frac.of(n,d);
                return new Fraction(f);
            } 
        } else {
            return new Fraction(Optional.<Frac>empty());
        }
    }


    private Fraction(Frac f) {
        super(f);
    }

    private Fraction(Optional<Frac> o) {
        super(o);
    }

    Fraction add(Fraction input) {
        Optional<Frac> o = this.opt.flatMap(x -> input.opt.map(y -> Frac.of(x.first()
            .mul(y.second()).add(x.second().mul(y.first())), 
                x.second().mul(y.second()))));
        return new Fraction(o);
    }

    Fraction sub(Fraction input) {
        Optional<Frac> o = this.opt.flatMap(x -> input.opt.map(y -> Frac.of(x.first()
            .mul(y.second()).sub(x.second().mul(y.first())), x.second().mul(y.second()))))
                .filter(x -> x.first().isValid() && x.second().isValid());
        return new Fraction(o);
    }

    Fraction mul(Fraction input) {
        Optional<Frac> o = this.opt.flatMap(x -> input.opt.map(y -> Frac.of(x.first()
            .mul(y.first()), x.second().mul(y.second()))));
        return new Fraction(o);
    }
        
}