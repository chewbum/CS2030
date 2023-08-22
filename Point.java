class Point {
    private final double x;
    private final double y;

    Point(double x, double y) {
        this.x = x;
        this.y = y;
    }

    double getX() {
        return this.x;
    }

    double getY() {
        return this.y;
    }


    public String toString() {
        return  String.format("point (%.3f, %.3f)", this.getX(), this.getY());
    }

    Point midPoint(Point otherpoint) {
        double midX = (this.getX() + otherpoint.getX()) / 2;
        double midY = (this.getY() + otherpoint.getY()) / 2;
        Point m = new Point(midX,midY);
        return m;
    }

    double angleTo(Point otherpoint) {
        double newX = otherpoint.getX() - this.getX();
        double newY = otherpoint.getY() - this.getY();
        return Math.atan2(newY,newX);
        
    }

    Point moveTo(double angle, double d) {
        double newX = this.getX() + d * Math.cos(angle);
        double newY = this.getY() + d * Math.sin(angle);
        Point p = new Point(newX,newY);
        return p;
    }

    double distanceTo(Point otherpoint) {
        double distX = this.getX() - otherpoint.getX();
        double distY = this.getY() - otherpoint.getY();
        return Math.sqrt(distX * distX + distY * distY);
    }
}
