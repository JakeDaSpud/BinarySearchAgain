public class Cylinder extends Container {

    private int radius;
    private int height;

    public Cylinder(String id, String contents, int radius, int height) {
        super(id, contents);
        this.radius = radius;
        this.height = height;
    }

    @Override
    public double volume() {
        return Math.PI * radius * radius * height;
    }

    @Override
    public void printDimensions() {
        System.out.printf("Cylinder Dimensions:\n\tHeight: %d\n\tRadius: %d\n", height, radius);
    }
}
