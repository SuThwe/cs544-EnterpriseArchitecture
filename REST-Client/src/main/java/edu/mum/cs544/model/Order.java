package edu.mum.cs544.model;

import lombok.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class Order {

    public enum OrderStatus {
		Created, Processing, Paid, Finished, Cancelld
	}

    private Integer id;

    private double totalPrice;

    private LocalDate orderDate = LocalDate.now();

    private String specialNote;

	private OrderStatus orderStatus = OrderStatus.Created;
    

    private Customer customer;

    private List<Food> foodList = new ArrayList<>();

    public double calculateTotalCost(List<Food> foods) {
        double cost = 0.0;
        for(Food f : foods) {
            cost += f.getPrice();
        }
        return cost;
    }
}
