void forEach(Consumer<T> con, int n) {
    for (int i = 0; i < n; i++) {
        con.accept(this.get);
    }
}
