public abstract class Container {
    String id;
    String contents;

    public Container() {
        id = "-1";
        contents = "null";
    }

    public Container(String id, String contents) {
        this.id = id;
        this.contents = contents;
    }

    public String getId() {
        return id;
    }

    public String getContents() {
        return contents;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setContents(String contents) {
        this.contents = contents;
    }

    public abstract double volume();
    public abstract void printDimensions();
}
