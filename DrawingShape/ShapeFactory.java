package DrawingShape;

public class ShapeFactory {
    private Shape getShape(String shapeNeeded) {
        if(shapeNeeded == null) {
            return null;
        }

        if(shapeNeeded.equalsIgnoreCase("Circle")) {
            return new Circle();
        } else if (shapeNeeded.equalsIgnoreCase("Triangle")) {
            return new Triangle();
        }

        return null;
    }

    private void preprocess() {

    }

    private void postprocess() {

    }

    public void drawShape(String shapeNeeded) {
        if(shapeNeeded == null) {
            return ;
        }

        preprocess();
        Shape shape = getShape(shapeNeeded);
        shape.draw();
        postprocess();
    }
}
