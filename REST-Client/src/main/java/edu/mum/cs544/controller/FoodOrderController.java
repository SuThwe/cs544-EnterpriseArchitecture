package edu.mum.cs544.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.view.RedirectView;

import edu.mum.cs544.model.Customer;
import edu.mum.cs544.model.Food;
import edu.mum.cs544.model.Order;
import edu.mum.cs544.service.CustomerService;
import edu.mum.cs544.service.FoodService;
import edu.mum.cs544.service.OrderService;


@RestController
@RequestMapping("/api")
public class FoodOrderController {
    @Autowired
    CustomerService customerService;

    @Autowired
    FoodService foodService;

    @Autowired
    OrderService orderService;
    
    // @GetMapping("/")
	// public String redirectRoot() {
	// 	return "redirect:/login";
	// }
    /*****************************ORDERS******************************************************* */
    @GetMapping(value = "/orders/{id}", produces = "application/json")
    public Order get(@PathVariable (value = "id") int id)
    {
        
        return orderService.get(id);
    }


    @GetMapping(value = "/orders", produces = "application/json")
    public ResponseEntity<Order[]> getAllOrders()
    {
        return orderService.getAll();
    }

    @PostMapping(value = "/orders/add", consumes = "application/json")
    public RedirectView add ( @RequestBody Order order){
        Order o= orderService.add(order);
         return new RedirectView("/api/orders/"+o.getId());
       
     }
     @PutMapping(value = "/orders/{id}", consumes = "application/json")
     public String update (@PathVariable (value = "id") int id, @RequestBody Order order)
     {
         if(id!=order.getId()){throw new IllegalArgumentException();}
         orderService.update(order);
         return "Order with id = " + id + " is updated.";
     }

     
    @DeleteMapping(value = "/orders/{id}")
    public String delete (@PathVariable int id){
        orderService.delete(id);
        return "Order with id = " + id + " is deleted.";
    }

    /*****************************FOODS******************************************************* */
  
    @GetMapping(value = "/foods", produces = "application/json")
    public ResponseEntity<Food[]> getAllFoods()
    {
        return foodService.getAll();
    }

    @GetMapping(value = "/foods/{id}", produces = "application/json")
    public Food getFood(@PathVariable (value = "id") int id)
    {
        
        return foodService.get(id);
    }


    @PostMapping(value = "/foods/add", consumes = "application/json")
    public RedirectView add ( @RequestBody Food food){
        Food f= foodService.add(food);
         return new RedirectView("/api/foods/"+f.getId());
       
     }

     
     @PutMapping(value = "/foods/{id}", consumes = "application/json")
     public String updateFood (@PathVariable (value = "id") int id, @RequestBody Food food)
     {
         if(id!=food.getId()){throw new IllegalArgumentException();}
         foodService.update(food);
         return "Food with id = " + id + " is updated.";
     }

     
    @DeleteMapping(value = "/foods/{id}")
    public String deleteFood (@PathVariable int id){
        foodService.delete(id);
        return "Food with id = " + id + " is deleted.";
    }

    
    /*****************************CUSTOMERS******************************************************* */
  
    @GetMapping(value = "/customers", produces = "application/json")
    public ResponseEntity<Customer[]> getAllCustomers()
    {
        return customerService.getAll();
    }

    @GetMapping(value = "/customers/{id}", produces = "application/json")
    public Customer getCustomer(@PathVariable (value = "id") int id)
    {
        
        return customerService.get(id);
    }


    @PostMapping(value = "/customers/add", consumes = "application/json")
    public RedirectView addCustomer ( @RequestBody Customer customer){
        Customer f= customerService.add(customer);
         return new RedirectView("/api/customers/"+f.getId());
       
     }

     
     @PutMapping(value = "/customers/{id}", consumes = "application/json")
     public String updateCustomer (@PathVariable (value = "id") int id, @RequestBody Customer customer)
     {
         if(id!=customer.getId()){throw new IllegalArgumentException();}
         customerService.update(customer);
         return "Customer with id = " + id + " is updated.";
     }

     
    @DeleteMapping(value = "/foods/{id}")
    public String deleteCustomer (@PathVariable int id){
        customerService.delete(id);
        return "Customer with id = " + id + " is deleted.";
    }


}
