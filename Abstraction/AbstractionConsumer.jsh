ImList<T> update(Consumer<ImList<T>> function) {
    ImList<T> newList = new ImList<T>(this.list);
    function.accept(newList);
    return newList;
}

ImList<T> add(T elem) {
    return update(x -> x.list.add(elem));
}

ImList<T> set(int index, T elem) {
    return update(x -> x.list.set(index, elem));
}
