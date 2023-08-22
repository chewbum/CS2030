// Write the entire class for q4(a) below. Do not remove this comment.
// The additional method in Command class should be written in q3a.java

class Invoker<T> {
    private final ImList<Command<T>> commandList;

    Invoker() {
        this.commandList = new ImList<Command<T>>();
    }
    
    Invoker(ImList<Command<T>> commandList) {
        this.commandList = commandList;
    }
    
    Invoker<T> addCommand(Command<T> command) {
        ImList<Command<T>> updated = this.commandList.add(command);
        return new Invoker<T>(updated);
    }

    Optional<Command<T>> executeCommand() {
        return this.commandList.stream().map(x -> Optional.of(new Command<T>(x.param, commandList))).reduce(Optional.of(new Command<T>(x.param, commandList)), (x+y) -> y);
    }

}