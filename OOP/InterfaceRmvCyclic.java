// Write your entire solution in this file only.
import java.util.Random;

interface Notifiable {
    void notify(String s);
}

class User implements Notifiable{
    private final String name;

    User(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return this.name;
    }

    Bot join(Bot bot) {
        return bot.userOutput(this);
    }

    public void notify(String s) {
        System.out.println(this.id + ": " + s);
    }


}




class Bot {
    private final int identifier; 
    private final ImList<Notifiable> userList;

    Bot() {
        this.identifier = new Random().nextInt(1000);
        this.userList = new ImList<Notifiable>();
    }

    private Bot(int identifier, ImList<Notifiable> newList) {
        this.identifier = identifier; 
        this.userList = newList;
    }

    Bot(List<Notifiable> users) {
        this(new Random().nextInt(1000), new ImList<Notiable>(users));
    }

    @Override
    public String toString() {
        return String.format("bot@%d", this.identifier);
    }

    Bot userOutput(Notifiable user) {
        String s = this.toString() + " says hi to " + user.toString();
        Bot newBot = new Bot(this.identifier, this.userList.add(user));
        for (Notifiable i : userList) {
            i.notify(s);
        }
        return newBot;
    }
}
