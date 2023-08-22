class Sphere implements Shape3D {
    private final double radius;
    private static final double volumeConstant = 4d / 3d;
    private static final int power = 3;
 
    Sphere(double radius) {
        this.radius = radius;
    }
    
    double getRadius() {
        return this.radius;
    } 
    
    @Override
    public double volume() {
        return volumeConstant * Math.PI * Math.pow(this.radius, power);
    } 
   
    @Override 
    public String toString() {
        return "sphere [" + String.format("%.2f", this.radius) + "]";
    }

}
