double epsilon = 1E-15;

double distanceBetween(Point p, Point q) {
    double dx = p.getX() - q.getX();
    double dy = p.getY() - q.getY();

    return Math.sqrt(Math.pow(dx, 2) + Math.pow(dy, 2));
}

boolean circleContainsPoint(Circle c, Point p) {
    return distanceBetween(c.getCentre(), p) < c.getRadius() + epsilon;
}

Circle createUnitCircle(Point p, Point q){
    Point M = p.midPoint(q);
    double angle = p.angleTo(q);
    double d = Math.sqrt(1 - Math.pow(distanceBetween(p,M),2));
    Point N = M.moveTo(angle + Math.PI /2,d);
    Circle c = new Circle(N,1);
    return c;

}
int findMaxDiscCoverage(ImList<Point> points) {
    int maxDiscCoverage = 0;
    int numOfPoints = points.size();

    for (int i = 0; i < numOfPoints - 1; i++) {
        for (int j = i + 1; j < numOfPoints; j++) {
            Point p = points.get(i);
            Point q = points.get(j);
            double distPQ = distanceBetween(p, q);
            if (distPQ < 2.0 + epsilon && distPQ > 0) {
                Circle c = createUnitCircle(p,q);

                int coverage = 0;
                for (Point point : points) {
                    if (circleContainsPoint(c, point)) {
                        coverage = coverage + 1;
                    }
                }
                if (coverage > maxDiscCoverage) {
                    maxDiscCoverage = coverage;
                }
            }
        }
    }
    return maxDiscCoverage;
}
