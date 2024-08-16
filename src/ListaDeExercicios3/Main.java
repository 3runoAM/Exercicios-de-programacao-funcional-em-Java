package ListaDeExercicios3;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {
        List<Book> books = Arrays.asList(
                new Book("Java Basics", Arrays.asList("Introduction", "Variables", "Control Flow")),
                new Book("Advanced Java", Arrays.asList("Streams", "Concurrency", "Networking")),
                new Book("Design Patterns", Arrays.asList("Singleton", "Observer", "Factory"))
        );
        System.out.println(allBooksChapters(books));

        List<Contact> contacts = Arrays.asList(
                new Contact("Alice", Arrays.asList("123-4567", "234-5678")),
                new Contact("Bob", Arrays.asList("345-6789")),
                new Contact("Charlie", Arrays.asList("456-7890", "567-8901"))
        );
    }

    // Dada a lista de frases (String) transformar essa lista em uma lista de palavras únicas, sem considerar a ordem;
    public static List<String> unorderedFlattenPhrases(List<String> phrases){
        return phrases.stream()
                .flatMap(phrase -> Arrays.stream(phrase.split(" ")))
                .collect(Collectors.toList());
    }

    // Dada a lista de frases (String) transformar essa lista em uma lista de palavras únicas, em ordem alfabetica;
    public static List<String> orderedFlattenPhrases(List<String> phrases){
        return phrases.stream()
                .flatMap(phrase -> Arrays.stream(phrase.split(" ")))
                .sorted()
                .collect(Collectors.toList());
    }

    // Dado um tipo Book, retorne uma lista de strings contendo todos capítulos de todos os livros
    public static List<String> allBooksChapters(List<Book> books){
        return books.stream()
            .map(Book::getChapters)
            .flatMap(List::stream)
            .collect(Collectors.toList());
    }

    // Crie uma lista de todos os números de telefone de todos os contatos.
    public static List<String> allPhoneNumbers(List<Contact> contacts) {
        return contacts.stream()
                .map(Contact::getphoneNumber)
                .flatMap(List::stream)
                .collect(Collectors.toList());
    }
}
