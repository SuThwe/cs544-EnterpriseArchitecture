package edu.mum.cs544.model;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class Food {

    private Integer id;
    private String name;
    private String description;
    private double price;
    private String categoryFood;
   

}
