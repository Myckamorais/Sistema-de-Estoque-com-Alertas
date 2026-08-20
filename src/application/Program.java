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
        products.add(new Product("Cabo HDMI", CategoriaEnum.ACESSORIOS, 30, 25.00));
        products.add(new Product("Webcam", CategoriaEnum.PERIFERICOS, 6, 210.00));
        products.add(new Product("Headset", CategoriaEnum.ACESSORIOS, 12, 180.00));
        products.add(new Product("SSD 1TB", CategoriaEnum.ELETRONICOS, 20, 430.00));

        double total = ps.totalValue(products);
        NumberFormat formatoMoeda = NumberFormat.getCurrencyInstance(new Locale("pt", "BR"));
        System.out.println("=== VALOR TOTAL EM ESTOQUE === \n" + formatoMoeda.format(total) + "\n");

        List<Product> lowStock = ps.lowStockProducts(products);
        System.out.println("=== ESTOQUE BAIXO (< 10 unidades) ===");
        lowStock.forEach(p -> System.out.println(p.getName() + " - " + p.getQuantity() + " un"));

        Map<CategoriaEnum, Integer> productsCategory = ps.quantityForCategory(products);
        System.out.println("\n=== QUANTIDADE POR CATEGORIA ===");
        productsCategory.forEach((categoria, quantidade) ->
                System.out.println(categoria + ": " + quantidade));

        Product expensive = ps.expensiveProduct(products);
        System.out.println("\n=== PRODUTO MAIS CARO ===\n"
                + expensive.getName()
                + " - "
                + String.format("%.2f", expensive.getPriceUnit()));









    }
}