package ThirdLectureIteratorsAndComparators.ComparableBook;

import java.util.Comparator;

public class BookComparator implements Comparator<Book> {

    @Override
    public int compare(Book o1, Book o2) {
        if (o1.getTitle().compareTo(o2.getTitle()) == 0){
         return Integer.compare(o1.getYear(),o2.getYear());
        }
        else{
            return o1.getTitle().compareTo(o2.getTitle());
        }
    }
}
