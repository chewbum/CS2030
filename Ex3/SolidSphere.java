class SolidSphere extends Sphere implements Solid { 
    private final double density; 
    private final SolidImpl solidimpl;
    
    SolidSphere(double radius, double density) {
        super(radius);
        this.density = density;
        this.solidimpl = new SolidImpl(new Sphere(radius), density);
    } 
    
    @Override 
    public double mass() {
        return this.solidimpl.mass();
    }
 
    @Override
    public String toString() {
        return "solid-sphere [" + String.format("%.2f] with a mass of %.2f",
               this.getRadius(), this.mass());
    }

}
