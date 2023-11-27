public class Cuboid extends Container {

    private int height;
    private int width;
    private int length;

    Cuboid(String id, String contents, int width, int height, int length) {
        super(id, contents);
        this.width = width;
        this.height = height;
        this.length = length;
    }

    @Override
    public double volume() {
        return length * width * height;
    }

    @Override
    public void printDimensions() {
        System.out.printf("Cuboid Dimensions:\n\tHeight: %d\n\tWidth: %d\n\tLength: %d", height, width, length);
    }
}
