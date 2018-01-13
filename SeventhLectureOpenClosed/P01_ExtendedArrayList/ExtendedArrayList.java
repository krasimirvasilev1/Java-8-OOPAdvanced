package SeventhLectureOpenClosed.P01_ExtendedArrayList;


import java.util.List;

public interface ExtendedArrayList <T> extends List<T> {

    T max();

    T min();
}
