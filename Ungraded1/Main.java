class Main { 
    public static void main(String[] args) {
        Pager p1 = new Pager("pager1");
        System.out.println(p1);
        Transmitter r1 = new Transmitter("transmit1");
        System.out.println(r1);
        System.out.println(p1.snd(r1).rcv().ack());
        System.out.println(p1.snd(r1).rcv().equals(p1));
        System.out.println(p1.snd(r1).rcv().ack().equals(r1));
        System.out.println(p1.snd(r1).rcv().ack().equals(p1.snd(r1)));
    }

}
