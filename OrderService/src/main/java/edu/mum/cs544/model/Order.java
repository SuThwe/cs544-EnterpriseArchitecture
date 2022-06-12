package edu.mum.cs544.model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.*;
import javax.validation.constraints.Positive;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Table(name = "Orders")
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Order {

    public enum OrderStatus {
		Created, Processing, Paid, Finished, Cancelld
	}

    @Id
    @GeneratedValue
    private Integer id;

    private double totalPrice;

    private LocalDate orderDate = LocalDate.now();

    @Lob
    private String specialNote;

    @Enumerated(EnumType.STRING)
	private OrderStatus orderStatus = OrderStatus.Created;

    @ManyToOne
    private Customer customer;

    @ManyToMany
    private List<Food> foodList = new ArrayList<>();

    public double calculateTotalCost(List<Food> foods) {
        double cost = 0.0;
        for(Food f : foods) {
            cost += f.getPrice();
        }
        return cost;
    }

}
