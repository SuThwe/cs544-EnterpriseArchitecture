package edu.mum.cs544.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Food {

    private Integer id;
    private String name;
    private String description;
    private double price;
    private String categoryFood;

}
