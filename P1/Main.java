class Main {
    public static void main(String[] args) {
        Task t = new Task(1,12,14,"lunch with boss");
        System.out.println(new RecurringTask(t, 7, 4).edit(3, 10, 8, 10));
        System.out.println( new RecurringTask(t, 7, 4).edit(3, 5, 8, 10));
    }
}
