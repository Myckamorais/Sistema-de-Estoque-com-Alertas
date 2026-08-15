package entities;

import enums.CategoriaEnum;

public class Product {

    private String name;
    private CategoriaEnum categoria;
    private Integer quantity;
    private Double priceUnit;

    public Product(String name, CategoriaEnum categoria, Integer quantity, Double priceUnit) {
        this.name = name;
        this.categoria = categoria;
        this.quantity = quantity;
        this.priceUnit = priceUnit;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public CategoriaEnum getCategoria() {
        return categoria;
    }

    public void setCategoria(CategoriaEnum categoria) {
        this.categoria = categoria;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Double getPriceUnit() {
        return priceUnit;
    }

    public void setPriceUnit(Double priceUnit) {
        this.priceUnit = priceUnit;
    }

    @Override
    public String toString() {
        return "Product: " + name +
                " | " + categoria +
                " | " + quantity  +
                " | " + priceUnit;
    }
}
