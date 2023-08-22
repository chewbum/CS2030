<R> MyStream<R> map(Function<? super T, ? extends R> f) {
    return new MyStream<R>() {
        public R get() {
            return f.apply(MyStream.this.get());
        }
    }
}