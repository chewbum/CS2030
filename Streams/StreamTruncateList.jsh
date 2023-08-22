Function<ImList<Integer>, ImList<Integer>> f = 
    imList -> new ImList<Integer>(IntStream.iterate(0, x < imList.size(), x -> x + 2)
.map(x -> imList.get(x) * 2).toList());
