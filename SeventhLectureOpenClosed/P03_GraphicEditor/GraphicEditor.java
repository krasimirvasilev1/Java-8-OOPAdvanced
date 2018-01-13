package SeventhLectureOpenClosed.P03_GraphicEditor;


/**
 * Created by Buro on 3.4.2017 г..
 */
public class GraphicEditor {

    public static void drawShape(Shape shape){
        shape.draw();
    }

    public static void main(String[] args) {
        Circle circle = new Circle();
        Rectangle rectangle = new Rectangle();
        Square square = new Square();

        circle.draw();
        rectangle.draw();
        square.draw();
    }
}
