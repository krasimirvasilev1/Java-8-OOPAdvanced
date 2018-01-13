package SeventhLectureOpenClosed.P05_Square;

public class Square extends Rectangle {
    public Square(int m_width) {
        super(m_width, m_width);
    }

    @Override
    public int getWidth() {
        return super.getWidth();
    }

    @Override
    public int getHeight() {
        return super.getWidth();
    }

    @Override
    public int getArea() {
        return getWidth() * getWidth();
    }
}
