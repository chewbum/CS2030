void conway(List<Integer> im, Function r, int n) {
    Stream.iterate(im, r).limit(n).map(x -> output(x)).forEach(x -> System.out.println(X));

}

String output(List<Integer> list) {
    return list.stream().map(x -> x == 0 ? " " : "*").reduce("", (x,y) -> x + y);
}


List<Integer> convert(List<Integer> ls, Function r) {

}