package edu.mum.cs544.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Food {
    @Id
    @GeneratedValue
    private Integer id;
    private String name;
    private String description;
    private double price;
    private String categoryFood;
    
    @ManyToMany(mappedBy = "foodList")
    private List<Order> orderList = new ArrayList<>();

}
