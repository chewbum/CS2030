class Main { 
    public static void main(String[] args) {
        SolidCuboid solidcuboid = new SolidCuboid(2.0, 2.0, 2.0, 0.5);
        System.out.println(solidcuboid.volume());
        System.out.println(solidcuboid.mass());
        Cuboid cuboid = solidcuboid;
        System.out.println(solidcuboid.volume());
        System.out.println(solidcuboid.mass());
        Shape3D shape = solidcuboid;
        System.out.println(shape.volume());
        Solid solid = solidcuboid;
        System.out.println(solid.volume());
        System.out.println(solid.mass());
        shape = cuboid; 
        System.out.println(shape);
        shape = solid;
        System.out.println(shape);
    }
}
