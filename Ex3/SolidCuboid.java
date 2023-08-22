class SolidCuboid extends Cuboid implements Solid { 
    private final double density; 
    private final SolidImpl solidimpl; 

    SolidCuboid(double height, double width, double length, double density) {
        super(height, width, length); 
        this.density = density;
        this.solidimpl = new SolidImpl(new Cuboid(height, width, length), density); 
    } 
    
    @Override 
    public double mass() {
        return this.solidimpl.mass();
    } 
   
    @Override 
    public String toString() { 
        return "solid-cuboid [" + String.format("%.2f x %.2f x %.2f] with a mass of %.2f",
             this.getHeight(), this.getWidth(), this.getLength(), this.mass());
    }

}
