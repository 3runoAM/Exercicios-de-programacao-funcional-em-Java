package ListaDeExercicios3;

import java.util.List;

public class Book {
    private final String title;
    private final List<String> chapters;

    public Book(String title, List<String> chapters) {
        this.title = title;
        this.chapters = chapters;
    }

    public String getTitle() {
        return title;
    }

    public List<String> getChapters() {
        return chapters;
    }

    @Override
    public String toString() {
        return "Book: " + title + "\nChapters: " + chapters;
    }
}