class Circle {
    private final Point centre;
    private final double radius;

    Circle(Point centre, double radius) {
        this.centre = centre;
        this.radius = radius;
    }
   
    double getRadius() {
        return this.radius;
    }

    Point getCentre() {
        return this.centre;
    }

    public String toString() {
        return "circle of radius " + this.getRadius() + " centred at " + this.getCentre();
    } 
    
    boolean contains(Point point) {
        return this.getCentre().distanceTo(point) < this.getRadius() + 1E-15;
    }
   
}
