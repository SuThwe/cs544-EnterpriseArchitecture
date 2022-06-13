package edu.mum.cs544.service;

import edu.mum.cs544.model.Food;
import edu.mum.cs544.model.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;

@Service
public class OrderService {

    @Autowired
    private RestTemplate restTemplate;

    private String orderUrl = "http://localhost:9900/api/order";

    public Order add(Order order) {
        order.setTotalPrice(order.calculateTotalCost(order.getFoodList()));
        restTemplate.postForLocation(orderUrl + "/add", order);

        return order;
    }

    public Order get(int id) {
        return restTemplate.getForObject(orderUrl + "/{id}", Order.class, id);
    }

    public ResponseEntity<Order[]> getAll() {

       
         ResponseEntity<Order[]> responseEntity =   restTemplate.getForEntity(orderUrl+ "/", Order[].class);

         return responseEntity;
    }

    public void update(Order order) {
        order.setTotalPrice(order.calculateTotalCost(order.getFoodList()));
        restTemplate.postForLocation(orderUrl + "/"+ order.getId(), order);

    }

    public void delete(int id) {
        restTemplate.delete(orderUrl+ "/"+ id, id);
    }

}
