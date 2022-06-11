package edu.mum.cs544.VO;

public class Food {
    private Integer id;
    private String name;
    private String description;
    private double price;
    private String categoryFood;
    private int quantity;

    public Food() {
    }

    public Food( String name,  String description, double price,
             String categoryFood, int quantity) {
        this.name = name;
        this.description = description;
        this.price = price;
        this.categoryFood = categoryFood;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getCategoryFood() {
        return categoryFood;
    }

    public void setCategoryFood(String categoryFood) {
        this.categoryFood = categoryFood;
    }

    public int getQuantity(){
        return quantity;
    }

    public void setQuantity(int quantity){
        this.quantity = quantity;
    }

}
