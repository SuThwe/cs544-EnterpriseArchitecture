package edu.mum.cs544;

import edu.mum.cs544.model.Customer;
import edu.mum.cs544.model.Food;
import edu.mum.cs544.model.Order;
import edu.mum.cs544.service.CustomerService;
import edu.mum.cs544.service.FoodService;
import edu.mum.cs544.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class Client implements CommandLineRunner {

    @Autowired
    CustomerService customerService;

    @Autowired
    FoodService foodService;

    @Autowired
    OrderService orderService;

    @Override
    public void run(String... args) throws Exception {

        System.out.println("REST Client Running...");

        /* Save customer */
        Customer customer1 = new Customer(1, "Su", "Thwe", "Fairfield", "123-456");
        Customer customer2 = new Customer(2, "Cloryse", "Dorimain", "Iowa", "234-546");
        customerService.add(customer1);
        customerService.add(customer2);

        /* Save Food */
        Food food1 = new Food(1, "Chicken Hamburger Sandwich", "Hamburger with chicken", 6.0, "Hamburger");
        Food food2 = new Food(2, "Coca Cola", "Coca Cola", 1.0, "Drinks");
        Food food3 = new Food(3, "French Fries", "Potato Fries", 1.5, "Fries");
        foodService.add(food1);
        foodService.add(food2);
        foodService.add(food3);

        /* Save Order */
        List<Food> foodList = new ArrayList<>();
        foodList.add(food1);
        foodList.add(food2);

        Order order = new Order();
        order.setId(1);
        order.setCustomer(customer1);
        order.setFoodList(foodList);
        orderService.add(order);

//        Order order1 = orderService.get(order.getId());
        System.out.println("------ Order id " + order.getId() + " is saved successfully ---------");
        System.out.println(order);
    }

}
