package service;

import entities.Product;

import java.util.List;

public class ProductService {


    public double totalValue(List<Product> list){
        double total = 0;
        if (list != null){
            for (Product x : list){
                total += x.getQuantity() * x.getPriceUnit();
            }
        }
        return total;
    }



}
