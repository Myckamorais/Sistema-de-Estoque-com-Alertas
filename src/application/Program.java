package application;

import entities.Product;
import enums.CategoriaEnum;
import service.ProductService;

import java.text.NumberFormat;
import java.util.*;
import java.util.stream.Collectors;

public class Program {
    void main(){

        List<Product> products = new ArrayList<>();
        ProductService ps = new ProductService();

        products.add(new Product("Mouse", CategoriaEnum.PERIFERICOS, 15, 45.00));
        products.add(new Product("Teclado", CategoriaEnum.PERIFERICOS, 8, 120.00));
        products.add(new Product("Monitor", CategoriaEnum.ELETRONICOS, 5, 850.00));
        products.add(new Product("Cabo HDMI", CategoriaEnum.ACCESSORIOS, 30, 25.00));
        products.add(new Product("Webcam", CategoriaEnum.PERIFERICOS, 6, 210.00));
        products.add(new Product("Headset", CategoriaEnum.ACCESSORIOS, 12, 180.00));
        products.add(new Product("SSD 1TB", CategoriaEnum.ELETRONICOS, 20, 430.00));

        double total = ps.totalValue(products);
        NumberFormat formatoMoeda = NumberFormat.getCurrencyInstance(new Locale("pt", "BR"));
        System.out.println("=== VALOR TOTAL EM ESTOQUE === \n" + formatoMoeda.format(total) + "\n");

        List<String> names = products.stream()
                .filter(p -> p.getQuantity() < 10)
                .map(p -> p.getName())
                .sorted()
                .collect(Collectors.toList());

        System.out.println("=== ESTOQUE BAIXO (< 10 unidades) ===");
        names.forEach(System.out::println);

        Map<CategoriaEnum, Integer> quantidadePorCategoria = products.stream()
                .collect(Collectors.groupingBy(
                        Product::getCategoria,
                        Collectors.summingInt(Product::getQuantity)
                ));

        System.out.println("\n=== QUANTIDADE POR CATEGORIA ===\n" + quantidadePorCategoria + "\n");

        Product expensiveProduct = products.stream()
                .max(Comparator.comparingDouble(Product::getPriceUnit))
                .orElse(null);

        System.out.println("=== PRODUTO MAIS CARO ===\n"
                            + expensiveProduct.getName()
                            + " - "
                            + String.format("%.2f", expensiveProduct.getPriceUnit()));











    }
}