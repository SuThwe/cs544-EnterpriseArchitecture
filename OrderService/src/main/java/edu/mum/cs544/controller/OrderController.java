package edu.mum.cs544.controller;

import edu.mum.cs544.model.Order;
import edu.mum.cs544.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/orders")
public class OrderController {

    @Autowired
    private OrderService orderService;

    @GetMapping(value = "/", produces = "application/json")
    public List<Order> getAll(){return orderService.getAll();}

    @GetMapping(value = "/{id}", produces = "application/json")
    public Order get(@PathVariable (value = "id") int id)
    {
        return orderService.get(id);
    }

    @PostMapping(value = "/add", consumes = "application/json")
    public Order add ( @RequestBody Order order){
       return orderService.add(order);
    }

    @PutMapping(value = "/{id}", consumes = "application/json")
    public String update (@PathVariable (value = "id") int id, @RequestBody Order order)
    {
        if(id!=order.getId()){throw new IllegalArgumentException();}
        orderService.update(order);
        return "Order with id = " + id + " is updated.";
    }

    @DeleteMapping(value = "/{id}")
    public String delete (@PathVariable int id){
        orderService.delete(id);
        return "Order with id = " + id + " is deleted.";
    }
}
