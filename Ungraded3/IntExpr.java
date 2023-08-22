import java.util.stream.IntStream;

class IntExpr extends AbstractIntExpr {
    private static final Operator<Integer> sub = Operator.<Integer>of((x, y) -> x - y, 4);
    private static final Operator<Integer> div = Operator.<Integer>of((x, y) -> x / y, 3);
    private static final Operator<Integer> exp = Operator.<Integer>of((x, y) -> 
        IntStream.range(0, y).reduce(1, (n,m) -> n * x), 2);

    static IntExpr of(Integer value) {
        return new IntExpr(Expr.<Integer>of(value));
    }

    IntExpr(Expr<Integer> intexpression) {
        super(intexpression);
    }

    IntExpr add(int input) {
        return new IntExpr(super.op(addition, input));
    }

    IntExpr sub(int input) {
        return new IntExpr(super.op(sub, input));
    }

    IntExpr mul(int input) {
        return new IntExpr(super.op(multiplication, input));
    }

    IntExpr div(int input) {
        return new IntExpr(super.op(div, input));
    }

    IntExpr exp(int input) {
        return new IntExpr(super.op(exp, input));
    }

    IntExpr add(IntExpr input) {
        return new IntExpr(super.op(addition, input));
    }

    IntExpr sub(IntExpr input) {
        return new IntExpr(super.op(sub, input));
    }

    IntExpr mul(IntExpr input) {
        return new IntExpr(super.op(multiplication, input));
    }

    IntExpr div(IntExpr input) {
        return new IntExpr(super.op(div, input));
    }

    IntExpr exp(IntExpr input) {
        return new IntExpr(super.op(exp, input));
    }

}
