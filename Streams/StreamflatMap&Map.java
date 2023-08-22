// Answer 3a below. Do not remove this comment.
Stream<Integer> getMarks() {
    return levels.stream().map(x -> x.getMarks());

}





// Answer 3b below. Do not remove this comment.
Stream<Optional<Integer>> getMarks() {
    return listPA.stream().map(x -> x.map(y -> y.getMarks().reduce(0, (a,b) -> a + b)));

}





// Answer 3c below. Do not remove this comment.
int getTotalMarks(List<Student> students) {
    return students.stream().flatMap(x -> x.getMarks().map(y -> y.orElse(0)))
        .reduce(0, (a,b) -> a + b);
}
