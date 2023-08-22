// Answer 5a below. Do not remove this comment.

Supplier<Integer> supply = () -> urls.stream().map(x -> processUrl(x)).reduce(0, (x,y) -> x + y);









// Answer 5b below. Do not remove this comment.
CompletableFuture<Integer> cf = urls.stream().map(x -> CompletableFuture
    .supplyAsync(() -> processUrl(x)))
        .reduce(CompletableFuture.completedFuture(0),
            (x,y) -> x.thenCombine(y, (a,b) -> a + b));

cf.join();







