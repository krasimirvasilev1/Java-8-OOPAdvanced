package SeventhLectureOpenClosed.P05_Square;

import org.junit.Assert;
import org.junit.Test;

public class RectangleTests {
    @Test
    public void getSidesTest() {
        Rectangle rect = new Rectangle(5,7);
        Assert.assertEquals(5, rect.getWidth());
        Assert.assertEquals(7, rect.getHeight());
    }

    @Test
    public void getAreaTest() {
        Rectangle rect = new Rectangle(5,7);
        Assert.assertEquals(35, rect.getArea());
    }

    @Test
    public void getSquareSidesTest() {
        Square square = new Square(5);
        Assert.assertEquals(5, square.getWidth());
        Assert.assertEquals(5, square.getHeight());
    }

    @Test
    public void getSquareAreaTest() {
        Square square = new Square(10);
        Assert.assertEquals(100, square.getHeight() * square.getWidth());
    }
}
