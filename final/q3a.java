// Write the entire class for q3(a) below. Do not remove this comment.
// You will need to add another method in q4(a) to this class later.
abstract class Command<T> {
    protected final List<String> param;
    private final ImList<Command<T>> commands;

    Command(List<String> param) {
        this.param = param;
        this.commands = new ImList<Command<T>>().add(this);
    }

    Command(List<String> param, ImList<Command<T>> commands) {
        this.param = param;
        this.commands = commands;
    }

    abstract T execute(T recevier);

    Command<T> joiner(Command<T> other) {
        ImList<Command<T>> update = this.commands.add(other);
        return new Command(param,update);
    }

    ImList<Command<T>> getList() {
        return this.commands;
    }
}