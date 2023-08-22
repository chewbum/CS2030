class CachedString {
    private Supplier<String> supplier;
    
    CachedString(Supplier<String> suppString) {
        this.supplier = suppString;
    }

    boolean isEmpty() {
        return this.supplier.get() == "";
    }

    String get() {
        return this.supplier.get();
    }

    CachedString map(Function<? super String, String> f) {
        return new CachedString(() -> f.apply(this.get()));
    }

    CachedString flatMap(Function<? super String, CachedString> f) {
        return new CachedString(() -> f.apply(this.get()).get());
    }

    void forEach(Consumer<String> consumer) {
        consumer.accept(this.get());
    }
    
}