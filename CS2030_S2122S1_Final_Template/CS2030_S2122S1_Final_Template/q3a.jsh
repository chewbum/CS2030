List<Integer> convert(List<Integer> ls, Function<Integer, Integer> fn) {
    return ls.stream().map(x -> fn.apply(x)).toList();
}