package ThirdLectureIteratorsAndComparators.ComparableBook;

import java.util.Arrays;
import java.util.List;

public class Book implements Comparable<Book>{
    private String title;
    private int year;
    List<String> authors;

    public Book(String title, int year, String... args) {
        setTitle(title);
        setYear(year);
        setAuthors(args);
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public List<String> getAuthors() {
        return authors;
    }

    public void setAuthors(String... args) {
        this.authors = Arrays.asList(args);
    }

    @Override
    public int compareTo(Book book) {
        if(book.getTitle().compareTo(this.title) == 0){
            return 0;
        }
        else if (book.getTitle().compareTo(this.title) > 0){
            return 1;
        }
        else {
            return -1;
        }
    }
}
