<R> LazyList<R> flatmap(Function<T, LazyList<R>> f) {
    if (this.isEmpty()) {
        return LazyList.makeEmpty();
    } else {
        return f.apply(this.head()).concat(this.tail().flatMap(f));
    }
}


LazyList<LazyList<Integer>> permute(LazyList<Integer> LL, int r) {
    if (r == 1) {
        return LL.map(x -> LLmake(x, LazyList.makeEmpty()));
    } else {
        return LL.flatmap(x -> permute(remove(LL,x), r - 1).map(y -> LLmake(x, y)));
    }
}