import java.util.Optional;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Stream;

final class Num extends AbstractNum<Integer> {
    
    private Num(int i) {
        super(Optional.<Integer>of(i));
    }

    private Num(Optional<Integer> opt) {
        super(opt);
    }

    private Num(AbstractNum<Integer> i) {
        super(i.opt);
    }

    static Num of(int i) {
        if (valid.test(i)) {
            return new Num(i);
        } else {
            return new Num(Optional.<Integer>empty());
        }
    }
    
    static Num zero() {
        return new Num(AbstractNum.zero());
    }

    Num succ() {
        return new Num(opt.map(s));
    }
    
    static Num one() {
        return Num.zero().succ();
    }

    Num add(Num input) {
        if (this.isValid() && input.isValid()) {
            if (input.equals(Num.zero())) {
                return this;
            } else {
                return Stream.<Num>iterate(Num.zero(), x -> !x.equals(input), x -> x.succ())
                    .reduce(this, (x,y) ->  x.succ());
            }
        } else {
            return new Num(Optional.<Integer>empty());
        }
    }

    Num mul(Num input) {
        if (this.isValid() && input.isValid()) {
            if (input.equals(Num.zero()) || this.equals(Num.zero())) {
                return Num.zero();
            } else { 
                return Stream.<Num>iterate(Num.zero(), x -> !x.equals(this.sub(Num.one())), 
                    x -> x.succ()).reduce(input, (x,y) -> x.add(input));
                /*Num counter = new Num(this.opt.map(n).map(s));
                Num temp = new Num(input.opt);
                while (!counter.equals(Num.zero())) {
                    temp = temp.add(input);
                    counter = new Num(counter.opt.map(s));
                }
                return temp;*/
            } 
        } else {
            return new Num(Optional.<Integer>empty());
        }
    }

    Num sub(Num input) {
        if (this.isValid() && input.isValid()) {
            if (input.equals(Num.zero())) {
                return this;
            } else {
                Optional<Integer> o = new Num(input.opt.map(n)).add(this).opt
                    .filter(x -> valid.test(x));
                return new Num(o);
            }
        } else {
            return new Num(Optional.<Integer>empty());
        }
    }

}
