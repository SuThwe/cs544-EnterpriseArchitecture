package edu.mum.cs544.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Positive;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
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

}
