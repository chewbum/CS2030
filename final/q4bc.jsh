// Answer q4(b) below. Do not remove this comment.
static Command<City> parseCommand(String userInput) {
    String commandString = getFirstWord(userInput);
    if (commandString.equalsIgnoreCase("updateroute")) {
        return new UpdateRoute<City>(splitParameters(userInput));
    } else if (commandString.equalsIgnoreCase("getdistance")) {
        return new GetDistance<City>(splitParameters(userInput));
    } else {
        return new Command<City>() {
            City execute(City recevier);

            public String toString() {
                return "invalid command format: <" + userInput + ">";

            }
        }
    }
}



// Answer q4(c) below. Do not remove this comment.
public static void main(String[] args) {
    City city = new City();
    Scanner scanner = new Scanner(System.in);
    while (scanner.hasNextLine()) {
    String userInput = scanner.nextLine();
    Command<City> command = parseCommand(userInput);
    String feedback = "";
    City c = new City();
    c = command.execute(city);
}
}

