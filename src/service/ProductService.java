package service;

import entities.Product;
import enums.CategoriaEnum;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class ProductService {

    public double totalValue(List<Product> list) {
        double total = 0;
        if (list != null) {
            for (Product x : list) {
                total += x.getQuantity() * x.getPriceUnit();
            }
        }
        return total;
    }

    public List<Product> lowStockProducts(List<Product> list) {
        List<Product> lowStock = list.stream()
                .filter(p -> p.getQuantity() < 10)
                .sorted(Comparator.comparing(Product::getName))
                .collect(Collectors.toList());
        return lowStock;
    }

    public Map<CategoriaEnum, Integer> quantityForCategory (List<Product> list){
        Map<CategoriaEnum, Integer> quantityList = list.stream()
                .collect(Collectors.groupingBy(
                        Product::getCategoria,
                        Collectors.summingInt(Product::getQuantity)
                ));
        return quantityList;
    }

    public Product expensiveProduct(List<Product> list){
            Product expensive = list.stream()
                    .max(Comparator.comparingDouble(Product::getPriceUnit))
                    .orElseThrow(() -> new RuntimeException("Erro valor nulo"));
        return expensive;
    }

}
