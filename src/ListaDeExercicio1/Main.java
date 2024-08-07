package ListaDeExercicio1;

import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        List<Product> products = Arrays.asList(
                new Product("Smartphone", "Eletrônicos"),
                new Product("Smart TV 80 polegadas", "Eletrônicos"),
                new Product("Fone de Ouvido", "Eletrônicos"),
                new Product("A casa da Srta. Peregrine para crianças superdotadas", "Livros"),
                new Product("Tablet", "Eletrônicos"),
                new Product("Câmera", "Eletrônicos"),
                new Product("Monitor", "Eletrônicos"),
                new Product("Teclado", "Eletrônicos"),
                new Product("Mouse", "Eletrônicos"),
                new Product("Notebook", "Eletrônicos"),
                new Product("Impressora", "Eletrônicos"),
                new Product("Cadeira de Escritório", "Móveis"),
                new Product("Mesa de Escritório", "Móveis"),
                new Product("Lâmpada Inteligente", "Eletrônicos"),
                new Product("Console de Videogame", "Eletrônicos"),
                new Product("Drone", "Eletrônicos"),
                new Product("Geladeira", "Eletrodomésticos"),
                new Product("Máquina de Lavar", "Eletrodomésticos"),
                new Product("Forno Micro-ondas", "Eletrodomésticos"),
                new Product("Fogão", "Eletrodomésticos"),
                new Product("Ar-condicionado", "Eletrodomésticos"),
                new Product("Sofá", "Móveis"),
                new Product("Estante", "Móveis"),
                new Product("Guarda-roupa", "Móveis"),
                new Product("Cama", "Móveis"),
                new Product("Travesseiro", "Cama e Banho"),
                new Product("Cobertor", "Cama e Banho"),
                new Product("Toalha de Banho", "Cama e Banho"),
                new Product("Shampoo", "Beleza"),
                new Product("Condicionador", "Beleza"),
                new Product("Perfume", "Beleza"),
                new Product("Sabonete", "Beleza"),
                new Product("Camiseta", "Vestuário"),
                new Product("Calça Jeans", "Vestuário"),
                new Product("Tênis", "Vestuário"),
                new Product("Casaco", "Vestuário"),
                new Product("Relógio", "Acessórios"),
                new Product("Óculos de Sol", "Acessórios"),
                new Product("Carteira", "Acessórios")
        );
    }

    // Quantos produtos da categoria "Eletrônicos" existem?
    public static long howManyProductsInCategory(String category, List<Product> products) {
        return products.stream()
                .filter(product -> product.getCategory().equals(category))
                .count();
    }

    // Quais são os produtos que possuem a palavra "Smart" no nome?
    public static List<Product> wichProductsNameContainWord(String word, List<Product> products) {
        return products.stream()
                .filter(product -> product.getName().toLowerCase().contains(word.toLowerCase()))
                .collect(Collectors.toList());
    }

    // Existem produtos da categoria "Alimentos"?
    public static List<String> getAllProductsNames(List<Product> products) {
        return products.stream()
                .map(Product::getName)
                .collect(Collectors.toList());
    }

    // Crie uma lista com os nomes de todos os produtos.
    public static boolean isThereAnyProductsInCatetory(List<Product> products, String category){
        return products.stream()
                .anyMatch(p -> p.getCategory().equals(category));
    }

    // Crie um mapa onde a chave seja a categoria e o valor seja uma lista com os nomes dos produtos daquela categoria.
    public static Map<String, List<Product>> getProductsByCategory(List<Product> products){
        return products.stream()
                .collect(Collectors.groupingBy(Product::getCategory, Collectors.toList()));
    }

    // Qual é a categoria com mais produtos?
    public static Optional<Map.Entry<String, Long>> mostProductsCategory(List<Product> products){
        Map<String, Long> productQuantityPerCategory = products.stream()
                .collect(Collectors.groupingBy(Product::getCategory, Collectors.counting()));
        return productQuantityPerCategory.entrySet()
                .stream()
                .max(Comparator.comparing(Map.Entry::getValue));
    }

    // Ordene os produtos por nome em ordem alfabética.
    public static List<Product> orderedProducts(List<Product> products) {
        return products.stream()
                .sorted(Comparator.comparing(Product::getName))
                .collect(Collectors.toList());
    }

    // Agrupe os produtos por categoria e conte quantos produtos existem em cada categoria.
    public static Map<String, Long> getAmountOfProductsByCategory(List<Product> products){
        return products.stream()
                .collect(Collectors.groupingBy(Product::getCategory, Collectors.counting()));
    }

    // Verifique se existe algum produto com o nome "Fone de Ouvido".
    public static boolean isThereAProductCalled(List<Product> products, String productName){
        return products.stream()
                .anyMatch(p -> p.getName().toLowerCase().equals(productName.toLowerCase()));
    }
}
