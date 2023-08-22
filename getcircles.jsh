List<Circle> getCircles(int n){
    return Stream.<Double>(0.0, x -> x + 1).limit(n).map(y -> 
    new Circle(new Point(y + 1.0, n - y))).toList();
}