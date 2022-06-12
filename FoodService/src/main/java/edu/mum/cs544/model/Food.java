package edu.mum.cs544.model;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Positive;

@Entity
public class Food {

    @Id
    @GeneratedValue
    private Integer id;

    @NotBlank
    private String name;
    @NotBlank
    private String description;

    @Positive
    private double price;

    @NotBlank
    private String categoryFood;

    public Food() {
    }

    public Food(@NotBlank String name, @NotBlank String description, @Positive double price,
            @NotBlank String categoryFood) {
        this.name = name;
        this.description = description;
        this.price = price;
        this.categoryFood = categoryFood;
    }

    public Food(@NotBlank int id, @NotBlank String name, @NotBlank String description, @Positive double price,
                @NotBlank String categoryFood) {
        this.id = id;
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


}
