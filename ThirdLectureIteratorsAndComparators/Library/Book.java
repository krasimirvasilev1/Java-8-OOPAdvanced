package ThirdLectureIteratorsAndComparators.Library;

import java.util.Arrays;
import java.util.List;

public class Book {
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
}
