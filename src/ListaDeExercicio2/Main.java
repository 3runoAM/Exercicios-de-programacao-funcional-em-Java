package ListaDeExercicio2;
import ListaDeExercicio2.Book;
import org.jetbrains.annotations.NotNull;

import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static List<Book> books = Arrays.asList(
            new Book("To Kill a Mockingbird", "Harper Lee", 1960, "Fiction"),
            new Book("1984", "George Orwell", 1949, "Dystopian"),
            new Book("Pride and Prejudice", "Jane Austen", 1813, "Romance"),
            new Book("The Great Gatsby", "F. Scott Fitzgerald", 1925, "Fiction"),
            new Book("Moby Dick", "Herman Melville", 1851, "Adventure"),
            new Book("War and Peace", "Leo Tolstoy", 1869, "Historical"),
            new Book("The Catcher in the Rye", "J.D. Salinger", 1951, "Fiction"),
            new Book("The Hobbit", "J.R.R. Tolkien", 1937, "Fantasy"),
            new Book("The Lord of the Rings", "J.R.R. Tolkien", 1954, "Fantasy"),
            new Book("Brave New World", "Aldous Huxley", 1932, "Dystopian"),
            new Book("Animal Farm", "George Orwell", 1945, "Satire"),
            new Book("Jane Eyre", "Charlotte Bronte", 1847, "Romance"),
            new Book("Fahrenheit 451", "Ray Bradbury", 1953, "Dystopian"),
            new Book("The Grapes of Wrath", "John Steinbeck", 1939, "Fiction"),
            new Book("Ulysses", "James Joyce", 1922, "Modernist"),
            new Book("Crime and Punishment", "Fyodor Dostoevsky", 1866, "Philosophical"),
            new Book("The Odyssey", "Homer", -800, "Epic"),
            new Book("The Iliad", "Homer", -750, "Epic"),
            new Book("A Tale of Two Cities", "Charles Dickens", 1859, "Historical"),
            new Book("Les Misérables", "Victor Hugo", 1862, "Historical"),
            new Book("Great Expectations", "Charles Dickens", 1861, "Fiction"),
            new Book("The Brothers Karamazov", "Fyodor Dostoevsky", 1880, "Philosophical"),
            new Book("Anna Karenina", "Leo Tolstoy", 1877, "Romance"),
            new Book("The Picture of Dorian Gray", "Oscar Wilde", 1890, "Philosophical"),
            new Book("Dracula", "Bram Stoker", 1897, "Horror"),
            new Book("Frankenstein", "Mary Shelley", 1818, "Horror"),
            new Book("The Adventures of Huckleberry Finn", "Mark Twain", 1884, "Adventure"),
            new Book("Heart of Darkness", "Joseph Conrad", 1899, "Modernist"),
            new Book("Wuthering Heights", "Emily Bronte", 1847, "Romance"),
            new Book("The Count of Monte Cristo", "Alexandre Dumas", 1844, "Adventure"),
            new Book("The Scarlet Letter", "Nathaniel Hawthorne", 1850, "Historical"),
            new Book("Don Quixote", "Miguel de Cervantes", 1605, "Adventure"));

    public static void main(String[] args){
//        System.out.println(getBooksPublishedSinceThe20thCenturyCount());
//        System.out.println(getBooksNames());
//        System.out.println(getBooksByAuthor());
//        System.out.println(getOldestBook());
//        System.out.println(getLatestBook());
//        System.out.println(getMoreThanOneBookAuthor());
//        System.out.println(getBooksByGenre());
//        System.out.println(getOldestBookByGenre());
        System.out.println(getAuthorWithMostPublishedBooks());
        System.out.println();
    }

    // Conte quantos livros foram publicados no século XX.
    public static long getBooksPublishedSinceThe20thCenturyCount(){
        return books.stream()
                .filter(book -> book.getPublicationYear() >= 1901)
                .count();
    }

    // Crie uma lista com os títulos dos livros em ordem alfabética.
    public static List<String> getBooksNames(){
        return books.stream()
                .map(Book::getTitle)
                .collect(Collectors.toList());
    }

    // Crie um mapa onde a chave seja o autor e o valor seja uma lista de livros desse autor.
    public static Map<String, List<Book>> getBooksByAuthor(){
        return books.stream()
                .collect(Collectors.groupingBy(Book::getAuthor, Collectors.toList()));
    }

    //Encontre o livro mais antigo da lista.
    @NotNull
    public static  Optional<Book> getOldestBook(){
        return books.stream()
                .max(Comparator.comparing(Book::getPublicationYear));
    }

    //Encontre o livro mais recente da lista.
    @NotNull
    public static Optional<Book> getLatestBook(){
        return books.stream()
                .min(Comparator.comparing(Book::getPublicationYear));
    }

    //Crie uma lista com os autores que escreveram mais de um livro na lista.
    public static List<String> getMoreThanOneBookAuthor(){
        return books.stream()
                .collect(Collectors.groupingBy(Book::getAuthor, Collectors.counting()))
                .entrySet().stream()
                .filter(entry -> entry.getValue() > 1)
                .map(Map.Entry::getKey)
                .collect(Collectors.toList());
    }

    //Agrupe os livros por gênero e conte quantos livros existem em cada gênero.
    public static Map<String, Long> getBooksByGenre(){
        return books.stream()
                .collect(Collectors.groupingBy(Book::getGenre, Collectors.counting()));
    }

    // Crie um mapa onde a chave seja o gênero e o valor seja o livro mais antigo desse gênero.
    public static Map<String, Optional<Book>> getOldestBookByGenre(){
        return books.stream()
                .collect(Collectors.groupingBy(Book::getGenre, Collectors.maxBy(Comparator.comparing(Book::getPublicationYear))));
    }

    // Encontre o autor que escreveu o maior número de livros.
    public static Optional<String> getAuthorWithMostPublishedBooks(){
        return books.stream()
                .collect(Collectors.groupingBy(Book::getAuthor, Collectors.counting()))
                .entrySet().stream()
                .max(Comparator.comparing(Map.Entry<String, Long>::getValue).thenComparing(Comparator.comparing(Map.Entry<String, Long>::getKey).reversed()))
                .map(Map.Entry::getKey);
    }
}
