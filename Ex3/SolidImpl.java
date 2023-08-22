class SolidImpl implements Solid {
    private final Shape3D shape;
    private final double density;
    
    SolidImpl(Shape3D shape, double density) {
        this.shape = shape; 
        this.density = density;
    }
    
    @Override 
    public String toString() {
        return "SolidImpl";
    }
    
    @Override
    public double volume() {
        return shape.volume();
    }
    
    @Override
    public double mass() {
        return this.volume() * this.density;
    }

}
